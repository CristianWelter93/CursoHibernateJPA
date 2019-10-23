package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteFuncoesJPQLGroup {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        MovimentacaoDao dao = new MovimentacaoDao(em);

        List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);

        System.out.println("Media do dia 26 : "+medias.get(0));
        System.out.println("Media do dia 27 : "+medias.get(1));

        TypedQuery< Double> typequery =em.createNamedQuery("MediasPorDiaETipo", Double.class);
        typequery.setParameter("pConta",conta);
        typequery.setParameter("pTipo",TipoMovimentacao.SAIDA);

        medias = typequery.getResultList();
        System.out.println("Usando NamedQuery");
        System.out.println("Media do dia 26 : "+medias.get(0));
        System.out.println("Media do dia 27 : "+medias.get(1));

        em.getTransaction().commit();
        em.close();
    }

}

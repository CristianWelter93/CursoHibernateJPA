package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteFuncoesJPQL {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        MovimentacaoDao dao = new MovimentacaoDao(em);
        Double media = dao.getMedia(TipoMovimentacao.SAIDA, conta);

        System.out.println("Soma : "+media);

        em.getTransaction().commit();
        em.close();
    }
}

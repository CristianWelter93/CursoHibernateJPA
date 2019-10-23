package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        MovimentacaoDao dao = new MovimentacaoDao(em);

        List<Movimentacao> resultados = dao.getMovimentacoesDeSaidaDaContaOrdenadasPorValoresDecrescente(conta);
        for (Movimentacao movimentacao : resultados) {
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Conta.id: " + movimentacao.getConta().getId());
        }

        em.getTransaction().commit();
        em.close();
    }
}

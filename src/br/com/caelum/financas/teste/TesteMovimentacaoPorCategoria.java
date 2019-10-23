package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TesteMovimentacaoPorCategoria {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(2);
        MovimentacaoDao dao= new MovimentacaoDao(em);

        List<Movimentacao> resultados = dao.getMovimentacoesPorCategoria(categoria);
        for (Movimentacao movimentacao : resultados) {
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Conta.id: " + movimentacao.getConta().getId());
        }

        em.getTransaction().commit();
        em.close();
    }

}

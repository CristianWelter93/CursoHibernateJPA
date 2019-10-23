package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentacaoDao {
    private EntityManager em;

    public MovimentacaoDao(EntityManager em){
        this.em=em;
    }

    public Double getMedia(TipoMovimentacao tipo,Conta conta){
        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipo);
        return (Double) query.getSingleResult();
    }
    public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipo, Conta conta){
        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " group by day(m.data), month(m.data), year(m.data)";
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipo);
        return (List<Double>) query.getResultList();
    }

    public Long getQuantidadeMovimentacoesDaConta(Conta conta){
        String jpql = "select count(m) from Movimentacao m where m.conta = :pConta";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        return (Long) query.getSingleResult();
    }

    public BigDecimal getMovimentacaoComMaiorValor(Conta conta){
        String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        return  (BigDecimal) query.getSingleResult();
    }

    public List<Movimentacao> getMovimentacoesDeSaidaDaContaOrdenadasPorValoresDecrescente(Conta conta){
        String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        return query.getResultList();
    }

    public List<Movimentacao> getMovimentacoesPorCategoria(Categoria categoria){
        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);
        return query.getResultList();
    }
}

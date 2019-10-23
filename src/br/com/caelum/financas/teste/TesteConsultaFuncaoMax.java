package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TesteConsultaFuncaoMax {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        MovimentacaoDao dao = new MovimentacaoDao(em);

        BigDecimal maximo = dao.getMovimentacaoComMaiorValor(conta);

        System.out.println("Valor máximo : "+ maximo);

        em.getTransaction().commit();
        em.close();
    }
}

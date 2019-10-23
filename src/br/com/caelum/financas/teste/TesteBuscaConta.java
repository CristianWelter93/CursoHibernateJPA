package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {
    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta= em.find(Conta.class, 1);

        conta.setTitular("João");
        conta.setAgencia("456");

        System.out.println(conta.getTitular());

        em.getTransaction().commit();
        em.close();

    }

    public static class TesteJPA {
        public static void main(String[] args) {
            Conta conta = new Conta();
            conta.setTitular("Maria dos Santos");
            conta.setBanco("Caixa");
            conta.setAgencia("043");
            conta.setNumero("54321");

            /**
             * Usando MySQL
             */


            EntityManager em = new JPAUtil().getEntityManager();
            em.getTransaction().begin();

            em.persist(conta);

            em.getTransaction().commit();
            em.close();
        }
    }
}

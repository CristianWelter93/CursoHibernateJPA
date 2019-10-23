package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestaContaCliente {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Leonardo");
        cliente.setEndereco("Rua Fulano, 123");
        cliente.setProfissao("Professor");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Leonardo");
        cliente2.setEndereco("Rua Fulano, 123");
        cliente2.setProfissao("Professor");

        Conta conta = new Conta();
        conta.setId(2);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente);

        em.getTransaction().commit();
        em.close();
    }
}

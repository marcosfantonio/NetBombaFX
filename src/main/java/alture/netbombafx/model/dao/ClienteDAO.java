package alture.netbombafx.model.entity.dao;

import java.util.ArrayList;
import java.util.List;

import alture.netbombafx.model.entity.Cliente;
import alture.netbombafx.model.entity.services.PlanoService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDAO {
    public static void addCliente ( Cliente cliente ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        session.close();
    }

    public static Cliente getCliente ( int id ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = session.get(Cliente.class, id);
        session.close();
        return cliente;
    }

    public static void updateCliente ( int id, String nome, String cpf, String rua, int numero, int plano_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, id);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.getEndereco().setRua(rua);
        cliente.getEndereco().setNumero(numero);
        cliente.getAssinatura().setPlano(PlanoService.readPlanoById(plano_id));
        session.update(cliente);
        transation.commit();
        session.close();
    }

    public static void deleteCliente( int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, id);
        session.delete(cliente);
        transaction.commit();
        session.close();
    }

    public static List<Cliente> readClienteTable(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> tabelaCliente = null;

        try {
            tabelaCliente = session.createQuery("From Cliente", Cliente.class).list();
        } finally {
            session.close();
        }

        return tabelaCliente;
    }

    public static void cancelarInternet( int id ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = session.get(Cliente.class, id);
        Transaction transation = session.beginTransaction();
        cliente.getAssinatura().setStatus(false);
        session.update(cliente);
        transation.commit();
        session.close();
    }

    public static void ativarInternet( int id ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = session.get(Cliente.class, id);
        Transaction transation = session.beginTransaction();
        cliente.getAssinatura().setStatus(true);
        session.update(cliente);
        transation.commit();
        session.close();
    }
}

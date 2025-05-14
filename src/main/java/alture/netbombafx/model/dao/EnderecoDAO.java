package alture.netbombafx.model.entity.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import alture.netbombafx.model.entity.Endereco;
import alture.netbombafx.model.entity.Plano;
import alture.netbombafx.model.entity.Assinatura;

public class EnderecoDAO {
    public static void addEndereco ( Endereco endereco ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(endereco);
        session.getTransaction().commit();
        session.close();
    }
    public static Endereco getEndereco ( int id ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Endereco endereco = session.get(Endereco.class, id);
        session.close();
        return endereco;
    }
    public static void updateEndereco ( int id, String rua, int numero) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        Endereco endereco = session.get(Endereco.class, id);
        endereco.setRua(rua);
        endereco.setNumero( numero );
        session.update(endereco);
        transation.commit();
        session.close();
    }

    public static void deleteEndereco( int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Endereco endereco = session.get(Endereco.class, id);
        session.delete(endereco);
        transaction.commit();
        session.close();
    }
}

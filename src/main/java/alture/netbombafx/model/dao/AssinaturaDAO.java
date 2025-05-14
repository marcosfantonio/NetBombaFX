package alture.netbombafx.model.entity.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import alture.netbombafx.model.entity.Assinatura;
import alture.netbombafx.model.entity.Plano;

public class AssinaturaDAO {
    public static void addAssinatura ( Assinatura assinatura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(assinatura);
        session.getTransaction().commit();
        session.close();
    }

    public static Assinatura getAssinatura ( int id ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Assinatura assinatura = session.get(Assinatura.class, id);
        session.close();
        return assinatura;
    }

    public static void updateAssinatura( int id , Plano plano, boolean status ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        Assinatura assinatura = session.get(Assinatura.class, id);
        assinatura.setPlano(plano);
        assinatura.setStatus(status);
        session.update(assinatura);
        transation.commit();
        session.close();
    }

    public static void deleteAssinatura( int id ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Assinatura assinatura = session.get(Assinatura.class, id);
        session.delete(assinatura);
        transaction.commit();
        session.close();
    }
}

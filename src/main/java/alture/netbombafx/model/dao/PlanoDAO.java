package alture.netbombafx.model.entity.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import alture.netbombafx.model.entity.Assinatura;
import alture.netbombafx.model.entity.Cliente;
import alture.netbombafx.model.entity.Plano;

public class PlanoDAO {
    public static void addPlano(Plano plano) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(plano);
        session.getTransaction().commit();
        session.close();

    }
    public static Plano getPlano ( int id ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Plano plano = session.get(Plano.class, id);
        session.close();
        return plano;
    }
    public static void editPlano ( int id, int megas, BigDecimal preco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Plano plano = session.get(Plano.class, id);

        plano.setMegas(megas);
        plano.setPreco(preco);

        session.update(plano);
        transaction.commit();
        session.close();
    }

    public static void deletePlano( int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Plano plano = session.get(Plano.class, id);
        session.delete(plano);
        transaction.commit();
        session.close();
    }

    public static List<Plano> readPlanoTable(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Plano> tabelaPlano = null;

        try {
            tabelaPlano = session.createQuery("From Plano", Plano.class).list();
        } finally {
            session.close();
        }

        return tabelaPlano;
    }
}

package Dao;
import Entity.Boja;
import Entity.GodinaProizvodnje;
import Entity.RegistrovanDo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NenadIvana
 * AdminDao su metode koje se koriste na adminStranici
 */
public class AdminDao {

    public static Session session = null;
    public static void dodajBoju(String boja) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Boja b = new Boja(boja);
            session.persist(b);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }

    public static void dodajGodiste(String god) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            GodinaProizvodnje gd = new GodinaProizvodnje(god);
            session.persist(gd);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }
     public static void dodajRegistraciju(String regist) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            RegistrovanDo rd = new RegistrovanDo(regist);
            session.persist(rd);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }
}

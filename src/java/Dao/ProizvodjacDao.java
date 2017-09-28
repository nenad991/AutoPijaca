package Dao;
import static Dao.KorisnikDao.session;
import Entity.Proizvodjac;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
/**
 *
 * @author NenadIvana
 *
 * ProizvodjacDao se koristi za rad sa entitetom Proizvodjac.
 */
public class ProizvodjacDao {
   /*
    selektujProizvodjaca vraca listu Proizvodjaca i koristi se u DodajOglas.jsp
    */
    public static List<Proizvodjac> selektujProizvodjaca() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Proizvodjac> vraceni = null;
        try {
            
            tx = session.beginTransaction();
            Query query = session.createQuery("from Proizvodjac");
            vraceni = (List<Proizvodjac>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return vraceni;
    }
}

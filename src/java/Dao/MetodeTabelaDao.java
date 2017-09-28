package Dao;
import Entity.Boja;
import Entity.BrojSedista;
import Entity.BrojVrata;
import Entity.EmisionaKlasaMotora;
import Entity.GodinaProizvodnje;
import Entity.Gorivo;
import Entity.Karoserija;
import Entity.Kilometraza;
import Entity.Klima;
import Entity.Kubikaza;
import Entity.Menjac;
import Entity.Ostecenje;
import Entity.Pogon;
import Entity.PorekloVozila;
import Entity.RegistrovanDo;
import Entity.SnagaKs;
import Entity.StranaVolana;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author NenadIvana
 * MetodeTabelaDao se koriste za rad sa entitetima pomocnih tabela i 
 * sve metode vracaju liste tabela koje je dalje koriste za rad u OglasDao za dodavanje
 * novog oglasa i ProizvodjacDao za metode pretrazivanja po parametrima.
 */
public class MetodeTabelaDao {

    public static Session session = null;

    public static List<GodinaProizvodnje> selektujGodProizvodnje() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<GodinaProizvodnje> god = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from GodinaProizvodnje");
            god = (List<GodinaProizvodnje>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return god;
    }
    public static List<Karoserija> selektujKaroseriju() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Karoserija> karoserija = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Karoserija");
            karoserija = (List<Karoserija>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return karoserija;
    }
    public static List<Kubikaza> selektujKubikazu() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Kubikaza> kubikaza = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Kubikaza");
            kubikaza = (List<Kubikaza>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return kubikaza;
    }
    public static List<Gorivo> selektujGorivo() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Gorivo> gorivo = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Gorivo");
            gorivo = (List<Gorivo>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return gorivo;
    }
    public static List<SnagaKs> selektujSnaga() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<SnagaKs> ks = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from SnagaKs");
            ks = (List<SnagaKs>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return ks;
    }
    public static List<Kilometraza> selektujKilometrazu() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Kilometraza> km = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Kilometraza");
            km = (List<Kilometraza>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return km;
    }
    public static List<EmisionaKlasaMotora> selektujEMS() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<EmisionaKlasaMotora> EMS = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from EmisionaKlasaMotora");
            EMS = (List<EmisionaKlasaMotora>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return EMS;
    }
    public static List<Pogon> selektujPogon() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Pogon> pogon = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Pogon");
            pogon = (List<Pogon>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return pogon;
    }
    public static List<Menjac> selektujMenjac() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Menjac> menjac = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Menjac");
            menjac = (List<Menjac>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return menjac;
    }
    public static List<BrojVrata> selektujVrata() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<BrojVrata> vrata = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from BrojVrata");
            vrata = (List<BrojVrata>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return vrata;
    }
    public static List<BrojSedista> selektujSedista() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<BrojSedista> sedista = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from BrojSedista");
            sedista = (List<BrojSedista>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return sedista;
    }
    public static List<StranaVolana> selektujVolan() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<StranaVolana> volan = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from StranaVolana");
            volan = (List<StranaVolana>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return volan;
    }
    public static List<Klima> selektujKlimu() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Klima> klima = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Klima");
            klima = (List<Klima>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return klima;
    }
    public static List<Boja> selektujBoju() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Boja> boja = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Boja");
            boja = (List<Boja>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return boja;
    }
    public static List<RegistrovanDo> selektujRegistraciju() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<RegistrovanDo> reg = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from RegistrovanDo");
            reg = (List<RegistrovanDo>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return reg;
    }
    public static List<Ostecenje> selektujOstecenje() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Ostecenje> ostecenje = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Ostecenje");
            ostecenje = (List<Ostecenje>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return ostecenje;
    }
    public static List<PorekloVozila> selektujPoreklo() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<PorekloVozila> poreklo = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from PorekloVozila");
            poreklo = (List<PorekloVozila>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return poreklo;
    }
}

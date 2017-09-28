package Dao;
import Entity.Korisnik;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author NenadIvana
 *
 * KorisnikDao se korisni za rad sa entitetom Korisnik.
 */
public class KorisnikDao {

    public static Session session = null;

    /* Metoda ubaciKorisnika se koristi za ubacivanje novog korisnika u bazu
        koristeci parametre koji pune konstruktor entiteta Korisnik i preko 
    ugradjenih metoda "persist" i "commit" trajno cuvamo u 
    bazi podataka.
    Metoda ubaciKorisnika se koristi u servletu PocetnaServlet.
     */
    public static void ubaciKorisnika(String ime, String prezime, String datum, String pol,
            String zemlja, String korime, String sifra, String email, String telefon) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Korisnik k = new Korisnik(ime, prezime, datum, pol, zemlja, korime, sifra, email, telefon);
            session.persist(k);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }
    public static void promeniLozinku(String lozinka, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Korisnik k = (Korisnik) session.get(Korisnik.class, id);
            k.setSifra(lozinka);
            session.update(k);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }

    /* Metoda selektuj se koristi vracanje liste korisnika iz baze radi uporedjivanja 
    podataka iz forme za logovanje(uporedjivanje korisnickoIme i sifra) i 
    registraciju(uporedjivanje da li u bazi vec postoji pod odredjenim korisnickimImenom i emailom)
     i koristi se u servletu PocetnaServlet i servletu RegisterServlet.
     */
    public static List<Korisnik> selektuj() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Korisnik> vraceni = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Korisnik");
            vraceni = (List<Korisnik>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return vraceni;
    }
    public static List<Korisnik> selektujInfo(String kor) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List< Korisnik> info = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Korisnik where korisnickoIme =:kor");
            query.setParameter("kor", kor);
            info = (List<Korisnik>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return info;
    }
}

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
import Entity.Korisnik;
import Entity.Kubikaza;
import Entity.Menjac;
import Entity.Model;
import Entity.Oglas;
import Entity.Ostecenje;
import Entity.Pogon;
import Entity.PorekloVozila;
import Entity.Proizvodjac;
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
 *
 * OglasDao se korisni za rad sa entitetom Oglas.
 */
public class OglasDao {

    public static Session session = null;

    /* Metoda ubaciOglas ubacuje novi oglas koristeci parametre koji pune konstruktor
    entiteta Oglas od kojih prva tri objekti entiteta Korisnik,Proizvodjac,Model.
    Do njih dolazimo tako sto u telu metode ubaciOglas pravimo objekte istih i pozivamo ugradjenu 
    metodu "get" da bi dobili podatke istih.Na kraju preko ugradjenih metoda "persist" i "commit" trajno cuvamo u 
    bazi podataka.
    Metoda ubaciOglas se koristi u servletu DodajOglasServlet.
     */
    public static void ubaciOglas(int kori, int proizv, int model, int godiste,
            int karoserija, int kubikaza, int gorivo, int ks, int km,
            int ems, int pogon, int menjac, int vrata, int sedista, int volan,
            int klima, int boja, int reg, int ostecenje, int poreklo, String telefon,
            int cena, String slika) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Korisnik kor = (Korisnik) session.get(Korisnik.class, kori);
            Proizvodjac proiz = (Proizvodjac) session.get(Proizvodjac.class, proizv);
            Model mod = (Model) session.get(Model.class, model);
            GodinaProizvodnje god = (GodinaProizvodnje) session.get(GodinaProizvodnje.class, godiste);
            Karoserija karose = (Karoserija) session.get(Karoserija.class, karoserija);
            Kubikaza kub = (Kubikaza) session.get(Kubikaza.class, kubikaza);
            Gorivo gor = (Gorivo) session.get(Gorivo.class, gorivo);
            SnagaKs kS = (SnagaKs) session.get(SnagaKs.class, ks);
            Kilometraza kilo = (Kilometraza) session.get(Kilometraza.class, km);
            EmisionaKlasaMotora emsm = (EmisionaKlasaMotora) session.get(EmisionaKlasaMotora.class, ems);
            Pogon pogonn = (Pogon) session.get(Pogon.class, pogon);
            Menjac menja = (Menjac) session.get(Menjac.class, menjac);
            BrojVrata vra = (BrojVrata) session.get(BrojVrata.class, vrata);
            BrojSedista brsed = (BrojSedista) session.get(BrojSedista.class, sedista);
            StranaVolana strvolana = (StranaVolana) session.get(StranaVolana.class, volan);
            Klima klimaa = (Klima) session.get(Klima.class, klima);
            Boja boj = (Boja) session.get(Boja.class, boja);
            RegistrovanDo regis = (RegistrovanDo) session.get(RegistrovanDo.class, reg);
            Ostecenje ost = (Ostecenje) session.get(Ostecenje.class, ostecenje);
            PorekloVozila porek = (PorekloVozila) session.get(PorekloVozila.class, poreklo);
            
            Oglas oglas = new Oglas(kor, proiz, mod, god, karose, kub,
                    gor, kS, kilo, emsm, pogonn, menja, vra, brsed, strvolana,
                    klimaa, boj, regis, ost, porek, telefon, cena, slika);
            session.persist(oglas);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        }
    }
    /*
    Metoda selektujOglase vraca listu svih oglasa iz baze radi prikaza svih oglasa
    u Oglasi.jsp stranici.
     */
    public static List<Oglas> selektujOglase() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Oglas> vraceni = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Oglas");
            vraceni = (List<Oglas>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return vraceni;
    }
   /*
    Metoda selektujOglasId vraca listu svih oglasa iz baze radi prikaza oglasa pod 
   odredjenim id-em u OglasInformacije.jsp stranici.
    */
    public static List<Oglas> selektujOglasId(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List< Oglas> vraceni = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Oglas where oglasId =:id");
            query.setParameter("id", id);
            vraceni = (List<Oglas>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return vraceni;
    }
    /*
    Metoda pretraga vraca listu svih oglasa iz baze radi prikaza oglasa pod 
   odredjenim parametrima u OglasPretraga.jsp i OglasPretragaUlogovan.jsp  stranici.
    */
    public static List<Oglas> pretraga(int proiz,int model,int godina) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List< Oglas> pretraga = null;
        try {
            tx = session.beginTransaction();
            Proizvodjac pro=(Proizvodjac) session.get(Proizvodjac.class, proiz);
              Model mod=(Model) session.get(Model.class, model);
            GodinaProizvodnje god = (GodinaProizvodnje) session.get(GodinaProizvodnje.class, godina);
            Query query = session.createQuery("from Oglas where proizvodjac = :pro and model = :mod or godinaProizvodnje = :god ");
            query.setParameter("pro", pro);
            query.setParameter("mod", mod);
            query.setParameter("god", god);
            pretraga = (List<Oglas>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return pretraga;
    }
   /*
    Metoda selektujPoCeniRastuce vraca sortiranu listu Oglasa po rastucem redosledu
    i koristi se u oglasSortiranje.jsp,oglasSortiranjeUlogovan.jsp stranicama.
    */
      public static List<Oglas> selektujPoCeniRastuce() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List< Oglas> cena = null;
        try {
            tx = session.beginTransaction();
            
            Query query = session.createQuery("from Oglas AS o ORDER BY o.cena ASC ");
           
           cena= (List<Oglas>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return cena;
    }
      /*
    Metoda selektujPoCeniOpadajuce vraca sortiranu listu Oglasa po opadajucem redosledu
    i koristi se u oglasSortiranje.jsp,oglasSortiranjeUlogovan.jsp stranicama.
    */
       public static List<Oglas> selektujPoCeniOpadajuce() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List< Oglas> cena = null;
        try {
            tx = session.beginTransaction();
            
            Query query = session.createQuery("from Oglas AS o ORDER BY o.cena DESC ");
           
           cena= (List<Oglas>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return cena;
    }
       /*
    Metoda selektujPoNazivu vraca sortiranu listu Oglasa po proizvodjacu i po rastucem redosledu
    i koristi se u oglasSortiranje.jsp,oglasSortiranjeUlogovan.jsp stranicama.
    */
         public static List<Oglas> selektujPoNazivu() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List< Oglas> naziv = null;
        try {
            tx = session.beginTransaction();
            
            Query query = session.createQuery("from Oglas AS o ORDER BY o.proizvodjac ASC ");
           
           naziv= (List<Oglas>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            // session.close();
        }
        return naziv;
    }
}

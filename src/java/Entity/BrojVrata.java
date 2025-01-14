package Entity;
// Generated Jul 3, 2017 12:11:39 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BrojVrata generated by hbm2java
 */
@Entity
@Table(name="broj_vrata"
    ,catalog="baza_automobila"
)
public class BrojVrata  implements java.io.Serializable {


     private Integer brojVrataId;
     private String brojVrata;
     private Set<Oglas> oglases = new HashSet<Oglas>(0);

    public BrojVrata() {
    }

	
    public BrojVrata(String brojVrata) {
        this.brojVrata = brojVrata;
    }
    public BrojVrata(String brojVrata, Set<Oglas> oglases) {
       this.brojVrata = brojVrata;
       this.oglases = oglases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="broj_vrata_id", unique=true, nullable=false)
    public Integer getBrojVrataId() {
        return this.brojVrataId;
    }
    
    public void setBrojVrataId(Integer brojVrataId) {
        this.brojVrataId = brojVrataId;
    }

    
    @Column(name="broj_vrata", nullable=false, length=45)
    public String getBrojVrata() {
        return this.brojVrata;
    }
    
    public void setBrojVrata(String brojVrata) {
        this.brojVrata = brojVrata;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="brojVrata")
    public Set<Oglas> getOglases() {
        return this.oglases;
    }
    
    public void setOglases(Set<Oglas> oglases) {
        this.oglases = oglases;
    }

    @Override
    public String toString() {
        return brojVrata;
    }




}



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
 * SnagaKs generated by hbm2java
 */
@Entity
@Table(name="snaga_ks"
    ,catalog="baza_automobila"
)
public class SnagaKs  implements java.io.Serializable {


     private Integer snagaKsId;
     private String snagaKs;
     private Set<Oglas> oglases = new HashSet<Oglas>(0);

    public SnagaKs() {
    }

	
    public SnagaKs(String snagaKs) {
        this.snagaKs = snagaKs;
    }
    public SnagaKs(String snagaKs, Set<Oglas> oglases) {
       this.snagaKs = snagaKs;
       this.oglases = oglases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="snaga_ks_id", unique=true, nullable=false)
    public Integer getSnagaKsId() {
        return this.snagaKsId;
    }
    
    public void setSnagaKsId(Integer snagaKsId) {
        this.snagaKsId = snagaKsId;
    }

    
    @Column(name="snaga_ks", nullable=false, length=45)
    public String getSnagaKs() {
        return this.snagaKs;
    }
    
    public void setSnagaKs(String snagaKs) {
        this.snagaKs = snagaKs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="snagaKs")
    public Set<Oglas> getOglases() {
        return this.oglases;
    }
    
    public void setOglases(Set<Oglas> oglases) {
        this.oglases = oglases;
    }

    @Override
    public String toString() {
        return snagaKs;
    }




}


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
 * Gorivo generated by hbm2java
 */
@Entity
@Table(name="gorivo"
    ,catalog="baza_automobila"
)
public class Gorivo  implements java.io.Serializable {


     private Integer gorivoId;
     private String gorivo;
     private Set<Oglas> oglases = new HashSet<Oglas>(0);

    public Gorivo() {
    }

	
    public Gorivo(String gorivo) {
        this.gorivo = gorivo;
    }
    public Gorivo(String gorivo, Set<Oglas> oglases) {
       this.gorivo = gorivo;
       this.oglases = oglases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="gorivo_id", unique=true, nullable=false)
    public Integer getGorivoId() {
        return this.gorivoId;
    }
    
    public void setGorivoId(Integer gorivoId) {
        this.gorivoId = gorivoId;
    }

    
    @Column(name="gorivo", nullable=false, length=45)
    public String getGorivo() {
        return this.gorivo;
    }
    
    public void setGorivo(String gorivo) {
        this.gorivo = gorivo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="gorivo")
    public Set<Oglas> getOglases() {
        return this.oglases;
    }
    
    public void setOglases(Set<Oglas> oglases) {
        this.oglases = oglases;
    }

    @Override
    public String toString() {
        return gorivo;
    }




}


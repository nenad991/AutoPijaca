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
 * Kubikaza generated by hbm2java
 */
@Entity
@Table(name="kubikaza"
    ,catalog="baza_automobila"
)
public class Kubikaza  implements java.io.Serializable {


     private Integer kubikazaId;
     private String kubikaza;
     private Set<Oglas> oglases = new HashSet<Oglas>(0);

    public Kubikaza() {
    }

	
    public Kubikaza(String kubikaza) {
        this.kubikaza = kubikaza;
    }
    public Kubikaza(String kubikaza, Set<Oglas> oglases) {
       this.kubikaza = kubikaza;
       this.oglases = oglases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="kubikaza_id", unique=true, nullable=false)
    public Integer getKubikazaId() {
        return this.kubikazaId;
    }
    
    public void setKubikazaId(Integer kubikazaId) {
        this.kubikazaId = kubikazaId;
    }

    
    @Column(name="kubikaza", nullable=false, length=45)
    public String getKubikaza() {
        return this.kubikaza;
    }
    
    public void setKubikaza(String kubikaza) {
        this.kubikaza = kubikaza;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="kubikaza")
    public Set<Oglas> getOglases() {
        return this.oglases;
    }
    
    public void setOglases(Set<Oglas> oglases) {
        this.oglases = oglases;
    }

    @Override
    public String toString() {
        return kubikaza;
    }




}



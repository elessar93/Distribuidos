package org.rafa.dtd;
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


@Entity
@Table(name="tipo_unidad"
    ,catalog="distribuidos"
)
public class TipoUnidad  implements java.io.Serializable {


     private Integer idTipo;
     private String nomTipo;
     private String desTipo;
     private Set<Unidad> unidads = new HashSet<Unidad>(0);

    public TipoUnidad() {
    }

    public TipoUnidad(String nomTipo, String desTipo, Set<Unidad> unidads) {
       this.nomTipo = nomTipo;
       this.desTipo = desTipo;
       this.unidads = unidads;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idTipo", unique=true, nullable=false)
    public Integer getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    
    @Column(name="nom_tipo", length=50)
    public String getNomTipo() {
        return this.nomTipo;
    }
    
    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    
    @Column(name="des_tipo", length=250)
    public String getDesTipo() {
        return this.desTipo;
    }
    
    public void setDesTipo(String desTipo) {
        this.desTipo = desTipo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoUnidad")
    public Set<Unidad> getUnidads() {
        return this.unidads;
    }
    
    public void setUnidads(Set<Unidad> unidads) {
        this.unidads = unidads;
    }




}



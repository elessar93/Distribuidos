package org.rafa.dtd;
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

    public TipoUnidad() {
    }
    
    public TipoUnidad(String nomTipo, String desTipo) {
		this.nomTipo = nomTipo;
		this.desTipo = desTipo;
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

    @Override
    public String toString() {
    	return idTipo+" "+nomTipo+" "+desTipo;
    }


}



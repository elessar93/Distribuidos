package org.rafa.dtd;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto"
    ,catalog="distribuidos"
)
public class Producto  implements java.io.Serializable {


     private Integer idProducto;
     private String nomProd;
     private String desProd;
     private Integer nuExistencia;
     private Float nuCosto;

    public Producto() {
    }

    public Producto(String nomProd, String desProd, Integer nuExistencia, Float nuCosto) {
       this.nomProd = nomProd;
       this.desProd = desProd;
       this.nuExistencia = nuExistencia;
       this.nuCosto = nuCosto;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idProducto", unique=true, nullable=false)
    public Integer getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    
    @Column(name="nom_prod", length=50)
    public String getNomProd() {
        return this.nomProd;
    }
    
    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    
    @Column(name="des_prod", length=250)
    public String getDesProd() {
        return this.desProd;
    }
    
    public void setDesProd(String desProd) {
        this.desProd = desProd;
    }

    
    @Column(name="nu_existencia")
    public Integer getNuExistencia() {
        return this.nuExistencia;
    }
    
    public void setNuExistencia(Integer nuExistencia) {
        this.nuExistencia = nuExistencia;
    }

    
    @Column(name="nu_costo", precision=12, scale=0)
    public Float getNuCosto() {
        return this.nuCosto;
    }
    
    public void setNuCosto(Float nuCosto) {
        this.nuCosto = nuCosto;
    }

}



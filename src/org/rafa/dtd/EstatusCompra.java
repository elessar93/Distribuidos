package org.rafa.dtd;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estatus_compra"
    ,catalog="distribuidos"
)
public class EstatusCompra  implements java.io.Serializable {


     private int idEstatus;
     private String nbEstatus;
     private String dsEstatus;
     private Set<Compra> compras = new HashSet<Compra>(0);

    public EstatusCompra() {
    }

	
    public EstatusCompra(int idEstatus) {
        this.idEstatus = idEstatus;
    }
    public EstatusCompra(int idEstatus, String nbEstatus, String dsEstatus, Set<Compra> compras) {
       this.idEstatus = idEstatus;
       this.nbEstatus = nbEstatus;
       this.dsEstatus = dsEstatus;
       this.compras = compras;
    }
   
     @Id 

    
    @Column(name="idEstatus", unique=true, nullable=false)
    public int getIdEstatus() {
        return this.idEstatus;
    }
    
    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    
    @Column(name="nb_estatus", length=50)
    public String getNbEstatus() {
        return this.nbEstatus;
    }
    
    public void setNbEstatus(String nbEstatus) {
        this.nbEstatus = nbEstatus;
    }

    
    @Column(name="ds_estatus", length=250)
    public String getDsEstatus() {
        return this.dsEstatus;
    }
    
    public void setDsEstatus(String dsEstatus) {
        this.dsEstatus = dsEstatus;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="estatusCompra")
    public Set<Compra> getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }




}



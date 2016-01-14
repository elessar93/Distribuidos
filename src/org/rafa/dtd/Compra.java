package org.rafa.dtd;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="compra"
    ,catalog="distribuidos"
)
public class Compra  implements java.io.Serializable {


     private Integer idCompra;
     private EstatusCompra estatusCompra;
     private Usuario usuario;
     private Date fhInicio;
     private Date fhFin;
    
    public Compra() {
    }

	
    public Compra(EstatusCompra estatusCompra, Usuario usuario) {
        this.estatusCompra = estatusCompra;
        this.usuario = usuario;
    }
    public Compra(EstatusCompra estatusCompra, Usuario usuario, Date fhInicio, Date fhFin) {
       this.estatusCompra = estatusCompra;
       this.usuario = usuario;
       this.fhInicio = fhInicio;
       this.fhFin = fhFin;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
   
    @Column(name="idCompra", unique=true, nullable=false)
    public Integer getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="estatus", nullable=false)
    public EstatusCompra getEstatusCompra() {
        return this.estatusCompra;
    }
    
    public void setEstatusCompra(EstatusCompra estatusCompra) {
        this.estatusCompra = estatusCompra;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fh_inicio", length=19)
    public Date getFhInicio() {
        return this.fhInicio;
    }
    
    public void setFhInicio(Date fhInicio) {
        this.fhInicio = fhInicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fh_fin", length=19)
    public Date getFhFin() {
        return this.fhFin;
    }
    
    public void setFhFin(Date fhFin) {
        this.fhFin = fhFin;
    }
}



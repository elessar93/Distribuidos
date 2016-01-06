package org.rafa.dtd;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="unidad"
    ,catalog="distribuidos"
)
public class Unidad  implements java.io.Serializable {


     private UnidadId id;
     private TipoUnidad tipoUnidad;
     private String nomUni;
     private String txSiglas;
     private Set<Atributo> atributos = new HashSet<Atributo>(0);

    public Unidad() {
    }

	
    public Unidad(UnidadId id, TipoUnidad tipoUnidad) {
        this.id = id;
        this.tipoUnidad = tipoUnidad;
    }
    public Unidad(UnidadId id, TipoUnidad tipoUnidad, String nomUni, String txSiglas, Set<Atributo> atributos) {
       this.id = id;
       this.tipoUnidad = tipoUnidad;
       this.nomUni = nomUni;
       this.txSiglas = txSiglas;
       this.atributos = atributos;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idUnidad", column=@Column(name="idUnidad", nullable=false) ), 
        @AttributeOverride(name="idTipo", column=@Column(name="idTipo", nullable=false) ) } )
    public UnidadId getId() {
        return this.id;
    }
    
    public void setId(UnidadId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idTipo", nullable=false, insertable=false, updatable=false)
    public TipoUnidad getTipoUnidad() {
        return this.tipoUnidad;
    }
    
    public void setTipoUnidad(TipoUnidad tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    
    @Column(name="nom_uni", length=50)
    public String getNomUni() {
        return this.nomUni;
    }
    
    public void setNomUni(String nomUni) {
        this.nomUni = nomUni;
    }

    
    @Column(name="tx_siglas", length=10)
    public String getTxSiglas() {
        return this.txSiglas;
    }
    
    public void setTxSiglas(String txSiglas) {
        this.txSiglas = txSiglas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="unidad")
    public Set<Atributo> getAtributos() {
        return this.atributos;
    }
    
    public void setAtributos(Set<Atributo> atributos) {
        this.atributos = atributos;
    }




}



package org.rafa.dtd;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="atributo"
    ,catalog="distribuidos"
)
public class Atributo  implements java.io.Serializable {


     private Integer idAtributo;
     private Unidad unidad;
     private String nomAtri;
     private String desAtri;
     private Set<Categoria> categorias = new HashSet<Categoria>(0);
     private Set<ProductoAtributo> productoAtributos = new HashSet<ProductoAtributo>(0);

    public Atributo() {
    }

	
    public Atributo(Unidad unidad) {
        this.unidad = unidad;
    }
    public Atributo(Unidad unidad, String nomAtri, String desAtri, Set<Categoria> categorias, Set<ProductoAtributo> productoAtributos) {
       this.unidad = unidad;
       this.nomAtri = nomAtri;
       this.desAtri = desAtri;
       this.categorias = categorias;
       this.productoAtributos = productoAtributos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idAtributo", unique=true, nullable=false)
    public Integer getIdAtributo() {
        return this.idAtributo;
    }
    
    public void setIdAtributo(Integer idAtributo) {
        this.idAtributo = idAtributo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="idUnidad", referencedColumnName="idUnidad", nullable=false), 
        @JoinColumn(name="idTipo", referencedColumnName="idTipo", nullable=false) } )
    public Unidad getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    
    @Column(name="nom_atri", length=50)
    public String getNomAtri() {
        return this.nomAtri;
    }
    
    public void setNomAtri(String nomAtri) {
        this.nomAtri = nomAtri;
    }

    
    @Column(name="des_atri", length=250)
    public String getDesAtri() {
        return this.desAtri;
    }
    
    public void setDesAtri(String desAtri) {
        this.desAtri = desAtri;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="atributos")
    public Set<Categoria> getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="atributo")
    public Set<ProductoAtributo> getProductoAtributos() {
        return this.productoAtributos;
    }
    
    public void setProductoAtributos(Set<ProductoAtributo> productoAtributos) {
        this.productoAtributos = productoAtributos;
    }




}



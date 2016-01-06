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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categoria"
    ,catalog="distribuidos"
)
public class Categoria  implements java.io.Serializable {


     private Integer idCategoria;
     private Categoria categoria;
     private String nomCat;
     private String desCat;
     private Set<Atributo> atributos = new HashSet<Atributo>(0);
     private Set<Categoria> categorias = new HashSet<Categoria>(0);
     private Set<Producto> productos = new HashSet<Producto>(0);

    public Categoria() {
    }

	
    public Categoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Categoria(Categoria categoria, String nomCat, String desCat, Set<Atributo> atributos, Set<Categoria> categorias, Set<Producto> productos) {
       this.categoria = categoria;
       this.nomCat = nomCat;
       this.desCat = desCat;
       this.atributos = atributos;
       this.categorias = categorias;
       this.productos = productos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCategoria", unique=true, nullable=false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPadre", nullable=false)
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    @Column(name="nom_cat", length=50)
    public String getNomCat() {
        return this.nomCat;
    }
    
    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    
    @Column(name="des_cat", length=250)
    public String getDesCat() {
        return this.desCat;
    }
    
    public void setDesCat(String desCat) {
        this.desCat = desCat;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="categoria_atributo", catalog="distribuidos", joinColumns = { 
        @JoinColumn(name="idCategoria", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idAtributo", nullable=false, updatable=false) })
    public Set<Atributo> getAtributos() {
        return this.atributos;
    }
    
    public void setAtributos(Set<Atributo> atributos) {
        this.atributos = atributos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    public Set<Categoria> getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="categoria_producto", catalog="distribuidos", joinColumns = { 
        @JoinColumn(name="idCategoria", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idProducto", nullable=false, updatable=false) })
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }




}



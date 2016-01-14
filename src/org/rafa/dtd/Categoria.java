package org.rafa.dtd;

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
     private Integer categoria;
     private String nomCat;
     private String desCat;

    public Categoria() {
    }

    public Categoria(Integer categoria, String nomCat, String desCat) {
       this.categoria = categoria;
       this.nomCat = nomCat;
       this.desCat = desCat;
    }
   
     public Categoria(String nomCat, String desCat) {
		this.nomCat = nomCat;
		this.desCat = desCat;
	}
     

     
	public Categoria(Categoria categoria, String nomCat, String desCat) {
		this.nomCat = nomCat;
		this.desCat = desCat;
	}

	@Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCategoria", unique=true, nullable=false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    @JoinColumn(name="idPadre")
    public Integer getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Integer categoria) {
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
}


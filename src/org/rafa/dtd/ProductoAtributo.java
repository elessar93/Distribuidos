package org.rafa.dtd;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto_atributo"
    ,catalog="distribuidos"
)
public class ProductoAtributo  implements java.io.Serializable {


     private ProductoAtributoId id;
     private Atributo atributo;
     private Producto producto;
     private String txValor;

    public ProductoAtributo() {
    }

	
    public ProductoAtributo(ProductoAtributoId id, Atributo atributo, Producto producto) {
        this.id = id;
        this.atributo = atributo;
        this.producto = producto;
    }
    public ProductoAtributo(ProductoAtributoId id, Atributo atributo, Producto producto, String txValor) {
       this.id = id;
       this.atributo = atributo;
       this.producto = producto;
       this.txValor = txValor;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idAtributo", column=@Column(name="idAtributo", nullable=false) ), 
        @AttributeOverride(name="idProducto", column=@Column(name="idProducto", nullable=false) ) } )
    public ProductoAtributoId getId() {
        return this.id;
    }
    
    public void setId(ProductoAtributoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAtributo", nullable=false, insertable=false, updatable=false)
    public Atributo getAtributo() {
        return this.atributo;
    }
    
    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idProducto", nullable=false, insertable=false, updatable=false)
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    @Column(name="tx_valor", length=50)
    public String getTxValor() {
        return this.txValor;
    }
    
    public void setTxValor(String txValor) {
        this.txValor = txValor;
    }




}



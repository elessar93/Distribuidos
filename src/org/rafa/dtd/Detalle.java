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
@Table(name="detalle"
    ,catalog="distribuidos"
)
public class Detalle  implements java.io.Serializable {


     private DetalleId id;
     private Compra compra;
     private Producto producto;
     private Integer cantidad;

    public Detalle() {
    }

	
    public Detalle(DetalleId id, Compra compra, Producto producto) {
        this.id = id;
        this.compra = compra;
        this.producto = producto;
    }
    public Detalle(DetalleId id, Compra compra, Producto producto, Integer cantidad) {
       this.id = id;
       this.compra = compra;
       this.producto = producto;
       this.cantidad = cantidad;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idDetalle", column=@Column(name="idDetalle", nullable=false) ), 
        @AttributeOverride(name="compra", column=@Column(name="compra", nullable=false) ) } )
    public DetalleId getId() {
        return this.id;
    }
    
    public void setId(DetalleId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="compra", nullable=false, insertable=false, updatable=false)
    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="producto_idProducto", nullable=false)
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    @Column(name="cantidad")
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }




}



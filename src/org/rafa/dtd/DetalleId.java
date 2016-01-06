package org.rafa.dtd;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleId  implements java.io.Serializable {


     private int idDetalle;
     private int compra;

    public DetalleId() {
    }

    public DetalleId(int idDetalle, int compra) {
       this.idDetalle = idDetalle;
       this.compra = compra;
    }
   


    @Column(name="idDetalle", nullable=false)
    public int getIdDetalle() {
        return this.idDetalle;
    }
    
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }


    @Column(name="compra", nullable=false)
    public int getCompra() {
        return this.compra;
    }
    
    public void setCompra(int compra) {
        this.compra = compra;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetalleId) ) return false;
		 DetalleId castOther = ( DetalleId ) other; 
         
		 return (this.getIdDetalle()==castOther.getIdDetalle())
 && (this.getCompra()==castOther.getCompra());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdDetalle();
         result = 37 * result + this.getCompra();
         return result;
   }   


}



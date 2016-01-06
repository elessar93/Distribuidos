package org.rafa.dtd;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductoAtributoId  implements java.io.Serializable {


     private int idAtributo;
     private int idProducto;

    public ProductoAtributoId() {
    }

    public ProductoAtributoId(int idAtributo, int idProducto) {
       this.idAtributo = idAtributo;
       this.idProducto = idProducto;
    }
   


    @Column(name="idAtributo", nullable=false)
    public int getIdAtributo() {
        return this.idAtributo;
    }
    
    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }


    @Column(name="idProducto", nullable=false)
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProductoAtributoId) ) return false;
		 ProductoAtributoId castOther = ( ProductoAtributoId ) other; 
         
		 return (this.getIdAtributo()==castOther.getIdAtributo())
 && (this.getIdProducto()==castOther.getIdProducto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdAtributo();
         result = 37 * result + this.getIdProducto();
         return result;
   }   


}



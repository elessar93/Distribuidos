package org.rafa.dtd;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UnidadId  implements java.io.Serializable {


     private int idUnidad;
     private int idTipo;

    public UnidadId() {
    }

    public UnidadId(int idUnidad, int idTipo) {
       this.idUnidad = idUnidad;
       this.idTipo = idTipo;
    }
   


    @Column(name="idUnidad", nullable=false)
    public int getIdUnidad() {
        return this.idUnidad;
    }
    
    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }


    @Column(name="idTipo", nullable=false)
    public int getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UnidadId) ) return false;
		 UnidadId castOther = ( UnidadId ) other; 
         
		 return (this.getIdUnidad()==castOther.getIdUnidad())
 && (this.getIdTipo()==castOther.getIdTipo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUnidad();
         result = 37 * result + this.getIdTipo();
         return result;
   }   


}



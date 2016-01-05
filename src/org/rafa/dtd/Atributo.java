package org.rafa.dtd;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;;

@Entity
@Table(name="atributo")
public class Atributo   {

	@Id @GeneratedValue(strategy=AUTO)
    @Column(name="idAtributo", unique=true, nullable=false)
     private Integer idAtributo;
	
	@Column(name="nom_atri", length=45)
     private String nomAtri;
	
	@Column(name="des_atri", length=45)
     private String desAtri;
	
    @Column(name="idTipo", nullable=false)
     private int idTipo;

    public Atributo() {
    }

    public Atributo(String nomAtri, String desAtri, int idTipo) {
       this.nomAtri = nomAtri;
       this.desAtri = desAtri;
       this.idTipo = idTipo;
    }
   
    
    public Integer getIdAtributo() {
        return this.idAtributo;
    }
    
    public void setIdAtributo(Integer idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNomAtri() {
        return this.nomAtri;
    }
    
    public void setNomAtri(String nomAtri) {
        this.nomAtri = nomAtri;
    }

    public String getDesAtri() {
        return this.desAtri;
    }
    
    public void setDesAtri(String desAtri) {
        this.desAtri = desAtri;
    }

    public int getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }


}
package org.rafa.dtd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario"
    ,catalog="distribuidos"
)
public class Usuario implements java.io.Serializable  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 268403179372724230L;
	private Integer idUser;
     private String nomUser;
     private String password;
     private int role;
     private String appUser;

    public Usuario() {
    }

	
    public Usuario(String nomUser, String password, int role) {
        this.nomUser = nomUser;
        this.password = password;
        this.role = role;
    }
    public Usuario(String nomUser, String password, int role, String appUser) {
       this.nomUser = nomUser;
       this.password = password;
       this.role = role;
       this.appUser = appUser;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idUser", unique=true, nullable=false)
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    
    @Column(name="nom_user", nullable=false, length=45)
    public String getNomUser() {
        return this.nomUser;
    }
    
    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    
    @Column(name="password", nullable=false, length=50)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="role", nullable=false)
    public int getRole() {
        return this.role;
    }
    
    public void setRole(int role) {
        this.role = role;
    }

    
    @Column(name="app_user", length=45)
    public String getAppUser() {
        return this.appUser;
    }
    
    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
    	return idUser+" "+nomUser+" "+password+" "+role;
    }


}



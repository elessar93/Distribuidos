package org.rafa.dtd;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	@Id @GeneratedValue
	@Column(name = "id_producto")
	private int id;
	
	@Column(name = "nb_producto")
	private int nb_producto;
	
	@Column(name = "ds_producto")
	private int ds_producto;
	
	@Column(name = "nu_existencia")
	private int nu_existencia;
	
	@Column(name = "nu_costo",
			nullable=true)
	private float nu_costo;
	
	public int getId() {
		return id;
	}
	public void setId_producto(int id_producto) {
		this.id = id_producto;
	}
	public int getNb_producto() {
		return nb_producto;
	}
	public void setNb_producto(int nb_producto) {
		this.nb_producto = nb_producto;
	}
	public int getDs_producto() {
		return ds_producto;
	}
	public void setDs_producto(int ds_producto) {
		this.ds_producto = ds_producto;
	}
	public int getNu_existencia() {
		return nu_existencia;
	}
	public void setNu_existencia(int nu_existencia) {
		this.nu_existencia = nu_existencia;
	}
	public float getNu_costo() {
		return nu_costo;
	}
	public void setNu_costo(float nu_costo) {
		this.nu_costo = nu_costo;
	}
	public Producto(int nb_producto, int ds_producto, int nu_existencia, float nu_costo) {
		this.nb_producto = nb_producto;
		this.ds_producto = ds_producto;
		this.nu_existencia = nu_existencia;
		this.nu_costo = nu_costo;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nb_producto=" + nb_producto + ", ds_producto=" + ds_producto
				+ ", nu_existencia=" + nu_existencia + ", nu_costo=" + nu_costo + "]";
	}
	

}

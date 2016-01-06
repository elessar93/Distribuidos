package org.rafa.dao;

import java.util.List;

import org.hibernate.Session;
import org.rafa.dtd.TipoUnidad;
import org.rafa.dtd.Unidad;
import org.rafa.dtd.UnidadId;

public class DAOUnidad {
	Session session = null;
	public DAOUnidad() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void alta(Unidad u){
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		System.out.println(u.getId());
	}
	public Unidad getById(UnidadId uid){
		session.beginTransaction();
		return (Unidad)session.get(Unidad.class, uid);
	}
	public List<Unidad> getAll(){
		return session.createCriteria(Unidad.class).list();
	}
}

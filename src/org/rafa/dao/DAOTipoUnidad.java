package org.rafa.dao;

import java.util.List;

import org.hibernate.Session;
import org.rafa.dtd.Producto;
import org.rafa.dtd.TipoUnidad;

public class DAOTipoUnidad {
	Session session = null;
	public DAOTipoUnidad() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	public void alta(TipoUnidad tu){
		session.beginTransaction();
		session.save(tu);
		session.getTransaction().commit();
	}
	public TipoUnidad getById(int id){
		session.beginTransaction();
		return (TipoUnidad)session.get(TipoUnidad.class, id);
	}
	public List<TipoUnidad> getAll(){
		return session.createCriteria(TipoUnidad.class).list();
	}
	public void update(TipoUnidad tu){
		session.beginTransaction();
		session.update(tu);
		session.getTransaction().commit();
	}
}

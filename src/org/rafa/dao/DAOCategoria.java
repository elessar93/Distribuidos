package org.rafa.dao;

import java.util.List;

import org.hibernate.Session;
import org.rafa.dtd.Categoria;
import org.rafa.dtd.Unidad;

public class DAOCategoria {
	Session session = null;
	public DAOCategoria() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	public void alta (Categoria c){
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}
	public void borrar (Categoria c){
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
	}
	public Categoria getById(int id){
		return (Categoria)session.get(Categoria.class, id);
	}
	public List<Categoria> getAll(){
		return session.createCriteria(Categoria.class).list();
	}
}

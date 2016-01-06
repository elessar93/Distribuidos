package org.rafa.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.rafa.dtd.Producto;

public class DAOProducto {
	Session session = null;

	public DAOProducto() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	public void alta(Producto p){
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
    }
	public void eliminar(Producto p){
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
	}
	public void update(Producto p){
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
	}
	public Producto produtoById8(int id){
		Producto p=null;
		session.beginTransaction();
		p=(Producto)session.get(Producto.class, id);
		return p;
	}
}

package org.rafa.dao;

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
}

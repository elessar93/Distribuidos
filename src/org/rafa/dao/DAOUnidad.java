package org.rafa.dao;

import org.hibernate.Session;
import org.rafa.dtd.Unidad;

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
}

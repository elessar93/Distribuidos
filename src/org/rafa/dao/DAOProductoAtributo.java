package org.rafa.dao;

import org.hibernate.Session;

public class DAOProductoAtributo {
	Session session = null;
	public DAOProductoAtributo() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

}

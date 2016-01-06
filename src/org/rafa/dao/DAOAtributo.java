package org.rafa.dao;

import org.hibernate.Session;

public class DAOAtributo {
	Session session = null;
    public DAOAtributo() {
    	this.session = HibernateUtil.getSessionFactory().openSession();
	}
}

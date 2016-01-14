package org.rafa.dao;

import org.hibernate.Session;
import org.rafa.dtd.EstatusCompra;

public class DAOEstatusCompra {
	Session session = null;
	public DAOEstatusCompra() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	public EstatusCompra getById(int id){
		return (EstatusCompra)session.get(EstatusCompra.class, id);
	}
}

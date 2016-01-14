package org.rafa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.rafa.dtd.Compra;
import org.rafa.dtd.EstatusCompra;
import org.rafa.dtd.Usuario;

public class DAOCompra {
	Session session = null;
	public DAOCompra() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	public void nuevo (Compra c ){
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}
	public List<Compra> getByUser(Usuario u){
		Criteria criteria = session.createCriteria(Compra.class);
		criteria.add(Restrictions.eq("usuario", u));
		return criteria.list();
	}
	public void update(Compra c){
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
	}
	public Compra getById(int id){
		Compra res;
		res = (Compra)session.get(Compra.class, "idCompra");
		return res;
	}
}

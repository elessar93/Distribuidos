package org.rafa.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.rafa.dtd.Compra;
import org.rafa.dtd.Detalle;
import org.rafa.dtd.Producto;

public class DAODetalle {
	Session session = null;
	public DAODetalle() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	public void nuevo (Detalle d ){
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
	}
	public List<Detalle> getByCompra(Compra c){
		Criteria criteria = session.createCriteria(Detalle.class);
		criteria.add(Restrictions.eq("compra", c));
		return criteria.list();
	}
	public void update(Detalle d){
		session.beginTransaction();
		session.update(d);
		session.getTransaction().commit();
	}
	public Detalle getByCompraProducto(Compra c , Producto p){
		Criteria criteria=session.createCriteria(Detalle.class);
		criteria.add(Restrictions.eq("compra", c));
		criteria.add(Restrictions.eq("producto",p));
		return (Detalle) criteria.uniqueResult();
	}
}

package org.rafa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.rafa.dtd.Categoria;
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
	public Producto produtoById(int id){
		Producto p=null;
		session.beginTransaction();
		p=(Producto)session.get(Producto.class, id);
		return p;
	}
	public List<Categoria> prodctosByCategoria(Categoria categoria){
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Producto.class);
		criteria.add(Restrictions.eq("categorias", categoria));
		return criteria.list();
	}
}

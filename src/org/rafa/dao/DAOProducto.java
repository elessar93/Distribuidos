package org.rafa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.rafa.dtd.Categoria;
import org.rafa.dtd.Producto;

import javassist.convert.Transformer;

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
	public List<Producto> prodctosByCategoria(int categoria){
		session.beginTransaction();
		String sql = "select producto.idProducto,nom_prod,des_prod,nu_existencia,nu_costo from producto  join categoria_producto  where  producto.idProducto = categoria_producto.idProducto and idCategoria='"+categoria+"'; ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(Producto.class));
		List results = query.list();
		return results;
		
		//;
	}
	public List<Producto> productosLikeNombre(String nombre){
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Producto.class);
		criteria.add(Restrictions.like("nomProd", "%"+nombre+"%"));
		return criteria.list();
	}
}

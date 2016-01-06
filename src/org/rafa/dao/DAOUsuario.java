package org.rafa.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.rafa.dtd.Usuario;

public class DAOUsuario {
	Session session = null;
	
	public DAOUsuario() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public Usuario login(String nom_user,String password){
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nomUser", nom_user));
		Usuario u = (Usuario)criteria.uniqueResult();
		if(u!=null){
			if(u.getPassword().equals(password))
				return u;
		}
		return null;
	}
	
	public boolean registrar(Usuario u){
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nomUser", u.getNomUser()));
		Usuario u1 = (Usuario)criteria.uniqueResult();
		if(u1!=null)
			return false;
		try{
			session.save(u);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Usuario usuarioById(int id){
		Usuario u ;
		session.beginTransaction();
		u = (Usuario)session.get(Usuario.class, id);
		return u;
	}
}

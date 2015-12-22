package org.rafa.dao;
import org.hibernate.cfg.AnnotationConfiguration;
import org.rafa.dtd.Producto;
import org.hibernate.SessionFactory;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
    	try{
            sessionFactory = new AnnotationConfiguration().configure().
            		addPackage("org.rafa.dtd").addAnnotatedClass(Producto.class).buildSessionFactory();
         }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
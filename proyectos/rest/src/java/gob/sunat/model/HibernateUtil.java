package gob.sunat.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author cesar
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            /*
            sessionFactory = new AnnotationConfiguration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();
            */
            sessionFactory = new Configuration()
            .configure()
                    // configures settings from hibernate.cfg.xml
            .buildSessionFactory();
       } catch (Throwable ex) {
            // Log the exception. 
   //   } catch (org.hibernate.HibernateException he) {
       
  
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        
        return HibernateUtil.sessionFactory;
    }
    
    public static EntityManagerFactory getEntityManagerFactory()
    {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );

            return entityManagerFactory;
    }
}

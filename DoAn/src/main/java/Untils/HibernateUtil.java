package Untils;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.File;

import org.hibernate.SessionFactory;


public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static { 

			 try {
			File file = new File("");
			System.out.println("path:" + file.getAbsolutePath());
			 sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
			 } catch (Throwable ex) {
			
			 System.err.println("Initial SessionFactory creation failed." + ex);
			
			 throw new ExceptionInInitializerError(ex);
			
			 }

	}

	 public static SessionFactory getSessionFactory() {
	
		 return sessionFactory;
	
	 }

}

/*
public class HibernateUtil {

    private final SessionFactory sessionFactory;

    public HibernateUtil() {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
*/
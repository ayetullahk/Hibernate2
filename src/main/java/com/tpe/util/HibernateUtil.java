package com.tpe.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory ;

    static {
        try {
            sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable t) {
            System.out.println("Session factory Could not be created"+t);
            throw new ExceptionInInitializerError();
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

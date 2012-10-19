/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> sessionThread;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            sessionThread = new ThreadLocal<Session>();

        } catch (Throwable ex) {
            System.err.println("A criação da SessionFactory inicial falhou." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        Session session = sessionThread.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessionThread.set(session);

        }
        return session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import util.HibernateUtil;

/**
 *
 * @author root
 */
public class HibernateDAO<T> implements InterfaceDAO<T>{

    private Class<T> classe;

    public HibernateDAO(Class<T> classe) {
        super();
        this.classe = classe;
    }

    @Override
    public void save(T bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(bean);
        session.beginTransaction().commit();
        session.close();
    }

    @Override
    public void update(T bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(bean);
        session.beginTransaction().commit();
        session.close();
    }

    @Override
    public void remove(T bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(bean);
        session.beginTransaction().commit();
        session.close();
    }

    @Override
    public T getBean(Serializable codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        T bean = (T)session.get(classe,codigo);
        session.beginTransaction().commit();
        session.close();
        return bean;
    }

    @Override
    public List<T> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<T> beans = (List<T>)session.createCriteria(classe)
                .addOrder(Order.asc("id"))
                .list();
        session.beginTransaction().commit();
        session.close();
        return beans;
    }

}
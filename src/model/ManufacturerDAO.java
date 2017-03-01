/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Manufacturer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class ManufacturerDAO {
    private final SessionFactory sessionFactory;
    public ManufacturerDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public List<Manufacturer> getManufacturerList() {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Manufacturer.class.getName();
            Query query = session.createQuery(hql);
            List<Manufacturer> list = query.list();
            session.getTransaction().commit();
            return list;    
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Manufacturer getManufacturerByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Manufacturer.class.getName() + " m WHERE m.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            Manufacturer manufacturer = (Manufacturer) query.uniqueResult();
            session.getTransaction().commit();
            return manufacturer;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean addOrUpdateManufacturer(Manufacturer man) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(man);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean deleteManufacturer(Manufacturer man) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(man);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Customer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class CustomerDAO {
    private final SessionFactory sessionFactory;
    
    public CustomerDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public List<Customer> getCustomerList() {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            String hql = "FROM " + Customer.class.getName();
            Query query = session.createQuery(hql);
            List<Customer> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Customer getCustomerById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            String hql = "FROM " + Customer.class.getName() + " c WHERE c.idCustomer = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("ID", id);
            Customer customer = (Customer) query.uniqueResult();
            session.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean addOrUpdateCustomer(Customer c) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            session.saveOrUpdate(c);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean deleteCustomer(Customer c) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
 
            
            
}

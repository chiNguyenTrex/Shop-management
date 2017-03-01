/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Category;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class CategoryDAO {
    private final SessionFactory sessionFactory;
    
    public CategoryDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public List<Category> getCategoryList() {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            String hql = "FROM " + Category.class.getName();
            Query  query = session.createQuery(hql);
            List<Category> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean addOrUpdateCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            session.saveOrUpdate(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public Category getCategorybyId(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            String hql = "FROM " + Category.class.getName() + " c WHERE c.idCategory = :iD";
            Query query = session.createQuery(hql);
            query.setParameter("iD", id);
            Category category = (Category) query.uniqueResult();
            session.getTransaction().commit();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    public Category getCategoryByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Category.class.getName() + " c WHERE c.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            Category category = (Category) query.uniqueResult();
            session.getTransaction().commit();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean deleteCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
}

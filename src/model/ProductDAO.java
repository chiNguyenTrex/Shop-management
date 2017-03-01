/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Category;
import entities.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class ProductDAO {
    private final SessionFactory sessionFactory;
    
    public ProductDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Product.class.getName();
            Query query = session.createQuery(hql);
            List<Product> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }       
    }
    
    public Product getProductById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Product.class.getName() + " p WHERE p.idProduct = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("ID", id);
            Product product = (Product) query.uniqueResult();
            session.getTransaction().commit();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public List<Product> getProductByCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Product.class.getName() + " p WHERE p.category =:cate";
            Query query = session.createQuery(hql);
            query.setParameter("cate", category);
            List<Product> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean addOrUpdateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public List<Product> getListProductByName(String nameP) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            String hql = "FROM " + Product.class.getName() + " p WHERE p.name like :n";
            Query query = session.createQuery(hql);
            query.setParameter("n", "%" + nameP + "%");
            List<Product> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        List<Product> l = p.getListProductByName("k");
        l.stream().forEach((e) -> {
            System.out.println(e.getName());
        });
    }
    

}

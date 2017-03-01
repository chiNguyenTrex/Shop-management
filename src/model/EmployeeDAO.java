/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Employee;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class EmployeeDAO {

    private final SessionFactory sessionFactory;

    public EmployeeDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Employee> getEmployeeList() {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            String hql = "FROM " + Employee.class.getName();
            Query query = session.createQuery(hql);
            List<Employee> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean isUsernameDublicate(String username) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Employee.class.getName() + " e WHERE e.username =:username";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            Employee employee = (Employee) query.uniqueResult();
            session.getTransaction().commit();
            if (employee != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    public Employee getEmployeeById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Employee.class.getName() + " ee WHERE ee.idEmployee = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("ID", id);
            Employee employee = (Employee) query.uniqueResult();
            session.getTransaction().commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
     public Employee getEmployeeByName(String id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "FROM " + Employee.class.getName() + " ee WHERE ee.name = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("ID", id);
            Employee employee = (Employee) query.uniqueResult();
            session.getTransaction().commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean addOrUpdateEmployee(Employee e) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(e);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean deleteEmployee(Employee em) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(em);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public Employee getEmployeeByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            String hql = "FROM " + Employee.class.getName() + " e WHERE e.username = :user AND e.password = :pass";
            Query query = session.createQuery(hql);
            query.setParameter("user", username);
            query.setParameter("pass", password);
            Employee u = (Employee) query.uniqueResult();
            session.getTransaction().commit();
            return u;

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

  
     public List<Employee> getListEmployeeByName(String nameE) {
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            String hql = "FROM " + Employee.class.getName() + " p WHERE p.name like :n";
            Query query = session.createQuery(hql);
            query.setParameter("n", "%" + nameE + "%");
            List<Employee> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

}

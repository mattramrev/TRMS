package TRMS.Repository;

import TRMS.Util.HibernateUtil;
import TRMS.logger.MyLogger;
import TRMS.models.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.html.HTMLInputElement;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoHBImp implements EmployeeRepo{
    @Override
    public Employee addEmployee(Employee e) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.persist(e);
            transaction.commit();
        } catch (HibernateException ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
        return e;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Employee employee = null;
        try{
            employee = session.get(Employee.class, id);
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = HibernateUtil.getSession();

        List employees = null;
        try{
            employees = session.createQuery("FROM Employee").list();
            //MyLogger.logger.info("does it happen here?");
        } catch (HibernateException e) {
            e.printStackTrace();
            MyLogger.logger.warn("HibernateException");
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public Employee updateEmployee(int id, Employee e) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.merge(e);
            transaction.commit();
        } catch (HibernateException ex){
            ex.printStackTrace();
            if(transaction!=null) transaction.rollback();
            return null;
        } finally {
            session.close();
        }
        return e;
    }

    @Override
    public Employee deleteEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        Employee emp = null;
        try{
            transaction = session.beginTransaction();
            emp = session.getReference(Employee.class, id);
            session.delete(emp);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        } finally {
            session.close();
        }
        return emp;
    }
}

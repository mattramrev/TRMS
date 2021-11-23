package TRMS.Repository;

import TRMS.Util.HibernateUtil;
import TRMS.models.Grade;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GradeRepoHBImp implements GradeRepo{
    @Override
    public Grade addGrade(Grade g) {
        Session session = HibernateUtil.getSession();
        Transaction t = null;

        try{
            t= session.beginTransaction();
            session.persist(g);
            t.commit();
        }catch(HibernateException e)
        {
            e.printStackTrace();
            if(t!=null) t.rollback();
        }finally {
            session.close();
        }
        return g;
    }

    @Override
    public Grade getGrade(int eventID) {
        Session session = HibernateUtil.getSession();
        Grade g = null;

        try
        {
            g = session.get(Grade.class, eventID);

        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Grade updateGrade(int eventID, Grade g) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try{
            session.merge(g);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
            return null;
        } finally{
            session.close();
        }
        return g;
    }

    @Override
    public Grade deleteGrade(Grade g) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(g);
            transaction.commit();
        } catch (HibernateException e)
        {
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
        }
        finally {
            session.close();
        }
        return g;
    }
}

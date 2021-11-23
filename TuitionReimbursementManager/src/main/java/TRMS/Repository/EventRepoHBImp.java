package TRMS.Repository;

import TRMS.Util.HibernateUtil;
import TRMS.models.Event;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EventRepoHBImp implements EventRepo{
    @Override
    public Event addEvent(Event ev) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.persist(ev);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
        }finally {
            session.close();
        }
        return ev;
    }

    @Override
    public Event getEvent(int id) {
        Session session = HibernateUtil.getSession();
        Event event = null;

        try {
            event = session.getReference(Event.class, id);
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return event;
    }

    @Override
    public List<Event> getAllEmployeeEvents(int employeeID) {
        Session session = HibernateUtil.getSession();
        List<Event> events =null;
        try{
            events = session.createQuery("From Event").list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return events;
    }

    @Override
    public Event updateEvent(int id, Event ev) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.merge(ev);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
            return null;
        } finally {
            session.close();
        }
        return ev;
    }

    @Override
    public Event deleteEvent(int id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        Event event = null;
        try {
            transaction = session.beginTransaction();
            event = session.getReference(Event.class, id);
            session.delete(event);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return event;
    }
}

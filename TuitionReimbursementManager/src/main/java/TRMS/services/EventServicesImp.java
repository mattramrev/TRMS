package TRMS.services;

import TRMS.Repository.EventRepo;
import TRMS.models.Event;

import java.util.List;

public class EventServicesImp implements EventServices{

    EventRepo er;

    public EventServicesImp(EventRepo er) {
        this.er = er;
    }

    @Override
    public Event submitEvent(Event e) {
        return er.addEvent(e);
    }

    @Override
    public Event getEvent(int id) {
        return er.getEvent(id);
    }

    @Override
    public List<Event> getAllEmployeeEvents(int employeeID) {
        return er.getAllEmployeeEvents(employeeID);
    }

    @Override
    public Event updateEvent(int id, Event e) {
        return er.updateEvent(id,e);
    }

    @Override
    public Event cancelEventRequest(int id) {
        return er.deleteEvent(id);
    }

    @Override
    public Event getSuperApproval(int eventID, int SuperID) {
        return null;
    }

    @Override
    public Event getDepHeadApproval(int eventID, int depHead) {
        return null;
    }

    @Override
    public Event getBenCoApproval(int eventID) {
        return null;
    }

    @Override
    public Event checkTime(int eventID) {
        return null;
    }
}

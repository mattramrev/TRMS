package TRMS.services;

import TRMS.models.Event;

import java.util.List;

public interface EventServices {

    public Event submitEvent(Event e);
    public Event getEvent(int id);
    public List<Event> getAllEmployeeEvents(int employeeID);
    public Event updateEvent(int id, Event e);
    public Event cancelEventRequest(int id);



    public Event getSuperApproval(int eventID, int SuperID);
    public Event getDepHeadApproval(int eventID, int depHead);
    public Event getBenCoApproval(int eventID);
    public Event checkTime(int eventID);


}

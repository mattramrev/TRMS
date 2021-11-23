package TRMS.Repository;

import TRMS.models.Event;

import java.util.List;

public interface EventRepo {
    public Event addEvent(Event e);
    public Event getEvent(int id);
    public List<Event> getAllEmployeeEvents(int employeeID);
    public Event updateEvent(int id, Event e);
    public Event deleteEvent(int id);


}

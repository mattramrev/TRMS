package TRMS.controllers;

import TRMS.logger.MyLogger;
import TRMS.models.Event;
import TRMS.services.EventServices;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class EventController {

    EventServices es;
    Gson gson = new Gson();

    public EventController(EventServices es) {this.es = es; }

    public Handler submitEvent = (context) -> {
        int eventTypeID = Integer.parseInt(context.header("eventTypeID"));
        //MyLogger.logger.info(eventTypeID);
        double price = Double.parseDouble(context.header("price"));
        String location = context.header("location");
        String description = context.header("description");
        String reason = context.header("reason");
        int employeeID = Integer.parseInt(context.header("employeeID"));
        //MyLogger.logger.info("employeeID reached");
        long time = Long.parseLong(context.header("time"));

        Event newEvent = new Event(eventTypeID, price, location, description, reason, null, time);
            newEvent = es.submitEvent(newEvent);
        context.result((newEvent!=null)?gson.toJson(newEvent):"{}");
    };

    public Handler getEventByID = (context) -> {
        String input = context.pathParam("eventID");
        int id;

        try{
            id = Integer.parseInt(input);
        } catch (NumberFormatException e){
            id= -1;
            e.printStackTrace();
        }
        Event event = es.getEvent(id);

        if(event!=null){
            context.result(gson.toJson(event));
        } else {
            context.status(400);
        }
    };

    public Handler updateEvent = (context) -> {
        int id = 0;
        Event event = gson.fromJson(context.body(), Event.class);
        try {
            id = Integer.parseInt(context.pathParam("eventID"));
            event.setEventID(id);
        } catch (NumberFormatException e)
        {
            e.printStackTrace();
            id= -1;
        }
        event = es.updateEvent(id, event);
        context.result((event!=null) ? gson.toJson(event) : "{}");
        };

    public Handler deleteEvent = (context) -> {
        int id = Integer.parseInt(context.pathParam("eventID"));
        Event event = es.cancelEventRequest(id);
        context.result((event!=null) ? gson.toJson(event) : "{}");
    };

    public Handler getAllEvents = (context)->{
        int id = Integer.parseInt(context.pathParam("employeeID"));
        List<Event> eventList = es.getAllEmployeeEvents(id);
        context.result((eventList!=null) ? gson.toJson(eventList) : "{}");
    };


}


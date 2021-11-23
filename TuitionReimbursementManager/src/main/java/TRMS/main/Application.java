package TRMS.main;

import TRMS.Repository.EmployeeRepoHBImp;
import TRMS.Repository.EventRepoHBImp;
import TRMS.Repository.GradeRepoHBImp;
import TRMS.controllers.EmployeeController;
import TRMS.controllers.EventController;
import TRMS.controllers.GradeController;
import TRMS.services.EmployeeServiceImp;
import TRMS.services.EmployeeServices;
import TRMS.services.EventServicesImp;
import TRMS.services.GradeServiceImp;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        establishRoutes(app);
        app.start(7000);
    }

    private static void establishRoutes(Javalin app){

        addEmployeeRoutes(app);
        addEventRoutes(app);
        addGradeRoutes(app);



    }
    private static void addEmployeeRoutes(Javalin app){
        EmployeeRepoHBImp er = new EmployeeRepoHBImp();
        EmployeeServiceImp es = new EmployeeServiceImp(er);
        EmployeeController ec = new EmployeeController(es);

        app.get("/", ec.login);
        app.get("/employee/:employeeID", ec.getEmployeeByID);
        app.delete("/employee/:id", ec.deleteEmployee);
        app.post("/employee", ec.addEmployee);


    }

    private static void addEventRoutes(Javalin app){
        EventRepoHBImp er = new EventRepoHBImp();
        EventServicesImp es = new EventServicesImp(er);
        EventController ec = new EventController(es);

        app.get("employee/:employeeID/events/:eventID", ec.getEventByID);
        app.get("employee/:employeeID/events", ec.getAllEvents);
        app.post("employee/:employeeID/events", ec.submitEvent);
        app.put("employee/:employeeID/events/:eventID", ec.updateEvent);
        app.delete("employee/:employeeID/events/:eventID", ec.deleteEvent);

    }

    private static void addGradeRoutes(Javalin app){
        GradeRepoHBImp gr = new GradeRepoHBImp();
        GradeServiceImp gs = new GradeServiceImp(gr);
        GradeController gc = new GradeController(gs);

        app.get("employee/:employeeID/events/:eventID/grade", gc.getGrade);
        app.post("employee/:employeeID/events/:eventID/grade", gc.addGrade);
        app.put("employee/:employeeID/events/:eventID/grade", gc.updateGrade);
    }
}

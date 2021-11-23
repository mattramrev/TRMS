package TRMS.controllers;

import TRMS.logger.MyLogger;
import TRMS.models.Employee;
import TRMS.models.Event;
import TRMS.services.EmployeeServices;
import TRMS.services.EventServices;
import com.google.gson.Gson;
import io.javalin.http.Handler;
import io.javalin.http.HttpResponseException;

import java.util.List;

public class EmployeeController {

    EmployeeServices es;
    Gson gson = new Gson();

    public EmployeeController(EmployeeServices es) {this.es = es; }

    public Handler addEmployee = (context) -> {
        Employee employee = gson.fromJson(context.body(), Employee.class);
        employee = es.addEmployee(employee);
        context.result((employee!=null)?gson.toJson(employee):"{}");
    };

    public Handler getEmployeeByID = (context) -> {
        String input = context.pathParam("employeeID");
        int id;

        try{
            id = Integer.parseInt(input);
        } catch (NumberFormatException e){
            id= -1;
            e.printStackTrace();
        }
        Employee employee = es.getEmployee(id);

        if(employee!=null){
            context.result(gson.toJson(employee));
        } else {
            context.status(400);
        }
    };
    public Handler getAllEmployees = (context) ->
    {
        List<Employee> employeeList = es.getAllEmployees();
        context.result(gson.toJson(employeeList));
    };

    public Handler updateEmployee = (context) -> {
        int id = 0;
        Employee employee = gson.fromJson(context.body(), Employee.class);
        try {
            id = Integer.parseInt(context.pathParam("employeeID"));
            employee.setId(id);
        } catch (NumberFormatException e)
        {
            e.printStackTrace();
            id= -1;
        }
        employee = es.updateEmployee(id, employee);
        context.result((employee!=null) ? gson.toJson(employee) : "{}");
    };

    public Handler deleteEmployee = (context) -> {
        int id = Integer.parseInt(context.pathParam("EmployeeID"));
        Employee employee = es.deleteEmployee(id);
        context.result((employee!=null) ? gson.toJson(employee) : "{}");
    };

    public Handler login = (context) -> {
        //MyLogger.logger.info("controller reached");

        if(context.basicAuthCredentialsExist()) {
            MyLogger.logger.info("if statement");

            String username = context.basicAuthCredentials().getUsername();
            //MyLogger.logger.info(username);
            String password = context.basicAuthCredentials().getPassword();
            //MyLogger.logger.info(password);
            List<Employee> employeeList = es.getAllEmployees();
            //MyLogger.logger.info(employeeList);
            if (employeeList != null) {
                for (Employee e : employeeList) {
                    if (e.getAcctName().equals(username) && e.getAcctPass().equals(password)) {
                        Employee loginEmployee = es.getEmployee(e.getId());
                        context.result(gson.toJson(loginEmployee));
                        context.status(200);

                    }
                }

            }


        }
        };

    }


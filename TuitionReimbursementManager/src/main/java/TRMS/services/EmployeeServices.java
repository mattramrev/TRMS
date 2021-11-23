package TRMS.services;

import TRMS.models.Employee;

import java.util.List;

public interface EmployeeServices {

    public Employee addEmployee(Employee e);

    public Employee getEmployee(int id);

    public List<Employee> getAllEmployees();

    public  Employee updateEmployee(int id, Employee e);

    public Employee deleteEmployee(int id);

    public Employee reimburseForEvent(int empID, int eventID);





}

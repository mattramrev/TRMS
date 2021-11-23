package TRMS.services;

import TRMS.Repository.EmployeeRepo;
import TRMS.models.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeServices{

    EmployeeRepo er;

    public EmployeeServiceImp(EmployeeRepo er) {this.er = er;}

    @Override
    public Employee addEmployee(Employee e) {
        return er.addEmployee(e);
    }

    @Override
    public Employee getEmployee(int id) {
        return er.getEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return er.getAllEmployees();
    }

    @Override
    public Employee updateEmployee(int id, Employee e) {
        return er.updateEmployee(id,e);
    }

    @Override
    public Employee deleteEmployee(int id) {
        return er.deleteEmployee(id);
    }

    @Override
    public Employee reimburseForEvent(int empID, int eventID) {
        return null;
    }
}

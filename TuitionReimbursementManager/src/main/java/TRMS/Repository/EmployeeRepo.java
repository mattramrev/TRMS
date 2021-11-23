package TRMS.Repository;

import TRMS.models.Employee;

import java.util.List;

public interface EmployeeRepo
{
    public Employee addEmployee(Employee e);
    public Employee getEmployee(int id);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(int id, Employee e);
    public Employee deleteEmployee(int id);
}

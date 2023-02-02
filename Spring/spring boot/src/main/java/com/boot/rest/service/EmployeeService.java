package com.boot.rest.service;

import com.boot.rest.entity.Employee;
import java.util.List;

public interface EmployeeService {
    
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee empl);

    public Employee getEmployeeById(int id);

    public void deleteEmployee(int id);
    
    public List<Employee> getEmployeesByName(String name);
}

package com.olga.dao;

import com.olga.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee empl);
    
    public Employee getEmployeeById(int id);
    
    public void deleteEmployee(int id);
}

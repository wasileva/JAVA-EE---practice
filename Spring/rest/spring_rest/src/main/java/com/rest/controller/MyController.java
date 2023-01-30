package com.rest.controller;

import com.rest.entity.Employee;
import com.rest.exception_handling.NoSuchEmployeeException;
import com.rest.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id = " + id + " is absent in Databse");
        }
        return employee;
    }
    
    @PostMapping("/employee")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee!=null){
            employeeService.deleteEmployee(id);
        } else {
            throw new NoSuchEmployeeException("Employee with id = " + id + " is absent in Databse");
        }
        return "Employee with id = " + id + " deleted successfully";
    }
}

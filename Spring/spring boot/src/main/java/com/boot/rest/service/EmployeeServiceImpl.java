package com.boot.rest.service;

import com.boot.rest.dao.EmployeeRepository;
import com.boot.rest.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee empl) {
        employeeRepository.save(empl);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        Optional<Employee> empl = employeeRepository.findById(id);
        if (empl.isPresent()) {
            employee = empl.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    
    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findAllByName(name);
    }

}

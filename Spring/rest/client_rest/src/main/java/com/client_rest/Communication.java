package com.client_rest;

import com.client_rest.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Communication {
    
    @Autowired
    RestTemplate restTemplate;
    
    private final String URL = "http://localhost:8080/api/employee";
    
    public List<Employee> getAllEmployee() {
        
        ResponseEntity<List<Employee>> responseEntity = 
               restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>(){});
        return responseEntity.getBody();
    }
    
    public Employee getEmployee(int id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }
    
    public void saveEmployee(Employee employee){
        int id = employee.getId();
        
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println(responseEntity.getBody());        
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with id " + id + " was updated");
        }
    }
    
    public void deleteEmployee(int id) {
        restTemplate.delete(URL +"/" + id);
        System.out.println("Employee with id " + id + " was deleted");
    }
}

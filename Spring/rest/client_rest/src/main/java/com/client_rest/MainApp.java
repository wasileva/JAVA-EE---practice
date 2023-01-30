package com.client_rest;

import com.client_rest.configuration.MyConfig;
import com.client_rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean(Communication.class);
        System.out.println(communication.getAllEmployee());
        System.out.println(communication.getEmployee(1));
        communication.saveEmployee(new Employee(9, "Muka", "Herro", "IT", 8999));
        communication.deleteEmployee(9);
    }
}

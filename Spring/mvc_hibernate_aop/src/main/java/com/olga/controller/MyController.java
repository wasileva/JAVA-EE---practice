package com.olga.controller;

import com.olga.entity.Employee;
import com.olga.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    
    @Autowired
    EmployeeService employeeService;
    
    @RequestMapping("/")
    public String showAllEmpolyees(Model model){        
        List<Employee> empolyees = employeeService.getAllEmployees();      
        model.addAttribute("allEmpl", empolyees);       
        return "all-employees";
    }
    
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee empl = new Employee();
        model.addAttribute("employee", empl);
        return "add-customer";
    }
    
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee empl) {
        employeeService.saveEmployee(empl);
        return "redirect:/";
    }
    
    @RequestMapping("/updateInfo")
    public String updateEmployee(Model model, @RequestParam("empId") int id) {
        Employee empl = employeeService.getEmployeeById(id);
        model.addAttribute("employee", empl);
        return "add-customer";
    }
    
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}

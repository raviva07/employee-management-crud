package com.employee.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.emplyoee.model.Employee;
import com.employee.service.EmployeeService;
@Controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
  
    public class PageController {

        @GetMapping("/")
        public String index() {
            return "index"; // returns index.html from templates
        }
    }
   

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }


    // READ ALL
    @GetMapping("/displayAll")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // READ BY ID
    @GetMapping("/display/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        return service.getEmployeeById(employeeId).orElse(null);
    }

    // UPDATE
    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable String employeeId,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(employeeId, employee);
    }

    // DELETE
    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        service.deleteEmployee(employeeId);
        return "Employee Deleted Successfully";
    }
}

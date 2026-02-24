package com.employee.service;



import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.emplyoee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // READ BY ID
    public Optional<Employee> getEmployeeById(String id) {
        return repository.findById(id);
    }

    // UPDATE
    public Employee updateEmployee(String id, Employee updatedEmployee) {
        Optional<Employee> existing = repository.findById(id);

        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setName(updatedEmployee.getName());
            emp.setEmail(updatedEmployee.getEmail());
            emp.setLocation(updatedEmployee.getLocation());
            return repository.save(emp);
        } else {
            return null;
        }
    }

    // DELETE
    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}

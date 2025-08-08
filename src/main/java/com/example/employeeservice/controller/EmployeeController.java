// EmployeeController.java
package com.example.employeeservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
    	employee.setId((long) (employees.size() + 1));
    	employees.add(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }
}

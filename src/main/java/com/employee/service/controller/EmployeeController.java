// EmployeeController.java
package com.employee.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.employee.service.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private List<Employee> employees = new ArrayList<>();

    @PostMapping("addemployee")
    public Employee addEmployee(@RequestBody Employee employee) {
    	logger.info("Received POST request to create employee: {}", employee);
    	employee.setId((long) (employees.size() + 1));
    	employees.add(employee);
    	logger.info("Current employee list: {}", employees);
        return employee;
    }

    @GetMapping("getemployes")
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees, count: {}", employees.size());

        if (!employees.isEmpty()) {
            for (Employee emp : employees) {
            	logger.info("Employee Details:");
            	logger.info("   ID   : {}", emp.getId());
            	logger.info("   Name : {}", emp.getName());
            	logger.info("   Role : {}", emp.getRole());
            }
        } else {
            logger.warn("No employees found!");
        }
        return employees;
    }
}

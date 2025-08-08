package com.example.employeeservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

	private Long id;
	private String name;
	private String role;

	public Employee() {
	}

	public Employee(Long id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
}

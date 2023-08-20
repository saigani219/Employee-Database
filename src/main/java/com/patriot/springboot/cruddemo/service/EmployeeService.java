package com.patriot.springboot.cruddemo.service;

import com.patriot.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee theEmployee);

	void deleteById(int id);
}

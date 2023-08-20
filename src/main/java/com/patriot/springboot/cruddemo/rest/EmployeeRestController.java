package com.patriot.springboot.cruddemo.rest;


import com.patriot.springboot.cruddemo.entity.Employee;
import com.patriot.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	//inject employee service

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	//expose "/employees" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee employee = employeeService.findById(employeeId);

		if(employee == null)
			throw new RuntimeException("Employee not found with id : " + employeeId);

		return employee;

	}

	//add mapping for POST employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		//just in case if they pass an id .. set it to 0

		//this is to force a save of new item instead of updates

        theEmployee.setId(0);

		Employee dbEmployee = employeeService.save(theEmployee);

		return dbEmployee;
	}

	//add put mapping to update the employee details
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){

		Employee dbEmployee = employeeService.save(theEmployee);

		return dbEmployee;
	}

	//add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		Employee tempEmployee = employeeService.findById(employeeId);

		if(tempEmployee == null){
			throw new RuntimeException("Employee id not found : " + employeeId);
		}

		employeeService.deleteById(employeeId);

		return "Deleted Employee with id : " + employeeId;
	}
}

package com.patriot.springboot.cruddemo.service;

import com.patriot.springboot.cruddemo.dao.EmployeeRepository;
import com.patriot.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else{
			// couldn't find an employee with id
			throw new RuntimeException("Did not find the employee id - " + id);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {

		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}

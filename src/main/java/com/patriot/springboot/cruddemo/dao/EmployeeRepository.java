package com.patriot.springboot.cruddemo.dao;

import com.patriot.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it...  no need to write any code
}

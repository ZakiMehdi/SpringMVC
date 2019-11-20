package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.EmployeeTO;

@Service
public interface EmployeeService {

	public List<EmployeeTO> getAllEmployeeDetails();

	public void delete(int employeeId);

	public void saveOrUpdate(EmployeeTO employee);

	public EmployeeTO getEmployeeByEmployeeId(int employeeId);
	
}

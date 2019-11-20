package com.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import com.spring.dto.EmployeeTO;
import com.spring.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	 EmployeeDao employeeDao;
	
	@Override
	public List<EmployeeTO> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployeeDetails();
		 
	}

	@Override
	public void delete(int employeeId) {
		// TODO Auto-generated method stub
		employeeDao.delete(employeeId);
		
	}

	@Override
	public void saveOrUpdate(EmployeeTO employee) {
		employeeDao.saveOrUpdate(employee);
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeTO getEmployeeByEmployeeId(int employeeId) {
		
		return employeeDao.getEmployeeByEmployeeId(employeeId);
	}

	
}

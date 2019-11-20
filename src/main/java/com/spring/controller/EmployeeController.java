package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.EmployeeTO;
import com.spring.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/")
	public ModelAndView employeeList(ModelAndView model) throws IOException{
		List<EmployeeTO> employeeList = employeeService.getAllEmployeeDetails();
		model.addObject("employeeList", employeeList);
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		EmployeeTO employee = new EmployeeTO();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute EmployeeTO employee) {
		employeeService.saveOrUpdate(employee);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.delete(employeeId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		EmployeeTO employee = employeeService.getEmployeeByEmployeeId(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		
		model.addObject("employee", employee);
		
		return model;
	}

}

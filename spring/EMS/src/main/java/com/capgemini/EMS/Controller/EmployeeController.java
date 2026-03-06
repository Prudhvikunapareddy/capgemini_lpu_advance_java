package com.capgemini.EMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.EMS.Entity.Employee;
import com.capgemini.EMS.Service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller


public class EmployeeController {
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	@GetMapping("/signup")
	public String signUp() {
		return "signup";
	}
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute Employee emp) {
		return service.createEmp(emp);
		
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logincheck")
	public ModelAndView logincheck(HttpServletRequest request) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		return service.login(email, password);
	}

}
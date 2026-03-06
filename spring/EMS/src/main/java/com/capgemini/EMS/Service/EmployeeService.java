package com.capgemini.EMS.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.EMS.Entity.Employee;
import com.capgemini.EMS.Repository.EmployeeRepo;
@Service
public class EmployeeService {
	
	private EmployeeRepo jpa;
	
	public EmployeeService(EmployeeRepo jpa) {
		this.jpa = jpa;
	}
	
	public ModelAndView createEmp(Employee emp) {
		 Optional<Employee> e = jpa.findById(emp.getEmail());
		 ModelAndView m = new ModelAndView();
		 
		 if(e.isPresent()) {
			 m.addObject("msg",emp.getName());
			 m.setViewName("exist");
			 
			 return m;
		 }else {
			m.addObject("msg",emp.getName());
			m.setViewName("succesfull");
			Employee employee = jpa.save(emp);
			return m;
		 }
		
	}
	public ModelAndView login(String email,String password) {

	    Employee e = jpa.findByEmailAndPassword(email, password);
	    ModelAndView m = new ModelAndView();

	  
	    if(e == null){
	        m.addObject("msg", "Invalid Email or Password");
	        m.setViewName("login");
	        return m;
	    }

	    if(e.getRole().equalsIgnoreCase("admin")) {
	        List<Employee> emp = jpa.findAll();
	        m.addObject("msg",emp);
	        m.setViewName("admin");
	    } else {
	        m.addObject("msg",e);
	        m.setViewName("userdetails");
	    }

	    return m;
	}

}

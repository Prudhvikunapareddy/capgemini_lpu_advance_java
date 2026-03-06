package com.capgemini.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoContorller {
	@Autowired
	UsersJpaRepository jpa;
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
		}
	
	@GetMapping("/register")
	public String createAccount() {
		return "register";
	}
	
	@PostMapping("/create-account")
	
	public String register(@ModelAttribute Users users) {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String number =request.getParameter("number");
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(number);
		
//		System.out.println(users.getEmail());
//		System.out.println(users.getName());
//		System.out.println(users.getNumber());
		jpa.save(users);
		return "register";
	}
	@GetMapping("/Login")
	public String login() {
		return "login";
	}
	@PostMapping("/logincheck")
	public String loginchecck(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users user = jpa.findByEmailAndPassword(email, password);
		if(user!=null) {
			return "loginsuccess";
		}else {
			return "redirect:/Login";
		}
	}
	
	@GetMapping("/hi")
	public ModelAndView sendData() {
		ModelAndView m = new ModelAndView();
	List<String> names = List.of("Miller","Allen","Smith");
	m.addObject("msg",names);
	m.setViewName("abc");
	return m;
	}
}

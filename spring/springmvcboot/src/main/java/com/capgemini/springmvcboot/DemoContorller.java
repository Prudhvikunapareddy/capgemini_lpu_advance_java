package com.capgemini.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

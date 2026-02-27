package com.capgemini.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoContorller {
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
		}
}

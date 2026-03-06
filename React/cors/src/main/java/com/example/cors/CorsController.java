package com.example.cors;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CorsController {
	@GetMapping("/welcome")
	public String welcome() {
		return "";
	}
	@GetMapping("/api/hello")
	public String hello() {
		return "hello";
	}

}
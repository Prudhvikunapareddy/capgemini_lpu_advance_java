package com.capgemini.springbootbasic;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//@Controller
@RestController
public class DemoController {
	 
	@PostMapping("/a")
	
	public List<String>hello() {
		return List.of("prudhvi","krishna","kunapareddy");
	}
	
	@PostMapping("/add")
	public String createPlayer(@RequestBody Cricketer c) {
		System.out.println(c);
		return c.toString();
	}
}

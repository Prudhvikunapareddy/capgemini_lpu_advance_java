package com.classprac.springboot_task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerjpaRepository cusjpa;
	
	
	@PostMapping("/add")
	public String createCustomer(@RequestBody Customer c) {
		 Customer cu = cusjpa.save(c);
		 System.out.println(c);
		 return c.toString();
		
	}
	@GetMapping("/find")
	public String getbyid(@RequestParam int id) {
		Optional<Customer> c = cusjpa.findById(id);
		return c.isPresent()?c.get().toString():"data not exist";
	}
	
	@PutMapping("/update/{id}")
	public boolean updateCustomer(@PathVariable int id,@RequestBody Customer c) {
	Optional<Customer> optional =	cusjpa.findById(id);
	if(optional.isPresent()) {
		Customer cus  =  optional.get();
		cus.setAge(c.getAge());
		cus.setDob(c.getDob());
		cus.setEmail(c.getEmail());
		cus.setGender(c.getGender());
		cus.setName(c.getName());
		cus.setPhone(c.getPhone());
		cusjpa.save(cus);
		return true;
	}else {
		return false;
	}
	}
	
	@PatchMapping("/newone/{id}")
	public boolean updatedata(@PathVariable int id,@RequestBody Customer c) {
		Optional<Customer> optional = cusjpa.findById(id);
		if(optional.isPresent()) {
			Customer cus = optional.get();
			if(c.getAge() != 0) {
				cus.setAge(c.getAge());
			}
			cusjpa.save(cus);
			return true;
		}else {
			return false;
		}
	}
			
}

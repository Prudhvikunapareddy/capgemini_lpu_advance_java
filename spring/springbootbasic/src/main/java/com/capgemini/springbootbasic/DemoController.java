package com.capgemini.springbootbasic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/car")
	public String createCar(@RequestBody Car c) {
		System.out.println(c);
		return c.toString();
		
	}
	@PostMapping("/person")
	public String  createPerson(@RequestBody Person p){
		System.out.println(p);
		return p.toString();
	}
	 @Autowired
	CarJpaRepository carjpa;
	@PostMapping("/carr")
	public String createc(@RequestBody Car c) {
		Car C = carjpa.save(c);
		System.out.println(c);
		return c.toString();
	}
	
	@GetMapping("/find")
	public String getById(@RequestParam int id) {
		Optional<Car> c = carjpa.findById(id);
		return c.isPresent()?c.get().toString():"data not exist";
	}
	
	@DeleteMapping("/del/{id}")
	public boolean deletecar(@PathVariable int id) {
		 Optional<Car> option = carjpa.findById(id);
		 if(option.isPresent()) {
			 carjpa.delete(option.get());
			 return true;
		 }else {
			 return false;
		 }

		 
	}
	@PutMapping("/update/{id}")
	public boolean updateCar(@PathVariable int id,@RequestBody Car c) {
		Optional<Car> option = carjpa.findById(id);
		if(option.isPresent()) {
			Car car = option.get();
			car.setBrand(c.getBrand());
			car.setPrice(c.getPrice());
			carjpa.save(car);
			return true;
		}else {
			return false;
		}
	}
	
	@PatchMapping("/update-car/{id}")
	public boolean updateCarData(@PathVariable int id, @RequestBody Car c) {
		Optional<Car> option = carjpa.findById(id);
		if(option.isPresent()) {
			Car car = option.get();
			if(c.getBrand() != null) {
				car.setBrand(c.getBrand());
			}else if(c.getPrice() != 0.0) {
				car.setPrice(c.getPrice());
			}
			carjpa.save(car);
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/find/{price}")
	public Car getCarByPrice(@PathVariable double price) {
		return carjpa.getByPrice(price);
	}
	@DeleteMapping("/delete/{brand}")
	public String deleteByBrand(@PathVariable String brand) {
		carjpa.deleteByBrand(brand);
		return "deleted";
	}
}

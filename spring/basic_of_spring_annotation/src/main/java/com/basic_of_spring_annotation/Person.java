package com.basic_of_spring_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	//dependency Injection
//	@Autowired
	private Mobile mobile;
	
	public Mobile getMobile() {
		return mobile;
	}
//	@Autowired
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	@Autowired
	public Person(Mobile mobile) {
		super();
		this.mobile = mobile;
	}
	public void message() {
		System.out.println("Hi");
	
	}
}

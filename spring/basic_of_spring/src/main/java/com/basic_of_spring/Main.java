package com.basic_of_spring;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
public static void main(String[] args) {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
	 Person person = ioc.getBean("person",Person.class);
	 System.out.println(person);
	 person.message();
	 
	 Employee  emp = ioc.getBean("employee",Employee.class);
	 System.out.println(emp);
	 System.out.println(emp.getId());
	 System.out.println(emp.getName());
	 System.out.println(emp.getSalary());
}
}

package com.assignment;

public class User {
public static void main(String[] args) {
	StudentDao sd = new StudentDao();
	Student s = new Student();
//	s.setId(10);
//	s.setName("prudhvi");
//	s.setEmail("prudhvi@123");
//	s.setMarks(98.0);
//	sd.saveStudent(s);
//	
	Student sa = sd.findStudentById(10);
	System.out.println(sa);
	
}
}

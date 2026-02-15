package com.onetomay;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setStudent_id(101);
		s1.setBrand("cse");
		s1.setName("prudhvi");
		
		Student s2 = new Student();
		s2.setStudent_id(102);
		s2.setName("prince");
		s2.setBrand("Ece");
		College c = new College();
		c.setId(1);
		c.setName("ABC");
		c.setLocation("lpu");
		c.setPincode("528934");
		
		List<Student> list = new ArrayList<>();
		list.add(s2);
		list.add(s1);
		c.setSt(list);
		
		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(c);
		et.commit();
		
	}
}

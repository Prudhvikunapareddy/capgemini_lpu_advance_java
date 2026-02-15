package com.onetomay;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College c = em.find(College.class, 1);
		List<Student> list = c.getSt();
		Student s = new Student();
		s.setStudent_id(105);
		s.setName("Adam");
		s.setBrand("IT");
		list.add(s);
		c.setSt(list);
		et.begin();
		em.persist(s);
		et.commit();
	}

}

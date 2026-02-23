package com.cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
public static void main(String[] args) {
//	insert();
	read();
}
public static void insert() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Product p = new Product();
	p.setName("Pen");
	et.begin();
	em.persist(p);
	et.commit();
}
public static void read() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em1 = emf.createEntityManager();
	EntityManager em2 = emf.createEntityManager();
	System.out.println("---------Frist Level cache-------------");
	
	em1.find(Product.class,1);
	em2.find(Product.class,1);
}
}

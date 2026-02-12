package com.Product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdatePrice {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
//		String jpql = "update Product p set p.price=?1 where p.price = ?2";
//		et.begin();
//		
//		Query query = em.createQuery(jpql);
//		query.setParameter(1, 120.0);
//		query.setParameter(2, 10000.0);
//		query.executeUpdate();
//		et.commit();
//		em.close();
//		emf.close();
		String jpql ="select p from Product p where p.price >=:a";
		Query query = em.createQuery(jpql);
		query.setParameter("a",5.0);
		
		List<Product> list = query.getResultList();
		for(Product p :list) {
			System.out.println(p);
		}

	}

}

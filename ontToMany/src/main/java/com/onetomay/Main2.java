package com.onetomay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student stu = em.find(Student.class, 101);
		if(stu!=null) {
			String sql = "delete from college_student where st_student_id=?1";
			String Stusql = "delete from student where student_id=?1";
			
			Query query = em.createNativeQuery(sql);
			Query stuQuery = em.createNativeQuery(Stusql);
			query.setParameter(1,101);
			stuQuery.setParameter(1, 101);
			et.begin();
			query.executeUpdate();
			stuQuery.executeUpdate();
			
			et.commit();
		}
		
		
	}


}
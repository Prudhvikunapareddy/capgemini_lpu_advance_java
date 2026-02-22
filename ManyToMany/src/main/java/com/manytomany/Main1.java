package com.manytomany;



import java.util.Arrays;
import javax.persistence.*;

public class Main1{

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Studentt s1 = new Studentt();
        s1.setName("Prince");
        s1.setGender("Male");
        s1.setBranch("CSE");

        Subject sub1 = new Subject();
        sub1.setName("Java");
        sub1.setNo_of_days(30);

        Subject sub2 = new Subject();
        sub2.setName("DBMS");
        sub2.setNo_of_days(25);

        s1.setSubjects(Arrays.asList(sub1, sub2));

        et.begin();
        em.persist(sub1);
        em.persist(sub2);
        em.persist(s1);
        et.commit();

        System.out.println("Saved Successfully!");
    }
}


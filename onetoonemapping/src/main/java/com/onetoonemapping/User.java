package com.onetoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class User {

	
    static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");
    public static void saveCar(Car c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(c);
        et.commit();

        em.close();
        System.out.println("Car Saved Successfully");
    }
    public static void findCarById(int id) {
        EntityManager em = emf.createEntityManager();

        Car car = em.find(Car.class, id);

        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car Not Found");
        }

        em.close();
    }
    public static void deleteCarById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Car car = em.find(Car.class, id);

        if (car != null) {
            et.begin();
            em.remove(car);
            et.commit();
            System.out.println("Car Deleted");
        } else {
            System.out.println("Car Not Found");
        }

        em.close();
    }
    public static void updateCarById(int id, String newBrand) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Car car = em.find(Car.class, id);

        if (car != null) {
            et.begin();
            car.setBrand(newBrand);
            em.merge(car);
            et.commit();
            System.out.println("Car Updated");
        } else {
            System.out.println("Car Not Found");
        }

        em.close();
    }
    public static void main(String[] args) {

        Engine e = new Engine();
        e.setId(100);
        e.setType("V8");
        e.setFueltype("Petrol");
        e.setMileage("12");
        e.setCc("3000");

        Car c = new Car();
        c.setId(1);
        c.setBrand("Volkswagen");
        c.setModel("Polo GT10");
        c.setModelYear("2019");
        c.setPrice(10000000);
        c.setEngine(e);

        saveCar(c);

        findCarById(1);

        updateCarById(1, "BMW");

        deleteCarById(1);
        
        
    }
}
	
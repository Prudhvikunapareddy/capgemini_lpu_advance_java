package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PatientDao {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
EntityManager em = emf.createEntityManager();
	public void savePatient(Patient p) {
		EntityTransaction et= em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
		em.close();
	}
	public Patient findPatient(int id) {
		return em.find(Patient.class, id);
	}
    public void updatePatient(int id, String newName) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Patient p = em.find(Patient.class, id);
        p.setName(newName);
        et.commit();
        em.close();
    }

    public void deletePatient(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Patient p = em.find(Patient.class, id);
        em.remove(p);
        et.commit();
        em.close();
    }
	
}

package com.prac;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppointmentDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();

    public void saveAppointment(Appointment a) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(a);
        et.commit();
        em.close();
    }

    public void updateFee(int id, double newFee) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Appointment a = em.find(Appointment.class, id);
        a.setFee(newFee);
        et.commit();
        em.close();
    }

    public List<Appointment> findAppointmentByDoctor(int doctorId) {
        Doctor d = em.find(Doctor.class, doctorId);
        return d.getAppointments();   
        }
}

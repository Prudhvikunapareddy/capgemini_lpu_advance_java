package com.prac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HospitalTest {

    PatientDao patientDao = new PatientDao();
    DoctorDao doctorDao = new DoctorDao();
    AppointmentDao appointmentDao = new AppointmentDao();
    HospitalService service = new HospitalService();


    @Test
    void oneToOnePersistTest() {

        MedicalRecord mr = new MedicalRecord();
        mr.setId(100);
        mr.setBloodGroup("O+");
        mr.setAllergies("Dust");

        Patient p = new Patient();
        p.setId(100);
        p.setName("Prince");
        p.setAge(20);
        p.setContact(2589);
        p.setMedicalrecord(mr);

        patientDao.savePatient(p);

        Patient saved = patientDao.findPatient(100);

        assertNotNull(saved);
        assertEquals("O+", saved.getMedicalrecord().getBloodGroup());
    }


    @Test
    void oneToManyPersistTest() {

        Doctor d = new Doctor();
        d.setId(200);
        d.setName("Dr Rao");
        d.setSpecilaization("Cardiology");

        Appointment a1 = new Appointment();
        a1.setId(201);
        a1.setVisitDate("14-02-2026");
        a1.setFee(500);

        Appointment a2 = new Appointment();
        a2.setId(202);
        a2.setVisitDate("15-02-2026");
        a2.setFee(700);

        List<Appointment> list = Arrays.asList(a1, a2);
        d.setAppointments(list);

        doctorDao.saveDoctor(d);

        Doctor saved = doctorDao.findDoctor(200);

        assertEquals(2, saved.getAppointments().size());
    }


    @Test
    void manyToOnePersistTest() {

        Patient p = patientDao.findPatient(100);

        Appointment a = new Appointment();
        a.setId(300);
        a.setVisitDate("16-02-2026");
        a.setFee(900);
        a.setPatient(p);

        appointmentDao.saveAppointment(a);

        assertNotNull(a.getPatient());
        assertEquals("Prince", a.getPatient().getName());
    }


    @Test
    void daoUpdateTest() {

        appointmentDao.updateFee(300, 1500);

        Appointment updated = appointmentDao.em.find(Appointment.class, 300);

        assertEquals(1500, updated.getFee());
    }



    @Test
    void daoDeleteTest() {

        patientDao.deletePatient(100);

        Patient deleted = patientDao.findPatient(100);

        assertNull(deleted);
    }


    @Test
    void serviceWorkflowTest() {

        MedicalRecord mr = new MedicalRecord();
        mr.setId(400);
        mr.setBloodGroup("A+");
        mr.setAllergies("None");

        Patient p = new Patient();
        p.setId(400);
        p.setName("WorkflowUser");
        p.setAge(25);
        p.setContact(2589);

        service.registerPatient(p, mr);

        Doctor d = new Doctor();
        d.setId(401);
        d.setName("Dr Sharma");
        d.setSpecilaization("Neurology");

        Appointment a = new Appointment();
        a.setId(402);
        a.setVisitDate("20-02-2026");
        a.setFee(1200);

        service.addAppointmentsToDoctor(d, Arrays.asList(a));
        service.assignAppointmentToPatient(a, p);
        service.updateAppointmentFee(402, 2000);

        Doctor fetched = service.fetchDoctor(401);

        assertNotNull(fetched);
        assertEquals(1, fetched.getAppointments().size());
    }
}

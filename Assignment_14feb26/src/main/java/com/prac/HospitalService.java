package com.prac;

import java.util.List;

public class HospitalService {

    PatientDao patientDao = new PatientDao();
    DoctorDao doctorDao = new DoctorDao();
    AppointmentDao appointmentDao = new AppointmentDao();

    // Register patient with medical record
    public void registerPatient(Patient p, MedicalRecord m) {
        p.setMedicalrecord(m);
        patientDao.savePatient(p);
    }

    // Add appointments to doctor
    public void addAppointmentsToDoctor(Doctor d, List<Appointment> list) {
        d.setAppointments(list);
        doctorDao.saveDoctor(d);
    }

    // Assign appointment to patient
    public void assignAppointmentToPatient(Appointment a, Patient p) {
        a.setPatient(p);
        appointmentDao.saveAppointment(a);
    }

    // Update fee
    public void updateAppointmentFee(int id, double newFee) {
        appointmentDao.updateFee(id, newFee);
    }

    // Fetch doctor
    public Doctor fetchDoctor(int id) {
        return doctorDao.findDoctor(id);
    }

    // Delete patient
    public void deletePatient(int id) {
        patientDao.deletePatient(id);
    }
}

package com.prac;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        HospitalService service = new HospitalService();

    
        MedicalRecord mr = new MedicalRecord();
        mr.setId(1);
        mr.setBloodGroup("O+");
        mr.setAllergies("Dust");

        Patient p = new Patient();
        p.setId(1);
        p.setName("Prince");
        p.setAge(20);
        p.setContact(2589);

        service.registerPatient(p, mr);

  
        Doctor d = new Doctor();
        d.setId(101);
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

        service.addAppointmentsToDoctor(d, Arrays.asList(a1, a2));

     
        service.assignAppointmentToPatient(a1, p);

        
        service.updateAppointmentFee(201, 1000);


        Doctor fetchedDoctor = service.fetchDoctor(101);

        System.out.println("Doctor Name: " + fetchedDoctor.getName());
        System.out.println("Appointments Count: " + 
                           fetchedDoctor.getAppointments().size());

        System.out.println("Program Executed Successfully ✅");
    }
}

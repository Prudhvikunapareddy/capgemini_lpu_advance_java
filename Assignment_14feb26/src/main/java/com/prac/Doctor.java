package com.prac;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
	private int id;
	private String name;
	private String specilaization;
	@OneToMany
	List<Appointment> appointments;
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecilaization() {
		return specilaization;
	}
	public void setSpecilaization(String specilaization) {
		this.specilaization = specilaization;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specilaization=" + specilaization + "]";
	}
	
}

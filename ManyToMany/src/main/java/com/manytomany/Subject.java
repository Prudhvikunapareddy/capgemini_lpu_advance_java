package com.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int No_of_days;
	
	@ManyToMany(mappedBy = "subjects")
    private List<Studentt> students;
	
	
	public List<Studentt> getStudents() {
		return students;
	}
	public void setStudents(List<Studentt> students) {
		this.students = students;
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
	public int getNo_of_days() {
		return No_of_days;
	}
	public void setNo_of_days(int no_of_days) {
		No_of_days = no_of_days;
	}
	
}

package com.onetomay;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class College {
	@Id
private int id;
private String name;
private String location;
private String pincode;
@OneToMany
private List<Student> st;
public List<Student> getSt() {
	return st;
}
public void setSt(List<Student> st) {
	this.st = st;
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
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "College [id=" + id + ", name=" + name + ", location=" + location + ", pincode=" + pincode + "]";
}

}

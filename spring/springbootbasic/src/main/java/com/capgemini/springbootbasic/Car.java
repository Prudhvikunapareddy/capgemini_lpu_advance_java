package com.capgemini.springbootbasic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Car {
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Car() {
		
	}


	private String brand;
	private double price;

	public Car(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}
	

}

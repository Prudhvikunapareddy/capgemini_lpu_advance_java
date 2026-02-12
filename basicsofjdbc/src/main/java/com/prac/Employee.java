package com.prac;

public class Employee {
private int id;
private String name;
private int age;
private String branch;
public Employee(int id, String name, int age, String branch) {
	this.id = id;
	this.name = name;
	this.age = age;
	this.branch = branch;
}
public boolean isAge() {
	if(age>17) {
		return true;
	}else {
		return false;
	}
}
public static boolean isValidName(String name) {
	for(int i = 0; i < name.length(); i++) {
        if(!Character.isLetter(name.charAt(i))) {
            return false;
        }
    }
    return true;
}


}

package org.javachina.people.dto;

import java.sql.Date;

public class PeopleDto {
	private int id;
	private String name;
	private int age;
	private Date birth;
	public PeopleDto() {
		super();
	}
	public PeopleDto(int id, String name, int age, Date birth, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.salary = salary;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	private double salary;
}

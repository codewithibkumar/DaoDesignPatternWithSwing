package com.model;

public class Student {

	private int roll;
	private String name;
	private String course;
	private float fee;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public Student(int roll, String name, String course, float fee) {
		super();
		this.roll = roll;
		this.name = name;
		this.course = course;
		this.fee = fee;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", course=" + course + ", fee=" + fee + "]";
	}
	
	
}

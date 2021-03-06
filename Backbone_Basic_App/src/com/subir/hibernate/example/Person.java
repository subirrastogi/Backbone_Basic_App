package com.subir.hibernate.example;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Person {
	private String name;
	private int pid;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dob;
	private String address;
	private String city;
	private String country;
	private float age;
	private Set<MonthlyExpense> monthlyExpenses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPid() {
		return pid;
	}
	
	public void setPid(int id){
		this.pid=id;
	}
	public Set<MonthlyExpense> getMonthlyExpenses() {
		return monthlyExpenses;
	}
	public void setMonthlyExpenses(Set<MonthlyExpense> monthlyExpenses) {
		this.monthlyExpenses = monthlyExpenses;
	}
	
	public float getAge(){
		/*Date today = new Date();
		Date dob=this.getDob();
		Date c=today-dob;
		Calendar.getInstance().*/
		//TODO - implement date differnece;
		return (float) 1.1;
		
	}

}

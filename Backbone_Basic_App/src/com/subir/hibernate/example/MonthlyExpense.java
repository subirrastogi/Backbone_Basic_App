package com.subir.hibernate.example;

public class MonthlyExpense {
	private int mid;
	private String month;
	private int amount;
	private String category;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMid() {
		return mid;
	}
	
	public void setMid(int id){
		this.mid=id;
	}

}

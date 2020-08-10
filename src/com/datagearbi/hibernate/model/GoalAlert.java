package com.datagearbi.hibernate.model;

public class GoalAlert {

	private int id;
	private String message;

	public GoalAlert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoalAlert(String message) {
		super();
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

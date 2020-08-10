package com.datagearbi.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

	private int id;
	private String name;
	private ProteinData proteinData;
	private List<UserHistory> history = new ArrayList<UserHistory>();
	private Set<GoalAlert> goalAlerts = new HashSet<GoalAlert>();

	public User() {
		super();
		setProteinData(new ProteinData());
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Set<GoalAlert> getGoalAlert() {
		return goalAlerts;
	}

	public void setGoalAlert(Set<GoalAlert> goalAlerts) {
		this.goalAlerts = goalAlerts;
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

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		proteinData.setUser(this);
	}

	public List<UserHistory> getHistory() {
		return history;
	}

	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}

	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		history.add(historyItem);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}

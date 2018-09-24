package com.hibernateLearn.Hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Songs {
	private int year;
	private String name;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Songs [year=" + year + ", name=" + name + "]";
	}
}

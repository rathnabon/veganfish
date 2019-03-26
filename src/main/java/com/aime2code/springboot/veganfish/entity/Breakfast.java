package com.aime2code.springboot.veganfish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="breakfast")
public class Breakfast {
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int iId;
	
	@Column(name="breakfast_name")
	private String iBreakfast_name;
	
	@Column(name="calories")
	private String iCalories;
	
	@Column(name="carbs")
	private String iCarbs;
	
	@Column(name="protein")
	private String iProtein;

	//define constructors, No-arg constructor required by Hibernate
	public Breakfast() {
		
	}

	public Breakfast(String iBreakfast_name, String iCalories, String iCarbs, String iProtein) {
		this.iBreakfast_name = iBreakfast_name;
		this.iCalories = iCalories;
		this.iCarbs = iCarbs;
		this.iProtein = iProtein;
	}

	//define getter/setter
	
	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getiBreakfast_name() {
		return iBreakfast_name;
	}

	public void setiBreakfast_name(String iBreakfast_name) {
		this.iBreakfast_name = iBreakfast_name;
	}

	public String getiCalories() {
		return iCalories;
	}

	public void setiCalories(String iCalories) {
		this.iCalories = iCalories;
	}

	public String getiCarbs() {
		return iCarbs;
	}

	public void setiCarbs(String iCarbs) {
		this.iCarbs = iCarbs;
	}

	public String getiProtein() {
		return iProtein;
	}

	public void setiProtein(String iProtein) {
		this.iProtein = iProtein;
	}
	
	//define toString()

	@Override
	public String toString() {
		return "Breakfast [iId=" + iId + ", iBreakfast_name=" + iBreakfast_name + ", iCalories=" + iCalories
				+ ", iCarbs=" + iCarbs + ", iProtein=" + iProtein + "]";
	}
	
	
	
	
}

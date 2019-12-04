package com.niit;

import java.io.Serializable;

public class Employee implements Serializable 
{
	private String firstName;
	private String lastName;
	private String hireDate;
	private boolean attendedHrTraining;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public boolean isAttendedHrTraining() {
		return attendedHrTraining;
	}
	public void setAttendedHrTraining(boolean attendedHrTraining) {
		this.attendedHrTraining = attendedHrTraining;
	}
	
	
}

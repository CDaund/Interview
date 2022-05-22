package com.test.competitiveexam.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	String first_name;
	String last_name;
	String mobile_no;
	// admin or student
	String role;
	LocalDate signupdate;
	
	public Registration() {
	}
	
	public Registration(String first_name, String last_name, String mobile_no, String role, LocalDate signupdate) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_no = mobile_no;
		this.role = role;
		this.signupdate = signupdate;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDate getSignupdate() {
		return signupdate;
	}
	public void setSignupdate(LocalDate signupdate) {
		this.signupdate = signupdate;
	}

}

package com.test.competitiveexam.model;

import java.time.LocalDate;

public class Login {

	String mobile_no;
	String otp;
	LocalDate logindate;
	
	public Login() {
	}

	public Login(String mobile_no, String otp, LocalDate logindate) {
		super();
		this.mobile_no = mobile_no;
		this.otp = otp;
		this.logindate = logindate;
	}
	
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDate getLogindate() {
		return logindate;
	}
	public void setLogindate(LocalDate logindate) {
		this.logindate = logindate;
	}
	
	
}

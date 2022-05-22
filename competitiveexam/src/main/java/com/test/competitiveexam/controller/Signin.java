package com.test.competitiveexam.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.test.competitiveexam.model.Login;
import com.test.competitiveexam.model.Registration;
import com.test.competitiveexam.repository.RegistrationRepository;

@RestController
public class Signin {
	
	@Autowired
	private RegistrationRepository repo;
	
	// If we Signup & LogIn from same template
	// Home Page
	@GetMapping("/")
	public String welcome()
	{
		return "<html><body>"
			+  "<h1>WELCOME TO COMPETITIVE EXAM PAGE</h1>"
			+  "</body></html>";
	}
	
	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String,Object> signup(
			@RequestBody Registration reg)
	{
		HashMap<String, Object> resp = new HashMap<>();
		try {
			LocalDate date = LocalDate.now();
			reg.setSignupdate(date);
			repo.save(reg);
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		return resp;
	}
	
	// Verify Mobile Number from database.
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String,Object> login(
			@RequestBody Login log)
	{
		HashMap<String, Object> resp = new HashMap<>();
		LocalDate date = LocalDate.now();
		
		try {
			List<Registration> mobile = new ArrayList<>();
			mobile = repo.findAll();
			
			for(int i =0; i<mobile.size();i++)
			{		
				if(mobile.get(i).getRole().equals("Admin")) {
				
					if(mobile.get(i).getMobile_no().toString().equals(log.getMobile_no().toString()))
					{	
						if("000000".equals(log.getOtp().toString()))
						{
							resp.put("respcode", "00");
							resp.put("respvalue", "Admin Login Success!");
							resp.put("Date: ", date);
							break;
						}
						else
						{
							resp.put("respcode", "99");
							resp.put("respvalue", "OTP does not match");
						}
					}
					else
					{
						resp.put("respcode", "99");
						resp.put("respvalue", "Mobile number not found in database, please Sign in First!");
					}
				}
				else {
					if(mobile.get(i).getMobile_no().toString().equals(log.getMobile_no().toString()))
					{	
						if("000000".equals(log.getOtp().toString()))
						{
							resp.put("respcode", "00");
							resp.put("respvalue", "Student Login Success!");
							resp.put("Date: ", date);
							break;
						}
						else
						{
							resp.put("respcode", "99");
							resp.put("respvalue", "OTP does not match");
						}
					}
					else
					{
						resp.put("respcode", "99");
						resp.put("respvalue", "Mobile number not found in database, please Sign in First!");
					}
				}
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return resp;
	}
	
	
}

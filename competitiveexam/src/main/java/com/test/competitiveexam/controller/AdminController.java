package com.test.competitiveexam.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.competitiveexam.model.AdminRegistration;
import com.test.competitiveexam.model.ComputerScienceJavaQuestions;
import com.test.competitiveexam.model.EnglishQuestions;
import com.test.competitiveexam.model.MathQuestions;
import com.test.competitiveexam.model.StudentLogin;
import com.test.competitiveexam.repository.AdminRepository;
import com.test.competitiveexam.repository.ComputerScienceJavaRepository;
import com.test.competitiveexam.repository.EnglishQuestionsRepository;
import com.test.competitiveexam.repository.MathQuestionsRepository;

@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository admrepo;
	
	@Autowired
	private MathQuestionsRepository mathquesrepo;
	
	@Autowired
	private EnglishQuestionsRepository engquesrepo;
	
	@Autowired
	private ComputerScienceJavaRepository csjquesrepo;
	
	// If you choose Separate 
	// Admin Home Page
	@GetMapping("/admin")
	public String welcome()
	{
		return "<html><body>"
			+  "<h1>WELCOME TO COMPETITIVE EXAM <br> ADMIN WEBSITE</h1>"
			+  "</body></html>";
	}
	
	@PostMapping("/admin/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String,Object> addAdmin(
			@RequestBody AdminRegistration admreg)
	{
		HashMap<String, Object> resp = new HashMap<>();
		try {
			LocalDate date = LocalDate.now();
			admreg.setSignupdate(date);
			resp.put("Sign In Details", admrepo.save(admreg));
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		return resp;
	}
	
	// Verify Mobile Number from database.
	@PostMapping("/admin/login")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String,Object> loginStudent(
			@RequestBody StudentLogin studlog)
	{
		HashMap<String, Object> resp = new HashMap<>();
		LocalDate date = LocalDate.now();
		
		try {
			List<AdminRegistration> mobile = new ArrayList<>();
			mobile = admrepo.findAll();
			
			for(int i =0; i<mobile.size();i++)
			{		
				
				if(mobile.get(i).getMobile_no().toString().equals(studlog.getMobile_no().toString()))
				{	
					if("000000".equals(studlog.getOtp().toString()))
					{
						resp.put("respcode", "00");
						resp.put("respvalue", "Login Success!");
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
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return resp;
	}
		
	// add math questions
	@PostMapping("/admin/addmathquestions")
	@ResponseStatus(HttpStatus.CREATED)
	public MathQuestions addMathQuestions(
			@RequestBody MathQuestions questions)
	{

		return mathquesrepo.save(questions);
		
	}
	
	// add english questions
	@PostMapping("/admin/addengquestions")
	@ResponseStatus(HttpStatus.CREATED)
	public EnglishQuestions addEnglishQuestions(
			@RequestBody EnglishQuestions questions)
	{

		return engquesrepo.save(questions);
		
	}
	
	// add csj questions
	@PostMapping("/admin/addcsjquestions")
	@ResponseStatus(HttpStatus.CREATED)
	public ComputerScienceJavaQuestions addcsjQuestions(
			@RequestBody ComputerScienceJavaQuestions questions)
	{

		return csjquesrepo.save(questions);
		
	}
	
	// Get All math questions id
	@GetMapping("/admin/mathquestions")
	public List<MathQuestions> getAllmathquestions()
	{
		return mathquesrepo.findAll();
	}
	
	// Get All english questions id
	@GetMapping("/admin/engquestions")
	public List<EnglishQuestions> getAllengquestions()
	{
		return engquesrepo.findAll();
	}
	
	// Get All english questions id
	@GetMapping("/admin/csjquestions")
	public List<ComputerScienceJavaQuestions> getAllcsjquestions()
	{
		return csjquesrepo.findAll();
	}
	
	// Get questions by id
	@GetMapping("/admin/mathquestions/{id}")
	public MathQuestions getMathQuestionsById(@PathVariable(value = "id") int id)
	{
		return mathquesrepo.findById(id);
	}
	
	// Get questions by id
	@GetMapping("/admin/engquestions/{id}")
	public EnglishQuestions getEngQuestionsById(@PathVariable(value = "id") int id)
	{
		return engquesrepo.findById(id);
	}
	
	// Get questions by id
	@GetMapping("/admin/csjquestions/{id}")
	public ComputerScienceJavaQuestions getcsjQuestionsById(@PathVariable(value = "id") int id)
	{
		return csjquesrepo.findById(id);
	}
	
	// Delete questions
	@DeleteMapping("/admin/deletemathquestions/{id}")
	public void deletemathQuestions(
			@PathVariable(value = "id") int id)
	{
		mathquesrepo.deleteById(id);
	}
	
	// Delete questions
	@DeleteMapping("/admin/deleteengquestions/{id}")
	public void deleteengQuestions(
			@PathVariable(value = "id") int id)
	{
		engquesrepo.deleteById(id);
	}
	
	// Delete questions
	@DeleteMapping("/admin/deletecsjquestions/{id}")
	public void deletecsjQuestions(
			@PathVariable(value = "id") int id)
	{
		csjquesrepo.deleteById(id);
	}
	
	// Update questions
	@PutMapping("/admin/updatemathquestions/{id}")
	public ResponseEntity<Object> updatemathQuestions(
			@RequestBody MathQuestions questions,
			@PathVariable int id)
	{
		Optional<MathQuestions> questionsRepo
				= Optional.ofNullable(
						mathquesrepo.findById(id));
		
		if(!questionsRepo.isPresent())
			return ResponseEntity
					.notFound()
					.build();
		
		questions.setID(id);
		
		mathquesrepo.save(questions);
		
		return ResponseEntity
				.noContent()
				.build();
	}
	
	// Update questions
	@PutMapping("/admin/updateengquestions/{id}")
	public ResponseEntity<Object> updateengQuestions(
			@RequestBody EnglishQuestions questions,
			@PathVariable int id)
	{
		Optional<EnglishQuestions> questionsRepo
				= Optional.ofNullable(
						engquesrepo.findById(id));
		
		if(!questionsRepo.isPresent())
			return ResponseEntity
					.notFound()
					.build();
		
		questions.setID(id);
		
		engquesrepo.save(questions);
		
		return ResponseEntity
				.noContent()
				.build();
	}

	// Update questions
	@PutMapping("/admin/updatecsjquestions/{id}")
	public ResponseEntity<Object> updatecsjQuestions(
			@RequestBody ComputerScienceJavaQuestions questions,
			@PathVariable int id)
	{
		Optional<ComputerScienceJavaQuestions> questionsRepo
				= Optional.ofNullable(
						csjquesrepo.findById(id));
		
		if(!questionsRepo.isPresent())
			return ResponseEntity
					.notFound()
					.build();
		
		questions.setID(id);
		
		csjquesrepo.save(questions);
		
		return ResponseEntity
				.noContent()
				.build();
	}
}

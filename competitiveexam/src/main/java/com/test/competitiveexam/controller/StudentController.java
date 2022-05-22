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

import com.test.competitiveexam.model.ComputerScienceJavaQuestions;
import com.test.competitiveexam.model.EnglishQuestions;
import com.test.competitiveexam.model.Final;
import com.test.competitiveexam.model.MathQuestions;
import com.test.competitiveexam.model.SelectSubject;
import com.test.competitiveexam.model.StudentLogin;
import com.test.competitiveexam.model.StudentRegistration;
import com.test.competitiveexam.repository.ComputerScienceJavaRepository;
import com.test.competitiveexam.repository.EnglishQuestionsRepository;
import com.test.competitiveexam.repository.FinalRepository;
import com.test.competitiveexam.repository.MathQuestionsRepository;
import com.test.competitiveexam.repository.StudentRepository;
import com.test.competitiveexam.repository.SubjectRepository;


@RestController
public class StudentController {

	@Autowired
	private StudentRepository studrepo;
	
	@Autowired
	private SubjectRepository subrepo;
	
	@Autowired
	private MathQuestionsRepository mathquesrepo;
	
	@Autowired
	private EnglishQuestionsRepository engquesrepo;
	
	@Autowired
	private ComputerScienceJavaRepository csjquesrepo;
	
	@Autowired
	private FinalRepository finalrepo;
	
	
//	@Autowired
//	private StudentLogin studlog;
	
	// If you choose Separate 
	// Student Home Page
	@GetMapping("/student")
	public String welcome()
	{
		return "<html><body>"
			+  "<h1>WELCOME TO COMPETITIVE EXAM <br> STUDENT WEBSITE</h1>"
			+  "</body></html>";
	}
	
	@PostMapping("/student/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String,Object> addStudent(
			@RequestBody StudentRegistration studreg)
	{
		HashMap<String, Object> resp = new HashMap<>();
		try {
			LocalDate date = LocalDate.now();
			studreg.setSignupdate(date);
			resp.put("Sign In Details", studrepo.save(studreg));
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		return resp;
	}
	
	// Verify Mobile Number from database.
	@PostMapping("/student/login")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String,Object> loginStudent(
			@RequestBody StudentLogin studlog)
	{
		HashMap<String, Object> resp = new HashMap<>();
		LocalDate date = LocalDate.now();
		
		try {
			List<StudentRegistration> mobile = new ArrayList<>();
			mobile = studrepo.findAll();
			
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
	 
	// Select Subject and get all questions and answers & verify the final result
	@PostMapping("/student/selectsub")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String,Object> selectsubStudent(
			@RequestBody SelectSubject studsub)
	{
		HashMap<String, Object> resp = new HashMap<>();
		Final fin = null;

		try {
			/*
			// Store Student ID
			List<StudentRegistration> sreg = new ArrayList<>();
			sreg = studrepo.findAll();
			for(int i =0; i<sreg.size();i++)
			{
				if(sreg.get(i).getMobile_no().equals(studlog.getMobile_no()))
				{
					subansw.setStudentid(String.valueOf(sreg.get(i).getID()));
				}
					
			}
			*/
			// Store All answers as per Subject 
			List<SelectSubject> sub = new ArrayList<>();
			sub = subrepo.findAll();
			
			for(int i =0; i<sub.size();i++)
			{		
				int score = 0;
				if(sub.get(i).getSubjectname().toString().equals(studsub.getSubjectname().toString()))
				{	
					//for math
					if(("maths").equals(studsub.getSubjectname().toString())) 
					{
						resp.put("Math Questions: ", mathquesrepo.findAll());
						//subansw.setSubjectid(String.valueOf(sub.get(i).getID()));
						resp.put("Answers: ", subrepo.save(studsub));
						List<MathQuestions> mathscore = new ArrayList<>();
						mathscore = mathquesrepo.findAll();
						for(int j=0;j<mathscore.size();j++) {
							if(studsub.getQuestionno().equals(mathscore.get(j).getQuestionno())) {
								if(studsub.getResponseanswers().equals(mathscore.get(j).getCorrectanswers()))
								{
									score++;
//									fin.setScore("Correct");
//									finalrepo.save(fin);
								}
								else {
//									fin.setScore("Incorrect");
//									finalrepo.save(fin);
								}
							}
						}
						//resp.put("Final Score repo: ", finalrepo.save(fin));
						resp.put("Final Score: ", score);
						break;
					}
					//for eng
					if(("english").equals(studsub.getSubjectname().toString())) 
					{
						resp.put("English Questions: ", engquesrepo.findAll());
						//subansw.setSubjectid(String.valueOf(sub.get(i).getID()));
						resp.put("Answers: ", subrepo.save(studsub));
						List<EnglishQuestions> engscore = new ArrayList<>();
						engscore = engquesrepo.findAll();
						
						for(int j=0;j<engscore.size();j++) {
							if(studsub.getQuestionno().equals(engscore.get(j).getQuestionno())) {
								if(studsub.getResponseanswers().equals(engscore.get(j).getCorrectanswers()))
								{
									score++;
	//								fin.setScore("Correct");
	//								finalrepo.save(fin);
								}
								else {
	//								fin.setScore("Incorrect");
	//								finalrepo.save(fin);
								}
							}
							resp.put("Final Score: ", score);
						}
						//resp.put("Final Score repo: ", finalrepo.save(fin));
						
						break;
					}
					//for csj
					if(("csjava").equals(studsub.getSubjectname().toString())) 
					{
						resp.put("CSJava Questions: ", csjquesrepo.findAll());
						//subansw.setSubjectid(String.valueOf(sub.get(i).getID()));
						resp.put("Answers: ", subrepo.save(studsub));
						List<ComputerScienceJavaQuestions> csjscore = new ArrayList<>();
						csjscore = csjquesrepo.findAll();
						for(int j=0;j<csjscore.size();j++) {
							if(studsub.getQuestionno().equals(csjscore.get(j).getQuestionno())) {
								if(studsub.getResponseanswers().equals(csjscore.get(j).getCorrectanswers()))
								{
									score++;
//									fin.setScore("Correct");
//									finalrepo.save(fin);
								}
								else {
//									fin.setScore("Incorrect");
//									finalrepo.save(fin);
								}
							}
						}
						//resp.put("Final Score repo: ", finalrepo.save(fin));
						resp.put("Final Score: ", score);
						break;
					}
				}
				else
				{
					resp.put("respcode", "99");
					resp.put("respvalue", "Subject is not available, Please contact Admin!");
				}
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return resp;
	}
	
	// 
	
}

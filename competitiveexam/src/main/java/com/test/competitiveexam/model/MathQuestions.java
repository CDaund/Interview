package com.test.competitiveexam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MathQuestions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	String questionno;
	String subjectname;
	String questions;
	String option_A;
	String option_B;
	String option_C;
	String option_D;
	String correctanswers;
	
	public MathQuestions() {
		
	}

	public MathQuestions(String questionno, String subjectname, String questions, String option_A, String option_B,
			String option_C, String option_D, String correctanswers) {
		super();
		this.questionno = questionno;
		this.subjectname = subjectname;
		this.questions = questions;
		this.option_A = option_A;
		this.option_B = option_B;
		this.option_C = option_C;
		this.option_D = option_D;
		this.correctanswers = correctanswers;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getQuestionno() {
		return questionno;
	}

	public void setQuestionno(String questionno) {
		this.questionno = questionno;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getOption_A() {
		return option_A;
	}

	public void setOption_A(String option_A) {
		this.option_A = option_A;
	}

	public String getOption_B() {
		return option_B;
	}

	public void setOption_B(String option_B) {
		this.option_B = option_B;
	}

	public String getOption_C() {
		return option_C;
	}

	public void setOption_C(String option_C) {
		this.option_C = option_C;
	}

	public String getOption_D() {
		return option_D;
	}

	public void setOption_D(String option_D) {
		this.option_D = option_D;
	}

	public String getCorrectanswers() {
		return correctanswers;
	}

	public void setCorrectanswers(String correctanswers) {
		this.correctanswers = correctanswers;
	}
	
}

package com.test.competitiveexam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	String studentid;
	String subjectid;
	String questionno;
	String responseanswers;
	
	public Answers() {

	}
	
	public Answers(String studentid, String subjectid, String responseanswers) {
		super();
		this.studentid = studentid;
		this.subjectid = subjectid;
		this.responseanswers = responseanswers;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getResponseanswers() {
		return responseanswers;
	}

	public void setResponseanswers(String responseanswers) {
		this.responseanswers = responseanswers;
	}
}

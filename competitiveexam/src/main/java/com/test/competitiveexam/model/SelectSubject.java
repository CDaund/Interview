package com.test.competitiveexam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SelectSubject {

	// Primary ID which increments
    // automatically when new entry
    // is added into the database
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	String subjectname;
	String studentid;
	String subjectid;
	String questionno;
	String responseanswers;
	
	public SelectSubject() {
		
	}

	public SelectSubject(String subjectname, String studentid, String subjectid, String questionno,
			String responseanswers) {
		super();
		this.subjectname = subjectname;
		this.studentid = studentid;
		this.subjectid = subjectid;
		this.questionno = questionno;
		this.responseanswers = responseanswers;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
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

	public String getQuestionno() {
		return questionno;
	}

	public void setQuestionno(String questionno) {
		this.questionno = questionno;
	}

	public String getResponseanswers() {
		return responseanswers;
	}

	public void setResponseanswers(String responseanswers) {
		this.responseanswers = responseanswers;
	}
	
}

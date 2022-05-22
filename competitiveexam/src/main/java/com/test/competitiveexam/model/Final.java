package com.test.competitiveexam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Final {

	// Primary ID which increments
    // automatically when new entry
    // is added into the database
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	String studentid;
	String subjectid;
	String questionno;
	String correctanswers;
	String responseanswers;
	String score;
	
	public Final() {	
	}	

	public Final(String studentid, String subjectid, String questionno, String correctanswers, String responseanswers,
			String score) {
		super();
		this.studentid = studentid;
		this.subjectid = subjectid;
		this.questionno = questionno;
		this.correctanswers = correctanswers;
		this.responseanswers = responseanswers;
		this.score = score;
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

	public String getQuestionno() {
		return questionno;
	}

	public void setQuestionno(String questionno) {
		this.questionno = questionno;
	}

	public String getCorrectanswers() {
		return correctanswers;
	}

	public void setCorrectanswers(String correctanswers) {
		this.correctanswers = correctanswers;
	}

	public String getResponseanswers() {
		return responseanswers;
	}

	public void setResponseanswers(String responseanswers) {
		this.responseanswers = responseanswers;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
}

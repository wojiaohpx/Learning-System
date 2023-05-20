package com.model;

public class Grade {
	private int userId;
	private String course;
	private String credit;
	private String semester;
	private String attribute;
	private String regularGrade;
	private String finalExamGrade;
	private Double totalGrade;
	
	public Grade(int userId, String course, String credit, String semester, String attribute, String regularGrade, String finalExamGrade) {
		super();
		this.userId = userId;
		this.course = course;
		this.credit = credit;
		this.semester = semester;
		this.attribute = attribute;
		this.regularGrade = regularGrade;
		this.finalExamGrade = finalExamGrade;
	}
	
	
	public Double getTotalGrade() {
		return totalGrade;
	}


	public void setTotalGrade(Double totalGrade) {
		this.totalGrade = totalGrade;
	}


	public Grade() {
		super();
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getRegularGrade() {
		return regularGrade;
	}
	public void setRegularGrade(String regularGrade) {
		this.regularGrade = regularGrade;
	}
	public String getFinalExamGrade() {
		return finalExamGrade;
	}
	public void setFinalExamGrade(String finalExamGrade) {
		this.finalExamGrade = finalExamGrade;
	}
	
	

}

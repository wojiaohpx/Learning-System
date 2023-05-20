package com.model;

public class Course {
	private int userId;
	private String course;
	private String teacher;
	private String totalCreditHours;
	private String credit;
	private String semester;
	private String attribute;

	public Course(int userId, String course, String teacher, String totalCreditHours, String credit, String semester, String attribute) {
		super();
		this.userId = userId;
		this.course = course;
		this.teacher = teacher;
		this.totalCreditHours = totalCreditHours;
		this.credit = credit;
		this.semester = semester;
		this.attribute = attribute;
	}

	public Course() {
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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTotalCreditHours() {
		return totalCreditHours;
	}

	public void setTotalCreditHours(String totalCreditHours) {
		this.totalCreditHours = totalCreditHours;
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

	@Override
	public String toString() {
		return userId + "," + course + "," + teacher + "," + totalCreditHours + "," + credit + "," + semester + "," + attribute;
	}

}

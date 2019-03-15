package model;

import java.io.Serializable;

public class Evaluation implements Serializable{

	private static final long serialVersionUID = 1L;
	private double grade;
	private String comments;
	
	public Evaluation(double grade, String comments) {
		this.grade = grade;
		this.comments = comments;
	}

	public double getGrade() {
		return grade;
	}

	public String getComments() {
		return comments;
	}
}

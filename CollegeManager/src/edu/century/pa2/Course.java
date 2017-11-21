package edu.century.pa2;

public class Course implements Cloneable{
	private String courseName;
	private double gPA;
	private int credits;
	
	public Course(String courseName, double gPA, int credits) {
		this.courseName = courseName;
		this.gPA = gPA;
		this.credits = credits;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public double getGPA() {
		return gPA;
	}
	
	public void setGPA(double gPA) {
		this.gPA = gPA;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public boolean equals(Object anotherCourse){
		if (anotherCourse instanceof Course)
		{	
			Course course = (Course)anotherCourse;
			return (this.courseName.equalsIgnoreCase(course.getCourseName()) 
				&& (this.gPA == course.getGPA()) 
				&& (this.credits == course.getCredits()));
		}
		else
		return false;
	}
	
	@Override
	public String toString() {
		return  courseName + "\t\t" + gPA + "\t" + credits;
	}
	
	
}

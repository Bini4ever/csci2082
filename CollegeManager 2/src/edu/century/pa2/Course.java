package edu.century.pa2;
/***********************************************************
 * Course class
 * @author biniamlemma
 ***********************************************************/
public class Course implements Cloneable{
	private String courseName;
	private double gPA;
	private int credits;
	
	/*********************************************************
	 * Contractor
	 * @param courseName
	 * @param gPA
	 * @param credits
	 *********************************************************/
	public Course(String courseName, double gPA, int credits) {
		this.courseName = courseName;
		this.gPA = gPA;
		this.credits = credits;
	}
	
	/**********************************************************
	 * getCourseName method 
	 * @return the name of the course
	 ***********************************************************/
	public String getCourseName() {
		return courseName;
	}
	
	/**********************************************************
	 * setCourseName method that initializes courseName
	 * @param courseName
	 **********************************************************/
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**********************************************************
	 * getGPA method
	 * @return the GPA
	 **********************************************************/
	public double getGPA() {
		return gPA;
	}

	/***********************************************************
	 * setGPA method that initializes the GPA
	 * @param gPA
	 ***********************************************************/
	public void setGPA(double gPA) {
		this.gPA = gPA;
	}
	
	/************************************************************
	 * getCredits method 
	 * @return credits
	 ************************************************************/
	public int getCredits() {
		return credits;
	}
	
	/************************************************************
	 * seCredits method that initializes credits
	 * @param credits
	 ************************************************************/
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	@Override //Clone method that copy course object to copy
	public Object clone() {
		Course copy = null;
		try {
			copy = (Course) super.clone();
		}
		catch (CloneNotSupportedException e){
			e.printStackTrace();
		}	
		return copy;
	}
	
	@Override //equals method that compares two objects
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
	
	@Override //to string metod
	public String toString() {
		return  courseName + "\t\t" + gPA + "\t" + credits;
	}
	
	
}

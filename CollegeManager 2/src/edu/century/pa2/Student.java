package edu.century.pa2;

import edu.century.pa2.collections.CourseCollection;
//Student class
public class Student implements Cloneable{
	private String name;
	private int ID;
	private CourseCollection courses = new CourseCollection();
	
	/***************************************************************
	 *Constractor
	 * @param name
	 * @param ID
	 ***************************************************************/
	public Student(String name, int ID){
		this.name = name;
		this.ID = ID;
	}
	
	/***************************************************************
	 *Constractor 
	 * @param name
	 * @param iD
	 * @param courses
	 ***************************************************************/
	public Student(String name, int iD, CourseCollection courses) {
		this.name = name;
		ID = iD;
		this.courses = courses;
	}
	
	/****************************************************************
	 * getName method
	 * @returns name
	 ****************************************************************/
	public String getName() {
		return name;
	}

	/****************************************************************
	 * setName method that initializes the name
	 * @param name
	 ****************************************************************/
	public void setName(String name) {
		this.name = name;
	}
	
	/****************************************************************
	 * getID method 
	 * @return ID
	 ****************************************************************/
	public int getID() {
		return ID;
	}

	/*****************************************************************
	 * setID method that initializes the ID
	 * @param iD
	 *****************************************************************/
	public void setID(int iD) {
		ID = iD;
	}
	
	/*****************************************************************
	 * Clone method that copy student to object "copy" 
	 *****************************************************************/
	public Object clone(){
		Student copy = null;
		
		try {
			copy = (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		copy.courses  = (CourseCollection) courses.clone();
		return copy;
		
	}
	
	/*****************************************************************
	 * equals method that compares two objects
	 *****************************************************************/
	public boolean equals(Object anotherStudent){
		if (anotherStudent instanceof Student) {
			Student student = (Student) anotherStudent;
		return (this.name.equalsIgnoreCase(student.getName())
				&& this.ID == student.getID());
		}else  {
			return false;
		}
	}
	
	/*****************************************************************
	 * addCourses method that add course to pacific student
	 * @param courseName
	 * @param GPA
	 * @param creadit
	 *****************************************************************/
	public void addCourses(String courseName, double GPA, int creadit){
		Course courseObj = new Course(courseName, GPA, creadit);
		courses.addFirst(courseObj);
	}
	
	/******************************************************************
	 * removeCourse method that removes course from student
	 * @param courseName
	 ******************************************************************/
	public void remvoeCourse(String courseName){
	if (!courses.isEmpty())
			courses.removeTarget(courseName);
	}
	
	
	@Override // toString method
	public String toString() {
		return  "**************************************************************" +
				"\nStudent name: " + name + ",\tID: " + ID + "\n" 
				+"**************************************************************\n"
				+ "Course Name\t\tGPA\tCredit\n"
				+courses.toString() + "\n";
	}
	
	
}

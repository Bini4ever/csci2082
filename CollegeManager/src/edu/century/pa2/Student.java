package edu.century.pa2;

import edu.century.pa2.collections.CourseCollection;

public class Student {
	public String name;
	public int ID;
	public CourseCollection courses = new CourseCollection();
	
	public Student(String name, int ID){
		this.name = name;
		this.ID = ID;
	}

	public Student(String name, int iD, CourseCollection courses) {
		this.name = name;
		ID = iD;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean equals(Object anotherStudent){
		if (anotherStudent instanceof Student) {
			Student student = (Student) anotherStudent;
		return (this.name.equalsIgnoreCase(student.getName())
				&& this.ID == student.getID());
		}else  {
			return false;
		}
	}
	
	public void addCourses(String courseName, double GPA, int creadit){
		Course courseObj = new Course(courseName, GPA, creadit);
		courses.addFirst(courseObj);
	}
	
	public void remvoeCourse(String courseName){
	if (!courses.isEmpty())
			courses.removeTarget(courseName);
	}
	
	@Override
	public String toString() {
		return  "**************************************************************" +
				"\nStudent name: " + name + ",\tID: " + ID + "\n" 
				+"**************************************************************\n"
				+ "Course Name\t\tGPA\tCredit\n"
				+courses.toString() + "\n";
	}
	
	
}

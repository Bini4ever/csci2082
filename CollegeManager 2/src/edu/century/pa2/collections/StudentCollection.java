package edu.century.pa2.collections;
import java.util.ArrayList;

import edu.century.pa2.Student;

/*************************************************************
 * StudentCollection class
 * @author biniamlemma
 *************************************************************/
public class StudentCollection implements Cloneable{
	
	private ArrayList<Student> students;
	
	/*********************************************************
	 * StudentCollection contractor
	 *********************************************************/
	public StudentCollection(){
		students = new ArrayList<>();
	}
	
	/*********************************************************
	 * addStudent method that adds student to the students list
	 * @param newStudent
	 *********************************************************/
	public void addStudent(Student newStudent){
		if(newStudent != null && !students.contains(newStudent));
			students.add(newStudent);
	}
	
	/*********************************************************
	 * searchStudent method searches student and return
	 * @param str
	 * @return student
	 *********************************************************/
	public Student searchStudent(String str){
		for(Student x: students)
		{
			if (x.getName().equalsIgnoreCase(str))
				return x;
		}
		return null;
	}
	
	/*********************************************************
	 * deleteStudent method removes student from students list
	 * @param str
	 **********************************************************/
	public void deleteStudent(String str){
		
		ArrayList<Student> toRemove = new ArrayList<Student>();
		for (Student x : students) {
		    if (x.getName().equalsIgnoreCase(str)) {
		        toRemove.add(searchStudent(str));
		    }
		}
		students.removeAll(toRemove);
		
	}
	
	/************************************************************
	 * addCourse method that searches student and call addCourse 
	 * @param str
	 * @param courseName
	 * @param GPA
	 * @param creadit
	 *************************************************************/
	public void addCourse(String str, String courseName, double GPA, int creadit){
		for(Student x: students)
		{
			if (x != null && x.getName().equalsIgnoreCase(str))
				x.addCourses(courseName, GPA, creadit);
		}
	}
	
	/*********************************************************
	 * deletCourse method searches student and remove course
	 * @param name
	 * @param courseName
	 ********************************************************/
	public void deleteCourse(String name, String courseName){
		for(Student x: students)
		{
			if (x != null && x.getName().equalsIgnoreCase(name));
				x.remvoeCourse(courseName);
		}
	}
	
	
	@Override //clone method that copys student list newStudent
	public Object clone(){
		ArrayList<Student> newStudents = null;
		try {
			newStudents = (ArrayList<Student>) super.clone();
		} 
		catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		return newStudents;
	}
	
	/*********************************************************
	 * displayStudent method that returns single student
	 * @param name
	 * @return student
	 *********************************************************/
	public String displayStudent(String name){
		for(Student x: students)
		{
			if (x.getName().equalsIgnoreCase(name))
			{
				return x.toString();
				
			}
		}
		return "student couldn't found";
	}
	
	/*********************************************************
	 * diplayStudent method that returns all student
	 * @return all students
	 *********************************************************/
	public String displayStudents(){
		String str = "";
		for(Student x: students)
		{
			str += x.toString();
			str += "\n";
		}
		return str;
	}
	
}

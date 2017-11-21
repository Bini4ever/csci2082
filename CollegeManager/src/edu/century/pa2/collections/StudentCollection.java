package edu.century.pa2.collections;
import java.util.ArrayList;

import edu.century.pa2.Student;

public class StudentCollection {
	
	private ArrayList<Student> students;
	
	public StudentCollection(){
		students = new ArrayList<>();
	}
	
	public void addStudent(Student newStudent){
		if(newStudent != null && !students.contains(newStudent));
			students.add(newStudent);
	}
	
	
	public Student searchStudent(String str){
		for(Student x: students)
		{
			if (x.getName().equalsIgnoreCase(str))
				return x;
		}
		return null;
	}
	
	public void deleteStudent(String str){
		
		ArrayList<Student> toRemove = new ArrayList<Student>();
		for (Student x : students) {
		    if (x.getName().equalsIgnoreCase(str)) {
		        toRemove.add(searchStudent(str));
		    }
		}
		students.removeAll(toRemove);
		
	}
	
	public void addCourse(String str, String courseName, double GPA, int creadit){
		for(Student x: students)
		{
			if (x != null && x.getName().equalsIgnoreCase(str))
				x.addCourses(courseName, GPA, creadit);
		}
	}
	
	public void deleteCourse(String name, String courseName){
		for(Student x: students)
		{
			if (x != null && x.getName().equalsIgnoreCase(name));
				x.remvoeCourse(courseName);
		}
	}
	
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

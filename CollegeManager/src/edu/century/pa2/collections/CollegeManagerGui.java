package edu.century.pa2.collections;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import edu.century.pa2.Student;

public class CollegeManagerGui extends JFrame implements ActionListener  {
	private int id = 10382521;
	private JButton addStudent = new JButton("Add Student");
	private JButton removeStudent = new JButton("Remove Student");
	private JButton addCourse = new JButton("Add Course");
	private JButton removeCourse = new JButton("Remove Course");
	private JButton display = new JButton("Display");
	private JButton displayAll = new JButton("Display All");
	
	private JLabel name1 = new JLabel("Name:"); 
	private JLabel selectStudent = new JLabel("Select Student:"); 
	private JLabel courseName = new JLabel("Course Name:");
	private JLabel GPA = new JLabel("GPA:"); 
	private JLabel credits = new JLabel("Credits:"); 
	private JComboBox<String> jcb = new JComboBox<String>();
	 
	private JTextField nameField1 = new JTextField();
	private JTextField courseField = new JTextField();
	private JTextField GPAField = new JTextField();
	private JTextField creaditsField = new JTextField();
	
	private JTextArea txtArea = new JTextArea();
	private JScrollPane scroll = new JScrollPane(txtArea);
	
	private JPanel topPanel1 = new JPanel(new BorderLayout());
	private JPanel topPanel2 = new JPanel(new BorderLayout());
	private JPanel midPanel1 = new JPanel(new GridLayout(5, 2));
	private JPanel midPanel2 = new JPanel(new BorderLayout());
	private JPanel bottomPanel = new JPanel(new BorderLayout());
	private JPanel panel = new JPanel(new GridLayout(1, 2));
	
	
	
	StudentCollection studentList = new StudentCollection();
	Student newStudent;
	Random r = new Random();
	
	
	public CollegeManagerGui(){
		setLayout(new GridLayout(2, 1));
		this.setTitle("Century College");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addStudent.addActionListener(this);
		removeStudent.addActionListener(this);
		addCourse.addActionListener(this);
		removeCourse.addActionListener(this);
		display.addActionListener(this);
		displayAll.addActionListener(this);
		txtArea.setEditable(false);
		
		topPanel1.add(name1, BorderLayout.WEST);
		topPanel1.add(nameField1, BorderLayout.CENTER);
		topPanel2.add(addStudent, BorderLayout.WEST);
		topPanel2.add(removeStudent, BorderLayout.CENTER);
		
		midPanel1.add(topPanel1);
		midPanel1.add(topPanel2);
		midPanel1.add(selectStudent);
		midPanel1.add(jcb);
		midPanel1.add(courseName);
		midPanel1.add(courseField);
		midPanel1.add(GPA);
		midPanel1.add(GPAField);
		midPanel1.add(credits);
		midPanel1.add(creaditsField);
		
		panel.add(removeCourse);
		panel.add(display);
		
		midPanel2.add(addCourse, BorderLayout.WEST);
		midPanel2.add(panel, BorderLayout.CENTER);
		midPanel2.add(displayAll, BorderLayout.EAST);
		
		bottomPanel.add(midPanel2, BorderLayout.NORTH);
		bottomPanel.add(scroll, BorderLayout.CENTER);
		
		add(midPanel1);
		add(bottomPanel);
	}
	

	public int getId() {
		return id;
	}



	public static void main(String[] args){
		CollegeManagerGui centuryCollege = new CollegeManagerGui();
		centuryCollege.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Add Student")){
			String name = nameField1.getText();
			newStudent = new Student(name, id);
			studentList.addStudent(newStudent);
			System.out.println(name + " added!");
			txtArea.append(name + " added!\n");
			id += (r.nextInt(100-50) + 50);
			jcb.addItem(name);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Remove Student")){
			System.out.println("Remove Student clicked");
			String name = nameField1.getText();
			if (studentList.searchStudent(name) != null){
				studentList.deleteStudent(name);
				System.out.println(name + " removed");
				txtArea.append(name + " removed\n");
			}
			else {
				txtArea.setText(name + "couldn't find\n");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Add Course")){
			String name = (String)jcb.getSelectedItem();
			String courseName = courseField.getText();
			double GPA = Double.parseDouble(GPAField.getText());
			int credit = Integer.parseInt(creaditsField.getText());
			if (studentList.searchStudent(name) != null){
				studentList.addCourse(name, courseName, GPA, credit);
				System.out.println(courseName + " added to " + name);
				txtArea.setText(courseName + " added to " + name + "\n");
			}else {
				System.out.println( name + " could not found!");
				txtArea.setText(name + " could not found!\n");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Remove Course")){
			String name = (String)jcb.getSelectedItem();
			String courseName = courseField.getText();
			if (studentList.searchStudent(name) != null){
				studentList.deleteCourse(name, courseName);
				System.out.println(courseName + " removed from " + name );
				txtArea.setText(courseName + " removed from " + name + "\n");
			} else {
				System.out.println(name + " could not found!");
				txtArea.setText(name + " could not found!\n");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Display")){
			String name = (String)jcb.getSelectedItem();
			String studentToDisplay = studentList.displayStudent(name);
			txtArea.setText(studentToDisplay + "\n");
			System.out.println(studentToDisplay + "\n");
		}
		else if (e.getActionCommand().equalsIgnoreCase("Display All")){
			String studentsToDisplay = studentList.displayStudents();
			txtArea.setText(studentsToDisplay + "\n");
			System.out.println(studentsToDisplay);
		}
		
	}
	
	
	
	
	
	
	
	
}

/**

 * Title: School.java

 * Abstract: School allows for courses to be added and deleted, instructors to 
 * 			be added, and students to be added and graduate 
 * 
 * Author: Jesus A. Bernal Lopez

 * Date: 10-14-2018

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class School {
	String name;
	File file = null;
	Scanner inFile = null;
	Scanner keyboard = new Scanner(System.in);
	static ArrayList<Instructor> instructors;
	static ArrayList<Course> courses;
	static ArrayList<Student> students;
	 
	public School(String name) {
		this.name = name;
		instructors = new ArrayList<>();
		courses = new ArrayList<>();
		students = new ArrayList<>();
		
	}
	
	public void readData(String fileName) {
		int counter = 0;

		try {
			file = new File(fileName);
			inFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("File not found.");
		}
		while(inFile.hasNextInt()) {
			int var = inFile.nextInt();
			inFile.nextLine();
						
			for(int i = 0; i < var; i++) {
				String line = inFile.nextLine();
				String delimeter = ",";
				StringTokenizer theLine = new StringTokenizer(line, delimeter);
				if(counter == 0) { // Instructors
					String employeeNumber = theLine.nextToken();
					String name = theLine.nextToken();
					String email = theLine.nextToken();
					String phoneNumber = theLine.nextToken();
					
					int employeeNum = Integer.parseInt(employeeNumber);
					
					addInstructor(employeeNum, name, email, phoneNumber);
					
				}else if(counter == 1) { //courses
					String courseNumber = theLine.nextToken();
					String title = theLine.nextToken();
					String instructorNumber = theLine.nextToken();
					String classLocation = theLine.nextToken();
					
					int iCourseNum = Integer.parseInt(courseNumber);
					int iInstructorNum = Integer.parseInt(instructorNumber);
					
					addCourse(iCourseNum, title, iInstructorNum, classLocation);
				}else if(counter == 2){ // students
					String id = theLine.nextToken();
					String name = theLine.nextToken();
					String courseEnrolled = theLine.nextToken();
					String finalScore = theLine.nextToken();
					String letterGrade = theLine.nextToken();
					
					int iid = Integer.parseInt(id);
					int iCourseEnrolled = Integer.parseInt(courseEnrolled);
					double iFinalScore = Double.parseDouble(finalScore);
					
					addStudent(iid, name, iCourseEnrolled, iFinalScore, letterGrade);
				}
			}
			counter++;
		}
		System.out.println("Done");
		

	}

	public void schoolInfo() {
		System.out.println("School Name: " + name);
		System.out.println("Instructor Information");
		for(int i = 0; i < instructors.size(); i++) System.out.println(instructors.get(i).getName());
		System.out.println("Course Information");
		for(int i = 0; i < courses.size(); i++) System.out.println(courses.get(i).getTitle());
		System.out.println("Student Information");
		for(int i = 0; i < students.size(); i++) students.get(i).getCoursesEnrolled();
	}
	
	public void addInstructor(int employeeNumber, String name, String email, String phoneNumber) {
		Instructor instructor = new Instructor(Integer.toString(employeeNumber), name, email, phoneNumber);
		
		if(instructors.isEmpty()) instructors.add(instructor);
		else {
			for(int i = 0; i < instructors.size(); i++) {
				if(Integer.toString(employeeNumber).equals(instructors.get(i).getEmployeeNumber())) {
					System.out.println("Instructor addition failed – Employee number already used.");
					break;
				}
				if(i == instructors.size() - 1) {
					instructors.add(instructor);
					break;
				}
			}
		}
	}
	
	public void addCourse(int courseNumber, String title, int instructorNumber, String classLocation) {
		String sCourseNumber = Integer.toString(courseNumber);
		String sInstructorNumber = Integer.toString(instructorNumber);
		Course course = new Course(sCourseNumber, title, sInstructorNumber, classLocation);
		
		for(int i = 0; i < courses.size(); i++) {
			if(sCourseNumber.equals(courses.get(i).getCourseNumber())){
				System.out.println("Course addition failed – Course number already used.");
				return;
			}
		}
		
		for(int i = 0; i < instructors.size(); i++) {
			if(sInstructorNumber.equals(instructors.get(i).getEmployeeNumber())) {
				courses.add(course);				
				break;
			}
			if(i == instructors.size() - 1) {
				System.out.println("Course addition failed – Non-existing instructor.");
				break;
			}
		}
		
	}
	
	public void courseInfo(int courseNumber) {
		String sCourseNumber = Integer.toString(courseNumber);
		System.out.println("Course Number: " + sCourseNumber);
		String instructorNum = null;
		
		for(int i = 0; i < courses.size(); i++) {
			if(sCourseNumber.equals(courses.get(i).getCourseNumber())) {
				instructorNum = courses.get(i).getInstructorNumber();
				for(int j = 0; j < instructors.size(); j++) {
					if(instructorNum.equals(instructors.get(j).getEmployeeNumber())) {
						System.out.println("Instructor: " + instructors.get(j).getName());
					}
				}
				System.out.println("Course Title: " + courses.get(i).getTitle());
				System.out.println("Room: " + courses.get(i).getClassLocation());
				System.out.println("Total Enrolled: " + courses.get(i).getEnrolled());
				
				double avg = 0;
				int size = 0;
				for(int j = 0; j < students.size(); j++) {
					for(int k = 0; k < students.get(j).courseEnrollment.size(); k++) {
						if(courses.get(i).equals(students.get(j).courseEnrollment.get(k).course)) {
							double a = Double.parseDouble(students.get(j).courseEnrollment.get(k).getFinalScore());
							avg += a;
							size++;
						}
					}
				}
				String average = String.format("%.2f", avg / size);
				System.out.println("Course Average: " + average);
			}
		}
	}
		
	public Course getCourse(int courseNum) {
		Course course = null;
		String sCourseNum = Integer.toString(courseNum);
		for(int i = 0; i < courses.size(); i++) {
			if(sCourseNum.equals(courses.get(i).getCourseNumber()))
				course = courses.get(i);
		}
		if (course == null)
			System.out.println("Null in course");
		return course;
	}

	public Student getStudentInfo(int id) {
		Student student = null;
		String sID = Integer.toString(id);
		for(int i = 0; i < students.size(); i++) {
			if(sID.equals(students.get(i).getID()))
				student = students.get(i);
		}
		if (student == null)
			System.out.println("Null in student");
		return student;
	}
	
	public void courseInfo() {
		System.out.println("Number of Courses: " + courses.size());
		for(int i = 0; i < courses.size(); i++) {
			String classNum = courses.get(i).getTitle().substring(3, 6);
			int numEnrolled = courses.get(i).getEnrolled();
			System.out.println(classNum + ": " + numEnrolled + " enrolled");
		}
	}
	
	public void deleteCourse(int courseNum) {
		String sCourseNum = Integer.toString(courseNum);
		
		for(int i = 0; i < courses.size(); i++) {
			if(sCourseNum.equals(courses.get(i).getCourseNumber())) {
				if(courses.get(i).getEnrolled() != 0) {
					System.out.println("Course deletion failed – Enrolled student(s) in the class");
				}
				else {
					courses.remove(i);
				}
				break;
			}
		}
	}
	
	public void addStudent(int id, String name, int courseEnrolled, double finalScore, String letterGrade) {
		
		String sID = Integer.toString(id);
		String sCourseEnrolled = Integer.toString(courseEnrolled);
		String sFinalScore = Double.toString(finalScore);
		
		Course course = null;
		boolean a = false;

		for(int j = 0; j < courses.size(); j++) {
			if(sCourseEnrolled.equals(courses.get(j).getTitle().substring(3, 6))) {
				course = courses.get(j);
				a = true;
				break;
				
			}
			if(j == courses.size() - 1) {
				System.out.println("Student info addition failed – Non-existing course number.");
				a = false;;
			}
			
		}
		if(a) {
			for(int k = 0; k < students.size(); k++) {
				if(sID.equals(students.get(k).getID()) && name.equals(students.get(k).getName())) {
					students.get(k).addCourse(course, sFinalScore, letterGrade);
					for(int i = 0; i < courses.size(); i++) {
						if(sCourseEnrolled.equals(courses.get(i).getCourseNumber()))
							courses.get(i).updateEnrolled(1);
					}
					a = false;
				}
				if(sID.equals(students.get(k).getID()) && !name.equals(students.get(k).getName())) {
					System.out.println("Student info addition failed – Student ID number already used.");
					a = false;
					break;
				}
			}
		}
		
		Student student = new Student(sID, name, course, sFinalScore, letterGrade);

		if(a) {
			students.add(student);
			for(int i = 0; i < courses.size(); i++) {
				if(sCourseEnrolled.equals(courses.get(i).getCourseNumber()))
					courses.get(i).updateEnrolled(1);
			}
		}
	
	}

	public void graduateStudent(int id) {
		String sID = Integer.toString(id);
		for(int i = 0; i < students.size(); i++) {
			if(sID.equals(students.get(i).getID())) {
				students.get(i).graduate();
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/**

 * Title: Student.java

 * Abstract: Allows for students to be created and added to the school\
 * 
 * Author: Jesus A. Bernal Lopez

 * Date: 10-14-2018

 */

import java.util.ArrayList;

public class Student {
	String id;
	String name;
	ArrayList<CourseEnrollment> courseEnrollment;
	
	public Student(String id, String name, Course course, String finalScore, String letterGrade) {
		this.id = id;
		this.name = name;
		courseEnrollment = new ArrayList<>();
		CourseEnrollment ce = new CourseEnrollment(course, finalScore, letterGrade);
		courseEnrollment.add(ce);
		
	}
	
	public void getCoursesEnrolled() {
		for(int i = 0; i < courseEnrollment.size(); i++) {
			System.out.println(name + ": " + courseEnrollment.get(i).getCourse());
		}
	}
	
	public void addCourse(Course course, String finalScore, String letterGrade) {
		courseEnrollment.add(new CourseEnrollment(course, finalScore, letterGrade));
	}
	
	public String getName() { return name;}
		
	public String getID() {return id;}
	
	public void graduate() {
		if(courseEnrollment.isEmpty()) {
			System.out.println("Student graduation failed – Non-existing student.");
		}else {
			for(int i = 0; i < courseEnrollment.size(); i++) {
				courseEnrollment.get(i).dropClass();
			}
			
			
			courseEnrollment.clear();
		}
	}
	
	@Override
	public String toString(){
		String statement = "Student Number: " + id;
		if(courseEnrollment.size() == 0) {
			statement += "\nNo student information.";
			return statement;
		}else {
			statement += "\nName: " + name + "\nCourses Enrolled:\n";
			double average = 0;
			for(int i =0; i < courseEnrollment.size(); i++) {
				double dFinalScore = Double.parseDouble(courseEnrollment.get(i).getFinalScore());
				String formatted = String.format("%.2f", dFinalScore);
				statement += courseEnrollment.get(i).getCourse().substring(3, 6) + ": "
						+ formatted + " ("
						+ courseEnrollment.get(i).getLetterGrade() + ")\n";
				average += dFinalScore;
			}
			average = average / courseEnrollment.size();
			String fm = String.format("%.2f", average);
			statement += "Course Average: " + fm;
			return statement;
		}
	}
	
	public class CourseEnrollment{
		Course course;
		String finalScore;
		String letterGrade;
		
		public CourseEnrollment(Course course, String finalScore, String letterGrade) {
			this.course = course;
			this.finalScore = finalScore;
			this.letterGrade = letterGrade;
		}
		
		public String getCourse() {
			if (course.getTitle() != null){
				return course.getTitle();
			}
			return " ";
		}
		
		public void dropClass() {
			course.updateEnrolled(-1);
		}
		
		public String getFinalScore() {return finalScore;}
		
		public String getLetterGrade() {return letterGrade;}
		
	}
}

/**

 * Title: Course.java

 * Abstract: Allows for courses to be created and added to the school
 * 
 * Author: Jesus A. Bernal Lopez

 * Date: 10-14-2018

 */

public class Course {
	String courseNumber;
	String title;
	String instructorNumber;
	String classLocation;
	int enrollmentCount = 0;
	
	public Course(String courseNumber, String title, String instructorNumber, String classLocation) {
		this.courseNumber = courseNumber;
		this.title = title;
		this.instructorNumber = instructorNumber;
		this.classLocation = classLocation;
	}
	
	public void updateEnrolled(int n) {
		this.enrollmentCount += n;
	}
	
	public void updateLocation(String location) {
		this.classLocation = location;
	}
		
	public int getEnrolled() {return enrollmentCount;}
	
	public String getTitle() {return title;}
	
	public String getCourseNumber() {return courseNumber;}
	
	public String getClassLocation() {return classLocation;}
	
	public String getInstructorNumber() {return instructorNumber;}
	
}

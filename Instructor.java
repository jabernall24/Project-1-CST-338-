/**

 * Title: Instructor.java

 * Abstract: Allows for instructors to be created and added to the school
 * 
 * Author: Jesus A. Bernal Lopez

 * Date: 10-14-2018

 */

public class Instructor {
	String employeeNumber;
	String name;
	String email;
	String phoneNumber;
	
	public Instructor(String employeeNumber, String name, String email, String phoneNumber) {
		this.employeeNumber = employeeNumber;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {return this.name;}
	
	public String getEmployeeNumber() {return this.employeeNumber;}
}

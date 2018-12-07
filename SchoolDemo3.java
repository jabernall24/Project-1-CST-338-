public class SchoolDemo3 {
/*  The output should be similar to the following: 
 
===== Read Data =====
Done.

===== Error Messages =====

===== Detailed Course Info 5 =====
Course Number: 205
Instructor: S. Narayanan
Course Title: CST205 - Multimedia Design and Programming
Room: BIT 118
Total Enrolled: 5
Course Average:75.0

===== Detailed Student Info =====
Student Number: 7777
Name: Alice Otter
Courses Enrolled:
338: 89.5  (B)
306: 98.0  (A)
205: 100.0  (A)
306: 100.0  (A)
Course Average: 96.88

===== Detailed Student Info 2 =====
Student Number: 7777
No Student Information.

===== Detailed Course Info 6 =====
Course Number: 205
Instructor: S. Narayanan
Course Title: CST205 - Multimedia Design and Programming
Room: BIT 118
Total Enrolled: 4
Course Average:68.75

===== Good Job! Bye! =====
*/

	public static void main(String[] args) {
		School SCD = new School("SCD");
		Student student1;

		System.out.println("===== Read Data =====");
		SCD.readData("test1.txt");

		SCD.addStudent(5555, "Chris Watson", 205, 50, "F");
		SCD.addStudent(9999, "Mike Watson", 205, 100.0, "A");
		SCD.addStudent(8888, "Bob Otter", 205, 50, "F");
		SCD.addStudent(7777, "Alice Otter", 205, 100, "A");
		SCD.addStudent(7777, "Alice Otter", 306, 100, "A");

		System.out.println("\n===== Error Messages =====");

		System.out.println("\n===== Detailed Course Info 5 =====");
		SCD.courseInfo(205);

		student1 = SCD.getStudentInfo(7777);
		System.out.println("\n===== Detailed Student Info =====");
		System.out.println(student1);

		SCD.graduateStudent(7777);
		System.out.println("\n===== Detailed Student Info 2 =====");
		student1 = SCD.getStudentInfo(7777);
		if (student1 == null)
			System.out.println("No student information. ");
		else
			System.out.println(student1);

		System.out.println("\n===== Detailed Course Info 6 =====");
		SCD.courseInfo(205);

		System.out.println("\n===== Good Job! Bye! =====");
	}
}

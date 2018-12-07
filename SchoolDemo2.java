public class SchoolDemo2 {
/*  output of this program should be 
 
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
		Course course1;

		System.out.println("===== Read Data =====");
		SCD.readData("test1.txt");

		SCD.addInstructor(700, "E. Tao", "tao@csumb.edu", "777-777-1234");
		SCD.addCourse(300, "CST300 – ProSem", 70, "BIT 110");
		SCD.addCourse(499, "CST499 – iOS Dev", 15, "BIT 104");

		System.out.println("\n===== Error Messages =====");
		SCD.addCourse(306, "CST306 – GUI Dev", 25, "BIT 120");

		System.out.println("\n===== Detailed Course Info =====");
		SCD.courseInfo(306);

		course1 = SCD.getCourse(205);
		course1.updateLocation("Library 104");
		System.out.println("\n===== Detailed Course Info 2 =====");
		SCD.courseInfo(205);

		System.out.println("\n===== Detailed Course Info 3 =====");
		SCD.courseInfo();

		SCD.deleteCourse(306);
		SCD.deleteCourse(338);
		System.out.println("\n===== Detailed Course Info 4 =====");
		SCD.courseInfo();

		System.out.println("\n===== Good Job! Bye! =====");
	}
}

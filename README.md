## Project 1 ##

In the project, you will develop four classes called School, Instructor, Course, and Student to store instructors, courses, and student information of a school. Based on the sample input data and sample run, you should identify instance variables and methods of each class. If it’s necessary, you can add more classes for the project.

Sample Input Files

The following sample data files, C:\\tmp\\test1.txt and C:\\tmp\\test2.txt, are used for the sample run below. In the case of C:\\tmp\\test1.txt, the first line (= 4) indicates the number of instructors in the school. The information includes the instructor’s unique employee number, name, email, and phone number. Note that each field of a line is delimited by comma symbol (,). There’s no blank space around the comma symbol and at the end of each line.

After the instructor’s data, the following number 3 indicates the number of courses in the school. The course data includes the unique course number, course title, instructor’s number, and class location. After the course data, there is the student information (= 3 in the example). Each student information indicates the student’s unique ID, name, course enrolled, final score, and letter grade.

This is a sample file, C:\\tmp\\test1.txt
4
100,Y. Byun,ybyun@csumb.edu,111-111-1111
200,S. Narayanan,sathya@csumb.edu,222-222-2222
300,M. Lara,lara@csumb.edu,333-333-3333
250,S. Bude,bude@csumb.edu,444-123-4567
3
338,CST338 - Software Design,100,BIT 104
205,CST205 - Multimedia Design and Programming,200,BIT 118
306,CST306 - Game Engine Programming,100,BIT 104
3
7777,Alice Otter,338,89.50,B
8888,Bob Otter,205,75.00,C
7777,Alice Otter,306,98.00,A

This is another sample file, C:\\tmp\\test2.txt

2
500,G. Bruns,bruns@csumb.edu,555-222-2222
300,O. Doe,doe@csumb.edu,444-333-3333
1
336,CST336 - Internet Programming,300,Library 1010
4
7777,Alice Otter,205,71.00,C
7777,Unknown Otter,205,71.00,C
7777,Alice Otter,310,81.55,B
9999,John Doe,338,89.50,B


The following presents a sample demo program called SchoolDemo.java.

public class SchoolDemo {
public static void main(String[] args) {
School SCD = new School("SCD");
Course course1;
Student student1;
System.out.println("===== Read Data 1 =====");
SCD.readData("C:\\tmp\\test1.txt");
System.out.println("\n===== School Info 1 =====");
SCD.schoolInfo();
System.out.println("===== Read Data 2 =====");
SCD.readData("C:\\tmp\\test2.txt");
System.out.println("\n===== School Info 2 =====");
SCD.schoolInfo();
SCD.addInstructor(700, "E. Tao", "tao@csumb.edu", "777-777-1234");
SCD.addCourse(300, "CST300 – ProSem", 700, "BIT110");
SCD.addCourse(231, "CST231 – Intro C++", 100, "BIT104");
System.out.println("\n===== Failed Course Addition =====");
SCD.addCourse(306, "CST306 – GUI Dev", 250, "BIT120");
SCD.addCourse(499, "CST499 – iOS Dev", 150, "BIT104");
System.out.println("\n===== Detailed Course Info =====");
SCD.courseInfo(306);
course1 = SCD.getCourse(205);
course1.updateLocation("Library 104");
System.out.println("\n===== Detailed Course Info 2 =====");
SCD.courseInfo(205);
System.out.println("\n===== Detailed Course Info 3 =====");
SCD.courseInfo();
SCD.deleteCourse(231);
SCD.deleteCourse(336);
SCD.deleteCourse(338);
System.out.println("\n===== Detailed Course Info 4 =====");
SCD.courseInfo();
SCD.addStudent(5555, "Chris Watson", 205, 85.50, "B");
System.out.println("\n===== Detailed Course Info 5 =====");
SCD.courseInfo(205);
student1 = SCD.getStudentInfo(7777);
System.out.println("\n===== Detailed Student Info =====");
System.out.println(student1);
SCD.graduateStudent(7777);
System.out.println("\n===== Detailed Student Info 2 =====");
System.out.println(SCD.getStudentInfo(7777));
SCD.graduateStudent(5555);
System.out.println("\n===== Detailed Course Info 6 =====");
SCD.courseInfo(205);
SCD.graduateStudent(5555);
System.out.println("\n===== Good Job! Bye! =====");
}
}


A sample run of your program should look like below.

===== Read Data 1 =====
Done.
===== School Info 1 =====
School Name: SCD
Instructor Information
Y. Byun
S. Narayanan
M. Lara
S. Bude
Course Information
CST338 - Software Design
CST205 - Multimedia Design and Programming
CST306 - Game Engine Programming
Student Information
Alice Otter: CST338 - Software Design
Bob Otter: CST205 - Multimedia Design and Programming
Alice Otter: CST306 - Game Engine Programming
===== Read Data 2 =====
Instructor addition failed – Employee number already used.
Student info addition failed – Student ID number already used.
Student info addition failed – Non-existing course number.
Done.
===== School Info 2 =====
School Name: SCD
Instructor Information
Y. Byun
S. Narayanan
M. Lara
S. Bude
G. Bruns
Course Information
CST338 - Software Design
CST205 - Multimedia Design and Programming
CST306 - Game Engine Programming
CST336 - Internet Programming
Student Information
Alice Otter: CST338 - Software Design
Bob Otter: CST205 - Multimedia Design and Programming
Alice Otter: CST306 - Game Engine Programming
Alice Otter: CST205 - Multimedia Design and Programming
John Doe: CST338 - Software Design
===== Failed Course Addition =====
Course addition failed – Course number already used.
Course addition failed – Non-existing instructor.
===== Detailed Course Info =====
Course Number: 306
Instructor: Y. Byun
Course Title: CST306 - Game Engine Programming
Room: BIT 104
Total Enrolled: 1
Course Average: 98.00
===== Detailed Course Info 2 =====
Course Number: 205
Instructor: S. Narayanan
Course Title: CST205 - Multimedia Design and Programming
Room: Library 104
Total Enrolled: 2
Course Average: 73.00
===== Detailed Course Info 3 =====
Number of Courses: 6
338: 2 enrolled
205: 2 enrolled
336: 0 enrolled
306: 1 enrolled
300: 0 enrolled
231: 0 enrolled
Course deletion failed – Enrolled student(s) in the class
===== Detailed Course Info 4 =====
Number of Courses: 4
338: 2 enrolled
205: 2 enrolled
306: 1 enrolled
300: 0 enrolled
===== Detailed Course Info 5 =====
Course Number: 205
Instructor: S. Narayanan
Course Title: CST205 - Multimedia Design and Programming
Room: Library 104
Total Enrolled: 3
Course Average: 77.17
===== Detailed Student Info =====
Student Number: 7777
Name: Alice Otter
Courses Enrolled:
338: 89.50 (B)
306: 98.00 (A)
205: 71.00 (C)
Course Average: 86.17
===== Detailed Student Info 2 =====
Student Number: 7777
No student information.
===== Detailed Course Info 6 =====
Course Number: 205
Instructor: S. Narayanan
Course Title: CST205 - Multimedia Design and Programming
Room: Library 104
Total Enrolled: 1
Course Average: 75.00
Student graduation failed – Non-existing student.
===== Good Job! Bye! =====



Some comments for the project 1.

•	For the project, you can assume that the input data file has a correct format. For instance, you don’t need to check if the email address in the file is valid or not.
•	To process the input data with the comma symbol (,) delimiter, StringTokenizer class may be useful.  
•	At the deleteCourse() method, a course should not be deleted if there’s student(s) enrolled in the course.
•	For the graduateStudent() method, all courses the student enrolled should be removed.

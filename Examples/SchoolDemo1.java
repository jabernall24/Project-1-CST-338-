public class SchoolDemo1 {
	/* output of this program is the following

===== Read Data 1 =====
Done.

===== School Info 1 =====
School info: SCD
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
Alice Otter: CST306 - Game Engine Programming
Bob Otter: CST205 - Multimedia Design and Programming

===== Read Data 2 =====
Add Instructor failed. Employee number already used. 300
AddStudent failed. Studnet id already in use. 7777
AddStudent failed. Non existing course. 310
Done.

===== School Info 2 =====
School info: SCD
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
Alice Otter: CST306 - Game Engine Programming
Alice Otter: CST205 - Multimedia Design and Programming
Bob Otter: CST205 - Multimedia Design and Programming
John Doe: CST338 - Software Design

===== End of SchoolDemo1 =====


	 */
	
  public static void main(String[] args)   {
    School SCD = new School("SCD");

    System.out.println("===== Read Data 1 =====");
    SCD.readData("test1.txt");

    System.out.println("\n===== School Info 1 =====");
    SCD.schoolInfo();

    System.out.println("\n===== Read Data 2 =====");
    SCD.readData("test2.txt");

    System.out.println("\n===== School Info 2 =====");
    SCD.schoolInfo();

    System.out.println("\n===== End of SchoolDemo1 =====");
  }
}

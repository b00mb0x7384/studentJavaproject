package com.seth.soto;

import java.util.Scanner;
// import com.seth.soto.Student; // turn this off so Doc doesnt have to fix my code as per comment on Project 1.
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class School {
	public static void main(String[] args) {
		int userSelect = 0;
		ArrayList<Student> Students = new ArrayList<>();

		try { // try to read the file. If the file doesnt exist no big deal we probably havent
				// run the program before. just jump to catch block
			FileInputStream fis = new FileInputStream("students.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Students = (ArrayList<Student>) ois.readObject();
			ois.close();

		} catch (IOException | ClassNotFoundException i) {
			i.printStackTrace(); // print the error and continue on.
		}
		do {
			System.out.println(
					"eStaff v1.0.1------ \n Select from the following \n 1. Search 2. New Student Entry  3. Edit Student ");

			Scanner input = new Scanner(System.in);
			userSelect = input.nextInt();

			if (userSelect == 1) {
				if (Students.size() == 0) {
					System.out.println("NO STUDENTS");
				} else {
					int studentCounter = 0;
					String searchMajor = "";
					String searchLastName = "";

					System.out.println("Search by Last name (1) or Major (2) Or List ALL (3)? ");
					int searchMode = input.nextInt();
					Scanner nameOrMajorIn = new Scanner(System.in);
					boolean foundStudents = false;
					if (searchMode == 1) {
						System.out.println("Enter Last Name");
						searchLastName = nameOrMajorIn.nextLine();
					}
					if (searchMode == 2) {
						System.out.println("Enter Major");
						searchMajor = nameOrMajorIn.nextLine();
					}
					if (searchMode == 3) {
						for (Student student : Students) {
							System.out.println("\n");
							studentCounter++;
							System.out.println(
									studentCounter + ") " + student.getFirstName() + " " + student.getLastName());
							System.out.println("Currently Enrolled the following courses: \n");
							student.getCourses();

						}
						foundStudents = true;
					}

					for (Student student : Students) {
						if (student.getLastName().toUpperCase().equals(searchLastName.toUpperCase())
								|| student.getMajor().toUpperCase().equals(searchMajor.toUpperCase())) {
							System.out.println("\n");
							studentCounter++;
							System.out.println(
									studentCounter + ") " + student.getFirstName() + " " + student.getLastName());
							System.out.println("Currently Enrolled the following courses: \n");
							student.getCourses();
							foundStudents = true;
						}
					}
					if (!foundStudents) {
						System.out.println("No Matches");
					}
				}
				// userSelect = input.nextInt();
			}
			if (userSelect == 2) {
				System.out.println("New Student:");
				Scanner inputSubMenu = new Scanner(System.in);
				System.out.println("First Name");
				String firstName = inputSubMenu.nextLine();
				System.out.println("Last Name");

				String lastName = inputSubMenu.nextLine();
				if (Students.size() == 0) {
					System.out.println("Major");
					String major = inputSubMenu.nextLine();
					Student newEntry = new Student(firstName, lastName, major);
					Students.add(newEntry);

				} else {
					boolean match = false;
					for (Student student : Students) {
						if (student.getLastName().toUpperCase().equals(lastName)) {

							System.out.println("ERROR: STUDENT EXISTS");
							match = true;
							break;

						}
					}
					if (!match) {
						System.out.println("Major");
						String major = inputSubMenu.nextLine();
						Student newEntry = new Student(firstName, lastName, major);
						Students.add(newEntry); // continue if we already havent made this student

					}
				}
			}
			if (userSelect == 3) {
				Scanner inputSubMenu = new Scanner(System.in);
				System.out.println("Students that Exists");
				if (Students.size() == 0) {
					System.out.println("NONE");
				} else {
					int studentCounter = 0;
					for (Student student : Students) {
						studentCounter++;
						System.out
								.println(studentCounter + ") " + student.getFirstName() + " " + student.getLastName());
						System.out.println("Currently Enrolled the following courses: \n");
						student.getCourses();
					}
				}

				System.out.println("Which Student would you like to edit (Number Next to Name)");
				int selectedUser = inputSubMenu.nextInt();
				System.out.println("Enter Course to Enroll " + Students.get(selectedUser - 1).getFirstName());
				Scanner courseToAddScanner = new Scanner(System.in);
				String courseToEnroll = courseToAddScanner.nextLine();

				System.out.println("Adding student to course");
				Students.get(selectedUser - 1).addCourse(courseToEnroll);
				Students.get(selectedUser - 1).getCourses();

			}
			// run the save method everytime
			try (FileOutputStream fos = new FileOutputStream("students.dat"); // try to load the file if it doesnt
																				// exists we'll go to the catch
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(Students);
				oos.close();
				fos.close();
			} catch (IOException e) { // print file didnt exsists no big deal. continue the loop
				e.printStackTrace();
			}
		} while (userSelect != 0);
	}

}

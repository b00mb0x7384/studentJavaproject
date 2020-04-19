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
		ArrayList<Major> Majors = new ArrayList<>();
		// lets make some majors
		Majors.add(new Programming());
		Majors.get(0).createMajor(200);
		Majors.add(new Accounting());
		Majors.get(1).createMajor(100);
		Majors.add(new Biology());
		Majors.get(2).createMajor(100);
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
					"eStaff v1.0.1------ \n Select from the following \n 1. Search 2. New Student Entry  3. Edit Student  4.View Majors ");

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
								|| student.getMajor().getTrack().toUpperCase().equals(searchMajor.toUpperCase())) {
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
					// todo when Doc says we need user input change here to prompt the user to
					// select from available majors, spec says no user input required this project.
					// for simplicity sake I will just be adding a list majors to teh exisisting
					// menu
					// TODO: Check this line and make it behave as the same as if tthere were
					// students in teh dat file
					System.out.println("Major");
					int major = inputSubMenu.nextInt();
					Student newEntry = new Student(firstName, lastName, Majors.get(major));
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
						System.out.println("Majors Available");
						int majorCount = 0;
						for (Major x : Majors) {

							System.out.println(majorCount + " " + x);

							majorCount++;

						}
						System.out.println("Select student major");
						int major = inputSubMenu.nextInt();
						Student newEntry = new Student(firstName, lastName, Majors.get(major));
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
			if (userSelect == 4) {
				int majorCount = 0;
				System.out.println("Majors that Exists");
				System.out.println("number of majors" + Majors.size());
				if (Students.size() == 0) {
					System.out.println("NONE");
				} else {
					for (Major x : Majors) {
						majorCount++;
						System.out.println(x);
					}
					int result = Majors.get(0).compareTo(Majors.get(1));

					if (result == -1) {
						System.out.println("Major Track " + Majors.get(0).getTrack() + "  Has Less Courses than "
								+ Majors.get(1).getTrack());
					}
					if (result == 0) {
						System.out.println("Major Track " + Majors.get(0).getTrack() + " Has Same Courses than "
								+ Majors.get(1).getTrack());
					}
					if (result == 1) {
						System.out.println("Major Track " + Majors.get(0).getTrack() + "  Has More Courses than "
								+ Majors.get(1).getTrack());
					}
					System.out.println(
							"A message from the programming advocate: " + ((Programming) Majors.get(0)).plusICanCode());
					System.out.println(
							"A message from the accounting advocate: " + ((Accounting) Majors.get(1)).crunchNumbers());
					System.out.println("a scientific voice says: " + ((Biology) Majors.get(2)).flex());
				}
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

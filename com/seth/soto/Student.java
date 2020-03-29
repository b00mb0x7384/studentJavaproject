package com.seth.soto;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	String firstName = ""; // known good state as per video
	String lastName = "";
	String major = "";
	ArrayList<String> courses = new ArrayList<>();
	// TODO: String email = ""
	// TODO: Double INT = this.calcGPA();

	public Student(String firstName, String lastName, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lasName=" + lastName + ", major=" + major;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setlasName(String lastName) {
		this.lastName = lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void addCourse(String course) {
		System.out.println("Currently enrolled in" + courses.size());
		if (courses.size() < 4) {

			if (courses.contains(course)) {
				System.out.println("Already Enrolled in this course");

			} else {
				courses.add(course);
			}
		} else {
			System.out.println(
					"we appreciate your enthuasiasm but you cannot enroll in more than 4 courses \n you are already in :");
		}
	}

	public void getCourses() {
		if (courses.size() == 0) {
			System.out.println("NONE");
		} else {
			for (String course : courses) {
				System.out.println(course);
			}
		}
	}
	//
	// addCourse method should not allow for more than 5 course (check this in the
	// student class to allow for flow of)
	// student1.addCourse(COPxxxx)
	// addCourse()
	// for(let i = 0; i<currentCourses.length

}
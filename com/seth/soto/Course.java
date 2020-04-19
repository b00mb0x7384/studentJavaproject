package com.seth.soto;

import java.io.Serializable;

public class Course implements Serializable {

    String courseNumber;
    String courseName;
    String description;

    public Course(String courseNumber, String courseName, String description) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.description = description;

    }

    public String getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
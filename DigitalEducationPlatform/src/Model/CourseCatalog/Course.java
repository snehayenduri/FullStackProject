/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CourseCatalog;

/**
 *
 * @author snehayenduri
 */
public class Course {
    
    private String courseID;
    private String courseName;
    private int credits;
    private int pricePerCredit = 1500;

    public Course() {
    }

    public Course(String courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPricePerCredit() {
        return pricePerCredit;
    }

    public void setPricePerCredit(int pricePerCredit) {
        this.pricePerCredit = pricePerCredit;
    }

    @Override
    public String toString() {
        return courseName;
    }
    
}

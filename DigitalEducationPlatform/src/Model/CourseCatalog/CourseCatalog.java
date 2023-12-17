/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CourseCatalog;

import java.util.ArrayList;

/**
 *
 * @author snehayenduri
 */
public class CourseCatalog {
    private ArrayList<Course> courseList; 

    public CourseCatalog() {
        courseList = new ArrayList<>();
        
    }
    
    public Course addCourse(String courseID, String courseName, int credits){
        if(null == getCourseByID(courseID) 
                && null == getCourseByName(courseName)){
            Course course = new Course(courseID, courseName, credits);
            courseList.add(course);
            return course;
        }
        return null;
    }
    
    public Course getCourseByID(String courseID){
        for(Course course: courseList){
            if(course.getCourseID().equals(courseID)){
                return course;
            }
        }
        return null;
    }
    
    public Course getCourseByName(String courseName){
        for(Course course: courseList){
            if(course.getCourseName().equals(courseName)){
                return course;
            }
        }
        return null;
    }

    
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }
    
    public void populateCourses(){
        addCourse("INFO6150", "Web Design and User Experience Engineering", 3);
        addCourse("INFO6250", "Program Structure and Algorithms", 4);
        addCourse("INFO6215", "Business Analysis and Information Engineering", 4);
        addCourse("INFO6250", "Web Development Tools and Methods", 3);
        addCourse("INFO4550", "Software Quality Control and Management", 4);
        addCourse("INFO8150", "Cloud Computing", 3);
        addCourse("ACCT3304", "Business Law and Professional Ethics", 4);
        addCourse("ACCT3416", "Strategic Cost Analysis for Decision Making", 3);
        addCourse("FINA4320", "International Financial Management", 3);
        addCourse("IELG1120", "Moroccan Arabic and Culture", 5);
    }
    
}

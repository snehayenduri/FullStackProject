/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.StudentTranscripts;

import Model.CourseSchedule.CourseOffer;
import Model.People.Student;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author snehayenduri
 */
public class Transcripts {
    private static final int COURSES_COMPLETION_GRADUATION = 8;
    private Student student;
    private Map<CourseOffer,String> grades;
    
    public Transcripts(Student student) {
        grades = new HashMap<>();
        this.student = student;
    }
    
    public Transcripts(Student student, Map<CourseOffer, String> grades) {
        this.student = student;
        this.grades = grades;
    }
    
    public String getGradeOfCourseOffer(CourseOffer courseOffer){
        return grades.get(courseOffer);
    }
    
    public boolean isEligibleForGraduation(){
        return (grades.size()>=COURSES_COMPLETION_GRADUATION);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<CourseOffer, String> getGrades() {
        return grades;
    }

    public void setGrades(Map<CourseOffer, String> grades) {
        this.grades = grades;
    }
    
    
    
}

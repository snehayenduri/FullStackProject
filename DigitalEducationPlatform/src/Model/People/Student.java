/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.People;

import Model.CourseSchedule.CourseOffer;
import Model.CourseSchedule.CourseSchedule;
import Model.StudentTranscripts.Transcripts;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class Student{
    Person person;
    int StudentID;
    Transcripts transcript;
    CourseSchedule courseSchedule;
    ArrayList<CourseOffer> previousCourses;

    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }
    
    public Student(Person p) {
        person = p;
        transcript = new Transcripts(this);
        courseSchedule = new CourseSchedule(this);
        previousCourses = new ArrayList<CourseOffer>();
    }
    
    public Student(Person p, int StudentID){
        person = p;
        this.StudentID = StudentID;
        transcript = new Transcripts(this);
        courseSchedule = new CourseSchedule(this);
        previousCourses = new ArrayList<CourseOffer>();
    }

    public Transcripts getTranscript() {
        return transcript;
    }
    
    public Boolean isMatch(int id){
        return (StudentID==id);
    }
    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    @Override
    public String toString() {
        return this.person.toString();
    }
    
    
}

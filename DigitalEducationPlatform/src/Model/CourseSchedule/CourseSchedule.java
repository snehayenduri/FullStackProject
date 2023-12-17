/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CourseSchedule;

import Model.People.Student;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author snehayenduri
 */
public class CourseSchedule {
    private ArrayList<CourseOffer> studentCourses;
    private Student student;

    public CourseSchedule(Student student) {
        this.student = student;
        studentCourses = new ArrayList<>();
    }

    public ArrayList<CourseOffer> getStudentCourses() {
        return studentCourses;
    }
    
    public boolean dropCourses(CourseOffer courseDrop){
        for(CourseOffer cr: studentCourses){
            if(cr==courseDrop){
                studentCourses.remove(cr);
                return true;
            }
        }
        return false;
    }
    
    public List<CourseOffer> getCourseOfferBySem(String semester){
        List<CourseOffer> result = new ArrayList<>();
        for(CourseOffer courseOffer : studentCourses){
           if(courseOffer.getSemester().equals(semester)){
               result.add(courseOffer);
           }
        }
        return result;
    }

    public void setStudentCourses(ArrayList<CourseOffer> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}

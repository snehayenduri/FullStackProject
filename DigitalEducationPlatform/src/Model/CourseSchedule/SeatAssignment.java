/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CourseSchedule;

import Model.People.Student;


/**
 *
 * @author snehayenduri
 */
public class SeatAssignment {
    CourseOffer courseOffer;
    Student student;

    public SeatAssignment(CourseOffer courseOffer, Student student) {
        this.courseOffer = courseOffer;
        this.student = student;
    }

    public SeatAssignment() {
    }

    public Seat assignSeat(CourseOffer courseOffer, Student student){
        Seat seat = courseOffer.getEmptySeat();
        if(seat != null){
            seat.setIsOccupied(true);
            seat.setStudent(student);
            return seat;
        }else{
            courseOffer.setOpen(false);
        }
        return null;
    }
    
    public CourseOffer getCourseOffer() {
        return courseOffer;
    }

    public void setCourseOffer(CourseOffer courseOffer) {
        this.courseOffer = courseOffer;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}

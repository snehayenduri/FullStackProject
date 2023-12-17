/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CourseSchedule;


import Model.CourseCatalog.Course;
import Model.Faculty.Professor;
import Model.People.Student;
import java.util.ArrayList;

/**
 *
 * @author snehayenduri
 */
public class CourseOffer {
    private Course course;
    private ArrayList<Seat> seatList;
    private Professor professor;
    private boolean open;
    private String semester;
    private String languageTaught;
    private String Timing;

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String Timing) {
        this.Timing = Timing;
    }
    

    public CourseOffer() {
        this.seatList = new ArrayList<>();
        open = true;
    }
    
    
    public void generateSeats(int noOfSeats) {

        for (int i = 0; i < noOfSeats; i++) {
            seatList.add(new Seat(i, this));
        }

    }
    
    public Seat getEmptySeat() {
        for (Seat seat : seatList) {

            if (!seat.getIsOccupied()) {
                return seat;
            }
        }
        return null;
    }
    
    public Seat getSeatOfStudent(Student st){
        for(Seat seat : seatList){
            if(seat.getStudent() == st) return seat;
        }
        return null;
    }
    
    public String getLanguageTaught() {
        return languageTaught;
    }

    public void setLanguageTaught(String languageTaught) {
        this.languageTaught = languageTaught;
    }

    
    
    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return course.toString();
    }
  
    
    
}

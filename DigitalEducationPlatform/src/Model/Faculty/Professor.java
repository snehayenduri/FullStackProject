package Model.Faculty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.CourseSchedule.CourseOffer;
import Model.People.Person;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class Professor {

    Person person;
    int professorID;
    ArrayList <ProfessorAssignment> professorAssignments; 
    double rating;
    ArrayList<CourseOffer> teachingHistory;
    int flag = 0;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public Professor(Person p, int id) {

        person = p;
        professorID = id;
        professorAssignments = new ArrayList();
        teachingHistory = new ArrayList<>();
        double rating = 0;
    }

    public Professor(Person person, int professorID, double rating) {
        this.person = person;
        this.professorID = professorID;
        this.professorAssignments = new ArrayList();
        this.rating = rating;
        this.teachingHistory = new ArrayList();
    }
    
    
    public  double getProfAverageOverallRating(int n){
        rating = ((rating*flag)+n)/(++flag);
        return rating;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public ArrayList<CourseOffer> getTeachingHistory() {
        return teachingHistory;
    }

    public void setTeachingHistory(ArrayList<CourseOffer> teachingHistory) {
        this.teachingHistory = teachingHistory;
    }

    public ProfessorAssignment AssignAsTeacher(CourseOffer co){
        
        ProfessorAssignment fa = new ProfessorAssignment(this, co);
        professorAssignments.add(fa);
        
        return fa;
    }
    
    public Professor getCourseOffer(String courseid){
        return null; //complete it later
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<ProfessorAssignment> getProfessorAssignments() {
        return professorAssignments;
    }

    public void setProfessorAssignments(ArrayList<ProfessorAssignment> professorAssignments) {
        this.professorAssignments = professorAssignments;
    }

    public boolean isMatch(int id) {
        if (professorID==id) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return person.toString();
    }
    
    
}

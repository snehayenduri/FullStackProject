package Model.Faculty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.People.Person;
import Model.People.PersonDirectory;
import java.util.ArrayList;
import Model.CourseCatalog.CourseCatalog;
import Model.CourseSchedule.CourseLoad;

/**
 *
 * @author nitin
 */

public class ProfessorDirectory {

    ArrayList<Professor> teacherlist;

    public ProfessorDirectory() {

        teacherlist = new ArrayList();
       
    }

    public Professor newFacultyProfile(Person p, int professorID){
        Professor sp = new Professor(p, professorID);
        teacherlist.add(sp);
        return sp;
    }
    public Professor newFacultyProfile(Person p, int professorID, double rating) {

        Professor sp = new Professor(p, professorID, rating);
        teacherlist.add(sp);
        return sp;
    }
    
    public boolean deleteProfessor(Professor professor){
        return teacherlist.remove(professor);
    }

    public ArrayList<Professor> getTeacherlist() {
        return teacherlist;
    }

    public void setTeacherlist(ArrayList<Professor> teacherlist) {
        this.teacherlist = teacherlist;
    }
    

    public Professor findProfessor(int id) {

        for (Professor sp : teacherlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }

    public void populateProfessors(PersonDirectory personDirectory, CourseLoad courseLoad, CourseCatalog courseCatalog) {
       Person p1= personDirectory.newPerson(1, "Liu", "Handan", "MA, USA", "l.h@gmail.com", 1223245);
       Professor pf = newFacultyProfile(p1, 1, 4);
       pf.teachingHistory.add(courseLoad.createCourseOffer(courseCatalog.getCourseByID("INFO6150"), 20, pf, "Spring2022", "py"));
       pf.teachingHistory.add(courseLoad.createCourseOffer(courseCatalog.getCourseByID("INFO6250"), 20, pf, "Spring2022", "py"));
       pf.teachingHistory.add(courseLoad.createCourseOffer(courseCatalog.getCourseByID("ACCT3304"), 20, pf, "Spring2022", "py"));
       
       Person p2= personDirectory.newPerson(1, "Gupta", "Pramod", "NY, USA", "g.p@gmail.com", 9833245);
       newFacultyProfile(p2, 2, 4.5);
       
       Person p3= personDirectory.newPerson(1, "Kadwell", "Frank", "Beijing, China", "k.f@gmail.com", 9033245);
       newFacultyProfile(p3, 3, 3);
       
       Person p4= personDirectory.newPerson(1, "Oza", "Taral", "Florida, USA", "o.t@gmail.com", 1283245);
       newFacultyProfile(p4, 4, 3.5);
       
       Person p5= personDirectory.newPerson(1, "Aityen", "Sargey", "Hyderabad, India", "a.s@gmail.com", 9608655);
       newFacultyProfile(p5, 5, 3.7);
       
       Person p6= personDirectory.newPerson(1, "Pan", "Hong", "Moscow, Russia", "p.h@gmail.com", 85423245);
       newFacultyProfile(p6, 6, 4.4);
       
       Person p7= personDirectory.newPerson(1, "Ritter", "Bret", "Tokyo, Japan", "r.b@gmail.com", 1623245);
       newFacultyProfile(p7, 7, 4.9);
       
       Person p8= personDirectory.newPerson(1, "Dsouza", "Ashwin", "London, UK", "d.a@gmail.com", 8423245);
       newFacultyProfile(p8, 8, 4.3);
       
       Person p9= personDirectory.newPerson(1, "Chen", "Yuz", "Beijing, China", "c.y@gmail.com",9323245);
       newFacultyProfile(p9, 9, 4.1);
       
       Person p10= personDirectory.newPerson(1, "Zheng", "Hannah", "Seoul, Korea", "z.h@gmail.com",83223245);
       newFacultyProfile(p10, 10, 3.9);
    }
}

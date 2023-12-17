/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.People;

import Model.CourseSchedule.CourseOffer;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author nitin
 */

public class StudentDirectory {

    ArrayList<Student> studentlist;

    public ArrayList<Student> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(ArrayList<Student> studentlist) {
        this.studentlist = studentlist;
    }

    public StudentDirectory() {

        studentlist = new ArrayList();

    }

    public Student newStudentProfile(Person p) {

        Student sp = new Student(p);
        studentlist.add(sp);
        return sp;
    }
    
    public Student newStudentProfile(Person p, int studentID) {

        Student sp = new Student(p, studentID);
        studentlist.add(sp);
        return sp;
    }

    public Student findStudent(int id) {

        for (Student sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
    }
    
    public boolean addCurrentCoursesToTranscripts(String currentSemester){
        for(Student student: studentlist){
            Map<CourseOffer,String> map = student.getTranscript().getGrades();
            for(CourseOffer co : student.getCourseSchedule().getCourseOfferBySem(currentSemester)){
                String grade = co.getSeatOfStudent(student).getGrade();
                map.put(co, grade);
            }
        }
        return true;
    }
   
    
    public boolean deleteStudent(Student student){
       return studentlist.remove(student); 
    }
    
    public void populateStudents(PersonDirectory personDirectory){
        Person p1 = personDirectory.newPerson(11, "Nikhil", "Godalla", "Boston", "n.g@gmail.com", 56273460);
        newStudentProfile(p1, 11);
        
         Person p2 = personDirectory.newPerson(12, "Vignesh", "Surampalli", "New York", "v.s@gmail.com", 68347120);
        newStudentProfile(p2, 12);
        
         Person p3 = personDirectory.newPerson(13, "Rukmini", "Reddy", "India", "r.r@gmail.com", 78924320);
        newStudentProfile(p3, 13);
        
         Person p4 = personDirectory.newPerson(14, "Akshara", "Patlannagari", "France", "a.p@gmail.com", 27354760);
        newStudentProfile(p4, 14);
        
         Person p5 = personDirectory.newPerson(15, "Vaesh", "Vella", "Italy", "v.v@gmail.com", 63748520);
        newStudentProfile(p5, 15);
        
         Person p6 = personDirectory.newPerson(16, "Nitin", "Indukuri", "India", "n.i@gmail.com", 307859332);
        newStudentProfile(p6, 16);
        
         Person p7 = personDirectory.newPerson(17, "Sneha", "Yenduri", "California", "s.y@gmail.com", 35467299);
        newStudentProfile(p7, 17);
        
         Person p8 = personDirectory.newPerson(18, "Vasavi", "Koneru", "India", "v.k@gmail.com", 75863292);
        newStudentProfile(p8, 18);
        
         Person p9 = personDirectory.newPerson(19, "Geetika", "Reddy", "Nepal", "g.r@gmail.com", 49678222);
        newStudentProfile(p9, 19);
        
         Person p10 = personDirectory.newPerson(20, "Rahul", "Chappidi", "Chicago", "r.c@gmail.com", 23932840);
        newStudentProfile(p10, 20);
        
         Person p11 = personDirectory.newPerson(21, "Sai", "Teja", "South Korea", "s.tej@gmail.com", 49678222);
        newStudentProfile(p11, 21);
        
         Person p12 = personDirectory.newPerson(22, "Saryu", "Vytla", "North Korea", "s.v@gmail.com", 23932840);
        newStudentProfile(p12, 22);
        
         Person p13 = personDirectory.newPerson(23, "Surya", "Teja", "North Korea", "s.t@gmail.com", 49678222);
        newStudentProfile(p13, 23);
        
         Person p14 = personDirectory.newPerson(24, "Sindhu", "p", "Canada", "s.p@gmail.com", 49678222);
        newStudentProfile(p14, 24);
        
         Person p15 = personDirectory.newPerson(25, "Meghana", "Reddy", "West Indies", "m.r@gmail.com", 4567231);
        newStudentProfile(p15, 25);
        
        Person p16 = personDirectory.newPerson(26, "Srjinesh", "Alanka", "Italy", "s.a@gmail.com", 32456778);
        newStudentProfile(p16, 26);
        
        Person p17 = personDirectory.newPerson(27, "Grace", "Meghana", "France", "g.m@gmail.com", 49678222);
        newStudentProfile(p17, 27);
        
        Person p18 = personDirectory.newPerson(28, "Pranavi", "Jedigunta", "New York", "p.j@gmail.com", 23932840);
        newStudentProfile(p18, 28);
        
        Person p19 = personDirectory.newPerson(29, "Suriya", "Sivakumar", "India", "s.s@gmail.com", 0);
        newStudentProfile(p19, 29);
        
        Person p20 = personDirectory.newPerson(30, "Shresta", "Kamani", "China", "s.k@gmail.com", 0);
        newStudentProfile(p20, 30);
    }
    
}

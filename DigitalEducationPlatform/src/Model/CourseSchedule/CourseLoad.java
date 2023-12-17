/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CourseSchedule;

import Model.CourseCatalog.Course;
import Model.Faculty.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author snehayenduri
 */
public class CourseLoad {
    ArrayList<CourseOffer> courseOffers;
    ArrayList<CourseSchedule> courseSchedules;

    public CourseLoad() {
        courseOffers = new ArrayList<>();
        courseSchedules = new ArrayList<>();
    }
    
    public CourseOffer createCourseOffer(Course course, int noOfSeats, Professor professor, String semester, String languageTaught){
        
        CourseOffer courseOffer = new CourseOffer();
        courseOffer.setCourse(course);
        courseOffer.generateSeats(noOfSeats);
        courseOffer.setProfessor(professor);
//        courseOffer.setSemester(getSemester(semester));
        courseOffer.setSemester(semester);
        courseOffer.setLanguageTaught(languageTaught);
        courseOffers.add(courseOffer);
        
        return courseOffer;      
    }
    
    public CourseOffer getCourseOffer(Course course){
        for(CourseOffer courseOffer : courseOffers){
            if(courseOffer.getCourse()==course) return courseOffer;
        }
        return null;
    }
    
    public List<CourseOffer> getCourseOfferBySem(String semester){
        List<CourseOffer> result = new ArrayList<>();
        for(CourseOffer courseOffer : courseOffers){
           if(courseOffer.getSemester().equals(semester)){
               result.add(courseOffer);
           }
        }
        return result;
    }
    
    public List<CourseOffer> getCourseOfferByLanguage(String language){
        List<CourseOffer> result = new ArrayList<>();
        for(CourseOffer courseOffer : courseOffers){
            System.out.println(courseOffer);
            System.out.println(courseOffer.getLanguageTaught()+" "+language);
           if(courseOffer.getLanguageTaught().equalsIgnoreCase(language)){
                System.out.println("in - "+courseOffer);
               result.add(courseOffer);
           } 
        }
        return result;
    }
    
     public List<CourseOffer> getCourseOfferByProf(String professorName){
        List<CourseOffer> result = new ArrayList<>();
        for(CourseOffer courseOffer : courseOffers){
            String pName =  courseOffer.getProfessor().getPerson().getFirstName();
            String lastName = courseOffer.getProfessor().getPerson().getLastName();
           if((pName+" "+lastName).equalsIgnoreCase(professorName)){
               result.add(courseOffer);
           }
        }
        return result;
    }
     
     public List<CourseOffer> getCourseOfferByProfInSem(Professor professor, String semester){
        List<CourseOffer> result = new ArrayList<>();
        for(CourseOffer courseOffer : courseOffers){
            String sem =  courseOffer.getSemester();
           if(courseOffer.getProfessor()==professor && sem.equalsIgnoreCase(semester)){
               result.add(courseOffer);
           }
        }
        return result;
    }

    private SemesterEnum getSemester(String semester) {
        return switch (semester) {
            case "Fall2021" -> SemesterEnum.Fall2021;
            case "Spring2021" -> SemesterEnum.Spring2021;
            case "Fall2022" -> SemesterEnum.Fall2022;
            case "Fall2023" -> SemesterEnum.Fall2023;
            default -> null;
        };
    }

    public ArrayList<CourseOffer> getCourseOffers() {
        return courseOffers;
    }

    public void setCourseOffers(ArrayList<CourseOffer> courseOffers) {
        this.courseOffers = courseOffers;
    }

    public ArrayList<CourseSchedule> getCourseSchedules() {
        return courseSchedules;
    }

    public void setCourseSchedules(ArrayList<CourseSchedule> courseSchedules) {
        this.courseSchedules = courseSchedules;
    }
    
    
}

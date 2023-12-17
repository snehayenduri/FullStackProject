/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Employment;

import Model.CourseSchedule.CourseOffer;
import Model.Employer.EmployerProfile;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class Employment {
    ArrayList<CourseOffer> relevantcourseoffers;
    int weight;
    String quality;
    String job;
    Employment nextemplyment;  //next job so they are in a sequence 
    
    EmployerProfile employer;
    public Employment(String j){
        
         relevantcourseoffers = new ArrayList();
        
    }

}

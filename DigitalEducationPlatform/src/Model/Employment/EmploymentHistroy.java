/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Employment;

import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class EmploymentHistroy {
    ArrayList<Employment> employments;
    public EmploymentHistroy(){
        employments = new ArrayList();
    }
    
    public Employment newEmployment(String job){
        Employment ne = new Employment(job);
        employments.add(ne);
        return ne;
    }
    
}
package Model.Employer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class EmployerDirectory {

    ArrayList<EmployerProfile> employerlist;

    public EmployerDirectory() {
        employerlist = new ArrayList();

    }

    public EmployerProfile newEmployerProfile(String n) {

        EmployerProfile sp = new EmployerProfile(n);
        employerlist.add(sp);
        return sp;
    }

    public EmployerProfile findTeachingFaculty(String id) {

        for (EmployerProfile ep : employerlist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
         }
    
}

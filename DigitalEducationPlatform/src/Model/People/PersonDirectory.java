/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.People;

import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class PersonDirectory {
    
      ArrayList<Person> personlist ;
    
      public PersonDirectory (){
          
       personlist = new ArrayList();
    }

    public Person newPerson(int id, String FirstName, String LastName, String Address, String email, int PhoneNumber) {

        Person p = new Person(id, FirstName, LastName, Address, email, PhoneNumber);
        personlist.add(p);
        return p;
    }

    public Person findPerson(int id) {

        for (Person p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }

    private void populatePersons() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

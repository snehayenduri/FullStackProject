/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Personnel;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String ID;

    public Person(String id) {

        this.ID = ID;
    }

    public Person() {

    }
    public String getPersonID() {
        return ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    

    public boolean isMatch(String id) {
        if (getPersonID().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getPersonID();
    }
    
    
}

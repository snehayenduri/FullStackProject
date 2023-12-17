/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.People;

/**
 *
 * @author nitin
 */
public class Person {
    
    int PersonID;
    String FirstName;
    String LastName;
    String Address;
    String email;
    int PhoneNumber;

    public Person(int PersonID) {
        this.PersonID = PersonID;
    }

    public Person(int PersonID, String FirstName, String LastName, String Address, String email, int PhoneNumber) {
        this.PersonID = PersonID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
    }
    
    

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    public Boolean isMatch(int ID){
        return(PersonID==ID);
    }

    @Override
    public String toString() {
        return FirstName + " "+LastName ;
    }
    
    
}

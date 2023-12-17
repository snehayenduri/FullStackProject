/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Enterprise.GuestEventRequest;
import Business.Organization.Organization;
import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class UserAccount {
    private String username;
    private String password;
    private Person person;
    private Organization organization;
    private Role role;
    ArrayList<GuestEventRequest> eventRequestList;
    
    UserAccount(){
        eventRequestList = new ArrayList<>();
    }

    public ArrayList<GuestEventRequest> getEventRequestList() {
        return eventRequestList;
    }

    public void setEventRequestList(ArrayList<GuestEventRequest> eventRequestList) {
        this.eventRequestList = eventRequestList;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    public String getUsername() {
        return username;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }
    
    
    
}

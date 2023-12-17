/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Guest;

import Business.Enterprise.Event;
import Business.Person.Person;
import Business.Roles.GuestRole;
import Business.Roles.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class GuestDirectory {
//    ArrayList<UserAccount> userList;
   ArrayList<GuestRole> guestList;
    public GuestDirectory() {
        guestList = new ArrayList<>();
}
    
//    public UserAccount addGuest(String guestMail, Event event, Person person){
//    }

    public ArrayList<GuestRole> getGuests() {
        return guestList;
    }

    public void setGuests(ArrayList<GuestRole> userList) {
        this.guestList = userList;
    }
    
    public GuestRole addGuest(String email, Event event, UserAccount user){
        GuestRole gr = new GuestRole(event, user, email);
        guestList.add(gr);
        return gr;
    }
}

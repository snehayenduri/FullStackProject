/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Business;
import Business.Enterprise.Event;
import Business.Organization.Organization;
import Business.Person.Person;
import javax.swing.JPanel;
import ui.guest.GuestJPanel;

/**
 *
 * @author nitin
 */
public class GuestRole extends Role{
    private Event event;
    private UserAccount userAccount;
    private String guestEmail;
    
    public GuestRole(){
        this.type = Role.RoleType.Guest;
    }

    public GuestRole(Event event, UserAccount userAccount, String guestEmail) {
        this();
        this.event = event;
        this.userAccount = userAccount;
        this.guestEmail = guestEmail;
    }

    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = Role.RoleType.Guest;
        return new GuestJPanel(userProcessContainer, account , business);
    }
}

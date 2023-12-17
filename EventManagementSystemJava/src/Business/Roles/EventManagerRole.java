/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Business;
import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.Organization;
import Business.Organization.VendorOrganization.VendorOrganization;
import javax.swing.JPanel;
import ui.eventManagement.EventManagementJPanel;

/**
 *
 * @author nitin
 */
public class EventManagerRole extends Role{
    public EventManagerRole(){
        this.type = Role.RoleType.EventManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = Role.RoleType.EventManager;
        return new EventManagementJPanel(userProcessContainer, account, (EventManagementOrganization)organization, business);
    }
}

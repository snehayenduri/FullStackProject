/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Business;
import Business.Organization.Organization;
import Business.Organization.VendorOrganization.VendorOrganization;
import Business.Organization.VenueOrganization.VenueOrganization;
import javax.swing.JPanel;
import ui.venue.VenueJPanel;

/**
 *
 * @author nitin
 */
public class VenueManagerRole extends Role {
    public VenueManagerRole(){
        this.type = Role.RoleType.VenueManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = Role.RoleType.VenueManager;
        return new VenueJPanel(userProcessContainer, account, (VenueOrganization)organization, business);
    }
}

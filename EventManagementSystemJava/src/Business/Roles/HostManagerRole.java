/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Business;
import Business.Organization.HostOrganization.HostOrganization;
import Business.Organization.Organization;
import Business.Organization.VendorOrganization.VendorOrganization;
import javax.swing.JPanel;
import ui.host.HostJPanel;

/**
 *
 * @author nitin
 */
public class HostManagerRole extends Role {

    public HostManagerRole() {
        this.type = RoleType.HostManager;
    }
    
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = RoleType.HostManager;
        return new HostJPanel(userProcessContainer, account, (HostOrganization)organization, business);
    }
}

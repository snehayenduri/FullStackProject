/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Business;
import Business.Organization.Organization;
import javax.swing.JPanel;
import ui.Admin.AdminJPanel;
import ui.guest.GuestJPanel;

/**
 *
 * @author nitin
 */
public class AdminRole  extends Role  {

    public AdminRole() {
        this.type = Role.RoleType.Admin;

    }
 
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
         this.type = Role.RoleType.Admin;
        return new AdminJPanel(userProcessContainer , business);
    }
    
}

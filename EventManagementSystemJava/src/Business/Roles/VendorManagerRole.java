/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Business;
import Business.Organization.Organization;
import Business.Organization.VendorOrganization.VendorOrganization;
import javax.swing.JPanel;
import ui.vendor.VendorJPanel;

/**
 *
 * @author nitin
 */
public class VendorManagerRole extends Role{
    public VendorManagerRole(){
        this.type = RoleType.VendorManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = RoleType.VendorManager;
        return new VendorJPanel(userProcessContainer, account, (VendorOrganization)organization, business);
    }
    
}

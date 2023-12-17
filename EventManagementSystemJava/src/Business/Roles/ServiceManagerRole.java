/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Business;
import Business.Organization.Organization;
import Business.Organization.ServiceOrganization.ServiceOrganization;
import Business.Organization.VendorOrganization.VendorOrganization;
import javax.swing.JPanel;
import ui.service.ServiceJPanel;

/**
 *
 * @author nitin
 */
public class ServiceManagerRole extends Role{
    public ServiceManagerRole(){
        this.type = RoleType.ServiceManager;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        this.type = RoleType.ServiceManager;
        return new ServiceJPanel(userProcessContainer, account, (ServiceOrganization)organization, business);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.EventDirectory;
import Business.Guest.GuestDirectory;
import Business.Organization.OrganizationDirectory;
import Business.Organization.ServiceOrganization.OrderManagement.MasterOrderList;
import Business.Person.PersonDirectory;
import Business.Roles.UserAccountDirectory;

/**
 *
 * @author nitin
 */
public class Business {
    private EnterpriseDirectory enterpriseDirectory;
    private static Business business;
    private UserAccountDirectory userAccountDirectory;
    private PersonDirectory personDirectory;
    private EventDirectory eventDirectory;
    private OrganizationDirectory organizationDirectory;
    private GuestDirectory guestDirectory;
    private MasterOrderList masterOrderList;
    
    public static Business getInstance(){
        if(business == null){
            business = new Business();
        }
        return business;
    }
    public Business(){
        enterpriseDirectory = new EnterpriseDirectory();
        userAccountDirectory = new UserAccountDirectory();
        personDirectory = new PersonDirectory();
        eventDirectory = new EventDirectory();
        organizationDirectory = new OrganizationDirectory();
        guestDirectory = new GuestDirectory();
        masterOrderList = new MasterOrderList();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
    public EventDirectory getEventDirectory() {
        return eventDirectory;
    }

    public void setEventDirectory(EventDirectory eventDirectory) {
        this.eventDirectory = eventDirectory;
    }
    
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public static Business getBusiness() {
        return business;
    }

    public static void setBusiness(Business business) {
        Business.business = business;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public GuestDirectory getGuestDirectory() {
        return guestDirectory;
    }

    public void setGuestDirectory(GuestDirectory guestDirectory) {
        this.guestDirectory = guestDirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterOrderList;
    }

    public void setMasterOrderList(MasterOrderList masterOrderList) {
        this.masterOrderList = masterOrderList;
    }
    
}

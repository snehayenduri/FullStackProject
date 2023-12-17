/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.HostOrganization.HostOrganization;
import Business.Organization.Organization.OrganizationType;
import Business.Organization.ServiceOrganization.ServiceOrganization;
import Business.Organization.VendorOrganization.VendorOrganization;
import Business.Organization.VenueOrganization.VenueOrganization;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class OrganizationDirectory {
    ArrayList<Organization> organizationList;
    int id =1;
    public OrganizationDirectory(){
        organizationList = new ArrayList<>();
    }
    public Organization addOrganization(OrganizationType type, String orgName, String orgAddress){
        Organization organization;
        switch(type){
            case HostOrganization:
                organization = new HostOrganization(orgName, orgAddress);
                break;
            case VenueOrganization:
                organization = new VenueOrganization(orgName, orgAddress);
                break;
            case VendorOrganization:
                organization = new VendorOrganization(orgName, orgAddress);
                break;
            case EventManagementOrganization:
                organization = new EventManagementOrganization(orgName, orgAddress);
                break;
            case ServiceOrganization:
                organization = new ServiceOrganization(orgName, orgAddress);
                break;
            default:
                throw new IllegalArgumentException("Unsupported Organization type: " + type);
                
        }
        organization.setId(id++);
        organization.setType(type);
        organizationList.add(organization);
        return organization;
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public Organization getOrganizationById(int id){
        for(Organization organization : organizationList){
            if(organization.getId()==id) return organization;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

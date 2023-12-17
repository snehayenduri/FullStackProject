/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.VendorOrganization;

import Business.Enterprise.VendorEventRequest;
import Business.Organization.Organization;
import Business.Roles.VendorManagerRole;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class VendorOrganization extends Organization{
    String vendorType;
    VendorManagerRole manager;
    ArrayList<VendorEventRequest> vendorEventRequestList;
    public VendorOrganization( String orgName, String orgAddress){
        super(orgName, orgAddress);
        this.vendorEventRequestList = new ArrayList<>();
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public VendorManagerRole getManager() {
        return manager;
    }

    public void setManager(VendorManagerRole manager) {
        this.manager = manager;
    }

    public ArrayList<VendorEventRequest> getVendorEventRequestList() {
        return vendorEventRequestList;
    }

    public void setVendorEventRequestList(ArrayList<VendorEventRequest> vendorEventRequestList) {
        this.vendorEventRequestList = vendorEventRequestList;
    }

    @Override
    public String toString() {
        return this.getOrganizationName();
    }
    
    
    
}

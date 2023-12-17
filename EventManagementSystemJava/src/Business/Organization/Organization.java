/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;


/**
 *
 * @author nitin
 */
public class Organization {
    String organizationName;
    String organizationAddress;
    int id;

    public Organization(String organizationName, String organizationAddress) {
        this.organizationAddress = organizationAddress;
        this.organizationName = organizationName;
    }
    
    public enum OrganizationType {
        HostOrganization("HostOrganization"),
        EventManagementOrganization("EventManagementOrganization"),
        ServiceOrganization("ServiceOrganization"),
        VenueOrganization("VenueOrganization"),
        VendorOrganization("VendorOrganization");

        private String value;

        private OrganizationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public OrganizationType type;

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }
    

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getOrganizationName() ;
//        return type.getValue();
    }
    
    
    
}

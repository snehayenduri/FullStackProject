/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.Business;
import Business.Organization.Organization;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {

    public enum RoleType {
        Admin("Admin"),
        VendorManager("VendorManager"),
        VenueManager("VenueManager"),
        EventManager("EventManager"),
        ServiceManager("ServiceManager"),
        HostManager("HostManager"),
        Employee("Employee"),
        Guest("Guest"),
        EventEmployee("EventEmployee"),
        ServiceEmployee("ServiceEmployee");

        private String value;

        private RoleType(String value) {
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

    public RoleType type;

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business);

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    
}

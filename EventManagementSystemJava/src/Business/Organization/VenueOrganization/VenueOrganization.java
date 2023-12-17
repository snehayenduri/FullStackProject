/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.VenueOrganization;

import Business.Enterprise.Event;
import Business.Organization.Organization;
import Business.Roles.VenueManagerRole;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class VenueOrganization extends Organization{
    public VenueAvailability availability;
    VenueManagerRole manager;
    ArrayList<Event> hostedEvents;
    public enum VenueAvailability{
        Available("Available"),
        Unavailable("Unavailable");

        private String availability;

        private VenueAvailability(String availability) {
            this.availability = availability;
        }

        public String getAvailability() {
            return availability;
        }

        @Override
        public String toString() {
            return availability;
        }
    }
    public VenueAvailability getAvailability(){
        return availability;
    }
    public VenueOrganization(String orgName, String orgAddress){
        super(orgName, orgAddress);
        hostedEvents = new ArrayList<>();
    }

    public ArrayList<Event> getHostedEvents() {
        return hostedEvents;
    }

    public void setHostedEvents(ArrayList<Event> hostedEvents) {
        this.hostedEvents = hostedEvents;
    }

    public OrganizationType getType() {
        return type;
    }

    public VenueManagerRole getManager() {
        return manager;
    }

    public void setManager(VenueManagerRole manager) {
        this.manager = manager;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public void setAvailability(VenueAvailability availability) {
        this.availability = availability;
    }
    @Override
    public String toString(){
        return super.getOrganizationName();
    }
    
    
}

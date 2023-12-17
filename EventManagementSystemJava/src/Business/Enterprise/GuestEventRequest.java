/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.HostOrganization.HostOrganization;
import Business.Roles.UserAccount;

/**
 *
 * @author nitin
 */
public class GuestEventRequest {
    private Event event;
    HostOrganization hostOrganization;
    private String message;
    UserAccount user;
    private EventRequestStatus status;
    public enum EventRequestStatus {
        Recieved("Recived"),
        Accepted ("Accepted"),
        Rejected ("Rejected");

        private String value;

        private EventRequestStatus(String value) {
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

    public EventRequestStatus getStatus() {
        return status;
    }

    public void setStatus(EventRequestStatus status) {
        this.status = status;
    }

    public GuestEventRequest(Event event, HostOrganization hostOrganization, UserAccount guest) {
        this.event = event;
        this.hostOrganization = hostOrganization;
        this.user = guest;
    }
    
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getGuest() {
        return user;
    }

    public void setGuest(UserAccount user) {
        this.user = user;
    }
    
    

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public HostOrganization getHostOrganization() {
        return hostOrganization;
    }

    public void setHostOrganization(HostOrganization hostOrganization) {
        this.hostOrganization = hostOrganization;
    }
    @Override
    public String toString(){
        return event.getName();
    }
    
}

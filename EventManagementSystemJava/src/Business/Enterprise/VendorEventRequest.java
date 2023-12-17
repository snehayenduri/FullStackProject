/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.HostOrganization.HostOrganization;
import Business.Organization.VendorOrganization.VendorOrganization;

/**
 *
 * @author nitin
 */
public class VendorEventRequest {
    private Event event;
    HostOrganization hostOrganization;
    private String message;
    VendorOrganization organization;
    private VendorEventRequestStatus status;
    public enum VendorEventRequestStatus {
        Recieved("Recived"),
        Accepted ("Accepted"),
        Rejected ("Rejected");

        private String value;

        private VendorEventRequestStatus(String value) {
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

    public VendorEventRequestStatus getStatus() {
        return status;
    }

    public void setStatus(VendorEventRequestStatus status) {
        this.status = status;
    }

    public VendorEventRequest(Event event, HostOrganization hostOrganization, VendorOrganization organization) {
        this.event = event;
        this.hostOrganization = hostOrganization;
        this.organization = organization;
    }
    
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VendorOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(VendorOrganization organization) {
        this.organization = organization;
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
    public String toString(){
        return event.getName();
    }
}

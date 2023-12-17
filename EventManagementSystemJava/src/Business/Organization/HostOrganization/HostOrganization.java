/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.HostOrganization;

import Business.Enterprise.Event;
import Business.Organization.Organization;
import Business.Roles.HostManagerRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nitin
 */
public class HostOrganization extends Organization {
    List<Event> hostedEvents;
    HostManagerRole manager;
    public HostOrganization(String orgName, String orgAddress){
        super(orgName, orgAddress);
        hostedEvents = new ArrayList<>();
    }

    public List<Event> getHostedEvents() {
        return hostedEvents;
    }

    public HostManagerRole getManager() {
        return manager;
    }

    public void setManager(HostManagerRole manager) {
        this.manager = manager;
    }

    public void setHostedEvents(List<Event> hostedEvents) {
        this.hostedEvents = hostedEvents;
    }
    
}

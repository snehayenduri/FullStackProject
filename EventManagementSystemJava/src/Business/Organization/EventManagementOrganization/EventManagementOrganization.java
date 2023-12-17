/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.EventManagementOrganization;

import Business.Enterprise.Event;
import Business.Organization.Organization;
import Business.Roles.EventManagerRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nitin
 */
public class EventManagementOrganization extends Organization{
    List<Event> managedEvents;
    EventManagerRole manager;
    public EventManagementOrganization(String orgName, String orgAddress){
        super(orgName, orgAddress);
        managedEvents = new ArrayList<>();
    }

    public List<Event> getManagedEvents() {
        return managedEvents;
    }

    public EventManagerRole getManager() {
        return manager;
    }

    public void setManager(EventManagerRole manager) {
        this.manager = manager;
    }

    public void setManagedEvents(List<Event> managedEvents) {
        this.managedEvents = managedEvents;
    }
}

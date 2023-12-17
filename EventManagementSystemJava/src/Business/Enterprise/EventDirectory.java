/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;


import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.HostOrganization.HostOrganization;
import Business.Roles.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author snehayenduri
 */
public class EventDirectory {
    private List<Event> events;
    private int eventID = 1;

    public EventDirectory() {
        events=new ArrayList<>();
    }

    
    public Event addEvent(String name, String type, HostOrganization host, String date, String time, int eventCapacity){
        Event event = new Event(eventID++, name, type, host, date, time, eventCapacity);
        events.add(event);
        return event;
    }
    
    public Event changeStatus(int eventId, EventStatusEnum eventStatus){
        Event event = getEventById(eventId);
        if(event!=null){
            event.setStatus(eventStatus);
        }
        return event;
    }
    
    public Event getEventById(int eventId){
        for(Event event : events){
            if(event.getEventId()==eventId) return event;
        }
        return null;
    }
    
    public List<Event> getEventsByHost(HostOrganization host){
        ArrayList<Event> hostEvents = new ArrayList<>();
        for(Event event : events){
            if(event.getHost()==host) hostEvents.add(event);
        }
        return hostEvents;
    }
    
    public List<Event> getEventsByEventMngmt(EventManagementOrganization eventManagement){
        ArrayList<Event> retEvents = new ArrayList<>();
        for(Event event : events){
            if(event.getEventManagement()==eventManagement) retEvents.add(event);
        }
        return retEvents;
    }
    
    public Event addGuest(int eventId, UserAccount user){
        Event event =  getEventById(eventId);
        if(event!=null){
            event.getInvitedGuestList().add(user);
        }
        return event;
    }
    
    public Event addGuestList(int eventId, List<UserAccount> users){
        Event event =  getEventById(eventId);
        if(event!=null){
            List<UserAccount> getGuestList = event.getInvitedGuestList();
            for(UserAccount user : users){
                getGuestList.add(user);
            }
        }
        return null;
    }
    
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
   
    
    
}

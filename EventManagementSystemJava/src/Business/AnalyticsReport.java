/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Enterprise.Event;
import Business.Enterprise.EventDirectory;
import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.HostOrganization.HostOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.ServiceOrganization.ProductManagement.Product;
import Business.Organization.VenueOrganization.VenueOrganization;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author nitin
 */
public class AnalyticsReport {
    public static void findBestEventOrganization(OrganizationDirectory organizations) {
        EventManagementOrganization bestOrganization = null;
        int maxEvents = 0;
        
        for (Organization organization : organizations.getOrganizationList()) {
            if(organization instanceof EventManagementOrganization){
                EventManagementOrganization eOrganization = (EventManagementOrganization) organization;
                int numberOfEvents = eOrganization.getManagedEvents().size();
                if (numberOfEvents > maxEvents) {
                     maxEvents = numberOfEvents;
                     bestOrganization = eOrganization;
                }
            }
        }
        
        System.out.println("Event Management Organization with most events:"+ bestOrganization);
    }
    public static void findHostOrganizationWithMostEvents(OrganizationDirectory organizations) {
        HostOrganization hostWithMostEvents = null;
        int maxEvents = 0;

        for (Organization organization : organizations.getOrganizationList()) {
            if(organization instanceof HostOrganization){
                HostOrganization hOrganization = (HostOrganization) organization;
            int numberOfEvents = hOrganization.getHostedEvents().size();
            if (numberOfEvents > maxEvents) {
                maxEvents = numberOfEvents;
                hostWithMostEvents = hOrganization;
            }
        }
        }

        System.out.println("Host Organization with most events:"+hostWithMostEvents);
    }
    public static void findVenueWithMostEvents(OrganizationDirectory venues) {
        VenueOrganization venueWithMostEvents = null;
        int maxEvents = 0;

        for (Organization organization: venues.getOrganizationList()) {
            if(organization instanceof VenueOrganization){
                VenueOrganization vOrganization  = (VenueOrganization) organization;
            int numberOfEvents = vOrganization.getHostedEvents().size();
            if (numberOfEvents > maxEvents) {
                maxEvents = numberOfEvents;
                venueWithMostEvents = vOrganization;
            }
            }
        }
       
      System.out.println("Venue with most events: "+venueWithMostEvents);
    }

    public static void findTop3Events(EventDirectory events) {
        // Sort events based on the number of attendees in descending order
        Collections.sort(events.getEvents(), new EventComparator());
       

        // Get the top 3 events
        List<Event> top3Events = new ArrayList<>();
        for (int i = 0; i < Math.min(3, events.getEvents().size()); i++) {
            top3Events.add(events.getEvents().get(i));
        }
        System.out.println("Top 3 Events with most attendees:");
        for(Event event: top3Events){
            System.out.println(event);
        }
    }
    
    public static void getTop3ExpensiveEvents(EventDirectory events) {
        // Use the custom comparator to sort events based on total expense
        Collections.sort(events.getEvents(), new EventExpenseComparator());

        // Get the top 3 most expensive events
        int topCount = Math.min(3, events.getEvents().size());
        List<Event> top3ExpensiveEvents = new ArrayList<>();
        for (int i = 0; i < topCount; i++) {
            top3ExpensiveEvents.add(events.getEvents().get(i));
        }
        System.out.println("Top 3 most expensive events:");
        for(Event event: top3ExpensiveEvents){
            System.out.println(event);
        }
    }

    private static class EventExpenseComparator implements Comparator<Event> {

        @Override
        public int compare(Event event1, Event event2) {
            // Calculate the total price for each event by summing the prices of all services
            float totalExpense1 = calculateTotalExpense(event1);
            float totalExpense2 = calculateTotalExpense(event2);

            // Compare events based on total expense in descending order
            return Float.compare(totalExpense2, totalExpense1);
        }

        private float calculateTotalExpense(Event event) {
            float totalExpense = 0;

            // Sum the prices of all services used in the event
            for (Product product : event.getProductList()) {
                totalExpense += product.getPrice();
            }

            return totalExpense;
        }
    }

    private static float calculateTotalExpense(Event event) {
        float totalExpense = 0;

        // Sum the prices of all services used in the event
        for (Product product : event.getProductList()) {
            totalExpense += product.getPrice();
        }

        return totalExpense;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.HostOrganization.HostOrganization;
import Business.Organization.ServiceOrganization.ProductManagement.Product;
import Business.Organization.VendorOrganization.VendorOrganization;
import Business.Organization.VenueOrganization.VenueOrganization;
import Business.Roles.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author snehayenduri
 */
public class Event {
    private int eventId;
    private String name;
    private String type;
    private HostOrganization host;
    private EventManagementOrganization eventManagement;
    private String date;
    private String time;
    private VenueOrganization venue;
    private List<UserAccount> invitedGuestList;
    private List<UserAccount> acceptedGuestList;
    private int eventCapacity;
    private EventStatusEnum status;
    private List<Product> productList;
    private List<VendorOrganization> invitedVendorList;
    private List<VendorOrganization> vendorList;
    private List<GuestEventRequest> eventRequestList;

    public Event() {
    }

    public Event(int id, String name, String type, HostOrganization host,  String date, String time, int eventCapacity) {
        this.name = name;
        this.type = type;
        this.host = host;
        this.date = date;
        this.time = time;
        this.eventId = id;
        this.invitedGuestList = new ArrayList<>();
        this.eventCapacity = eventCapacity;
        this.status = EventStatusEnum.Created;
        this.productList = new ArrayList<>();
        this.invitedVendorList = new ArrayList<>();
        this.eventRequestList = new ArrayList<>();
        this.acceptedGuestList = new ArrayList<>();
        this.vendorList = new ArrayList<>();
        
    }

    public List<VendorOrganization> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<VendorOrganization> vendorList) {
        this.vendorList = vendorList;
    }

    public List<GuestEventRequest> getEventRequestList() {
        return eventRequestList;
    }

    public void setEventRequestList(List<GuestEventRequest> eventRequestList) {
        this.eventRequestList = eventRequestList;
    }

    public List<UserAccount> getAcceptedGuestList() {
        return acceptedGuestList;
    }

    public void setAcceptedGuestList(List<UserAccount> acceptedGuestList) {
        this.acceptedGuestList = acceptedGuestList;
    }
    

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<VendorOrganization> getInvitedVendorList() {
        return invitedVendorList;
    }

    public void setInvitedVendorList(List<VendorOrganization> invitedVendorList) {
        this.invitedVendorList = invitedVendorList;
    }
    
    

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HostOrganization getHost() {
        return host;
    }

    public void setHost(HostOrganization host) {
        this.host = host;
    }

    public EventManagementOrganization getEventManagement() {
        return eventManagement;
    }

    public void setEventManagement(EventManagementOrganization eventManagement) {
        this.eventManagement = eventManagement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public VenueOrganization getVenue() {
        return venue;
    }

    public void setVenue(VenueOrganization venue) {
        this.venue = venue;
    }

    public List<UserAccount> getInvitedGuestList() {
        return invitedGuestList;
    }

    public void setInvitedGuestList(List<UserAccount> invitedGuestList) {
        this.invitedGuestList = invitedGuestList;
    }

    public int getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(int eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    public EventStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EventStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}

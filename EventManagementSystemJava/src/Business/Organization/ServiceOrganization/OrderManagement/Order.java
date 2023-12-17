/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.ServiceOrganization.OrderManagement;

import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.ServiceOrganization.ServiceOrganization;
import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class Order {
    int orderId;
    ArrayList<OrderItem> orderItems;
    EventManagementOrganization eventManagementOrganization;
    ServiceOrganization serviceOrganization;
    public Order(int orderId, EventManagementOrganization eventManagementOrganization, ServiceOrganization serviceOrganization){
        this.eventManagementOrganization = eventManagementOrganization;
        this.serviceOrganization = serviceOrganization;
        this.orderId = orderId;
        orderItems = new ArrayList<>();
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public EventManagementOrganization getEventManagementOrganization() {
        return eventManagementOrganization;
    }

    public void setEventManagementOrganization(EventManagementOrganization eventManagementOrganization) {
        this.eventManagementOrganization = eventManagementOrganization;
    }

    public ServiceOrganization getServiceOrganization() {
        return serviceOrganization;
    }

    public void setServiceOrganization(ServiceOrganization serviceOrganization) {
        this.serviceOrganization = serviceOrganization;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    
}

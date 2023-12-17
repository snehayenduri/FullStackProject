/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.ServiceOrganization;

import Business.Enterprise.Event;
import Business.Organization.Organization;
import Business.Organization.ServiceOrganization.OrderManagement.Order;
import Business.Organization.ServiceOrganization.ProductManagement.ProductCatalog;
import Business.Roles.ServiceManagerRole;
import java.util.ArrayList;


public class ServiceOrganization extends Organization{
    ProductCatalog productCatalog;
    ArrayList<Event> servicedEvents;
    ServiceManagerRole manager;
    public ServiceOrganization(String orgName, String orgAddress){
        super(orgName, orgAddress);
        productCatalog = new ProductCatalog();
        servicedEvents = new ArrayList<>();
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public ServiceManagerRole getManager() {
        return manager;
    }

    public void setManager(ServiceManagerRole manager) {
        this.manager = manager;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public ArrayList<Event> getServicedEvents() {
        return servicedEvents;
    }

    public void setServicedEvents(ArrayList<Event> servicedEvents) {
        this.servicedEvents = servicedEvents;
    }

    @Override
    public String toString() {
        return this.getOrganizationName();
    }

    
    
}

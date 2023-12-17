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
public class MasterOrderList {
    private ArrayList<Order> masterOrderList;
    private int id=1;
    public MasterOrderList(){
        masterOrderList = new ArrayList<>();
    }
    public Order addOrder(EventManagementOrganization eventManagementOrganization, ServiceOrganization serviceOrganization){
        Order newOrder = new Order(id++, eventManagementOrganization, serviceOrganization);
        masterOrderList.add(newOrder);
        return newOrder;
    }
    
    public Order getOrderById(int id){
        for(Order order : masterOrderList){
            if(order.getOrderId() == id) return order;
        }
        return null;
    }

    public ArrayList<Order> getMasterOrderList() {
        return masterOrderList;
    }

    public void setMasterOrderList(ArrayList<Order> masterOrderList) {
        this.masterOrderList = masterOrderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
           
    
}

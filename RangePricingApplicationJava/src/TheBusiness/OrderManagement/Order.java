/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class Order {

    ArrayList<OrderItem> orderitems;
    CustomerProfile customer;
    SalesPersonProfile salesperson;
    MarketChannelAssignment mca;
    String status;
    
    
    public Order(CustomerProfile cp) {
        orderitems = new ArrayList();
        customer = cp;
//        customer.addCustomerOrder(this);
        salesperson = null;
        status = "in process";
    }
    
    public Order(CustomerProfile cp, SalesPersonProfile ep) {
        orderitems = new ArrayList();
        customer = cp;
        salesperson = ep;
//        customer.addCustomerOrder(this); 
//        salesperson.addSalesOrder(this);  
    }
    
    public OrderItem newOrderItem(Product p, int actualprice, int q) {
        OrderItem oi = new OrderItem(p, actualprice, q);
        orderitems.add(oi);
        return oi;
    }
    
    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }
    
    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     
        }
        return sum;
    }
    
    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    
    public boolean isOrderAboveTotalTarget(){
        int sum = 0;
        for (OrderItem oi: orderitems){
            sum = sum + oi.getOrderItemTargetTotal(); 
        }
        if(getOrderTotal()>sum) {return true;}
        else {return false;} 
    }
    
    public void CancelOrder(){
        status = "Cancelled";
    }
    
    public void Submit(){
        status = "Submitted";
    }
    
}

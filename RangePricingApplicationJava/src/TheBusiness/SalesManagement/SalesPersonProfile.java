/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SalesManagement;

import java.util.ArrayList;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonProfile extends Profile {
    ArrayList<SolutionOrder> salesorders;
    int totalPricePerformance = 0;


    public SalesPersonProfile(Person p) {

        super(p); 
        salesorders = new ArrayList();
    }
    public void addSalesOrder(SolutionOrder o){
        salesorders.add(o);
    }
    @Override
    public String getRole(){
        return  "Sales";
    }
    public int getTotalPricePerformance(){
        for(SolutionOrder or: salesorders){
            totalPricePerformance+=or.getActualPrice();
        }
        return totalPricePerformance;
    }
    public int getNumberOfOrdersAboveTotalTarget(){
        int numberOfOrdersAboveTotalTarget = 0;
        for(SolutionOrder or: salesorders){
            if(or.isOrderAboveTotalTarget())
                numberOfOrdersAboveTotalTarget++;
        }
        return numberOfOrdersAboveTotalTarget;
    }
    public int getTotalTargetPrice(){
        int targetPrice = 0;
        for(SolutionOrder so: salesorders){
            targetPrice += so.getSelectedsolutionoffer().getTargetPrice();
        }
        return targetPrice;
    }

    public ArrayList<SolutionOrder> getSalesorders() {
        return salesorders;
    }

    public void setSalesorders(ArrayList<SolutionOrder> salesorders) {
        this.salesorders = salesorders;
    }
    
}

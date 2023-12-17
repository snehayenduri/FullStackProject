/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import java.util.ArrayList;
import TheBusiness.MarketModel.Market;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile extends Profile {

    ArrayList<SolutionOrder> solutionOrders;
    ArrayList<Market> markets;

    Person person;

    public CustomerProfile(Person p) {
        super(p);
        person = p;
        solutionOrders = new ArrayList();

    }
    
    @Override
    public String getRole(){
        return "Sales";
    }
    
    

    public int getTotalPricePerformance() {

        int price = 0;
        for(SolutionOrder so: solutionOrders){
            price+=so.getActualPrice();
        }
        return price;
    }

    public int getNumberOfOrdersAboveTotalTarget() {
        //for each order in the customer order list 
        //calculate if order is positive (actual order total is greater than sum of item targets
        //if yes then add 1 to total 
        int sum = 0;
        for (SolutionOrder o : solutionOrders) {
            if (o.isOrderAboveTotalTarget() == true) {
                sum = sum + 1;
            }
        }

        return sum;
    }
    public int getTotalTargetPrice(){
        int targetPrice = 0;
        for(SolutionOrder so: solutionOrders){
            targetPrice += so.getSelectedsolutionoffer().getTargetPrice();
        }
        return targetPrice;
    }
    public int getNumberOfOrdersBelowTotalTarget() {
        int sum = 0;
        for (SolutionOrder o : solutionOrders) {
            if (o.isOrderBelowTotalTarget() == true) {
                sum = sum + 1;
            }
        }

        return sum;
    }
    //for each order in the customer order list 
    //calculate if order is negative
    //if yes then add 1 to total 

    public boolean isMatch(String id) {
        if (person.getPersonID().equals(id)) {
            return true;
        }
        return false;
    }

    public void addCustomerOrder(SolutionOrder o) {
        solutionOrders.add(o);
    }

    @Override
    public String toString() {
        return person.getPersonID();
    }

    public String getCustomerId() {
        return person.getPersonID();
    }

    public Person getPerson() {
        return person;
    }

}

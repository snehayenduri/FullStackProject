/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.SalesManagement.SalesPersonProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MasterSolutionOrderList {
        ArrayList<SolutionOrder> solutionorderlist;
        int id;

    public MasterSolutionOrderList() {
        solutionorderlist = new ArrayList();
        id = 0;
    }
    public SolutionOrder newSolutionOrder(SolutionOffer soloffer, int actualPrice, MarketChannelAssignment mca, SalesPersonProfile salesPersonProfile, CustomerProfile customerprofile) {

        SolutionOrder so = new SolutionOrder(soloffer, ++id, actualPrice, mca, customerprofile);
        solutionorderlist.add(so);
        customerprofile.addCustomerOrder(so);
        soloffer.addSolutionOrder(so);
        mca.addSolutionOrder(so);
        salesPersonProfile.addSalesOrder(so);
        //System.out.println(mca.getMarket()+"--"+so);
        return so;
    }
    public int getRevenueByMarket(Market m) {
        int sum = 0;
        for(SolutionOrder so: solutionorderlist){
         
         MarketChannelAssignment mcc =   so.getMarketChannelCombo();
         if(mcc.getMarket()==m) sum = sum +so.getSolutionPrice();   
        }
        return sum;
    }
    public int getRevenueByChannel(Channel c) {
        int sum = 0;
        for(SolutionOrder so: solutionorderlist){
         
         MarketChannelAssignment mcc =   so.getMarketChannelCombo();
         if(mcc.getChannel()==c) sum = sum +so.getSolutionPrice();
           
        }
        return sum;
    }
    public int getRevenueByMarketChannelCombo(MarketChannelAssignment mca) {
        int sum = 0;
        for(SolutionOrder so: solutionorderlist){
         
         MarketChannelAssignment mcc =   so.getMarketChannelCombo();
         if(mcc==mca) sum = sum +so.getSolutionPrice(); 
           
        }
        return sum;
    }
    public ArrayList<SolutionOrder> getSolutionorderlist() {
        return solutionorderlist;
    }
    public void setSolutionorderlist(ArrayList<SolutionOrder> solutionorderlist) {
        this.solutionorderlist = solutionorderlist;
    }
}

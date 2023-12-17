/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;

/**
 *
 * @author kal bugrara
 */

public class SolutionOrder {
    
    SolutionOffer selectedsolutionoffer;
    int actualPrice = 0;
    int targetPrice = 0;
    int id=0;
    CustomerProfile customerprofile;
    MarketChannelAssignment marketChannelAssignment; 
    public SolutionOrder(SolutionOffer so, int id, int actualPrice, MarketChannelAssignment mca, CustomerProfile customerprofile){
        selectedsolutionoffer = so;
        marketChannelAssignment = mca;
        this.customerprofile = customerprofile;
        this.actualPrice = actualPrice;
        this.id = id;
        this.targetPrice = selectedsolutionoffer.getTargetPrice();
    }
    
    public int getSolutionPrice(){
        return actualPrice;
//        return selectedsolutionoffer.getSolutionPrice();
    }
    public MarketChannelAssignment getMarketChannelCombo(){
        
        return marketChannelAssignment;
                
    }

    public boolean isOrderAboveTotalTarget() {
        return selectedsolutionoffer.getTargetPrice()<actualPrice;
    }   

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    public boolean isOrderBelowTotalTarget() {
        return selectedsolutionoffer.getTargetPrice()>actualPrice;
    }

    public SolutionOffer getSelectedsolutionoffer() {
        return selectedsolutionoffer;
    }

    public void setSelectedsolutionoffer(SolutionOffer selectedsolutionoffer) {
        this.selectedsolutionoffer = selectedsolutionoffer;
    }

    public CustomerProfile getCustomerprofile() {
        return customerprofile;
    }

    public void setCustomerprofile(CustomerProfile customerprofile) {
        this.customerprofile = customerprofile;
    }

    public MarketChannelAssignment getMarketChannelAssignment() {
        return marketChannelAssignment;
    }

    public void setMarketChannelAssignment(MarketChannelAssignment marketChannelAssignment) {
        this.marketChannelAssignment = marketChannelAssignment;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  selectedsolutionoffer.toString();
    }
    
    
}

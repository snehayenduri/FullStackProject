/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    int id=0;
    ArrayList<Product> products;
    private int floorPrice =0 ;
    private int targetPrice=0;
    private int ceilingPrice=0;
    String ad;
    MarketChannelAssignment marketchannelcomb;
    ArrayList<SolutionOrder> solutionorders;
    
    public SolutionOffer(MarketChannelAssignment m){
        marketchannelcomb = m;
        products = new ArrayList();
        solutionorders = new ArrayList();
        id++;
        m.addSolutionOffer(this); 
       
    } 
    
    public void addProduct(Product p){
        products.add(p);
    }
    
    public int getRevenues(){
        int sum = 0;
        for(SolutionOrder so: solutionorders){
            sum = sum + so.getSolutionPrice();
            
        }
        return sum;
    }
    
    public void addSolutionOrder(SolutionOrder so){
        solutionorders.add(so);
    }
    // this will allow one to retrieve all offers meant for this market/channel combo
    public boolean isSolutionOfferMatchMarketChannel(MarketChannelAssignment mca){
        
        if (marketchannelcomb==mca) return true;
        else return false;
    }
    public String getAd(){
        return ad;
    }
    public void setAd(String a){ //this an amazing solution for people like
        ad = a;
    }
    public int getFloorPrice(){
        floorPrice=0;
        for(Product p: products){
            floorPrice+=p.getFloorPrice();
        }
        return floorPrice;
    }
    public int getTargetPrice(){
        targetPrice = 0;
        for(Product p: products){
            targetPrice+=p.getTargetPrice();
        }
        return targetPrice;
    }
    public int getCeilingPrice(){
        ceilingPrice = 0;
        for(Product p: products){
            ceilingPrice+=p.getCeilingPrice();
        }
        return ceilingPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<SolutionOrder> getSolutionorders() {
        return solutionorders;
    }

    public void setSolutionorders(ArrayList<SolutionOrder> solutionorders) {
        this.solutionorders = solutionorders;
    }

    @Override
    public String toString() {
        String product ="";
        for(Product p : products){
            product= product+p.toString()+", ";
        }
        return product;
    }
    
    
    
    
}

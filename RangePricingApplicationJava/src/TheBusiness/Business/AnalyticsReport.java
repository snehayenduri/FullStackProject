/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness.Business;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.SolutionOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import TheBusiness.Business.SolutionOrderComparator;

/**
 *
 * @author nitin
 */
public class AnalyticsReport {
    public static void negotiatedSolutions(Business business){
        // Assuming you have a method to get all solution orders
        ArrayList<SolutionOrder> allSolutionOrders = business.getMasterSolutionOrderList().getSolutionorderlist();
        
//        ArrayList<Market> allMarkets = business.getMarketCatalog().getMarkets();
        
//        HashMap<Market, Integer> marketRevenueMap = new HashMap<>();
        
//        for (SolutionOrder so : allSolutionOrders) {
//            MarketChannelAssignment mca = so.getMarketChannelCombo();
//            Market market = mca.getMarket();
//            
//            if (so.getSolutionPrice() > mca.getRevenues()) {
//                
//                int currentRevenue = marketRevenueMap.getOrDefault(market, 0);
//                marketRevenueMap.put(market, currentRevenue + so.getSolutionPrice());
//            }
//        }
//        List<Market> top3Markets = marketRevenueMap.entrySet()
//                .stream()
//                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
//                .limit(3)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//        
//        System.out.println("Top 3 Best Markets: ");
//        for(Market market: top3Markets){
//            System.out.println(market.getName());
//        }
        ArrayList<MarketChannelAssignment> marketChannels = business.getMarketChannelComboCatalog().getMcalist();
        HashMap<Market,List<SolutionOrder>> negotiatedSolutions = new HashMap<>();
        for(MarketChannelAssignment mca: marketChannels){
            Market market =  mca.getMarket();
            if(!negotiatedSolutions.containsKey(market)){
                negotiatedSolutions.put(market, new ArrayList<SolutionOrder>());
            }
            for(SolutionOrder so: mca.getSolutionorderlist()){
                negotiatedSolutions.get(market).add(so);
            }  
        }
        
        Set<Market> markets = negotiatedSolutions.keySet();
        for(Market market : markets){
            ArrayList<SolutionOrder> sol = (ArrayList<SolutionOrder>) negotiatedSolutions.get(market);
            Collections.sort(sol, new SolutionOrderComparator());
            Collections.reverse(sol);
            System.out.println("Market:"+market.getName());
            for(int i=0;i<Integer.min(sol.size(),3);i++){
            System.out.println((i+1)+" "+sol.get(i));
        }
        }
    }
    
    public static void bestCustomers(Business business){
        ArrayList<CustomerProfile> allCustomers = business.getCustomerDirectory().getCustomerlist();
        HashMap<CustomerProfile, Integer> customerRevenueMap = new HashMap<>();
        for (CustomerProfile cp : allCustomers) {
            int totalRevenue = cp.getTotalPricePerformance();
            int totalTarget = cp.getTotalTargetPrice();
            customerRevenueMap.put(cp, totalRevenue - totalTarget);
        }
        List<CustomerProfile> top3Customers = customerRevenueMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        
        System.out.println("Top 3 Best Customers: " + top3Customers);
        for(CustomerProfile sp: top3Customers){
            System.out.println(sp.getPerson().getPersonID());
        }
    }
    public static void bestSalesPeople(Business business){
                // Assuming you have a method to get all salespeople
        ArrayList<SalesPersonProfile> allSalesPeople = business.getSalesPersonDirectory().getSalesPersonList();

        // Create a map to store total revenue for each salesperson
        HashMap<SalesPersonProfile, Integer> salesPersonRevenueMap = new HashMap<>();

        // Iterate through salespeople and calculate revenue for each
        for (SalesPersonProfile sp : allSalesPeople) {
            int totalRevenue = sp.getTotalPricePerformance();
            int totalTarget = sp.getNumberOfOrdersAboveTotalTarget();

            // Check if revenue is above target
            if (totalRevenue > totalTarget) {
                salesPersonRevenueMap.put(sp, totalRevenue - totalTarget);
            }
        }

        // Get the top 3 salespeople with the highest revenue
        List<SalesPersonProfile> top3SalesPeople = salesPersonRevenueMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Print or use top3SalesPeople as needed
        System.out.println("Top 3 Best Sales People: ");
        for(SalesPersonProfile sp: top3SalesPeople){
            System.out.println(sp.getPerson().getPersonID());
        }
        
    }
    
    public static void totalMarginalRevenueByMarket(Business business){
        // Assuming you have a method to get all solution orders
        ArrayList<SolutionOrder> allSolutionOrders = business.getMasterSolutionOrderList().getSolutionorderlist();

        // Assuming you have a method to get all markets
        ArrayList<Market> allMarkets = business.getMarketCatalog().getMarkets();

        // Create a map to store marginal revenue for each market
        HashMap<Market, Integer> marketMarginalRevenueMap = new HashMap<>();

        // Iterate through solution orders and calculate marginal revenue for each market
        for (SolutionOrder so : allSolutionOrders) {
            MarketChannelAssignment mca = so.getMarketChannelCombo();
            Market market = mca.getMarket();
            
            // Calculate marginal revenue (actual minus target)
            int ap = so.getActualPrice();
            int tp =  so.getSelectedsolutionoffer().getTargetPrice();
//            System.out.println(ap+" - "+tp);
            int marginalRevenue = ap-tp;
            //System.out.println(marginalRevenue+" "+so.getActualPrice()+" "+so.getSelectedsolutionoffer().getTargetPrice());
            // Update marginal revenue for the market
            int currentMarginalRevenue = marketMarginalRevenueMap.getOrDefault(market, 0);
            marketMarginalRevenueMap.put(market, currentMarginalRevenue + marginalRevenue);
            
        }

        // Print or use marketMarginalRevenueMap as needed
        
        System.out.println("Marginal Revenue by Market: ");
        for(Map.Entry<Market, Integer> map: marketMarginalRevenueMap.entrySet()){
            System.out.println("Market: "+map.getKey().getName());
            System.out.println("Market Revenue: "+map.getValue()+"\n");
        }
    }
    public static void optimalPricing(Business business){
        ArrayList<SolutionOrder> allSolutionOrders = business.getMasterSolutionOrderList().getSolutionorderlist();
        for(SolutionOrder so: allSolutionOrders){
            if(so.getActualPrice()>=so.getSelectedsolutionoffer().getTargetPrice())
                System.out.println("The Solution ("+so+") has been priced optimally.");
            else{
                System.out.println("The Solution's ("+so+") price can be increased by "+(so.getSelectedsolutionoffer().getTargetPrice()-so.getActualPrice())+"-"+(so.getSelectedsolutionoffer().getCeilingPrice()-so.getActualPrice()));
            }
        }
    }
}

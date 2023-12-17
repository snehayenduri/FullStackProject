/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author snehayenduri
 */
public class DataStore {
    DataReader dataReader;
    public Business initializeBusiness(){
        Business business = new Business("Xerox");
        getSupplierData(business.getSupplierDirectory());
        getPersonDirectory(business.getPersonDirectory(), business.getSalesPersonDirectory(), business.getCustomerDirectory(), business.getMarketingPersonDirectory(), business.getUserAccountDirectory());
        getProductDirectory(business.getSupplierDirectory());
        getOrders(business.getMasterOrderList(), business.getSalesPersonDirectory(), business.getCustomerDirectory(), business.getSupplierDirectory());
        getMarkets(business.getMarketCatalog());
        getChannels(business.getChannelCatalog());
        getMarketChannelComboSolutions(business.getMarketCatalog(), business.getChannelCatalog(), business.getMarketChannelComboCatalog(), business.getSolutionOfferCatalog(), business.getMasterSolutionOrderList(), business.getSupplierDirectory(), business.getCustomerDirectory(), business.getSalesPersonDirectory());
    
        return business;
    }
    public void getSupplierData(SupplierDirectory supplierDirectory){
        try {
            dataReader = new DataReader("./Supplier.csv");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(dataReader!=null){
            String[] s = null;
            do{
                try {
                    s = dataReader.getNextRow(" ");
                } catch (IOException ex) {
                    Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(s!=null)
                supplierDirectory.newSupplier(s[0]);
            }while(s!= null);
        }
        
        //System.out.println("TheBusiness.DataStore.getSupplierData()"+supplierDirectory.getSuplierList().size());
    }
    
    public void getPersonDirectory(PersonDirectory personDirectory,  SalesPersonDirectory salespersondirectory, CustomerDirectory customerdirectory, MarketingPersonDirectory marketingPersonDirectory, UserAccountDirectory userAccountDirectory){
        try {
            dataReader = new DataReader("./Person.csv");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(dataReader!=null){
            String[] s = null;
            do{
                try {
                    s = dataReader.getNextRow(",");
                } catch (IOException ex) {
                    Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
                }
                Person p=null;
                if(s!=null){
                    p=personDirectory.newPerson(s[0]);
                    switch (s[1]) {
                        case "sales":
                            SalesPersonProfile salespersonprofile= salespersondirectory.newSalesPersonProfile(p);
                            userAccountDirectory.newUserAccount(salespersonprofile, "Sales", "XXXX"); 
                            break;
                        case "customer":
                            customerdirectory.newCustomerProfile(p);
                            break;
                        case "marketing":
                            MarketingPersonProfile marketingPersonProfile = marketingPersonDirectory.newMarketingPersonProfile(p);
                            userAccountDirectory.newUserAccount(marketingPersonProfile, "Marketing", "XXXX");
                            break;
                        default:
                            break;
                    }
                }
            }while(s!= null);
        }
        
       // System.out.println("TheBusiness.DataStore.getPersonData()"+personDirectory.getPersonlist().size());
    }
    
     public void getProductDirectory(SupplierDirectory supplierDirectory){
        try {
            dataReader = new DataReader("./Product.csv");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(dataReader!=null){
            String[] s = null;
            do{
                try {
                    s = dataReader.getNextRow(",");
                } catch (IOException ex) {
                    Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(s!=null){
                    String name = s[0];
//                    System.out.println(name);
                    int fp = Integer.parseInt(s[1]);
                    int cp = Integer.parseInt(s[2]);
                    int tp = Integer.parseInt(s[3]);
                    String supplier = s[4];
                    supplierDirectory.findSupplier(supplier).getProductCatalog().newProduct(name, fp, cp, tp);
                }
            }while(s!= null);
        }
        //System.out.println("TheBusiness.DataStore.getProductDirectory()-done");
     }
     
     public void getOrders(MasterOrderList masterOrderList, SalesPersonDirectory salespersondirectory, CustomerDirectory customerdirectory, SupplierDirectory supplierDirectory){
        Order order1 = masterOrderList.newOrder(customerdirectory.findCustomer("JP Morgan"), salespersondirectory.findSalesPerson("Xerox sales"));
        Supplier supplier1 = supplierDirectory.findSupplier("Lenovo");
        Product products1p1 = supplier1.getProductCatalog().findProduct("Scanner 3  1");
        Product products1p2 = supplier1.getProductCatalog().findProduct("Scanner 4");
        Product products1p3 = supplier1.getProductCatalog().findProduct("Printer 2");
        Product products1p4 = supplier1.getProductCatalog().findProduct("Photocopier 2");
        Product products1p5 = supplier1.getProductCatalog().findProduct("Scanner  5");
        Product products1p6 = supplier1.getProductCatalog().findProduct("Scanner 6");
        Product products1p7 = supplier1.getProductCatalog().findProduct("Printer 3");
        Product products1p8 = supplier1.getProductCatalog().findProduct("Photocopier 3");
//         System.out.println("TheBusiness.DataStore.getOrders()"+products1p4);
        OrderItem oi1 = order1.newOrderItem(products1p1, 18000, 1);
        OrderItem oi2 = order1.newOrderItem(products1p2, 19500, 4);
        OrderItem oi3 = order1.newOrderItem(products1p3, 36500, 10);
        OrderItem oi4 = order1.newOrderItem(products1p4, 50000, 1);
        OrderItem oi5 = order1.newOrderItem(products1p5, 25000, 3);
        OrderItem oi6 = order1.newOrderItem(products1p6, 105000, 2);
        OrderItem oi7 = order1.newOrderItem(products1p7, 36500, 3);
        OrderItem oi8 = order1.newOrderItem(products1p8, 50000, 2);
        
        Order order2 = masterOrderList.newOrder(customerdirectory.findCustomer("JP Morgan"), salespersondirectory.findSalesPerson("Xerox sales"));
        OrderItem oi112 = order2.newOrderItem(products1p1, 17000, 1);
        OrderItem oi12 = order2.newOrderItem(products1p2, 9500, 4);
        OrderItem oi13 = order2.newOrderItem(products1p3, 29500, 10);
        OrderItem oi14 = order2.newOrderItem(products1p4, 30000, 1);
        OrderItem oi15 = order2.newOrderItem(products1p5, 2000, 3);
        OrderItem oi16 = order2.newOrderItem(products1p6, 95000, 2);
        OrderItem oi17 = order2.newOrderItem(products1p7, 26500, 3);
        OrderItem oi18 = order2.newOrderItem(products1p8, 40000, 2);
        
        
        Order order13 = masterOrderList.newOrder(customerdirectory.findCustomer("JP Morgan"), salespersondirectory.findSalesPerson("Xerox sales"));
        oi112 = order13.newOrderItem(products1p1, 19000, 1);
        oi12 = order13.newOrderItem(products1p2, 10500, 4);
        oi13 = order13.newOrderItem(products1p3, 20500, 10);
        oi14 = order13.newOrderItem(products1p4, 40000, 1);
        oi15 = order13.newOrderItem(products1p5, 4000, 3);
        oi16 = order13.newOrderItem(products1p6, 105000, 2);
        oi17 = order13.newOrderItem(products1p7, 36500, 3);
        oi18 = order13.newOrderItem(products1p8, 550000, 1);
     }
     
     public void getMarkets(MarketCatalog marketCatalog){
         try {
            dataReader = new DataReader("./Market.csv");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(dataReader!=null){
            String[] s = null;
            do{
                try {
                    s = dataReader.getNextRow(" ");
                } catch (IOException ex) {
                    Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(s!=null){
                    String name = s[0];
                    marketCatalog.newMarket(name);
                 }
            }while(s!= null);
        }
         //System.out.println("TheBusiness.DataStore.getMarkets()"+marketCatalog.getMarkets().size());
     }
        
    public void getChannels(ChannelCatalog channelCatalog){
         try {
            dataReader = new DataReader("./Channel.csv");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(dataReader!=null){
            String[] s = null;
            do{
                try {
                    s = dataReader.getNextRow(" ");
                } catch (IOException ex) {
                    Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(s!=null){
                    String name = s[0];
                    channelCatalog.newChannel(name);
                 }
            }while(s!= null);
        }
         //System.out.println("TheBusiness.DataStore.getChannels()"+channelCatalog.getChannelList().size());
     }
    
     public void getMarketChannelComboSolutions(MarketCatalog marketCatalog, ChannelCatalog channelCatalog, MarketChannelComboCatalog marketChannelComboCatalog, SolutionOfferCatalog solutionoffercatalog, MasterSolutionOrderList msol, SupplierDirectory sd, CustomerDirectory custDirectory, SalesPersonDirectory salesPersons){
         Market market1 = marketCatalog.findMarket("Children");
         Market market2 = marketCatalog.findMarket("Teenagers");
         Market market3 = marketCatalog.findMarket("CollegeGrads");
         Market market4 = marketCatalog.findMarket("WorkingAdults");
         Market market5 = marketCatalog.findMarket("SeniorCitizens");
         
         Channel channel1 = channelCatalog.findChannel("tv");
         Channel channel2 =  channelCatalog.findChannel("web");
//         
//         System.out.println(channel1+" - "+channel2);
//         
         market1.addValidChannel(channel1);
         market1.addValidChannel(channel2);

         market2.addValidChannel(channel1);
         market2.addValidChannel(channel2);

         market3.addValidChannel(channel1);
         market3.addValidChannel(channel2);

         market4.addValidChannel(channel1);
         market4.addValidChannel(channel2);

         market5.addValidChannel(channel1);
         market5.addValidChannel(channel2);
         
         MarketChannelAssignment tvchannelteenmarket = marketChannelComboCatalog.newMarketChannelCombo(market2, channel1);
         MarketChannelAssignment webchannelteenmarket = marketChannelComboCatalog.newMarketChannelCombo(market2, channel2);
         MarketChannelAssignment tvchannelChildren = marketChannelComboCatalog.newMarketChannelCombo(market1, channel1);
         MarketChannelAssignment webchannelChildren = marketChannelComboCatalog.newMarketChannelCombo(market1, channel2);
         MarketChannelAssignment tvchannelCollegeGrads = marketChannelComboCatalog.newMarketChannelCombo(market3, channel1);
         MarketChannelAssignment webchannelCollegeGrads = marketChannelComboCatalog.newMarketChannelCombo(market3, channel2);
         MarketChannelAssignment tvchannelWorkingAdults = marketChannelComboCatalog.newMarketChannelCombo(market4, channel1);
         MarketChannelAssignment webchannelWorkingAdults = marketChannelComboCatalog.newMarketChannelCombo(market4, channel2);
         MarketChannelAssignment tvchannelSeniorCitizens = marketChannelComboCatalog.newMarketChannelCombo(market5, channel1);
         MarketChannelAssignment webchannelSeniorCitizens = marketChannelComboCatalog.newMarketChannelCombo(market5, channel2);
        
         
         Supplier supplier2 = sd.findSupplier("Epson");
         Supplier supplier1 = sd.findSupplier("Lenovo");
         
         //50000
         Product products1p1 = supplier1.getProductCatalog().findProduct("Photocopier 2");
         //36500
         Product products1p2 = supplier1.getProductCatalog().findProduct("Printer 3");
         //10000
         Product products1p3 = supplier1.getProductCatalog().findProduct("Scanner 3  1");
         //36500
         Product products1p4 = supplier1.getProductCatalog().findProduct("Printer 2");
         
         //18500
         Product products2p1 = supplier2.getProductCatalog().findProduct("Scanner 13  1");
         //125000
         Product products2p2 = supplier2.getProductCatalog().findProduct("Scanner 14");
         //365102
         Product products2p3 = supplier2.getProductCatalog().findProduct("Low toner Scanner  102");
         //780000
         Product products2p4 = supplier2.getProductCatalog().findProduct("Color Photocopier 500");
         
//         System.out.println("products1p1"+products1p1);
//         System.out.println("products1p2"+products1p2);
//         System.out.println("products1p3"+products1p3);
//         System.out.println("products1p4"+products1p4);
//         System.out.println("products2p1"+products2p1);
//         System.out.println("products2p2"+products2p2);
//         System.out.println("products2p3"+products2p3);
//         System.out.println("products2p4"+products2p4);
         
         //28500
         SolutionOffer solutiontvteen = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
         solutiontvteen.addProduct(products1p3);
         solutiontvteen.addProduct(products2p1);
         
         //853000
         SolutionOffer solutionwebteen = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
         solutionwebteen.addProduct(products1p2);
         solutionwebteen.addProduct(products2p4);
         solutionwebteen.addProduct(products1p4);
         
         //415102
         SolutionOffer solutionwebChild = solutionoffercatalog.newSolutionOffer(webchannelChildren);
         solutionwebChild.addProduct(products1p1);
         solutionwebChild.addProduct(products2p3);
         
         //816500
         SolutionOffer solutiontvChild = solutionoffercatalog.newSolutionOffer(tvchannelChildren);
         solutiontvChild.addProduct(products1p4);
         solutiontvChild.addProduct(products2p4);
         
         //68500
         SolutionOffer solutiontvGrad = solutionoffercatalog.newSolutionOffer(tvchannelCollegeGrads);
         solutiontvGrad.addProduct(products1p1);
         solutiontvGrad.addProduct(products2p1);
         
         //175000
         SolutionOffer solutionwebGrad = solutionoffercatalog.newSolutionOffer(webchannelCollegeGrads);
         solutionwebGrad.addProduct(products1p1);
         solutionwebGrad.addProduct(products2p2);
         
         //55000
         SolutionOffer solutionwebAdults = solutionoffercatalog.newSolutionOffer(webchannelWorkingAdults);
         solutionwebAdults.addProduct(products1p4);
         solutionwebAdults.addProduct(products2p1);
         
         //161500
         SolutionOffer solutiontvAdults = solutionoffercatalog.newSolutionOffer(tvchannelWorkingAdults);
         solutiontvAdults.addProduct(products1p2);
         solutiontvAdults.addProduct(products2p2);
         
         //375102
         SolutionOffer solutionwebSnrs = solutionoffercatalog.newSolutionOffer(webchannelSeniorCitizens);
         solutionwebSnrs.addProduct(products1p3);
         solutionwebSnrs.addProduct(products2p3);
         
         //433602
         SolutionOffer solutiontvSnrs = solutionoffercatalog.newSolutionOffer(tvchannelSeniorCitizens);
         solutiontvSnrs.addProduct(products1p1);
         solutiontvSnrs.addProduct(products2p1);
         solutiontvSnrs.addProduct(products2p3);
         
         
         //microsoft - 1500-500+6987=7987
         //Dell - 47000+487 = 47,487
         //Google - 590+24898=25,488
         //Jp Morgan - 25000-5000=20,000
         //state street - 36,398
         
         //Xerox sales - 48500
         //Printer sales - 500
         //PhotoCopier sales -590+25000 = 25590
         //
         
         //28500
         SolutionOrder so1 = msol.newSolutionOrder(solutiontvteen, 30000, tvchannelteenmarket, salesPersons.findSalesPerson("Xerox sales"),custDirectory.findCustomer("Microsoft"));
        
         //853000 
         SolutionOrder so2 = msol.newSolutionOrder(solutionwebteen, 900000,webchannelteenmarket, salesPersons.findSalesPerson("Xerox sales"), custDirectory.findCustomer("Dell"));
         
         //816500
         SolutionOrder so3 = msol.newSolutionOrder(solutiontvChild, 816000, tvchannelChildren, salesPersons.findSalesPerson("Printer sales"),custDirectory.findCustomer("Microsoft"));
        
         //68500
         SolutionOrder so4 = msol.newSolutionOrder(solutiontvGrad, 69090,tvchannelCollegeGrads, salesPersons.findSalesPerson("PhotoCopier sales"), custDirectory.findCustomer("Google"));
        
         //175000
         SolutionOrder so5 = msol.newSolutionOrder(solutionwebGrad, 200000, webchannelCollegeGrads, salesPersons.findSalesPerson("PhotoCopier sales"),custDirectory.findCustomer("JP Morgan"));
        
         //175000
         SolutionOrder so6 = msol.newSolutionOrder(solutionwebGrad, 170000,webchannelCollegeGrads, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("JP Morgan"));
        
         //55000
         SolutionOrder so7 = msol.newSolutionOrder(solutionwebAdults, 61987, webchannelWorkingAdults, salesPersons.findSalesPerson("All sales"),custDirectory.findCustomer("Microsoft"));
        
         //161500
         SolutionOrder so8 = msol.newSolutionOrder(solutiontvAdults, 161987,tvchannelWorkingAdults, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("Dell"));
        
         //433602
         SolutionOrder so9 = msol.newSolutionOrder(solutiontvSnrs, 470000,tvchannelSeniorCitizens, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("State street"));
        
         //375102
         SolutionOrder so10 = msol.newSolutionOrder(solutionwebSnrs, 400000,webchannelSeniorCitizens, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("Google"));
        
         
         msol.getRevenueByMarketChannelCombo(tvchannelteenmarket);
         msol.getRevenueByChannel(channel1);
         
        // System.out.println("TheBusiness.DataStore.getMarketChannelCombo()"+marketChannelComboCatalog.getMcalist().size()+"-"+msol.getSolutionorderlist().size());
     }
       
}

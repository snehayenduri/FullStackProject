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
            dataReader = new DataReader("./CSupplier.csv");
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
        
        System.out.println("TheBusiness.DataStore.getSupplierData()"+supplierDirectory.getSuplierList().size());
    }
    
    public void getPersonDirectory(PersonDirectory personDirectory,  SalesPersonDirectory salespersondirectory, CustomerDirectory customerdirectory, MarketingPersonDirectory marketingPersonDirectory, UserAccountDirectory userAccountDirectory){
        try {
            dataReader = new DataReader("./CPerson.csv");
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
        
        System.out.println("TheBusiness.DataStore.getPersonData()"+personDirectory.getPersonlist().size());
    }
    
     public void getProductDirectory(SupplierDirectory supplierDirectory){
        try {
            dataReader = new DataReader("./CProduct.csv");
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
        System.out.println("TheBusiness.DataStore.getProductDirectory()-done");
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
            dataReader = new DataReader("./CMarket.csv");
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
         System.out.println("TheBusiness.DataStore.getMarkets()"+marketCatalog.getMarkets().size());
     }
        
    public void getChannels(ChannelCatalog channelCatalog){
         try {
            dataReader = new DataReader("./CChannel.csv");
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
         System.out.println("TheBusiness.DataStore.getChannels()"+channelCatalog.getChannelList().size());
     }
    
     public void getMarketChannelComboSolutions(MarketCatalog marketCatalog, ChannelCatalog channelCatalog, MarketChannelComboCatalog marketChannelComboCatalog, SolutionOfferCatalog solutionoffercatalog, MasterSolutionOrderList msol, SupplierDirectory sd, CustomerDirectory custDirectory, SalesPersonDirectory salesPersons){
         Market market1 = marketCatalog.findMarket("Children");
         Market market2 = marketCatalog.findMarket("Teenagers");
         Market market3 = marketCatalog.findMarket("CollegeGrads");
         Market market4 = marketCatalog.findMarket("WorkingAdults");
         Market market5 = marketCatalog.findMarket("SeniorCitizens");
         
         Channel channel1 = channelCatalog.findChannel("tv");
         Channel channel2 =  channelCatalog.findChannel("web");
         
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
         
         
         Product products1p1 = supplier1.getProductCatalog().findProduct("Photocopier 2");
         Product products1p2 = supplier1.getProductCatalog().findProduct("Printer 3");
         Product products1p3 = supplier1.getProductCatalog().findProduct("Scanner 3  1");
         Product products1p4 = supplier1.getProductCatalog().findProduct("Printer 2");
         
         Product products2p1 = supplier2.getProductCatalog().findProduct("Scanner 13  1");
         Product products2p2 = supplier2.getProductCatalog().findProduct("Scanner 14");
         Product products2p3 = supplier2.getProductCatalog().findProduct("Low toner Scanner  102");
         Product products2p4 = supplier2.getProductCatalog().findProduct("Color Photocopier 500");
         
//         System.out.println("products1p1"+products1p1);
//         System.out.println("products1p2"+products1p2);
//         System.out.println("products1p3"+products1p3);
//         System.out.println("products1p4"+products1p4);
//         System.out.println("products2p1"+products2p1);
//         System.out.println("products2p2"+products2p2);
//         System.out.println("products2p3"+products2p3);
//         System.out.println("products2p4"+products2p4);
         
          
         SolutionOffer solutiontvteen = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
         solutiontvteen.addProduct(products1p3);
         solutiontvteen.addProduct(products2p1);
         
         
         SolutionOffer solutionwebteen = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
         solutionwebteen.addProduct(products1p2);
         solutionwebteen.addProduct(products2p4);
         solutionwebteen.addProduct(products1p4);
         
         SolutionOffer solutionwebChild = solutionoffercatalog.newSolutionOffer(webchannelChildren);
         solutionwebteen.addProduct(products1p1);
         solutionwebteen.addProduct(products2p3);
         
         SolutionOffer solutiontvChild = solutionoffercatalog.newSolutionOffer(tvchannelChildren);
         solutionwebteen.addProduct(products1p4);
         solutionwebteen.addProduct(products2p4);
         
         SolutionOffer solutiontvGrad = solutionoffercatalog.newSolutionOffer(tvchannelCollegeGrads);
         solutionwebteen.addProduct(products1p1);
         solutionwebteen.addProduct(products2p1);
         
         SolutionOffer solutionwebGrad = solutionoffercatalog.newSolutionOffer(webchannelCollegeGrads);
         solutionwebteen.addProduct(products1p1);
         solutionwebteen.addProduct(products2p2);
         
         SolutionOffer solutionwebAdults = solutionoffercatalog.newSolutionOffer(webchannelWorkingAdults);
         solutionwebteen.addProduct(products1p4);
         solutionwebteen.addProduct(products2p1);
         
         SolutionOffer solutiontvAdults = solutionoffercatalog.newSolutionOffer(tvchannelWorkingAdults);
         solutionwebteen.addProduct(products1p2);
         solutionwebteen.addProduct(products2p2);
         
         SolutionOffer solutionwebSnrs = solutionoffercatalog.newSolutionOffer(webchannelSeniorCitizens);
         solutionwebteen.addProduct(products1p3);
         solutionwebteen.addProduct(products2p3);
         
         SolutionOffer solutiontvSnrs = solutionoffercatalog.newSolutionOffer(tvchannelSeniorCitizens);
         solutionwebteen.addProduct(products1p1);
         solutionwebteen.addProduct(products2p1);
         solutionwebteen.addProduct(products2p3);
         
         
         
         
         SolutionOrder so1 = msol.newSolutionOrder(solutiontvteen, 150000, tvchannelteenmarket, salesPersons.findSalesPerson("Xerox sales"),custDirectory.findCustomer("Microsoft"));
        
         SolutionOrder so2 = msol.newSolutionOrder(solutionwebteen, 170000,webchannelteenmarket, salesPersons.findSalesPerson("Xerox sales"), custDirectory.findCustomer("Dell"));
         
         SolutionOrder so3 = msol.newSolutionOrder(solutiontvChild, 816000, tvchannelChildren, salesPersons.findSalesPerson("Printer sales"),custDirectory.findCustomer("Microsoft"));
        
         SolutionOrder so4 = msol.newSolutionOrder(solutiontvGrad, 69090,tvchannelCollegeGrads, salesPersons.findSalesPerson("PhotoCopier sales"), custDirectory.findCustomer("Google"));
        
         SolutionOrder so5 = msol.newSolutionOrder(solutionwebGrad, 200000, webchannelCollegeGrads, salesPersons.findSalesPerson("PhotoCopier sales"),custDirectory.findCustomer("JP Morgan"));
        
         SolutionOrder so6 = msol.newSolutionOrder(solutionwebGrad, 170000,webchannelCollegeGrads, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("JP Morgan"));
        
         SolutionOrder so7 = msol.newSolutionOrder(solutionwebAdults, 61987, webchannelWorkingAdults, salesPersons.findSalesPerson("All sales"),custDirectory.findCustomer("Microsoft"));
        
         SolutionOrder so8 = msol.newSolutionOrder(solutiontvAdults, 161987,tvchannelWorkingAdults, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("Dell"));
        
         SolutionOrder so9 = msol.newSolutionOrder(solutiontvSnrs, 170000,tvchannelSeniorCitizens, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("State street"));
        
         SolutionOrder so10 = msol.newSolutionOrder(solutionwebSnrs, 400000,webchannelSeniorCitizens, salesPersons.findSalesPerson("All sales"), custDirectory.findCustomer("Google"));
        
         
         msol.getRevenueByMarketChannelCombo(tvchannelteenmarket);
         msol.getRevenueByChannel(channel1);
         
         System.out.println("TheBusiness.DataStore.getMarketChannelCombo()"+marketChannelComboCatalog.getMcalist().size()+"-"+msol.getSolutionorderlist().size());
     }
       
}

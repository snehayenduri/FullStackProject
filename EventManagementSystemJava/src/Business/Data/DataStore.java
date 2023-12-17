/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Data;

import Business.Business;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.Event;
import Business.Enterprise.EventDirectory;
import Business.Enterprise.EventStatusEnum;
import Business.Enterprise.VendorEventRequest;
import Business.Guest.GuestDirectory;
import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.HostOrganization.HostOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.ServiceOrganization.OrderManagement.MasterOrderList;
import Business.Organization.ServiceOrganization.OrderManagement.Order;
import Business.Organization.ServiceOrganization.OrderManagement.OrderItem;
import Business.Organization.ServiceOrganization.ProductManagement.Product;
import Business.Organization.ServiceOrganization.ServiceOrganization;
import Business.Organization.VendorOrganization.VendorOrganization;
import Business.Organization.VenueOrganization.VenueOrganization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Roles.Role;
import Business.Roles.UserAccount;
import Business.Roles.UserAccountDirectory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author snehayenduri
 */
public class DataStore {
    DataReader dataReader;
    Business business;
    
    public Business initializeBusiness(){
      business = Business.getInstance();
      getEnterprises(business.getEnterpriseDirectory());
      getOrganizations(business.getOrganizationDirectory());
      getPersons(business.getPersonDirectory(), business.getUserAccountDirectory(),business.getOrganizationDirectory()); 
//      getEmployees(business.getPersonDirectory(), business.getOrganizationDirectory());
      getEvents(business.getEventDirectory(),business.getOrganizationDirectory());
      getGuests(business.getGuestDirectory(), business.getEventDirectory(), business.getPersonDirectory());
      getProducts(business.getOrganizationDirectory());
      getOrders(business.getMasterOrderList(),business.getOrganizationDirectory());
      getOrderItems(business.getMasterOrderList());
      getVendorProduct(business.getEventDirectory(), business.getOrganizationDirectory());
      return business;
    }

    private void getPersons(PersonDirectory personDirectory, UserAccountDirectory ud, OrganizationDirectory od) {
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
                if(s!=null){
                    String name = s[0];
                    Person p =personDirectory.createPerson(name);
                    Role role = new Role() {
                        @Override
                        public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
                            return null;
                        }
                    };
                    role.setType(Role.RoleType.valueOf(s[3]));
                    //System.out.println("Business.Data.DataStore.getPersons()-Sneha-"+role.getType().getValue());
                    UserAccount userAccount = ud.createUserAccount(s[1], s[2], p, role);
                    userAccount.setRole(role);
                    int orgId = Integer.parseInt(s[4]);
                    if(orgId != 0){
                        userAccount.setOrganization(od.getOrganizationById(orgId));
                    }
                }
                
            }while(s!= null);
        }
        
     // System.out.println("TheBusiness.DataStore.getPersons()-"+personDirectory.getPersonList().size());

    }

//    private void getEmployees(PersonDirectory pd, OrganizationDirectory od) {
//       try {
//            dataReader = new DataReader("./Employee.csv");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      
//        if(dataReader!=null){
//            String[] s = null;
//            do{
//                try {
//                    s = dataReader.getNextRow(",");
//                } catch (IOException ex) {
//                    Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if(s!=null){
//                    int personId = Integer.parseInt(s[0]);
//                    int organizationId = Integer.parseInt(s[1]);
//                    Organization org = od.getOrganizationById(organizationId);
//                    EmployeeDirectory ed = org.getEmployeeDirectory();
//                    ed.createEmployee(pd.getPersonById(personId), org);
//                    System.out.println("TheBusiness.DataStore.getEmployees()-"+org.getOrganizationName()+" - "+ed.getEmployeeList().size());
//                }
//                
//            }while(s!= null);
//        }
//    }

    private void getEnterprises(EnterpriseDirectory enterpriseDirectory) {
        try {
            dataReader = new DataReader("./Enterprise.csv");
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
                    int enterpriseId = Integer.parseInt(s[0]);
                    String enterpriseName = s[1];
                    enterpriseDirectory.addEnterprise(enterpriseId, enterpriseName);
                }
                
            }while(s!= null);
        }
        // System.out.println("TheBusiness.DataStore.getEnterprises()-"+enterpriseDirectory.getEnterpriseDirectory().size());
    }

    private void getOrganizations(OrganizationDirectory od) {
        try {
            dataReader = new DataReader("./Organization.csv");
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
                    String orgType = s[0];
                    //System.out.println("Business.Data.DataStore.getOrganizations()- nitin"+orgType);
                    String orgName = s[1];
                    String orgAddress = s[2];
                    od.addOrganization(Organization.OrganizationType.valueOf(orgType), orgName, orgAddress);
                   // System.out.println("Business.Data.DataStore.getOrganizations()- nitin2"+Organization.OrganizationType.valueOf(orgType));
                }
                
            }while(s!= null);
        }
       // System.out.println("TheBusiness.DataStore.getOrganizations()-"+od.getOrganizationList().size());

    }

    private void getEvents(EventDirectory eventDirectory, OrganizationDirectory od) {
        try {
            dataReader = new DataReader("./Event.csv");
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
                    String type = s[1];
                    int hostId = Integer.parseInt(s[2]);
                    int eventManagementId = Integer.parseInt(s[3]);
                    String date = s[4];
                    String time = s[5];
                    int venueId = Integer.parseInt(s[6]);
                    int eventCapacity = Integer.parseInt(s[7]);
                    String status = s[8];
                    //System.out.println("hostID - "+hostId);
                    Organization org = od.getOrganizationById(hostId);
                    HostOrganization hostOrg = (HostOrganization)org;
                   // System.out.println("eventManagementId - "+eventManagementId);
                    org = od.getOrganizationById(eventManagementId);
                    EventManagementOrganization eventOrg = (EventManagementOrganization) org;
                    org = od.getOrganizationById(venueId);
                    VenueOrganization venueOrg = (VenueOrganization) org;
                    
                    Event evt = eventDirectory.addEvent(name, type, hostOrg, date, time, eventCapacity);
                    evt.setStatus(EventStatusEnum.valueOf(status));
                    evt.setEventManagement(eventOrg);
                    evt.setVenue(venueOrg);
                    
                    hostOrg.getHostedEvents().add(evt);
                    eventOrg.getManagedEvents().add(evt);
                    venueOrg.getHostedEvents().add(evt);
                    
                }
                
            }while(s!= null);
        }
        
        //System.out.println("TheBusiness.DataStore.getEvents()-"+eventDirectory.getEvents().size());

    }

    private void getGuests(GuestDirectory guestDirectory, EventDirectory eventDirectory, PersonDirectory pd) {
        try {
            dataReader = new DataReader("./Guest.csv");
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
                    String guestEmail = s[0];
                    int eventId = Integer.parseInt(s[1]);
                    int personId = Integer.parseInt(s[2]);
                    Event event = eventDirectory.getEventById(eventId);
                    UserAccount userAccount = business.getUserAccountDirectory().getUserByID(personId);
                    userAccount.getPerson().setEmail(guestEmail);
                    guestDirectory.addGuest(guestEmail, event, userAccount);
                    event.getInvitedGuestList().add(userAccount);
                }
                
            }while(s!= null);
        }
        
        //System.out.println("TheBusiness.DataStore.getGuests()-"+guestDirectory.getGuests().size());
    }
    
    private void getProducts(OrganizationDirectory od){
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
                    float price = Float.parseFloat(s[1]);
                    int orgId = Integer.parseInt(s[2]);
                    ServiceOrganization org = (ServiceOrganization)od.getOrganizationById(orgId);
                    org.getProductCatalog().addNewProduct(name, price);
                   // System.out.println("TheBusiness.DataStore.getProducts()-"+orgId+"-"+org.getProductCatalog().getProductList().size());
                }
                
            }while(s!= null);
        }
        
    }
        
    private void getOrderItems(MasterOrderList masterOrderList){
        try {
            dataReader = new DataReader("./OrderItem.csv");
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
                    String pName = s[1];
                    int orderId = Integer.parseInt(s[0]);
//                    int quantity = Integer.parseInt(s[2]);
                    Order o = masterOrderList.getOrderById(orderId);
                    Product p = o.getServiceOrganization().getProductCatalog().searchProduct(pName);
                    OrderItem oi = new OrderItem(orderId, p, 1);
                    ArrayList<OrderItem> orderItems = masterOrderList.getOrderById(orderId).getOrderItems();
                    orderItems.add(oi);
                  //  System.out.println("TheBusiness.DataStore.getOrderItems()-"+orderId+" - "+orderItems.size());
                }
                
            }while(s!= null);
        }
         
    }

    private void getOrders(MasterOrderList masterOrderList, OrganizationDirectory organizationDirectory) {
        try {
            dataReader = new DataReader("./Order.csv");
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
                    int eventOrgId = Integer.parseInt(s[0]);
                    int serviceOrgId = Integer.parseInt(s[1]);
                    
                    ServiceOrganization sorg = (ServiceOrganization)organizationDirectory.getOrganizationById(serviceOrgId);
                    EventManagementOrganization eorg = (EventManagementOrganization)organizationDirectory.getOrganizationById(eventOrgId);
                    masterOrderList.addOrder(eorg, sorg);
                    
                }
                
            }while(s!= null);
        }
      //  System.out.println("TheBusiness.DataStore.getOrders()-"+masterOrderList.getMasterOrderList().size());
    }
    
    private void getVendorProduct(EventDirectory ed, OrganizationDirectory od){
        try {
            dataReader = new DataReader("./VendorProduct.csv");
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
                    int eventId = Integer.parseInt(s[0]);
                    int serviceOrgId = Integer.parseInt(s[1]);
                    String productName = s[2];
                    int vendorId = Integer.parseInt(s[3]);
                    ServiceOrganization sorg = (ServiceOrganization)od.getOrganizationById(serviceOrgId);
                    EventManagementOrganization eorg = (EventManagementOrganization)od.getOrganizationById(eventId);
                    VendorOrganization vorg = (VendorOrganization)od.getOrganizationById(vendorId);
                    
                    Event event = ed.getEventById(eventId);
                    event.getProductList().add(sorg.getProductCatalog().searchProduct(productName));
                    event.getInvitedVendorList().add(vorg);
                    
                    sorg.getServicedEvents().add(event);
                    
                    VendorEventRequest vendorRequest = new VendorEventRequest(event, event.getHost(), vorg);
                    vendorRequest.setStatus(VendorEventRequest.VendorEventRequestStatus.Recieved);
                    vorg.getVendorEventRequestList().add(vendorRequest);
         
                }
                
            }while(s!= null);
        }
    }


}

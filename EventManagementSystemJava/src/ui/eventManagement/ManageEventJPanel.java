/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.eventManagement;

import Business.Business;
import Business.Enterprise.Event;
import Business.Enterprise.GuestEventRequest;
import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.OrganizationType.ServiceOrganization;
import Business.Organization.ServiceOrganization.ProductManagement.Product;
import Business.Organization.ServiceOrganization.ServiceOrganization;
import Business.Organization.VendorOrganization.VendorOrganization;
import Business.Roles.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nitin
 */
public class ManageEventJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEventJPanel
     */
    JPanel workArea;
    EventManagementOrganization organization;
    Business business;
    Event selectedEvent;
    
    public ManageEventJPanel(JPanel workArea, EventManagementOrganization organization,  Business business, Event selectedEvent) {
        initComponents();
        this.business = business;
        this.workArea = workArea;
        this.organization = organization;
        this.selectedEvent = selectedEvent;
        populateTableWithServices();
        if(selectedEvent.getVenue()!=null){
            txtVenue.setText((selectedEvent.getVenue().getOrganizationName()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        cmbEnterprise = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtVenue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnInviteGuests = new javax.swing.JButton();
        txtInvitation = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, 141));

        cmbEnterprise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Services", "Vendors" }));
        cmbEnterprise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbEnterpriseMouseClicked(evt);
            }
        });
        cmbEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEnterpriseActionPerformed(evt);
            }
        });
        add(cmbEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 102, -1));

        jButton1.setText("Add Services");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        jButton2.setText("Add Vendors");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 108, -1));

        jButton3.setText("Add Venue");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 123, -1));
        add(txtVenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 154, -1));

        jLabel1.setText("Venue:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        btnInviteGuests.setText("Invite Guests");
        btnInviteGuests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInviteGuestsActionPerformed(evt);
            }
        });
        add(btnInviteGuests, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 117, -1));
        add(txtInvitation, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 173, -1));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        AddServicesJPanel addServicePanel = new AddServicesJPanel(workArea, business, selectedEvent);
        AddServicesJPanel2 addServicePanel2 = new AddServicesJPanel2(workArea, business, selectedEvent);
        workArea.add("AddServicesJPanel", addServicePanel2);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddVendorJPanel addVendorPanel = new AddVendorJPanel(workArea, business, selectedEvent);
        workArea.add("AddVendorJPanel", addVendorPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(selectedEvent.getVenue()!=null){
             JOptionPane.showMessageDialog(this, "Venue is already selected..");
            return;
        }
        AddVenueJPanel addVenuePanel = new AddVenueJPanel(workArea, business, selectedEvent);

        workArea.add("AddVenueJPanel", addVenuePanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnInviteGuestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInviteGuestsActionPerformed
        // TODO add your handling code here:
        if(selectedEvent.getEventRequestList().size()>0){
            JOptionPane.showMessageDialog(this, "Invitations have already been sent out");
            return;
        }
        for(UserAccount guest: selectedEvent.getInvitedGuestList()){
            System.out.println(guest.getPerson().getName()+ " "+ guest.getPerson().getId());
            GuestEventRequest eventRequest = new GuestEventRequest(selectedEvent, selectedEvent.getHost(), guest);
            eventRequest.setMessage(txtInvitation.getText());
            eventRequest.setStatus(GuestEventRequest.EventRequestStatus.Recieved);
            selectedEvent.getEventRequestList().add(eventRequest);
            guest.getEventRequestList().add(eventRequest);
        }
        JOptionPane.showMessageDialog(this,"Invitation Sent to All the Guests");
    }//GEN-LAST:event_btnInviteGuestsActionPerformed

    private void cmbEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnterpriseActionPerformed
        // TODO add your handling code here:
       String  item = (String)cmbEnterprise.getSelectedItem();
       if(item.equalsIgnoreCase("services")){
          populateTableWithServices();
       }else if(item.equalsIgnoreCase("vendors")){
           populateTableWithVendors();
       }
       for(VendorOrganization vendor: selectedEvent.getInvitedVendorList()){
           System.out.println(vendor.getOrganizationName());
       }
         
    }//GEN-LAST:event_cmbEnterpriseActionPerformed

    private void cmbEnterpriseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbEnterpriseMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cmbEnterpriseMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
//        workArea.remove(this);
//        CardLayout layout = (CardLayout) workArea.getLayout();
//        layout.previous(workArea);
        workArea.remove(this);
        ((java.awt.CardLayout) workArea.getLayout()).next(workArea);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnInviteGuests;
    private javax.swing.JComboBox<String> cmbEnterprise;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtInvitation;
    private javax.swing.JTextField txtVenue;
    // End of variables declaration//GEN-END:variables



    private void populateTableWithServices() {
         List<Product> pl =selectedEvent.getProductList();
         DefaultTableModel model = (DefaultTableModel) table.getModel();
         model.setRowCount(0);
         for(Product p : pl){
             Object[] row = new Object[1];
             row[0] = p;
             model.addRow(row);
         }
         
    }

    private void populateTableWithVendors() {
        List<VendorOrganization> pl =selectedEvent.getInvitedVendorList();
         DefaultTableModel model = (DefaultTableModel) table.getModel();
         model.setRowCount(0);
         for(VendorOrganization p : pl){
             Object[] row = new Object[1];
             row[0] = p;
             model.addRow(row);
         }
         
    }
}

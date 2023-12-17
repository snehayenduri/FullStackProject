/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.eventManagement;

import Business.Business;
import Business.Enterprise.Event;
import Business.Enterprise.EventStatusEnum;
import Business.Organization.EventManagementOrganization.EventManagementOrganization;
import Business.Organization.Organization;
import Business.Roles.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author godalla
 */
public class EventManagementJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrganizerJPanel
     */
    JPanel workArea;
    Business business;
    UserAccount userAccount;
    EventManagementOrganization organization;
    public EventManagementJPanel(JPanel workArea, UserAccount account, EventManagementOrganization organization, Business business) {
        initComponents();
        this.workArea = workArea;
        this.business = business;
        this.organization = organization;
        this.userAccount = account;
        txtName.setText(userAccount.getPerson().getName());
        txtOrganization.setText(organization.getOrganizationName());
        intTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnManageEvent = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHostedEvents = new javax.swing.JTable();
        btnCompleteEvent = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOrganization = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 72, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setText("Event Management");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        btnManageEvent.setText("Manage Event");
        btnManageEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEventActionPerformed(evt);
            }
        });
        add(btnManageEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        tblHostedEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Event Name", "Event Type", "Event Date", "Event Time", "Event Capacity", "EventStatus"
            }
        ));
        jScrollPane1.setViewportView(tblHostedEvents);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 547, 147));

        btnCompleteEvent.setText("Complete Event");
        btnCompleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteEventActionPerformed(evt);
            }
        });
        add(btnCompleteEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, -1, -1));

        jLabel3.setText("Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 150, -1));

        jLabel4.setText("Organization:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        add(txtOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEventActionPerformed
        
        int selectedRow = tblHostedEvents.getSelectionModel().getLeadSelectionIndex();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(this,"Please select an event");
            return;
        }
        Event selectedEvent = (Event) tblHostedEvents.getValueAt(selectedRow,0);
//        ManageEventJPanel manageEventJPanel = new ManageEventJPanel(workArea, organization, business,selectedEvent);
        ManageEventJPanel manageEventJPanel = new ManageEventJPanel(workArea, organization, business,selectedEvent);
        workArea.add("ManageEventJPanel", manageEventJPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
        
    }//GEN-LAST:event_btnManageEventActionPerformed

    private void btnCompleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteEventActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblHostedEvents.getSelectionModel().getLeadSelectionIndex();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(this,"Please select an event");
            return;
        }
        
        Event selectedEvent = (Event) tblHostedEvents.getValueAt(selectedRow,0);
        selectedEvent.setStatus(EventStatusEnum.Done);
        
         JOptionPane.showMessageDialog(this,"Event completed successfully");
         intTable();
         
    }//GEN-LAST:event_btnCompleteEventActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompleteEvent;
    private javax.swing.JToggleButton btnManageEvent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHostedEvents;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrganization;
    // End of variables declaration//GEN-END:variables

    private void intTable() {
        DefaultTableModel model = (DefaultTableModel) tblHostedEvents.getModel();
        model.setRowCount(0);
        for(Event event: organization.getManagedEvents()){
                Object[] row = new Object[6];
                row[0] = event;
                row[1] = event.getType();
                row[2] = event.getDate();
                row[3] = event.getTime();
                row[4] = event.getEventCapacity();
                row[5] = event.getStatus();
                model.addRow(row);
        }
    }
    
 }
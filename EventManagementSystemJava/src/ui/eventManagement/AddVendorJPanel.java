/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.eventManagement;

import Business.Business;
import Business.Enterprise.Event;
import Business.Enterprise.VendorEventRequest;
import Business.Organization.Organization;
import Business.Organization.VendorOrganization.VendorOrganization;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nitin
 */
public class AddVendorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddVendorJPanel
     */
    JPanel workArea;
    Business business;
    Event event;
    public AddVendorJPanel(JPanel workArea, Business business, Event event) {
        this.event = event;
        this.workArea = workArea;
        this.business = business;
        initComponents();
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendor = new javax.swing.JTable();
        btnVendor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Add Vendor");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        tblVendor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Vendor Name", "Vendor Type"
            }
        ));
        jScrollPane1.setViewportView(tblVendor);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 677, 197));

        btnVendor.setText("Add Vendor");
        btnVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendorActionPerformed(evt);
            }
        });
        add(btnVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 155, -1));

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 19, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendorActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblVendor.getSelectionModel().getLeadSelectionIndex();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(this, "Please select a Vendor");
            return;
        }
        VendorOrganization selectedVendor = (VendorOrganization) tblVendor.getValueAt(selectedRow,0);
        VendorEventRequest vendorRequest = new VendorEventRequest(event, event.getHost(), selectedVendor);
        vendorRequest.setStatus(VendorEventRequest.VendorEventRequestStatus.Recieved);
        selectedVendor.getVendorEventRequestList().add(vendorRequest);
        event.getInvitedVendorList().add(selectedVendor);
        JOptionPane.showMessageDialog(this,"Vendor Added..");
        
    }//GEN-LAST:event_btnVendorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void initTable(){
        DefaultTableModel model = (DefaultTableModel) tblVendor.getModel();
        model.setRowCount(0);
        VendorOrganization vOrganization = null;
        for(Organization organization: business.getOrganizationDirectory().getOrganizationList()){
            if(organization.getType() == Organization.OrganizationType.VendorOrganization){
                vOrganization = (VendorOrganization) organization;
                Object[] row = new Object[2];
                row[0] = vOrganization;
                row[1] = vOrganization.getVendorType();
                
                model.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVendor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendor;
    // End of variables declaration//GEN-END:variables
}

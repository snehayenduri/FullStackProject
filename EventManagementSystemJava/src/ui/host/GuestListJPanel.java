/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.host;

import Business.Enterprise.Event;
import Business.Organization.ServiceOrganization.ProductManagement.Product;
import Business.Roles.GuestRole;
import Business.Roles.UserAccount;
import Business.Roles.UserAccountDirectory;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author godalla
 */
public class GuestListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GuestListJPanel
     */
    JPanel workArea;
    Event selectedEvent;
    UserAccountDirectory ud;
    
            
    public GuestListJPanel(JPanel userProcessContainer, Event selectedEvent, UserAccountDirectory ud) {
        initComponents();
        this.workArea = userProcessContainer;
        this.selectedEvent = selectedEvent;
        this.ud =ud;
        populateTable();
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
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        HostEventTbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        txtGuestId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGuestEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Guest List");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        HostEventTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Guest Name", "Email"
            }
        ));
        jScrollPane3.setViewportView(HostEventTbl);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 314, 233));

        jLabel2.setText("Guests of that event: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        AddBtn.setText("Add Guest");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, -1, -1));
        add(txtGuestId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 138, -1));

        jLabel3.setText("Guest Id");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, -1, -1));

        jLabel4.setText("Guest Email");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));
        add(txtGuestEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 138, -1));

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 35, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        UserAccount ua = ud.getUserByID(Integer.parseInt(txtGuestId.getText()));
        GuestRole gr = new GuestRole(selectedEvent, ua, txtGuestEmail.getText());
        ua.getPerson().setEmail(txtGuestEmail.getText());
        selectedEvent.getInvitedGuestList().add(ua);
        populateTable();
    }//GEN-LAST:event_AddBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTable HostEventTbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtGuestEmail;
    private javax.swing.JTextField txtGuestId;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        List<UserAccount> uas = selectedEvent.getInvitedGuestList();
        DefaultTableModel model = (DefaultTableModel) HostEventTbl.getModel();
           model.setRowCount(0);
        for(UserAccount ua : uas){
             Object[] row = new Object[2];
             row[0] = ua.getPerson().getName();
             row[1] = ua.getPerson().getEmail();
             model.addRow(row);
        }
    }
}
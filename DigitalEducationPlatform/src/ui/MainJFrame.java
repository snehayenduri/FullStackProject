/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import Model.CourseCatalog.CourseCatalog;
import Model.CourseSchedule.CourseLoad;
import Model.Faculty.ProfessorDirectory;
import Model.People.PersonDirectory;
import Model.People.StudentDirectory;
import Model.Persona.UserDirectory;
import java.awt.CardLayout;

/**
 *
 * @author godalla
 */
public class MainJFrame extends javax.swing.JFrame {
    private StudentDirectory studentDirectory;
    private UserDirectory userDirectory;
    private ProfessorDirectory professorDirectory;
    private CourseLoad courseLoad;
    private CourseCatalog courseCatalog;
    private String semester;
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        PersonDirectory personDirectory = new PersonDirectory();
        studentDirectory = new StudentDirectory();
        studentDirectory.populateStudents(personDirectory);
        userDirectory = new UserDirectory();
        userDirectory.populateUsers(personDirectory);
        professorDirectory = new ProfessorDirectory();
         courseLoad = new CourseLoad();
        courseCatalog = new CourseCatalog();
        courseCatalog.populateCourses();
        professorDirectory.populateProfessors(personDirectory, courseLoad, courseCatalog);
      
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        Menu = new javax.swing.JPanel();
        Login = new javax.swing.JButton();
        WorkArea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        Menu.setBackground(new java.awt.Color(204, 204, 204));

        Login.setText("LOGIN");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap(567, Short.MAX_VALUE)
                .addComponent(Login)
                .addGap(46, 46, 46))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(Login)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(Menu);

        WorkArea.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome To ED Tech");
        WorkArea.add(jLabel1, "card2");

        jSplitPane1.setRightComponent(WorkArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        LoginJPanel loginJPanel = new LoginJPanel(WorkArea, studentDirectory, userDirectory, professorDirectory, courseLoad, courseCatalog, semester);
        WorkArea.add("LoginJPanel", loginJPanel);
        CardLayout layout = (CardLayout) WorkArea.getLayout();
        layout.next(WorkArea);
    }//GEN-LAST:event_LoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel WorkArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}

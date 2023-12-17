/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import Model.CourseCatalog.Course;
import Model.CourseCatalog.CourseCatalog;
import Model.Faculty.Professor;
import Model.Faculty.ProfessorDirectory;
import Model.People.Student;
import Model.People.StudentDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author godalla
 */
public class AdminJpanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminJpanel
     */
    private ProfessorDirectory professorDirectory;
    private StudentDirectory studentDirectory;
    private JPanel workArea;
    private String currentSemester;
    public AdminJpanel(JPanel workArea, ProfessorDirectory professorDirectory, StudentDirectory studentDirectory, String currentSemester, CourseCatalog courseCatalog) {
        initComponents();
        this.studentDirectory = studentDirectory;
        this.professorDirectory = professorDirectory;
        this.workArea = workArea;
        this.currentSemester = currentSemester;
        
        DefaultTableModel model0 = (DefaultTableModel) tblCourses.getModel();
        model0.setRowCount(0);
        for(Course course : courseCatalog.getCourseList()){
            Object[] row = new Object[5];
            row[1] = course;
            row[0] = course.getCourseID();
            row[2] = course.getCredits();
            model0.addRow(row);
        }
        
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        model.setRowCount(0);
        for(Student student : studentDirectory.getStudentlist()){
            Object[] row = new Object[5];
            row[0] = student.getStudentID();
            row[1] = student;
            row[2] = student.getPerson().getAddress();
            row[3] = student.getPerson().getPhoneNumber();

            model.addRow(row);
        }
        
        DefaultTableModel model1 = (DefaultTableModel) tblProfessor.getModel();
        model1.setRowCount(0);
        for(Professor professor : professorDirectory.getTeacherlist()){
            Object[] row = new Object[5];
            row[0] = professor.getProfessorID();
            row[1] = professor;
            row[2] = professor.getPerson().getAddress();
            row[3] = professor.getRating();

            model1.addRow(row);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        deletebtnStud = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();
        deletebtnProf = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnEnd = new javax.swing.JToggleButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Admin Panel");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("Students");

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "StudentID", "Name", "Address", "Phno"
            }
        ));
        jScrollPane2.setViewportView(tblStudent);

        deletebtnStud.setText("Delete");
        deletebtnStud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnStudActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setText("Professors");

        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProfessorID", "Name", "Address", "Rating"
            }
        ));
        jScrollPane3.setViewportView(tblProfessor);

        deletebtnProf.setText("Delete");
        deletebtnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnProfActionPerformed(evt);
            }
        });

        jButton1.setText("<<Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course ID", "Course Name", "Credits"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblCourses);
        if (tblCourses.getColumnModel().getColumnCount() > 0) {
            tblCourses.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Course List");

        btnEnd.setText("End Semester");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(115, 115, 115)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(jButton1)
                                    .addGap(146, 146, 146)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(btnEnd))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(291, 291, 291)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(289, 289, 289)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(deletebtnStud)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(295, 295, 295)
                                    .addComponent(deletebtnProf)))
                            .addGap(101, 101, 101)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(736, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(btnEnd)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(deletebtnStud)
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deletebtnProf)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1299, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deletebtnProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnProfActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProfessor.getSelectedRow();
        if(selectedRow>=0){
            Professor professor = (Professor) tblProfessor.getValueAt(selectedRow, 1);
            if(professorDirectory.deleteProfessor(professor)){
                JOptionPane.showMessageDialog(this, "Deleted professor succesfully!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Please select a row",  "Warning", JOptionPane.WARNING_MESSAGE);
        }
        DefaultTableModel model = (DefaultTableModel)tblProfessor.getModel();
        model.setRowCount(0);
        for(Professor professor1 : professorDirectory.getTeacherlist()){
            Object[] row = new Object[5];
            row[0] = professor1.getProfessorID();
            row[1] = professor1; 
            row[2] = professor1.getPerson().getAddress();
            row[3] = professor1.getRating();

            model.addRow(row);
        }
    }//GEN-LAST:event_deletebtnProfActionPerformed

    private void deletebtnStudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnStudActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblStudent.getSelectedRow();
        if(selectedRow>=0){
            Student student = (Student) tblStudent.getValueAt(selectedRow, 1);
            if(studentDirectory.deleteStudent(student)){
                JOptionPane.showMessageDialog(this, "Deleted student succesfully!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Please select a row",  "Warning", JOptionPane.WARNING_MESSAGE);
        }
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        model.setRowCount(0);
        for(Student student : studentDirectory.getStudentlist()){
            Object[] row = new Object[5];
            row[0] = student.getStudentID();
            row[1] = student;
            row[2] = student.getPerson().getAddress();
            row[3] = student.getPerson().getPhoneNumber();

            model.addRow(row);
        }
    }//GEN-LAST:event_deletebtnStudActionPerformed

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        // TODO add your handling code here:
        studentDirectory.addCurrentCoursesToTranscripts(currentSemester);
        JOptionPane.showMessageDialog(this, "Ended semester succesfully!");
    }//GEN-LAST:event_btnEndActionPerformed

    public String getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(String currentSemester) {
        this.currentSemester = currentSemester;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEnd;
    private javax.swing.JButton deletebtnProf;
    private javax.swing.JButton deletebtnStud;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblCourses;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTable tblStudent;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        
    }
    
    
}

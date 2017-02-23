/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomstudentmatchups;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jlombardo
 */
public class ServiceChoiceWindow extends javax.swing.JFrame {
    private String filePath;
    private int groupSize;
    
    /**
     * Creates new form ServiceChoiceWindow
     */
    public ServiceChoiceWindow() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rboStudentChoices = new javax.swing.JRadioButton();
        rboSeatingChart = new javax.swing.JRadioButton();
        btnPerfService = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGetFile = new javax.swing.JButton();
        txtFilePath = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGroupSize = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Student Services");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choose a Service", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        buttonGroup1.add(rboStudentChoices);
        rboStudentChoices.setSelected(true);
        rboStudentChoices.setText("Random Student Choices");

        buttonGroup1.add(rboSeatingChart);
        rboSeatingChart.setText("Random Group Chart");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rboStudentChoices)
                    .addComponent(rboSeatingChart))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rboStudentChoices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rboSeatingChart)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnPerfService.setText("Perform Service");
        btnPerfService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfServiceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Choose a student file:");

        btnGetFile.setText("Select ...");
        btnGetFile.setActionCommand("");
        btnGetFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetFileActionPerformed(evt);
            }
        });

        txtFilePath.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        txtFilePath.setForeground(new java.awt.Color(0, 51, 255));
        txtFilePath.setText("/filepath/not/found");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Group Size:");

        txtGroupSize.setText("4");

        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFilePath, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(btnGetFile, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(196, 196, 196)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGroupSize)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnPerfService)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnGetFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFilePath)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGroupSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerfService)
                    .addComponent(jButton1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfServiceActionPerformed

        this.setVisible(false);
        
        try {
            groupSize = Integer.parseInt(txtGroupSize.getText());
        
            StudentMatchService srv = new StudentMatchService();
            if(this.rboSeatingChart.isSelected()) {
                srv.setOutputStrategy(new JDialogOutputStrategy());
            } else {
                StudentSeatingChart gui = new StudentSeatingChart(this,filePath);
                gui.repaint();
                return;
            }
        
            srv.createStudentMatchups(filePath, groupSize);
            srv.outputPairings();
            srv.clear();
            
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Sorry, group size must be a whole number", "Group Size Error", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Sorry, an error has occurred: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_btnPerfServiceActionPerformed

    private void btnGetFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetFileActionPerformed
        // TODO add your handling code here:
        final int ERROR = JFileChooser.ERROR_OPTION;
	final int APPROVE = JFileChooser.APPROVE_OPTION;
	final int CANCEL = JFileChooser.CANCEL_OPTION;
        
        // Build a file chooser component that displays files only
        JFileChooser fileChooser = new JFileChooser();
        if(filePath != null) fileChooser.setCurrentDirectory(new File(filePath));
        fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );

        // check if user clicked Cancel button on dialog, if so, return
        int result = fileChooser.showOpenDialog( this );
        if( !(result == APPROVE) )
                return;

        // Display all files available in FileChooser dialog
        // To filter for only ".txt" or other files you need to create a custom
        // filter class, and to learn more about JFileChooser,
        // see http://java.sun.com/j2se/1.4.2/docs/api/javax/swing/JFileChooser.html
        File file = fileChooser.getSelectedFile();
        filePath = file.getAbsolutePath();
        txtFilePath.setText(filePath);

    }//GEN-LAST:event_btnGetFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetFile;
    private javax.swing.JButton btnPerfService;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rboSeatingChart;
    private javax.swing.JRadioButton rboStudentChoices;
    private javax.swing.JLabel txtFilePath;
    private javax.swing.JTextField txtGroupSize;
    // End of variables declaration//GEN-END:variables
}

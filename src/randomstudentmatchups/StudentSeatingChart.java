/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package randomstudentmatchups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jlombardo
 */
public class StudentSeatingChart extends javax.swing.JFrame {
    private JButton oldSelection;
    private Set<Component> selectedStudents = new HashSet<Component>();
    
    /**
     * Creates new form StudentSeatingChart
     */
    public StudentSeatingChart(String filePath) throws Exception {
        initComponents();
        FileManager fileMgr = new FileManager(filePath);
        List<String> studentList = fileMgr.getStudentList();
        for(String student : studentList) {
            String[] parts = student.split(" ");
            JButton b = new JButton();
            b.setLayout(new BorderLayout());
            JLabel first = new JLabel(parts[0]);
            JLabel last = new JLabel(parts[1]);
            JLabel pad = new JLabel("                       ");
            JPanel namePanel = new JPanel();
            namePanel.setLayout(new BorderLayout());
            namePanel.add(pad,BorderLayout.NORTH);
            namePanel.add(first,BorderLayout.CENTER);
            namePanel.add(last,BorderLayout.SOUTH);
            b.add(namePanel,BorderLayout.CENTER);
            jPanel1.add(b);
        }
        this.setVisible(true);
        this.setSize(600, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSpin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seating Chart");
        setPreferredSize(new java.awt.Dimension(600, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel1.setSize(new java.awt.Dimension(600, 500));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        btnSpin.setText("Random Selection");
        btnSpin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpinActionPerformed(evt);
            }
        });
        getContentPane().add(btnSpin, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSpinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpinActionPerformed
        Color baseColor = btnSpin.getBackground();

        //Runnable r = () -> spinSelections();
        //r.run();
        
        pickRandomStudentNoRepeats();
    }//GEN-LAST:event_btnSpinActionPerformed
    
    private void pickRandomStudentNoRepeats() {
        Color selectedColor = Color.CYAN;
        Component selection = null;
        
        Random r = new Random(System.nanoTime());
        Component[] buttons = jPanel1.getComponents();
        int prevSize = selectedStudents.size();
        //System.out.println("Prev Size: " + prevSize);
        
        for(Component c : buttons) {
            selection = buttons[r.nextInt(buttons.length)];
            selectedStudents.add(selection);

            if(selectedStudents.size() > prevSize) {
                break;
            }
        }
        
        if(selection != null) {
            if(oldSelection != null) {
                Component[] panels = oldSelection.getComponents();
                panels[0].setBackground(selectedColor);
            }
            
            Component[] panels = ((JButton)selection).getComponents();
            panels[0].setBackground(Color.YELLOW);
            oldSelection = (JButton)selection;
            this.repaint();
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpin;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

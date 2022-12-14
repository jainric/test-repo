/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uiComponents.DentalPatientRole;

import Business.Network;
import Business.Organization;
import Business.Pharmacy.Model.Medicine;
import Business.Pharmacy.Model.MedicinesInventory;
import Business.Pharmacy.Organizations.PharmacyOrganization;
import Business.WorkQueue.MedicineWorkRequest;
import Business.WorkQueue.WorkRequest;
import Bussiness.model.PHC.UserAccount;
import Enterprise.Enterprise;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author richajain
 */
public class OrderRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private MedicinesInventory medInv;
    private Organization org;
    private PharmacyOrganization pharmorg;
    private Network network;
    /**
     * Creates new form PlaceRequestJPanel
     */
    public OrderRequestJPanel(JPanel userProcessContainer, UserAccount userAccount, PharmacyOrganization organization, Enterprise enterprise, Network network) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.pharmorg = organization;
        this.network = network;
        
        populateTable();
        populateComboBox();
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
        requestedItemsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        requestedItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Quantity", "Date Placed", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(requestedItemsTable);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setText("Medicine Name");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("Quantity");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Requested Items");

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton1.setText("Create Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel3)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRequestActionPerformed
        // TODO add your handling code here:
        try{
            MedicineWorkRequest med = new MedicineWorkRequest();
            med.setMedicationName((String) jComboBox1.getSelectedItem());
            med.setQuantity(Integer.parseInt(jTextField1.getText()));
            med.setRequestDate(new Date());
            med.setSender(userAccount);
            med.setPatientName("User");
            med.setStatus("Pending");

            userAccount.getWorkQueue().getWorkRequestList().add(med);
            pharmorg.getWorkQueue().getWorkRequestList().add(med);

            populateTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Details entered are not valid. Kindly check again.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_createRequestActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel)requestedItemsTable.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            if(request instanceof MedicineWorkRequest){
                Object[] row = new Object[4];
                row[0] = ((MedicineWorkRequest) request);
                row[1] = ((MedicineWorkRequest) request).getQuantity();
                row[2] = ((MedicineWorkRequest) request).getRequestDate();
                row[3] =  ((MedicineWorkRequest) request).getStatus();
                model.addRow(row);
            }
        }
    }
    
    private void populateComboBox() {
        jComboBox1.removeAllItems();

        for (Medicine name : pharmorg.getMedList()) {
                jComboBox1.addItem(name.getMedicineName());
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable requestedItemsTable;
    // End of variables declaration//GEN-END:variables
}

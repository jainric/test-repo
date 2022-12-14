/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uiComponents.DentalPatientRole;

import Business.EcoSystem;
import Business.WorkQueue.DoctorAvailableSlotWR;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author richajain
 */
public class AppointmentJPanel extends javax.swing.JPanel {

    private EcoSystem ecosystem;
    private javax.swing.JSplitPane jSplitPane1;
    /**
     * Creates new form AppointmentJPanel
     */
    public AppointmentJPanel(EcoSystem ecosystem) {
        initComponents();
        
        this.ecosystem = ecosystem;
        
        populateAvailableSlotsTable();
        populateBookedAppointmentTable();
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
        availableSlotsJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookedSlotsJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        availableSlotsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Doctor's Name", "Date/Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(availableSlotsJTable);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Available Slots");

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton1.setText("Book this Slot");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSlotActionPerformed(evt);
            }
        });

        bookedSlotsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Doctor's Name", "Date/Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bookedSlotsJTable);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Booked Slots");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(307, 307, 307)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(jButton1)))
                        .addGap(0, 279, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bookSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSlotActionPerformed
        // TODO add your handling code here:
        
        try{
            DoctorAvailableSlotWR wr = new DoctorAvailableSlotWR();

            wr.setPatient("Patients Name");
            wr.setStatus("Requested");
            
            populateBookedAppointmentTable();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Details entered are not valid. Kindly check again.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_bookSlotActionPerformed

    private void populateAvailableSlotsTable() {
        DefaultTableModel dtm = (DefaultTableModel) availableSlotsJTable.getModel();
	
        dtm.setRowCount(0);
        for (WorkRequest wr :  ecosystem.getWorkQueue().getWorkRequestList()) {
            Object row[] = new Object[3];
            if(wr instanceof DoctorAvailableSlotWR && "Available".equals(wr.getStatus())){
                row[0] = ((DoctorAvailableSlotWR) wr).getDoctor();
                row[1] = ((DoctorAvailableSlotWR) wr).getTimings();
                row[2] = wr.getStatus();
                dtm.addRow(row);
            }
        }
    }
    
    private void populateBookedAppointmentTable() {
        
        DefaultTableModel dtm = (DefaultTableModel) bookedSlotsJTable.getModel();
	
        dtm.setRowCount(0);
        for (WorkRequest wr :  ecosystem.getWorkQueue().getWorkRequestList()) {
            Object row[] = new Object[3];
            if(wr instanceof DoctorAvailableSlotWR && "Available".equals(wr.getStatus())){
                row[0] = ((DoctorAvailableSlotWR) wr).getDoctor();
                row[1] = ((DoctorAvailableSlotWR) wr).getTimings();
                row[2] = wr.getStatus();
                dtm.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableSlotsJTable;
    private javax.swing.JTable bookedSlotsJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Object.Reservation;
import Model.Services.DisplayService;
import Model.Services.UpdateService;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author muhse
 */
public class CancelFrame extends javax.swing.JFrame {
    private ArrayList<Reservation> userReservations;
    private DisplayService ds;
    private String faculty_id; // get from where?
    private String[][] userReservationsArray;
    private UpdateService us;
    /**
     * Creates new form CancelFrame
     */
    public CancelFrame(String faculty_id) throws SQLException {
        this.ds = new DisplayService();
        this.userReservations = ds.displayUserReservations(faculty_id);
        this.userReservationsArray = transformation();
        this.faculty_id = faculty_id;
        this.us = new UpdateService();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cancelButton1 = new javax.swing.JButton();
        cancelButton2 = new javax.swing.JButton();
        cancelButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            this.userReservationsArray,
            new String [] {
                "Room ID", "Time Slot"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(70);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }
        jTable1.getAccessibleContext().setAccessibleDescription("");

        cancelButton1.setText("CANCEL-->");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cancelButton1ActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        cancelButton2.setText("CANCEL-->");
        cancelButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cancelButton2ActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        cancelButton3.setText("CANCEL-->");
        cancelButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cancelButton3ActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(cancelButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addGap(459, 459, 459))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_cancelButton1ActionPerformed
        // TODO add your handling code here:
        String room_id = userReservationsArray[0][0];
        String time_slot = userReservationsArray[0][1];

        us.cancellation(faculty_id,Integer.parseInt(room_id),time_slot);

    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void cancelButton2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_cancelButton2ActionPerformed
        // TODO add your handling code here:
        String room_id = userReservationsArray[1][0];
        String time_slot = userReservationsArray[1][1];

        us.cancellation(faculty_id,Integer.parseInt(room_id),time_slot);

    }//GEN-LAST:event_cancelButton2ActionPerformed

    private int cancelButton3ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_cancelButton3ActionPerformed
        // TODO add your handling code here:
        String room_id = userReservationsArray[2][0];
        String time_slot = userReservationsArray[2][1];

        int return_type = us.cancellation("S017815",Integer.parseInt(room_id),time_slot);
        return return_type;

    }//GEN-LAST:event_cancelButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CancelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String faculty_id;

            public void run() {
                /*try {
                    new CancelFrame(this.faculty_id).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }
    private String[][] transformation(){
        String [][] userReservationArray = new String[this.userReservations.size()][2];
        for(int i = 0; i < this.userReservations.size(); i++){
            userReservationArray[i][0] = Integer.toString(this.userReservations.get(i).getRoom_id());
            userReservationArray[i][1] = this.userReservations.get(i).getTime_slot();


        }
        return userReservationArray;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton cancelButton2;
    private javax.swing.JButton cancelButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

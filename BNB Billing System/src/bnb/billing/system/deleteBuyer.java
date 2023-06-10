
package bnb.billing.system;

import java.sql.*;
import SQLManager.Connector;
import javax.swing.JOptionPane;

public class deleteBuyer extends javax.swing.JFrame implements Interface {

    public deleteBuyer() {
        initComponents();
    }
    
    public void clear() { // used for the clear all button
        txtName.setText("");
        txtPhoneNo.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtGender.setText("");
        btnDelete.setEnabled(false);
    }
        
    @Override
    public void backHomePage() {
        setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        txtPhoneNoSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClearAll = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(380, 240));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 330, 30));

        txtPhoneNo.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        getContentPane().add(txtPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 213, 330, 30));

        txtEmail.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 330, 30));

        txtAddress.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 330, 30));

        txtGender.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        getContentPane().add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 330, 30));

        txtPhoneNoSearch.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        getContentPane().add(txtPhoneNoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 180, -1));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        btnDelete.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        btnClearAll.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnClearAll.setText("Clear All");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        btnClose.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteBuyerWallP.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String phoneNo = txtPhoneNoSearch.getText();

        try {
            Connection con = Connector.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from buyer where phoneNo='"+phoneNo+"'");
            if (rs.next()) {
                txtName.setText(rs.getString(1));
                txtPhoneNo.setText(rs.getString(2));
                txtEmail.setText(rs.getString(3));
                txtAddress.setText(rs.getString(4));
                txtGender.setText(rs.getString(5));
                txtPhoneNoSearch.setEditable(false);
            }
            else
            JOptionPane.showMessageDialog(null, "Phone number doesn't exist!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        backHomePage();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        setVisible(false);
        new deleteBuyer().setVisible(true);
    }//GEN-LAST:event_btnClearAllActionPerformed

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
            java.util.logging.Logger.getLogger(deleteBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteBuyer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtPhoneNoSearch;
    // End of variables declaration//GEN-END:variables
}
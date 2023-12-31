
package bnb.billing.system;

import javax.swing.JOptionPane;
import java.sql.*;
import SQLManager.Connector;

public class updateBuyer extends javax.swing.JFrame implements Interface {

    public updateBuyer() {
        initComponents();
    }
    
    // takes method from interface
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

        txtPhoneNoSearch = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnClearAll = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtGender = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(380, 240));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtPhoneNoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 180, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 330, 30));
        getContentPane().add(txtPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 213, 330, 30));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 330, 30));
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 330, 30));

        btnUpdate.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

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
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        btnSearch.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));
        getContentPane().add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 330, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateBuyerwallp.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        backHomePage();
    }//GEN-LAST:event_btnCloseActionPerformed

    // resets the whole page
    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        setVisible(false);
        new updateBuyer().setVisible(true);
    }//GEN-LAST:event_btnClearAllActionPerformed

    // user will input a phone number, program will retrieve it to match it with the database
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String phoneNo = txtPhoneNoSearch.getText();
        
        try {
            Connection con = Connector.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from buyer where phoneNo='"+phoneNo+"'");
            if (rs.next()) { // presents the rest of the data from database
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

    // all editable fields are altered to textfields in order for user to edit the data
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String phoneNoSearch = txtPhoneNoSearch.getText();
        String name = txtName.getText();
        String phoneNo = txtPhoneNo.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String gender = txtGender.getText();
        
        try {
            Connection con = Connector.getCon();
            Statement st = con.createStatement();
            // inputs the update to the SQL database table
            st.executeUpdate("update buyer set name='"+name+"',phoneNo='"+phoneNo+"',email='"+email+"',address='"+address+"',gender='"+gender+"' where phoneNo='"+phoneNoSearch+"'");
            JOptionPane.showMessageDialog(null, "Successfully updated the Buyer!");
            setVisible(false);
            new updateBuyer().setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(updateBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateBuyer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateBuyer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtPhoneNoSearch;
    // End of variables declaration//GEN-END:variables
}


package bnb.billing.system;

import java.sql.*;
import javax.swing.JOptionPane;
import SQLManager.Connector;

public class deleteProduct extends javax.swing.JFrame implements Interface {

    public deleteProduct() {
        initComponents();
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

        btnClearAll = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txtActivate = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        txtRate = new javax.swing.JTextField();
        txtProdName = new javax.swing.JTextField();
        txtProductIDSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClearAll.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnClearAll.setText("Clear All");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 390, 90, -1));

        btnClose.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, -1, -1));

        btnRemove.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 90, -1));

        txtActivate.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        getContentPane().add(txtActivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 280, -1));

        txtDesc.setFont(new java.awt.Font("Moche", 0, 13)); // NOI18N
        getContentPane().add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 280, -1));

        txtRate.setFont(new java.awt.Font("Moche", 0, 13)); // NOI18N
        getContentPane().add(txtRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 280, -1));

        txtProdName.setFont(new java.awt.Font("Moche", 0, 13)); // NOI18N
        getContentPane().add(txtProdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 280, -1));
        getContentPane().add(txtProductIDSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 120, -1));

        btnSearch.setFont(new java.awt.Font("Moche", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/removeProdWallP.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        setVisible(false);
        new deleteProduct().setVisible(true);
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        backHomePage();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String pId = txtProductIDSearch.getText();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove?", "Select", JOptionPane.YES_NO_OPTION);
        
        if (a == 0) {
            try {
                Connection con = Connector.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("delete from product where pId='"+pId+"'");
                setVisible(false);
                new deleteProduct().setVisible(true);
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String pId = txtProductIDSearch.getText();
        
        try {
            Connection con = Connector.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product where pId='"+pId+"'");
            if (rs.next()) {
                txtProdName.setText(rs.getString(2));
                txtRate.setText(rs.getString(3));
                txtDesc.setText(rs.getString(4));
                txtActivate.setText(rs.getString(5));
                txtProductIDSearch.setEditable(false);
            }
            else
                JOptionPane.showMessageDialog(null, "Product ID doesn't exist!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }                                            
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(deleteProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtActivate;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtProductIDSearch;
    private javax.swing.JTextField txtRate;
    // End of variables declaration//GEN-END:variables
}
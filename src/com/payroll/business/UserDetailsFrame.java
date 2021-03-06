/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.business;

import com.payroll.dao.UserDAO;
import com.payroll.daoimpl.UserDaoImpl;
import com.payroll.models.User;

/**
 *
 * @author Kashif Alei
 */
public class UserDetailsFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserDetailsFrame
     */
    private User userModel;
    public UserDetailsFrame() {
        initComponents();
        this.userModel = LoginFrame.userModel;
        populateUserDetails();
        this.setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        updateUserBtn = new javax.swing.JLabel();
        resetBtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        confirmPasswordField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        phoneNoField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressField = new javax.swing.JTextArea();
        userTypeCombo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 760));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1370, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(53, 168, 83));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Profile Details");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 572, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("First name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Last Name");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        firstNameField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel2.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 188, -1));

        updateUserBtn.setBackground(new java.awt.Color(53, 168, 83));
        updateUserBtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        updateUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateUserBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateUserBtn.setText("Update Profile");
        updateUserBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateUserBtn.setOpaque(true);
        updateUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateUserBtnMouseClicked(evt);
            }
        });
        jPanel2.add(updateUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 152, 34));

        resetBtn.setBackground(new java.awt.Color(53, 168, 83));
        resetBtn.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resetBtn.setText("Reset");
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtn.setOpaque(true);
        resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetBtnMouseClicked(evt);
            }
        });
        jPanel2.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 300, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Email");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, -1));

        emailField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel2.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 188, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, -1, -1));

        passwordField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel2.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 188, -1));

        confirmPasswordField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel2.add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, 188, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Confirm Password");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, -1, -1));

        phoneNoField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel2.add(phoneNoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 188, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Address");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("User Type.");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Phone No.");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        addressField.setColumns(20);
        addressField.setRows(5);
        jScrollPane1.setViewportView(addressField);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 570, 90));

        userTypeCombo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User type", "Admin", "Accountant", "HR" }));
        userTypeCombo.setToolTipText("");
        jPanel2.add(userTypeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 190, 30));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Username");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        usernameField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel2.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 188, -1));

        lastNameField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel2.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 188, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1370, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void updateUserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateUserBtnMouseClicked
        String password = passwordField.getText().trim();
        String confirmPassword = passwordField.getText().trim();
        String address = addressField.getText().trim();
        String phoneNo = phoneNoField.getText().trim();

        userModel.setAddress(address);
        userModel.setPassword(password);
        userModel.setPhoneNumber(phoneNo);
        if (password.trim().isEmpty() || confirmPassword.trim().isEmpty()
                || address.trim().isEmpty() || phoneNo.trim().isEmpty()) {
            new MessageForm("Error", "Some fields are missing.", "error.png").setVisible(true);
            return;
        } else if (!password.equals(confirmPassword)) {
            new MessageForm("Error", "Password does not match.", "error.png").setVisible(true);
            return;
        }
        UserDaoImpl userDAO = new UserDaoImpl();
        int check = userDAO.update(userModel);

        if (check > 0) {
            this.clearFields();
            this.populateUserDetails();
            new MessageForm("Success", "User has been updated successfully.", "info.png").setVisible(true);
        } else {
            new MessageForm("Error", "Could not update the user, try again.", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_updateUserBtnMouseClicked

    private void resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseClicked
        //clearFields();

    }//GEN-LAST:event_resetBtnMouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(UserDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDetailsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressField;
    private javax.swing.JTextField confirmPasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneNoField;
    private javax.swing.JLabel resetBtn;
    private javax.swing.JLabel updateUserBtn;
    private javax.swing.JComboBox<String> userTypeCombo;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables

    private void populateUserDetails() {
        disableFileds();
        this.addressField.setText(userModel.getAddress());
        this.firstNameField.setText(userModel.getFirstName());
        this.emailField.setText(userModel.getEmail());
        this.lastNameField.setText(userModel.getLastName());
        this.phoneNoField.setText(userModel.getPhoneNumber());
        this.userTypeCombo.setSelectedItem(userModel.getDesignation());
        this.usernameField.setText(userModel.getUserName());
    }

    private void disableFileds() {
        this.firstNameField.setEnabled(false);
        this.emailField.setEnabled(false);
        this.lastNameField.setEnabled(false);
        this.phoneNoField.setEnabled(false);
        this.userTypeCombo.setEnabled(false);
        this.usernameField.setEnabled(false);
    }

    private void clearFields() {
       this.passwordField.setText("");
       this.confirmPasswordField.setText("");
       this.passwordField.requestFocus(true);
    }
}

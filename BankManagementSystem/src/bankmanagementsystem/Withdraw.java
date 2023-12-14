/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuan Dimianta
 */
public class Withdraw extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Withdraw() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        anotherAmmountBtn = new javax.swing.JButton();
        oneHundredBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        twoHundredBtn = new javax.swing.JButton();
        oneMillionBtn = new javax.swing.JButton();
        fiveMillionBtn = new javax.swing.JButton();
        fiveHundredBtn = new javax.swing.JButton();
        twoMillionBtn = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Please Select Your Transaction");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        anotherAmmountBtn.setText("JUMLAH LAIN");
        anotherAmmountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anotherAmmountBtnActionPerformed(evt);
            }
        });
        getContentPane().add(anotherAmmountBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 140, 30));

        oneHundredBtn.setText("Rp.100.000");
        oneHundredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneHundredBtnActionPerformed(evt);
            }
        });
        getContentPane().add(oneHundredBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 140, 30));

        backBtn.setText("KEMBALI");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 140, 30));

        twoHundredBtn.setText("Rp.200.000");
        twoHundredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoHundredBtnActionPerformed(evt);
            }
        });
        getContentPane().add(twoHundredBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 140, 30));

        oneMillionBtn.setText("Rp.1.000.000");
        oneMillionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneMillionBtnActionPerformed(evt);
            }
        });
        getContentPane().add(oneMillionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 140, 30));

        fiveMillionBtn.setText("Rp.5.000.000");
        fiveMillionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveMillionBtnActionPerformed(evt);
            }
        });
        getContentPane().add(fiveMillionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 140, 30));

        fiveHundredBtn.setText("Rp.500.000");
        fiveHundredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveHundredBtnActionPerformed(evt);
            }
        });
        getContentPane().add(fiveHundredBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 140, 30));

        twoMillionBtn.setText("Rp.2.000.000");
        twoMillionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoMillionBtnActionPerformed(evt);
            }
        });
        getContentPane().add(twoMillionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 140, 30));

        ImageIcon image = new ImageIcon("D:\\Yuan Dimianta\\Kuliah\\Semester 5\\PBO\\Praktikum\\projectPBO\\BankManagementSystem\\src\\Assets\\atm.jpg");
        background.setIcon(image); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 960, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void anotherAmmountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anotherAmmountBtnActionPerformed
        // TODO add your handling code here:
        new AntherAmount().setVisible(true);
        dispose();
    }//GEN-LAST:event_anotherAmmountBtnActionPerformed

    private void fiveHundredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveHundredBtnActionPerformed
        // TODO add your handling code here:
        if(Conn.balance > 500000 && Conn.balance - 500000 >= 50000){
                Conn.tarikTunai(500000);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak mencukupi");
        }
    }//GEN-LAST:event_fiveHundredBtnActionPerformed

    private void oneHundredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneHundredBtnActionPerformed
        // TODO add your handling code here:
        if(Conn.balance > 100000 && Conn.balance - 100000 >= 50000){
           Conn.tarikTunai(100000);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak mencukupi");
        }
    }//GEN-LAST:event_oneHundredBtnActionPerformed

    private void twoHundredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoHundredBtnActionPerformed
        // TODO add your handling code here:
        if(Conn.balance > 200000 && Conn.balance - 200000 >= 50000){
           Conn.tarikTunai(200000);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak mencukupi");
        }
    }//GEN-LAST:event_twoHundredBtnActionPerformed

    private void oneMillionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneMillionBtnActionPerformed
        // TODO add your handling code here:
        if(Conn.balance > 1000000 && Conn.balance - 1000000 >= 50000){
           Conn.tarikTunai(1000000);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak mencukupi");
        }
    }//GEN-LAST:event_oneMillionBtnActionPerformed

    private void fiveMillionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveMillionBtnActionPerformed
        // TODO add your handling code here:
        if(Conn.balance > 5000000 && Conn.balance - 5000000 >= 50000){
           Conn.tarikTunai(5000000);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak mencukupi");
        }
    }//GEN-LAST:event_fiveMillionBtnActionPerformed

    private void twoMillionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoMillionBtnActionPerformed
        // TODO add your handling code here:
        if(Conn.balance > 2000000 && Conn.balance - 2000000 >= 50000){
           Conn.tarikTunai(2000000);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak mencukupi");
        }
    }//GEN-LAST:event_twoMillionBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdraw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anotherAmmountBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel background;
    private javax.swing.JButton fiveHundredBtn;
    private javax.swing.JButton fiveMillionBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton oneHundredBtn;
    private javax.swing.JButton oneMillionBtn;
    private javax.swing.JButton twoHundredBtn;
    private javax.swing.JButton twoMillionBtn;
    // End of variables declaration//GEN-END:variables
}

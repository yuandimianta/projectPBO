/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuan Dimianta
 */
public class Transfer extends javax.swing.JFrame implements MouseMotionListener {

    /**
     * Creates new form Menu
     */
    public Transfer() {
        initComponents();
        setLocationRelativeTo(this);
        addMouseMotionListener(this);
        Session.setFrame(this);
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
        transferBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        amountLbl = new javax.swing.JTextField();
        transderToLbl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSFER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        transferBtn.setText("TRANSFER");
        transferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBtnActionPerformed(evt);
            }
        });
        getContentPane().add(transferBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 140, 30));

        backBtn.setText("KEMBALI");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 140, 30));

        amountLbl.setBackground(new java.awt.Color(255, 255, 255));
        amountLbl.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(amountLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 330, 40));

        transderToLbl.setBackground(new java.awt.Color(255, 255, 255));
        transderToLbl.setForeground(new java.awt.Color(0, 0, 0));
        transderToLbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                transderToLblKeyTyped(evt);
            }
        });
        amountLbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountLblKeyTyped(evt);
            }
        });
        getContentPane().add(transderToLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 330, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMINAL TRANSFER");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMOR REKENING TUJUAN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

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

    private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferBtnActionPerformed
        // TODO add your handling code here:
        long cardNum = Long.parseLong(transderToLbl.getText()); 
        long amount = Long.parseLong(amountLbl.getText());
        if(transderToLbl.getText().length() < 16){
            JOptionPane.showMessageDialog(null, "Card Number harus 16 digit");
            return;
        }

        if(amountLbl.getText().length() < 1){
            JOptionPane.showMessageDialog(null, "Nominal transfer tidak boleh kosong");
            return;
        }
        if(Conn.cekCardNumber(cardNum)){
            if(Conn.getBalance() - amount >= 50000){
                Conn.transfer(cardNum, amount);
            }else {
                JOptionPane.showMessageDialog(null, "Saldo tidak mencukupi");
            }
            return;
        }else{
            JOptionPane.showMessageDialog(null, "Nomor rekening tidak ditemukan");
            return;
        }
    }//GEN-LAST:event_transferBtnActionPerformed

    private void transderToLblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transderToLblKeyTyped
        // TODO add your handling code here:        
        char input = evt.getKeyChar();
        if ((!Character.isDigit(input)) || (transderToLbl.getText().length() > 15)) {
            evt.consume();
        }
        
    }//GEN-LAST:event_transderToLblKeyTyped
    private void amountLblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountLblKeyTyped
        // TODO add your handling code here:        
        char input = evt.getKeyChar();
        if ((!Character.isDigit(input))) {
            evt.consume();
        }
        
    }//GEN-LAST:event_amountLblKeyTyped

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField transderToLbl;
    private javax.swing.JButton transferBtn;
    // End of variables declaration//GEN-END:variables
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        AFKChecker.resetTimer();
    }
}

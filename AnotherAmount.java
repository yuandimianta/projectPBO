import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AnotherAmount extends javax.swing.JFrame implements MouseMotionListener {

    public AnotherAmount() {
        initComponents();
        setLocationRelativeTo(this);
        addMouseMotionListener(this);
        Session.setFrame(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        withdrawBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        amountLbl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("(KELIPATAN 100.000)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        withdrawBtn.setText("TARIK TUNAI");
        withdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBtnActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 140, 30));

        backBtn.setText("KEMBALI");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 140, 30));

        amountLbl.setBackground(new java.awt.Color(255, 255, 255));
        amountLbl.setForeground(new java.awt.Color(0, 0, 0));
        amountLbl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountLblActionPerformed(evt);
            }
        });
        getContentPane().add(amountLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 330, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MASUKKAN JUMLAH UANG");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        ImageIcon image = new ImageIcon("E:\\Kuliah\\Semester 5\\Pemrograman Berorientasi Objek\\Praktikum\\atm.jpg");
        background.setIcon(image); 
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 960, 870));

        pack();
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        new Menu().setVisible(true);
        dispose();
    }

    private void withdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {
        amountLbl.getText();
        long amount = Integer.parseInt(amountLbl.getText());
        int amountWithdraw = Integer.parseInt(amountLbl.getText());
        if(amountWithdraw % 100000 != 0){
            JOptionPane.showMessageDialog(null, "Jumlah uang harus kelipatan 100.000");
            return;
        }
        if(Conn.balance > amount && Conn.balance - amount >= 50000){
           Conn.tarikTunai(amount);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo anda tidak mencukupi");
        }
    }

    private void amountLblActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AntherAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntherAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntherAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntherAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntherAmount().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField amountLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton withdrawBtn;
    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        AFKChecker.resetTimer();
    }
}

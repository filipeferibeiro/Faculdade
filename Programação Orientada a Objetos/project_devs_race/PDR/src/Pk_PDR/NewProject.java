package Pk_PDR;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NewProject extends javax.swing.JFrame {
    
    public void changeColorEnv(String option, javax.swing.JLabel button) {
        if (option.equals("Entered")){
            ImageIcon icon = new ImageIcon(getClass().getResource("/Pk_PDR/images/buttonEnvD.png"));
            button.setIcon(icon);
        }
        else if (option.equals("Exited")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Pk_PDR/images/buttonEnv.png"));
            button.setIcon(icon);
        }
    }
    
    public void changeColorCancel(String option, javax.swing.JLabel button) {
        if (option.equals("Entered")){
            ImageIcon icon = new ImageIcon(getClass().getResource("/Pk_PDR/images/buttonCancelD.png"));
            button.setIcon(icon);
        }
        else if (option.equals("Exited")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Pk_PDR/images/buttonCancel.png"));
            button.setIcon(icon);
        }
    }
    PDR_Home home;
    public NewProject(PDR_Home homeWindow) {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Pk_PDR/images/icons8_User_Groups_32.png"));
        this.setIconImage(icon.getImage());
        home = homeWindow;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtGitHub = new javax.swing.JTextField();
        lblGitHub = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btCancel = new javax.swing.JPanel();
        imgCancel = new javax.swing.JLabel();
        btEnviar = new javax.swing.JPanel();
        imgEnviar = new javax.swing.JLabel();

        setTitle("Project Devs Race - Novo Projeto");
        setLocationByPlatform(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        bg.setBackground(new java.awt.Color(18, 34, 81));
        bg.setPreferredSize(new java.awt.Dimension(300, 400));

        txtNome.setBackground(new java.awt.Color(18, 34, 81));
        txtNome.setForeground(new java.awt.Color(255, 255, 255));
        txtNome.setBorder(null);

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("NOME");

        txtGitHub.setBackground(new java.awt.Color(18, 34, 81));
        txtGitHub.setForeground(new java.awt.Color(255, 255, 255));
        txtGitHub.setBorder(null);

        lblGitHub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGitHub.setForeground(new java.awt.Color(255, 255, 255));
        lblGitHub.setText("GITHUB - LINK");

        btCancel.setBackground(new java.awt.Color(18, 34, 81));

        imgCancel.setBackground(new java.awt.Color(18, 34, 81));
        imgCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pk_PDR/images/buttonCancel.png"))); // NOI18N
        imgCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imgCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgCancelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btCancelLayout = new javax.swing.GroupLayout(btCancel);
        btCancel.setLayout(btCancelLayout);
        btCancelLayout.setHorizontalGroup(
            btCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btCancelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btCancelLayout.setVerticalGroup(
            btCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgCancel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btEnviar.setBackground(new java.awt.Color(18, 34, 81));

        imgEnviar.setBackground(new java.awt.Color(18, 34, 81));
        imgEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pk_PDR/images/buttonEnv.png"))); // NOI18N
        imgEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgEnviarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imgEnviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgEnviarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btEnviarLayout = new javax.swing.GroupLayout(btEnviar);
        btEnviar.setLayout(btEnviarLayout);
        btEnviarLayout.setHorizontalGroup(
            btEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgEnviar)
        );
        btEnviarLayout.setVerticalGroup(
            btEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgEnviar, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(jSeparator1)
                            .addComponent(txtGitHub)
                            .addComponent(jSeparator2)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(lblGitHub))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGitHub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGitHub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(btEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 465, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imgEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEnviarMouseEntered
        changeColorEnv("Entered", imgEnviar);
    }//GEN-LAST:event_imgEnviarMouseEntered

    private void imgEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEnviarMouseExited
        changeColorEnv("Exited", imgEnviar);
    }//GEN-LAST:event_imgEnviarMouseExited

    private void imgCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCancelMouseEntered
        changeColorCancel("Entered", imgCancel);
    }//GEN-LAST:event_imgCancelMouseEntered

    private void imgCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCancelMouseExited
        changeColorCancel("Exited", imgCancel);
    }//GEN-LAST:event_imgCancelMouseExited

    private void imgCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgCancelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_imgCancelMouseClicked

    private void imgEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEnviarMouseClicked
        JOptionPane.showMessageDialog(null, "Você ainda não pode adicionar um novo projeto...");
        Projeto proj = new Projeto("hahah");
        home.addProj(proj);
        this.setVisible(false);
    }//GEN-LAST:event_imgEnviarMouseClicked

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
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {              
                //new NewProject().setVisible(true);    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btCancel;
    private javax.swing.JPanel btEnviar;
    private javax.swing.JLabel imgCancel;
    private javax.swing.JLabel imgEnviar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblGitHub;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtGitHub;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

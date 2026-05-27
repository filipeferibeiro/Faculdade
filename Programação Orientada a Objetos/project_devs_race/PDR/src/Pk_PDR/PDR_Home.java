package Pk_PDR;

import java.awt.event.WindowEvent;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PDR_Home extends javax.swing.JFrame {
    
    public void changeColor(String option, javax.swing.JPanel button) {
        if (option.equals("Entered")){
            button.setBackground(java.awt.Color.decode("#12679F"));
        }
        else if (option.equals("Exited")) {
            button.setBackground(java.awt.Color.decode("#122251"));
        }
    }
    
    //public void changeColorClick (String button)

    public PDR_Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Pk_PDR/images/icons8_User_Groups_32.png"));
        this.setIconImage(icon.getImage());
    }
    
    public void addProj (Projeto proj) {
        listProj.addProjeto(proj);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        barraLateral = new javax.swing.JPanel();
        lblPDR = new javax.swing.JLabel();
        btProjetos = new javax.swing.JPanel();
        pnMarca = new javax.swing.JPanel();
        lblProjetosIcon = new javax.swing.JLabel();
        lblProjetosNome = new javax.swing.JLabel();
        btPontGeral = new javax.swing.JPanel();
        pnMarca1 = new javax.swing.JPanel();
        lblPontGeral = new javax.swing.JLabel();
        lblPontGeralNome = new javax.swing.JLabel();
        btOutDados = new javax.swing.JPanel();
        pnMarca2 = new javax.swing.JPanel();
        lblOutDadosIcon = new javax.swing.JLabel();
        lblOutDadosNome = new javax.swing.JLabel();
        lbl_NewProject = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Devs Race");
        setLocationByPlatform(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(295, 300));

        barraLateral.setBackground(new java.awt.Color(18, 34, 81));
        barraLateral.setPreferredSize(new java.awt.Dimension(295, 491));

        lblPDR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pk_PDR/images/projectIcon.png"))); // NOI18N

        btProjetos.setBackground(new java.awt.Color(18, 45, 87));
        btProjetos.setPreferredSize(new java.awt.Dimension(250, 45));
        btProjetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btProjetosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btProjetosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btProjetosMouseExited(evt);
            }
        });

        pnMarca.setBackground(new java.awt.Color(18, 92, 157));
        pnMarca.setPreferredSize(new java.awt.Dimension(3, 50));

        javax.swing.GroupLayout pnMarcaLayout = new javax.swing.GroupLayout(pnMarca);
        pnMarca.setLayout(pnMarcaLayout);
        pnMarcaLayout.setHorizontalGroup(
            pnMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        pnMarcaLayout.setVerticalGroup(
            pnMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        lblProjetosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pk_PDR/images/icons8_Idea_25px.png"))); // NOI18N

        lblProjetosNome.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblProjetosNome.setForeground(new java.awt.Color(255, 255, 255));
        lblProjetosNome.setText("Projetos");

        javax.swing.GroupLayout btProjetosLayout = new javax.swing.GroupLayout(btProjetos);
        btProjetos.setLayout(btProjetosLayout);
        btProjetosLayout.setHorizontalGroup(
            btProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btProjetosLayout.createSequentialGroup()
                .addComponent(pnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProjetosIcon)
                .addGap(4, 4, 4)
                .addComponent(lblProjetosNome)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btProjetosLayout.setVerticalGroup(
            btProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btProjetosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(btProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProjetosIcon)
                    .addComponent(lblProjetosNome)))
        );

        btPontGeral.setBackground(new java.awt.Color(18, 45, 87));
        btPontGeral.setPreferredSize(new java.awt.Dimension(250, 45));
        btPontGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPontGeralMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btPontGeralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPontGeralMouseExited(evt);
            }
        });

        pnMarca1.setBackground(new java.awt.Color(18, 45, 87));
        pnMarca1.setPreferredSize(new java.awt.Dimension(3, 50));

        javax.swing.GroupLayout pnMarca1Layout = new javax.swing.GroupLayout(pnMarca1);
        pnMarca1.setLayout(pnMarca1Layout);
        pnMarca1Layout.setHorizontalGroup(
            pnMarca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        pnMarca1Layout.setVerticalGroup(
            pnMarca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        lblPontGeral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pk_PDR/images/icons8_Bar_Chart_25px.png"))); // NOI18N

        lblPontGeralNome.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblPontGeralNome.setForeground(new java.awt.Color(255, 255, 255));
        lblPontGeralNome.setText("Pontuação Geral");

        javax.swing.GroupLayout btPontGeralLayout = new javax.swing.GroupLayout(btPontGeral);
        btPontGeral.setLayout(btPontGeralLayout);
        btPontGeralLayout.setHorizontalGroup(
            btPontGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btPontGeralLayout.createSequentialGroup()
                .addComponent(pnMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPontGeral)
                .addGap(4, 4, 4)
                .addComponent(lblPontGeralNome)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btPontGeralLayout.setVerticalGroup(
            btPontGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMarca1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btPontGeralLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(btPontGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPontGeral)
                    .addComponent(lblPontGeralNome)))
        );

        btOutDados.setBackground(new java.awt.Color(18, 45, 87));
        btOutDados.setPreferredSize(new java.awt.Dimension(250, 45));
        btOutDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btOutDadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btOutDadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btOutDadosMouseExited(evt);
            }
        });

        pnMarca2.setBackground(new java.awt.Color(18, 45, 87));
        pnMarca2.setPreferredSize(new java.awt.Dimension(3, 50));

        javax.swing.GroupLayout pnMarca2Layout = new javax.swing.GroupLayout(pnMarca2);
        pnMarca2.setLayout(pnMarca2Layout);
        pnMarca2Layout.setHorizontalGroup(
            pnMarca2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        pnMarca2Layout.setVerticalGroup(
            pnMarca2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        lblOutDadosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pk_PDR/images/icons8_Combo_Chart_25px.png"))); // NOI18N

        lblOutDadosNome.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblOutDadosNome.setForeground(new java.awt.Color(255, 255, 255));
        lblOutDadosNome.setText("Outros Dados");

        javax.swing.GroupLayout btOutDadosLayout = new javax.swing.GroupLayout(btOutDados);
        btOutDados.setLayout(btOutDadosLayout);
        btOutDadosLayout.setHorizontalGroup(
            btOutDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btOutDadosLayout.createSequentialGroup()
                .addComponent(pnMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOutDadosIcon)
                .addGap(4, 4, 4)
                .addComponent(lblOutDadosNome)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btOutDadosLayout.setVerticalGroup(
            btOutDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMarca2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btOutDadosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(btOutDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOutDadosIcon)
                    .addComponent(lblOutDadosNome)))
        );

        javax.swing.GroupLayout barraLateralLayout = new javax.swing.GroupLayout(barraLateral);
        barraLateral.setLayout(barraLateralLayout);
        barraLateralLayout.setHorizontalGroup(
            barraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btProjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btPontGeral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btOutDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(barraLateralLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPDR)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        barraLateralLayout.setVerticalGroup(
            barraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLateralLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblPDR)
                .addGap(20, 20, 20)
                .addComponent(btProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btPontGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btOutDados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        lbl_NewProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pk_PDR/images/newProject.png"))); // NOI18N
        lbl_NewProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_NewProjectMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(barraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 695, Short.MAX_VALUE)
                .addComponent(lbl_NewProject)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_NewProject)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Ação para o botão de Novo Projeto
    private void lbl_NewProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_NewProjectMouseClicked
        new NewProject(this).setVisible(true);
        
    }//GEN-LAST:event_lbl_NewProjectMouseClicked

    private void btProjetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btProjetosMouseClicked
        pnMarca.setBackground(java.awt.Color.decode("#125C9D"));
        pnMarca1.setBackground(java.awt.Color.decode("#122D57"));
        pnMarca2.setBackground(java.awt.Color.decode("#122D57"));
        
    }//GEN-LAST:event_btProjetosMouseClicked

    private void btProjetosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btProjetosMouseEntered
        changeColor("Entered", btProjetos);
    }//GEN-LAST:event_btProjetosMouseEntered

    private void btProjetosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btProjetosMouseExited
        changeColor("Exited", btProjetos);
    }//GEN-LAST:event_btProjetosMouseExited

    private void btPontGeralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPontGeralMouseEntered
        changeColor("Entered", btPontGeral);
    }//GEN-LAST:event_btPontGeralMouseEntered

    private void btPontGeralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPontGeralMouseExited
        changeColor("Exited", btPontGeral);
    }//GEN-LAST:event_btPontGeralMouseExited

    private void btOutDadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOutDadosMouseEntered
        changeColor("Entered", btOutDados);
    }//GEN-LAST:event_btOutDadosMouseEntered

    private void btOutDadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOutDadosMouseExited
        changeColor("Exited", btOutDados);
    }//GEN-LAST:event_btOutDadosMouseExited

    private void btPontGeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPontGeralMouseClicked
        pnMarca.setBackground(java.awt.Color.decode("#122D57"));
        pnMarca1.setBackground(java.awt.Color.decode("#125C9D"));
        pnMarca2.setBackground(java.awt.Color.decode("#122D57"));
    }//GEN-LAST:event_btPontGeralMouseClicked

    private void btOutDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOutDadosMouseClicked
        pnMarca.setBackground(java.awt.Color.decode("#122D57"));
        pnMarca1.setBackground(java.awt.Color.decode("#122D57"));
        pnMarca2.setBackground(java.awt.Color.decode("#125C9D"));
    }//GEN-LAST:event_btOutDadosMouseClicked
        
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
            java.util.logging.Logger.getLogger(PDR_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDR_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDR_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDR_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDR_Home().setVisible(true);
            }
        });

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraLateral;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btOutDados;
    private javax.swing.JPanel btPontGeral;
    private javax.swing.JPanel btProjetos;
    private javax.swing.JLabel lblOutDadosIcon;
    private javax.swing.JLabel lblOutDadosNome;
    private javax.swing.JLabel lblPDR;
    private javax.swing.JLabel lblPontGeral;
    private javax.swing.JLabel lblPontGeralNome;
    private javax.swing.JLabel lblProjetosIcon;
    private javax.swing.JLabel lblProjetosNome;
    private javax.swing.JLabel lbl_NewProject;
    private javax.swing.JPanel pnMarca;
    private javax.swing.JPanel pnMarca1;
    private javax.swing.JPanel pnMarca2;
    // End of variables declaration//GEN-END:variables
    ListaProjetos listProj = new ListaProjetos();
}
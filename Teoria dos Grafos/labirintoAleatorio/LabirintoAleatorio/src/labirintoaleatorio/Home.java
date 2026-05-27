package labirintoaleatorio;

import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        this.setLocationRelativeTo(null); //Seta a tela do menu no meio da tela.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtPlayerName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblDificuldade = new javax.swing.JLabel();
        selectDificuldade = new javax.swing.JComboBox<>();
        btJogar = new javax.swing.JPanel();
        lblIMGJogar = new javax.swing.JLabel();
        btAjuda = new javax.swing.JPanel();
        lblIMGAjuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 125, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(java.awt.Color.white);

        lblNome.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        lblNome.setText("NOME");

        txtPlayerName.setBorder(null);

        jSeparator1.setBackground(java.awt.Color.black);

        lblDificuldade.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        lblDificuldade.setText("DIFICULDADE");

        selectDificuldade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Fácil", "Médio", "Difícil" }));

        btJogar.setBackground(new java.awt.Color(255, 255, 255));
        btJogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btJogarMouseClicked(evt);
            }
        });

        lblIMGJogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/btJogarN.png"))); // NOI18N

        javax.swing.GroupLayout btJogarLayout = new javax.swing.GroupLayout(btJogar);
        btJogar.setLayout(btJogarLayout);
        btJogarLayout.setHorizontalGroup(
            btJogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btJogarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblIMGJogar)
                .addGap(0, 0, 0))
        );
        btJogarLayout.setVerticalGroup(
            btJogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btJogarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblIMGJogar)
                .addGap(0, 0, 0))
        );

        btAjuda.setBackground(new java.awt.Color(255, 255, 255));

        lblIMGAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/btAjudaN.png"))); // NOI18N

        javax.swing.GroupLayout btAjudaLayout = new javax.swing.GroupLayout(btAjuda);
        btAjuda.setLayout(btAjudaLayout);
        btAjudaLayout.setHorizontalGroup(
            btAjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btAjudaLayout.createSequentialGroup()
                .addComponent(lblIMGAjuda)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btAjudaLayout.setVerticalGroup(
            btAjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btAjudaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblIMGAjuda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlayerName)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDificuldade)
                            .addComponent(selectDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(btJogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblDificuldade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btJogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btJogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btJogarMouseClicked
        if (txtPlayerName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor informe seu nome jogador!");
        }
        else {
            if (selectDificuldade.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione uma dificuldade!");
            }
            else {
                if (selectDificuldade.getSelectedIndex() == 1){
                    this.setVisible(false);
                    new Game(txtPlayerName.getText(), 160).setVisible(true);
                }
                else if (selectDificuldade.getSelectedIndex() == 2) {
                    this.setVisible(false);
                    new Game(txtPlayerName.getText(), 216).setVisible(true);
                }
                else if (selectDificuldade.getSelectedIndex() == 3) {
                    this.setVisible(false);
                    new Game(txtPlayerName.getText(), 280).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btJogarMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btAjuda;
    private javax.swing.JPanel btJogar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDificuldade;
    private javax.swing.JLabel lblIMGAjuda;
    private javax.swing.JLabel lblIMGJogar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JComboBox<String> selectDificuldade;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables
}
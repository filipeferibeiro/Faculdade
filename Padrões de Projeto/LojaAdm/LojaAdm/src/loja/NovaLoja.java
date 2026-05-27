package loja;

public class NovaLoja extends javax.swing.JFrame {
    private boolean isEdit;
    private LojaFacade loja;
    private ObserverDadosLoja tela;
    
    public NovaLoja(boolean isEdit, LojaFacade loja, ObserverDadosLoja tela) {
        initComponents();
        //Seta a janela no meio de tela
        this.setLocationRelativeTo(null);
        
        this.isEdit = isEdit;
        this.loja = loja;
        this.tela = tela;
        //Configura o modo de edição
        if (isEdit) {
            this.setTitle("Editar Loja");
            this.lbl_loja.setText("Editar Loja");
            this.tf_nome.setText(loja.getNome());
            this.tf_motdA.setText(loja.getMotd());
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            //Habilita o botão restaurar caso exista algum memento salvo
            if (loja.getLojaInfoMementoState() != null) {
                this.bt_restaurar.setEnabled(true);
            }
        }
        //Se não estiver no modo de edição, o botão restaurar não aparece
        else {
            this.bt_restaurar.setVisible(false);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_loja = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_motd = new javax.swing.JScrollPane();
        tf_motdA = new javax.swing.JTextArea();
        bt_salvar = new javax.swing.JButton();
        bt_restaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nova Loja");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(75, 98, 171));
        jPanel1.setPreferredSize(new java.awt.Dimension(273, 42));
        jPanel1.setSize(new java.awt.Dimension(100, 42));

        lbl_loja.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbl_loja.setForeground(new java.awt.Color(255, 255, 255));
        lbl_loja.setText("Nova Loja");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lbl_loja)
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_loja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel2.setText(" NOME");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel3.setText(" MOTD");

        tf_motdA.setColumns(20);
        tf_motdA.setRows(5);
        tf_motdA.setBorder(null);
        tf_motd.setViewportView(tf_motdA);

        bt_salvar.setBackground(new java.awt.Color(75, 98, 171));
        bt_salvar.setForeground(new java.awt.Color(255, 255, 255));
        bt_salvar.setText("Salvar");
        bt_salvar.setToolTipText("");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_restaurar.setText("Restaurar");
        bt_restaurar.setEnabled(false);
        bt_restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_restaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_nome)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tf_motd)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_restaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_salvar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(tf_motd, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_salvar)
                    .addComponent(bt_restaurar))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if (tf_nome.getText().equals("")) {
            System.out.println("Campo Nome é obrigatório!");
        }
        else {
            //Salava na base de dados a nova configuração da loja e guarda o estado anterior no memento
            if (isEdit) {
                loja.setLojaInfoMemento(new LojaInfoMemento(loja.getNome(), loja.getMotd()));
                loja.editLoja(tf_nome.getText(), tf_motdA.getText());
                tela.update(tf_nome.getText(), tf_motdA.getText());
                
                this.bt_restaurar.setEnabled(true);
            }
            //Adiciona a loja na base de dados na configuração inicial
            else {
                loja.novaLoja(tf_nome.getText(), tf_motdA.getText());
                tela.update(tf_nome.getText(), tf_motdA.getText());
                new Cadastro(true, loja, false, null, null).setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_restaurarActionPerformed
        LojaInfoMemento memento = loja.getLojaInfoMemento();
        
        tf_nome.setText(memento.getNome());
        tf_motdA.setText(memento.getMotd());
        //Restaura o as configurações anteriores da loja salvas no memento
        loja.editLoja(tf_nome.getText(), tf_motdA.getText());
        tela.update(tf_nome.getText(), tf_motdA.getText());
        //Desabilita o botão restaurar depois do memento ser restaurado
        this.bt_restaurar.setEnabled(false);
    }//GEN-LAST:event_bt_restaurarActionPerformed


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
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_restaurar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_loja;
    private javax.swing.JScrollPane tf_motd;
    private javax.swing.JTextArea tf_motdA;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables
}

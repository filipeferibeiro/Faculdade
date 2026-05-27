package loja;

public class Cadastro extends javax.swing.JFrame {
    private boolean isFirst, isEdit; //Verificador se é a primeira vez ou modo edição
    private LojaFacade loja; //Facade
    private Funcionario funcionario; //Funcionário para Edição
    private ObserverAlt tela; //Tela anterior para aplicar modificações
    
    public Cadastro(boolean isFirst, LojaFacade loja, boolean isEdit, Funcionario funcionario, ObserverAlt tela) {
        initComponents();
        //Seta a janela no meio de tela
        this.setLocationRelativeTo(null);
        
        this.isFirst = isFirst;
        this.loja = loja;
        this.isEdit = isEdit;
        
        if (isEdit) {
            //Seta os Campos com as informações
            tf_nome.setText(funcionario.getNome());
            tf_login.setText(funcionario.getLogin());
            tf_senha.setText(funcionario.getSenha());
            tf_email.setText(funcionario.getEmail());
            cb_tipo.setSelectedItem(funcionario.getNivelAcesso());
            
            //Edita a tela para modo edição
            this.setTitle("Editar Funcionário");
            this.lbl_cadas.setText("Editar Funcionário");
            this.bt_cadastrar.setText("Salvar");
            
            //Instancia apenas no modo edição
            this.funcionario = funcionario;
            this.tela = tela;
            
            //Um usuário não pode mudar seu próprio cargo
            if (funcionario.getId() == loja.getId_logado()) {
                cb_tipo.setVisible(false);
                lbl_tipo.setVisible(false);
            }   
        }
        
        if (isFirst) {
            //Prepara a tela para a primeira vez
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            bt_cancelar.setVisible(false);
            lbl_tipo.setVisible(false);
            cb_tipo.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_cadas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tf_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_login = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_senha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        bt_cadastrar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        lbl_tipo = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Funcionário");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(75, 98, 171));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 42));

        lbl_cadas.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbl_cadas.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cadas.setText("Cadastrar Funcionário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_cadas)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cadas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tf_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nomeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel2.setText(" NOME");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel3.setText(" LOGIN");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel4.setText(" SENHA");

        tf_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_senhaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel5.setText(" E-MAIL");

        bt_cadastrar.setBackground(new java.awt.Color(75, 98, 171));
        bt_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        bt_cadastrar.setText("Cadastrar");
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        lbl_tipo.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lbl_tipo.setText(" TIPO");

        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Administrador", "Gerente" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cadastrar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_login)
                            .addComponent(tf_senha)
                            .addComponent(tf_email)
                            .addComponent(cb_tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(lbl_tipo))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addComponent(tf_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lbl_tipo)
                .addGap(0, 0, 0)
                .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cadastrar)
                    .addComponent(bt_cancelar))
                .addContainerGap())
        );

        tf_nome.getAccessibleContext().setAccessibleName("tf_nome");
        tf_login.getAccessibleContext().setAccessibleName("tf_login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tf_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_senhaActionPerformed

    private void tf_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nomeActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        //Adiciona o gerente
        if (this.isFirst == true) {
            this.loja.addFuncionario(this.tf_nome.getText(), this.tf_login.getText(), new String(this.tf_senha.getPassword()).trim(), this.tf_email.getText(), "Gerente", 1);
        }
        //Edita um Funcionário
        else if (this.isEdit) {
            this.loja.editFuncionario(funcionario.getId(), this.tf_nome.getText(), this.tf_login.getText(), new String(this.tf_senha.getPassword()).trim(), this.tf_email.getText(), this.cb_tipo.getSelectedItem().toString(), funcionario);
            this.tela.updateList();
        }
        //Adiciona um Funcionário
        else {
            this.loja.addFuncionario(this.tf_nome.getText(), this.tf_login.getText(), new String(this.tf_senha.getPassword()).trim(), this.tf_email.getText(), this.cb_tipo.getSelectedItem().toString(), 1);
        }
        //Fecha a janela
        this.dispose();
    }//GEN-LAST:event_bt_cadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JComboBox<String> cb_tipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_cadas;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_login;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JPasswordField tf_senha;
    // End of variables declaration//GEN-END:variables
}

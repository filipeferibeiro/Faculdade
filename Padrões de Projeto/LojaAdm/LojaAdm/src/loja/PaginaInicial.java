package loja;

import java.sql.Date;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

public class PaginaInicial extends javax.swing.JFrame implements ObserverDadosLoja, ObserverAlt {
    Funcionario pessoaLogada;
    LojaFacade loja;
    DefaultListModel listaCompras = new DefaultListModel();
    Venda venda;
    
    public PaginaInicial(Funcionario pessoaLogada, LojaFacade loja) {
        initComponents();
        //Seta a janela no meio de tela
        this.setLocationRelativeTo(null);
        //Seta o título da janela para o nome da loja
        this.setTitle(loja.getNome() + " - Administração");
        
        this.pessoaLogada = pessoaLogada;
        this.loja = loja;
        //Configura a janela com as informações do banco
        this.lbl_nomePessoa.setText(pessoaLogada.getNome());
        this.lbl_cargoPessoa.setText(pessoaLogada.getNivelAcesso());
        this.lbl_nomeLoja.setText(loja.getNome());
        loja.getProdutosToCombo(cb_produtos);
        this.venda = new Venda(pessoaLogada.getId());
        this.sn_quantidade.setValue(1);
        //Um funcionário só pode ver os produtos e suas vendas
        if (pessoaLogada.getNivelAcesso().equals("Funcionário")) {
            this.bt_novoProd.setVisible(false);
            this.bt_func.setVisible(false);
            this.bt_novoFunc.setVisible(false);
            this.bt_editLoja.setVisible(false);
        }
        //Um administrador não pode adicionar um novo funcionário nem editar a loja
        else if (pessoaLogada.getNivelAcesso().equals("Administrador")) {
            this.bt_novoFunc.setVisible(false);
            this.bt_editLoja.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        lbl_nomeLoja = new javax.swing.JLabel();
        lbl_adm = new javax.swing.JLabel();
        lbl_nomePessoa = new javax.swing.JLabel();
        lbl_cargoPessoa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cb_produtos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt_addProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_produtos = new javax.swing.JList<>();
        bt_comprar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        cb_pagamento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        sn_quantidade = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        bt_minhasVendas = new javax.swing.JButton();
        bt_prod = new javax.swing.JButton();
        bt_func = new javax.swing.JButton();
        bt_deslogar = new javax.swing.JButton();
        bt_novoProd = new javax.swing.JButton();
        bt_novoFunc = new javax.swing.JButton();
        bt_editLoja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        topPanel.setBackground(new java.awt.Color(75, 98, 171));

        lbl_nomeLoja.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbl_nomeLoja.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nomeLoja.setText("Loja");

        lbl_adm.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lbl_adm.setForeground(new java.awt.Color(255, 255, 255));
        lbl_adm.setText("Administração");

        lbl_nomePessoa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nomePessoa.setText("NOME DA PESSOA");

        lbl_cargoPessoa.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lbl_cargoPessoa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cargoPessoa.setText("Cargo");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_nomeLoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_adm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nomePessoa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_cargoPessoa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addComponent(lbl_nomePessoa)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_cargoPessoa))
                    .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_nomeLoja)
                        .addComponent(lbl_adm)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel1.setText(" PRODUTO");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel2.setText(" QUANTIDADE");

        bt_addProd.setBackground(new java.awt.Color(75, 98, 171));
        bt_addProd.setForeground(new java.awt.Color(255, 255, 255));
        bt_addProd.setText("Adicionar");
        bt_addProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addProdActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list_produtos);

        bt_comprar.setBackground(new java.awt.Color(75, 98, 171));
        bt_comprar.setForeground(new java.awt.Color(255, 255, 255));
        bt_comprar.setText("Finalizar compra");
        bt_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        cb_pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Crédito", "Débito" }));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel3.setText(" FORMA DE PAGAMENTO");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setText("TOTAL: R$");

        lbl_total.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbl_total.setText("0,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(sn_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_addProd, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cb_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_total)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_comprar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sn_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bt_addProd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bt_comprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(lbl_total))))
                .addGap(1, 1, 1))
        );

        sidePanel.setBackground(new java.awt.Color(79, 76, 119));

        bt_minhasVendas.setBackground(new java.awt.Color(255, 255, 255));
        bt_minhasVendas.setText("Minhas Vendas");
        bt_minhasVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_minhasVendasActionPerformed(evt);
            }
        });

        bt_prod.setBackground(new java.awt.Color(255, 255, 255));
        bt_prod.setText("Produtos");
        bt_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_prodActionPerformed(evt);
            }
        });

        bt_func.setBackground(new java.awt.Color(255, 255, 255));
        bt_func.setText("Funcionários");
        bt_func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_funcActionPerformed(evt);
            }
        });

        bt_deslogar.setBackground(new java.awt.Color(238, 0, 0));
        bt_deslogar.setText("Deslogar");
        bt_deslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deslogarActionPerformed(evt);
            }
        });

        bt_novoProd.setBackground(new java.awt.Color(255, 255, 255));
        bt_novoProd.setText("Novo Produto");
        bt_novoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoProdActionPerformed(evt);
            }
        });

        bt_novoFunc.setBackground(new java.awt.Color(255, 255, 255));
        bt_novoFunc.setText("Novo Funcionário");
        bt_novoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoFuncActionPerformed(evt);
            }
        });

        bt_editLoja.setBackground(new java.awt.Color(255, 255, 255));
        bt_editLoja.setText("Editar Loja");
        bt_editLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editLojaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_minhasVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_deslogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_novoProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_novoFunc, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(bt_editLoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_minhasVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_func, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_editLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_deslogar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoFuncActionPerformed
        new Cadastro(false, loja, false, null, null).setVisible(true); //Abre janela de cadastro de novo funcionário
    }//GEN-LAST:event_bt_novoFuncActionPerformed

    private void bt_deslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deslogarActionPerformed
        //Desloga do sistema
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_deslogarActionPerformed

    private void bt_editLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editLojaActionPerformed
        new NovaLoja(true, loja, this).setVisible(true); //Abre janela de edição das informações da loja
    }//GEN-LAST:event_bt_editLojaActionPerformed

    private void bt_novoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoProdActionPerformed
        new NovoProd(false, loja, this, null).setVisible(true); //Abre janela de adição de novo produto
    }//GEN-LAST:event_bt_novoProdActionPerformed

    private void bt_addProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addProdActionPerformed
        Produto produto = loja.getProdutos().get(cb_produtos.getSelectedIndex());
        //Verifica se tem estoque do produto para a quantidade pedida
        if (produto.getEstoque() >= Integer.parseInt(sn_quantidade.getValue().toString())) {
            produto.setEstoque(produto.getEstoque() - Integer.parseInt(sn_quantidade.getValue().toString()));
            //Adiciona o produto na lista
            this.venda.getProdutos().add(produto);
            this.venda.getQuant().add(Integer.parseInt(sn_quantidade.getValue().toString()));

            this.listaCompras.addElement("(" + sn_quantidade.getValue() + ") - " + cb_produtos.getSelectedItem().toString());
            this.list_produtos.setModel(listaCompras);

            this.lbl_total.setText(String.format("%,.2f", this.venda.getTotal()));
        }
    }//GEN-LAST:event_bt_addProdActionPerformed

    private void bt_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprarActionPerformed
        venda.setPagamento(cb_pagamento.getSelectedItem().toString());
        //Escolhe o tipo de pagamento
        if (cb_pagamento.getSelectedIndex() == 0) {
            loja.novaVenda(venda, new PagamentoDinheiro());
            clean();
        }
        else if (cb_pagamento.getSelectedIndex() == 1) {
            loja.novaVenda(venda, new PagamentoCredito());
            clean();
        }
        else if (cb_pagamento.getSelectedIndex() == 2) {
            loja.novaVenda(venda, new PagamentoDebito());
            clean();
        }
    }//GEN-LAST:event_bt_comprarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        clean(); //Limpa as informações da tela para cancelar a compra
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_prodActionPerformed
        new ProdutosView(pessoaLogada.getNivelAcesso(), loja, this).setVisible(true); //Abre a tela de listegem de produtos
    }//GEN-LAST:event_bt_prodActionPerformed

    private void bt_funcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_funcActionPerformed
        new FuncionariosView(pessoaLogada.getNivelAcesso(), loja, this).setVisible(true); //Abre a tela de lsitagem de funcionários
    }//GEN-LAST:event_bt_funcActionPerformed

    private void bt_minhasVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_minhasVendasActionPerformed
        new MinhasVendas(loja).setVisible(true); //Abre a tela de lsitagem de vendas
    }//GEN-LAST:event_bt_minhasVendasActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addProd;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_comprar;
    private javax.swing.JButton bt_deslogar;
    private javax.swing.JButton bt_editLoja;
    private javax.swing.JButton bt_func;
    private javax.swing.JButton bt_minhasVendas;
    private javax.swing.JButton bt_novoFunc;
    private javax.swing.JButton bt_novoProd;
    private javax.swing.JButton bt_prod;
    private javax.swing.JComboBox<String> cb_pagamento;
    private javax.swing.JComboBox<String> cb_produtos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_adm;
    private javax.swing.JLabel lbl_cargoPessoa;
    private javax.swing.JLabel lbl_nomeLoja;
    private javax.swing.JLabel lbl_nomePessoa;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JList<String> list_produtos;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JSpinner sn_quantidade;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(String nome, String motd) {
        //Atualiza a tela com o novo nome da loja
        this.lbl_nomeLoja.setText(nome);
        this.setTitle(nome + " - Administração");
    }
    
    @Override
    public void updateList() {
        //Atualiza os produtos e o nome da pessoa caso seja mudado
        this.loja.getProdutosToCombo(cb_produtos);
        this.lbl_nomePessoa.setText(pessoaLogada.getNome());
    }
    
    public void clean() {
        //Função que limpa a tela
        this.cb_produtos.setSelectedIndex(0);
        this.sn_quantidade.setValue(1);
        this.lbl_total.setText("0,00");
        this.cb_pagamento.setSelectedIndex(0);
        this.listaCompras = new DefaultListModel();
        this.list_produtos.setModel(listaCompras);
        this.venda = new Venda(this.pessoaLogada.getId());
        
        this.loja.putProdutos();
    }
}

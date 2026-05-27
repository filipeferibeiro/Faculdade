package labirintoaleatorio;

import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import labirintoaleatorio.Labirinto.Sala;

public class Game extends javax.swing.JFrame {

    public Game(String playerName, int tam) {
        initComponents();
        //Criando o Objeto player com o nome dado no Home.
        player = new Player(playerName);
        lblPlayerName.setText(player.getPlayerName());
        this.tam = tam;
        //Para setando a janela com o valor mínimo de 890x640.
        setSize(890, 640);
        //Colocando jogo em tela cheia.
        setExtendedState(MAXIMIZED_BOTH);
        
        //Definindo tamanho dos grids baseado na dificuldade escolhida no Home.
        if (tam == 160) {
            gamePanel.setLayout(new java.awt.GridLayout(0, 16));
            this.x = 10;
            this.y = 16;
        }
        else if (tam == 216) {
            gamePanel.setLayout(new java.awt.GridLayout(0, 18));
            this.x = 12;
            this.y = 18;
        }
        else {
            gamePanel.setLayout(new java.awt.GridLayout(0, 20));
            this.x = 14;
            this.y = 20;
        }
        //Criando o Labirinto do tamanho da dificuldade escolhida.
        lab = new Labirinto(tam);
        //Criando a matriz da Interface Gráfica.
        createMatriz(tam); 
        putKeys();
        putTrap();
        putDoor();
        putPlayer();
    }
    
    public void createMatriz(int tam) {
        Sala[] salas = lab.getSalas();
        
        //Criação dos Arrays baseado no tamanho de jogo.
        this.matriz = new JLabel[tam];
        this.personagem = new JLabel[tam];
        this.trapKeyDor = new JLabel[tam];
        
        gamePanel.removeAll();
        
        int cont = 0;
        for (int i = 0; i < tam; i++) {
            //Alocação dos Arrays de MatrizDeJogo, do Personagem e das Armadilhas, Chaves e Portas
            matriz[i] = new JLabel();
            personagem[i] = new JLabel();
            trapKeyDor[i] = new JLabel();
            //Setando tanto a matriz de jogo, quanto a matriz de armadilhas como uma espécie de "Panel"
            matriz[i].setLayout(new java.awt.CardLayout(10, 0));
            trapKeyDor[i].setLayout(new java.awt.CardLayout(0, 0));
            
            if (lab.getSala(i).getQntSala() == 0) {
                matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/back.png"))); 
            }
            
            else if (lab.getSala(i).getQntSala() == 1){
                if (lab.getSala(i).isUp()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/3-c.png")));
                }
                else if (lab.getSala(i).isRight()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/3-d.png")));
                }
                else if (lab.getSala(i).isDown()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/3-b.png")));
                }
                else if (lab.getSala(i).isLeft()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/3-e.png")));
                }
            }
            
            else if (lab.getSala(i).getQntSala() == 2){
                if (lab.getSala(i).isUp() && lab.getSala(i).isRight()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/2-be.png")));
                }
                else if (lab.getSala(i).isUp() && lab.getSala(i).isDown()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/2-cb.png")));
                }
                else if (lab.getSala(i).isUp() && lab.getSala(i).isLeft()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/2-bd.png")));
                }
                else if (lab.getSala(i).isRight()&& lab.getSala(i).isDown()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/2-ce.png")));
                }
                else if (lab.getSala(i).isRight()&& lab.getSala(i).isLeft()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/2-ed.png")));
                }
                else if (lab.getSala(i).isDown()&& lab.getSala(i).isLeft()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/2-cd.png")));
                }
            }
            
            else if (lab.getSala(i).getQntSala() == 3){
                if (!lab.getSala(i).isUp()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/1-cima.png")));
                }
                else if (!lab.getSala(i).isRight()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/1-dir.png")));
                }
                else if (!lab.getSala(i).isDown()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/1-baixo.png")));
                }
                else if (!lab.getSala(i).isLeft()) {
                    matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/1-esq.png")));
                }
            }
            
            else if (lab.getSala(i).getQntSala() == 4){
                matriz[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/def/null.png"))); 
            }
            //Adicionando a cada item de armadilha um campo para o personagem.
            trapKeyDor[i].add(personagem[i]);
            trapKeyDor[i].revalidate();
            trapKeyDor[i].repaint();  
            //Adicionando a cada item da matriz de jogo um campo para armadilha.
            matriz[i].add(trapKeyDor[i]);
            matriz[i].revalidate();
            matriz[i].repaint();
            //Adicionando a Grid cada item da matriz.
            gamePanel.add(matriz[i]);            
        }
        //Atualizando a interface.
        gamePanel.updateUI();
    }
    
    public void addKeys() {
        if (player.getKeys() < 3) {
            player.addKeys();
            lblKeys.setText(player.getKeys() + " / 3");
        }
        if (player.getKeys() == 3){
            lblKeys.setText(player.getKeys() + " / 3");
            lblStatus.setText("Você achou todas as chaves, procure a porta.");
            lblDoorStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Door_25px.png")));
        }
    }
    
    public void removeLife() {
        player.removeLife();
        if (player.getLife() == 2) {
            life1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png")));
            life2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png")));
            life3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_2.png")));
        }
        else if (player.getLife() == 1) {
            life1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png")));
            life2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_2.png")));
            life3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_2.png")));
        }
        else if (player.getLife() == 0) {
            life1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_2.png")));
            life2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_2.png")));
            life3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_2.png")));
            int n = JOptionPane.showConfirmDialog(null, "Suas vidas acabaram :(, deseja jogar novamente?", "Fim de Jogo", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                this.setVisible(false);
                new Home().setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Volte sempre.");
                System.exit(0);
            }
        }
    }
    
    public void doorFounded(int i) {
        lblStatus.setText("Parabéns, você achou a porta!");
        trapKeyDor[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Door_30px.png")));
        lblDoorStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Door_25px.png")));
    }
    
    public void trapFound (int i) {
        trapKeyDor[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Prisoner_30px.png")));
        JOptionPane.showMessageDialog(null, "Você caiu em uma armadilha e perdeu uma vida, que pena :(.");
        removeLife();
    }
    
    public void movePlayer(int i, String position) {
        int pos = player.getPos();
        Sala salas[] = lab.getSalas();
        personagem[pos].setIcon(null);
        if (position.equals("U")) {
            personagem[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/playerU.png")));
        }
        else if (position.equals("D")) {
            personagem[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/playerD.png")));
        }
        else if (position.equals("L")) {
            personagem[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/playerL.png")));
        }
        else if (position.equals("R")) {
            personagem[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/playerR.png")));
        }
        player.setPos(i);
        
        if (salas[i].isTrap()) {
            trapFound(i);
            salas[i].setTrap(false);
        }
    }
    
    public void putKeys() {
        salas = lab.getSalas();
        int j;
        for (int i = 0; i < 3; i++) {
            Random rand = new Random();
            j = rand.nextInt(this.tam);
            salas[j].setKey(true);
            trapKeyDor[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Password_1_30px.png")));
        }
    }
    
    public void putTrap() {
        salas = lab.getSalas();
        int j;
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            j = rand.nextInt(this.tam);
            salas[j].setTrap(true);            
        }
    }
    
    public void putDoor() {
        salas = lab.getSalas();
        int j;
        Random rand = new Random();
        j = rand.nextInt(this.tam);
        salas[j].setExit(true);
        trapKeyDor[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Door_30px.png")));
    }
    
    public void putPlayer() {
        salas = lab.getSalas();
        int j;
        Random rand = new Random();
        j = rand.nextInt(this.tam);
        player.setPos(j);
        personagem[player.getPos()].setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/playerD.png")));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topBar = new javax.swing.JPanel();
        lblPlayerName = new javax.swing.JLabel();
        lblPlayerImg = new javax.swing.JLabel();
        lblKeys = new javax.swing.JLabel();
        life1 = new javax.swing.JLabel();
        life2 = new javax.swing.JLabel();
        life3 = new javax.swing.JLabel();
        lblDoorStatus = new javax.swing.JLabel();
        mainGame = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gamePanel = new javax.swing.JPanel();
        bottonBar = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblQuit = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        topBar.setBackground(new java.awt.Color(33, 125, 25));

        lblPlayerName.setForeground(java.awt.Color.white);
        lblPlayerName.setText("PlayerName");

        lblPlayerImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/playerIMG.png"))); // NOI18N
        lblPlayerImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlayerImgMouseClicked(evt);
            }
        });

        lblKeys.setForeground(new java.awt.Color(255, 255, 255));
        lblKeys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Password_1_25px.png"))); // NOI18N
        lblKeys.setText("0 / 3");
        lblKeys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeysMouseClicked(evt);
            }
        });

        life1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png"))); // NOI18N

        life2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png"))); // NOI18N

        life3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png"))); // NOI18N

        lblDoorStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Door_25pxbw.png"))); // NOI18N

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayerImg)
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPlayerName))
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(life1)
                        .addGap(0, 0, 0)
                        .addComponent(life2)
                        .addGap(0, 0, 0)
                        .addComponent(life3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDoorStatus)))
                .addGap(13, 13, 13)
                .addComponent(lblKeys)
                .addGap(12, 12, 12))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblPlayerImg))
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblPlayerName)
                        .addGap(2, 2, 2)
                        .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(life1)
                            .addComponent(life2)
                            .addComponent(life3))))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKeys)
                    .addComponent(lblDoorStatus))
                .addGap(18, 18, 18))
        );

        mainGame.setBackground(java.awt.Color.white);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        gamePanel.setBackground(new java.awt.Color(255, 255, 255));
        gamePanel.setLayout(new java.awt.GridLayout(0, 16));
        jScrollPane1.setViewportView(gamePanel);

        javax.swing.GroupLayout mainGameLayout = new javax.swing.GroupLayout(mainGame);
        mainGame.setLayout(mainGameLayout);
        mainGameLayout.setHorizontalGroup(
            mainGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainGameLayout.setVerticalGroup(
            mainGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottonBar.setBackground(new java.awt.Color(33, 125, 25));

        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Notification_20px.png"))); // NOI18N
        lblStatus.setText("Bem vindo(a) ao Labirinto");
        lblStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        lblQuit.setForeground(new java.awt.Color(255, 255, 255));
        lblQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Exit_20px.png"))); // NOI18N
        lblQuit.setText("Sair");
        lblQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuitMouseClicked(evt);
            }
        });

        lblRefresh.setForeground(new java.awt.Color(255, 255, 255));
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Refresh_20px.png"))); // NOI18N
        lblRefresh.setText("Atualizar");
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bottonBarLayout = new javax.swing.GroupLayout(bottonBar);
        bottonBar.setLayout(bottonBarLayout);
        bottonBarLayout.setHorizontalGroup(
            bottonBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottonBarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuit)
                .addGap(5, 5, 5))
        );
        bottonBarLayout.setVerticalGroup(
            bottonBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottonBarLayout.createSequentialGroup()
                .addGroup(bottonBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(lblQuit)
                    .addComponent(lblRefresh))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bottonBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(bottonBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblKeysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeysMouseClicked
        
    }//GEN-LAST:event_lblKeysMouseClicked

    private void lblPlayerImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlayerImgMouseClicked
        
    }//GEN-LAST:event_lblPlayerImgMouseClicked

    private void lblQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblQuitMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        salas = lab.getSalas();
        //Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (salas[player.getPos()].isKey()) {
                trapKeyDor[player.getPos()].setIcon(null);
                addKeys();
            }
            else if (salas[player.getPos()].isExit()) {
                if (player.getKeys() == 3) {
                    int n = JOptionPane.showConfirmDialog(null, "Parabéns você achou a porta e ganhou o jogo! Deseja jogar novamente?", "Fim de Jogo", JOptionPane.YES_NO_OPTION);
                    if (n == 0) {
                        this.setVisible(false);
                        new Home().setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Volte sempre.");
                        System.exit(0);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Você ainda não achou todas as chaves para abrir a porta.");
                    lblStatus.setText("Você ainda não achou todas as chaves para abrir a porta.");
                }
                
            }
        }
        //Seta Cima
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (salas[player.getPos()].isUp()) {
                movePlayer(player.getPos() - this.y, "U");
            }
        }
        //Seta Baixo
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (salas[player.getPos()].isDown()) {
                movePlayer(player.getPos() + this.y, "D");
            }
        }
        //Seta Esquerda
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            if (salas[player.getPos()].isLeft()) {
                movePlayer(player.getPos() - 1, "L");
            }
        }
        //Seta Direita
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (salas[player.getPos()].isRight()) {
                movePlayer(player.getPos() + 1, "R");
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        //Criando o Labirinto do tamanho da dificuldade escolhida.
        lab = new Labirinto(tam);
        //Criando a matriz da Interface Gráfica.
        createMatriz(tam); 
        //Resetando os valores para nome, chaves e vidas.
        player = new Player(player.getPlayerName());
        lblKeys.setText(player.getKeys() + " / 3");
        life1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png")));
        life2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png")));
        life3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labirintoaleatorio/images/icons8_Hearts_25px_3.png")));
        
        putKeys();
        putTrap();
        putDoor();
        putPlayer();
    }//GEN-LAST:event_lblRefreshMouseClicked

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottonBar;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoorStatus;
    private javax.swing.JLabel lblKeys;
    private javax.swing.JLabel lblPlayerImg;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblQuit;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel life1;
    private javax.swing.JLabel life2;
    private javax.swing.JLabel life3;
    private javax.swing.JPanel mainGame;
    private javax.swing.JPanel topBar;
    // End of variables declaration//GEN-END:variables
    private Labirinto lab;
    private Player player;
    private JLabel matriz[];
    private JLabel personagem[];
    private JLabel trapKeyDor[];
    private Sala salas[];
    private int x, y, tam;
}
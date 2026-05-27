package Pk_PDR;

import Pk_PDR.Projeto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FazGrafico {
    
    private List<GraficoDeBarras.Dado> dados;
    private static BufferedImage imagem;
    
    public FazGrafico (ArrayList <Projeto> projetos) {
        for (int i = 0; i < projetos.size(); i++) {
            GraficoDeBarras.Dado dado = new GraficoDeBarras.Dado(projetos.get(i).getLinhas(), projetos.get(i).getNome());
            dados.add(dado);
        }
        this.imagem = GraficoDeBarras.desenharTamanhoFixo(500, 180, dados);
        
        mostraImagem(imagem);
    }

    /*public static void main(String[] args) {
        
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }*/

    private static void mostraImagem(BufferedImage imagem) {
        JFrame jf = new JFrame("Pontuação por projeto");
        JPanel jp = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(imagem, 0, 0, null);
            }
        };
        jf.add(jp, BorderLayout.CENTER);
        jp.setPreferredSize(new Dimension(imagem.getWidth(), imagem.getHeight()));
        jf.setResizable(false);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation((screen.width - jf.getWidth()) / 2, (screen.height - jf.getHeight()) / 2);
        jf.setVisible(true);
    }
}
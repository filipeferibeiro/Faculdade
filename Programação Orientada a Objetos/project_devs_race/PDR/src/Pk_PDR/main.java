package Pk_PDR;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
    
    
    
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
    
    public static void linhas (){
        for (int i = 0; i < 200; i++){
            System.out.println("");
        }
    }
    
    public static ArrayList <Projeto> Read () {
        ArrayList <Projeto> proj = null;
        try {
            //carrega o arquivo serializado do disco para o programa
            FileInputStream fin = new FileInputStream("D:\\Documentos\\IFPB\\P3\\PDR\\Git\\project_devs_race\\PDR\\src\\Pk_PDR\\objeto\\projetos.ser");
            
            //lê o objeto contido no arquivo serializado
            ObjectInputStream ois = new ObjectInputStream(fin);
            
            //converte os dados lidos anteriormente em um objeto do tipo
            //Address e o instancia, alocando-o na variável address
            proj = (ArrayList <Projeto>) ois.readObject();
            
            //fecha o objeto responsável por ler o arquivo serializado
            ois.close();
            
            //imprime o objeto "resgatado" do arquivo serializado
            //System.out.println(address);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return proj;
    }
    
    public static void Write(ArrayList <Projeto> proj) {
        try {
            //cria o objeto serializável (o arquivo do objeto) no disco
            FileOutputStream fout = new FileOutputStream("D:\\Documentos\\IFPB\\P3\\PDR\\Git\\project_devs_race\\PDR\\src\\Pk_PDR\\objeto\\projetos.ser");
            
            //instancia o objeto que escreve os dados no arquivo serializável,
            //ou seja, a classe que serializa os objetos
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            
            //do objeto instanciado anteriormente, chamamos o
            //método writeObject, que realiza a escrita do objeto
            //no arquivo serializado
            oos.writeObject(proj);
            
            //fecha o objeto responsável pela escrita no arquivo serializável
            oos.close();
            
            //imprime uma mensagem que informa que o processo foi concluído
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        //Variáveis
        //ListaProjetos projetos = new ListaProjetos();
        ArrayList <Projeto> projetos = new ArrayList<>();
        Scanner sn = new Scanner(System.in);
        String selection;
        
        projetos = Read();
              
        do {
            System.out.println("Bem Vindo ao Projects Dev Race");
            System.out.println("A- Novo Projeto\nB- Listar Projetos\nC- Atualizar Projeto\nD- Remover Projeto\nE- Gráfico de quantidade de linhas\nF- Gráfico de quantidade de Commits\nG- Gráfico de pontuação geral\nH- Sair");
            System.out.print("Seleção: ");
            selection = sn.next();
            
            if (selection.equals("A") || selection.equals("a")) {
                linhas();
                String nome;
                System.out.print("Nome do projeto: ");
                nome = sn.next();
                nome+= sn.nextLine();
                Projeto proj = new Projeto(nome);
                projetos.add(proj);
                Write(projetos);
            }
            else if (selection.equals("B") || selection.equals("b")) {
                linhas();
                String enter;
                int i = projetos.size();
                System.out.println("----------------------------------------");
                for (int j = 0; j < i; j++) {
                    Projeto proj = projetos.get(j);
                    
                    System.out.println("Projeto " + j + ": " + proj.getNome());
                    System.out.println("Commits: " + proj.getCommits());
                    System.out.println("Linhas: " + proj.getLinhas());
                    System.out.println("Pontuação: " + proj.getPontuacao());
                    System.out.println("----------------------------------------");
                }
                
                
            }
            else if (selection.equals("C") || selection.equals("c")) {
                linhas();
                int i;
                System.out.print("Qual a posição referente ao projeto? ");
                i = sn.nextInt();
                if (i < projetos.size()){
                    Projeto proj = projetos.get(i);
                    System.out.println("Novos Commits");
                    i = sn.nextInt();
                    proj.setCommits(proj.getCommits()+i);
                    System.out.println("Novas Linhas");
                    i = sn.nextInt();
                    proj.setLinhas(proj.getLinhas()+i);

                    proj.setPontuacao();

                    Write(projetos);
                }
                else{
                    System.out.println("Índice inválido.");
                }
            }
            
            else if (selection.equals("D") || selection.equals("d")) {
                linhas();
                int i;
                System.out.println("Digite -1 para remover todos.");
                System.out.print("Qual a posição referente ao projeto? ");
                
                i = sn.nextInt();
                if (i < projetos.size() && i > 0){
                    projetos.remove(i);
                    System.out.println("Projeto Removido!");

                    Write(projetos);
                }
                
                else if (i == -1){
                    projetos.removeAll(projetos);
                    System.out.println("Todos os projetos foram removidos!");

                    Write(projetos);
                }
                else{
                    System.out.println("Índice inválido.");
                }
            }
            
            else if (selection.equals("E") || selection.equals("e")) {
                linhas();
                BufferedImage imagem;
                List<GraficoDeBarras.Dado> dados = new ArrayList();
                
                for (int i = 0; i < projetos.size(); i++) {
                    GraficoDeBarras.Dado dado = new GraficoDeBarras.Dado(projetos.get(i).getLinhas(), projetos.get(i).getNome());
                    dados.add(dado);
                }
                imagem = GraficoDeBarras.desenharTamanhoFixo(500, 180, dados);

                mostraImagem(imagem);
            }
            
            else if (selection.equals("F") || selection.equals("f")) {
                linhas();
                BufferedImage imagem;
                List<GraficoDeBarras.Dado> dados = new ArrayList();
                
                for (int i = 0; i < projetos.size(); i++) {
                    GraficoDeBarras.Dado dado = new GraficoDeBarras.Dado(projetos.get(i).getCommits(), projetos.get(i).getNome());
                    dados.add(dado);
                }
                imagem = GraficoDeBarras.desenharTamanhoFixo(500, 180, dados);

                mostraImagem(imagem);
            }
            
            else if (selection.equals("G") || selection.equals("g")) {
                linhas();
                BufferedImage imagem;
                List<GraficoDeBarras.Dado> dados = new ArrayList();
                
                for (int i = 0; i < projetos.size(); i++) {
                    GraficoDeBarras.Dado dado = new GraficoDeBarras.Dado(projetos.get(i).getPontuacao(), projetos.get(i).getNome());
                    dados.add(dado);
                }
                imagem = GraficoDeBarras.desenharTamanhoFixo(500, 180, dados);

                mostraImagem(imagem);
            }
            else if (selection.equals("H") || selection.equals("h")) {
                System.exit(0);
            }
            else {
                System.out.println("Selecione uma opção válida!");
            }
                      
        } while (true);
    }
}

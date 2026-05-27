package Pk_PDR;

import Pk_PDR.Projeto;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class GraficoDeBarras {

    private static final int AZUL = 0xFF99D8EA;
    private static final int VERMELHO = 0xFFEA9999;

    private final int larguraRetangulo;
    private final int alturaRetangulo;
    private final int alturaTotal;
    private final int yBaseBarra;
    private final int xBaseBarra;
    private final int larguraBarra;
    private final int profundidade;
    private final int yRetangulo;
    private final int yRotulo;
    private final int yValor;

    public GraficoDeBarras(
            int larguraRetangulo,
            int alturaRetangulo,
            int alturaTotal,
            int yBase,
            int xBase,
            int larguraBarra,
            int profundidade,
            int yRetangulo,
            int yRotulo,
            int yValor)
    {
        this.larguraRetangulo = larguraRetangulo;
        this.alturaRetangulo = alturaRetangulo;
        this.alturaTotal = alturaTotal;
        this.yBaseBarra = yBase;
        this.xBaseBarra = xBase;
        this.larguraBarra = larguraBarra;
        this.profundidade = profundidade;
        this.yRetangulo = yRetangulo;
        this.yRotulo = yRotulo;
        this.yValor = yValor;
    }

    private static class Barra {
        private final int alturaBarra;
        private final int cor;
        private final String valor;
        private final String rotulo;

        public Barra(int alturaBarra, int cor, String valor, String rotulo) {
            this.alturaBarra = alturaBarra;
            this.cor = (cor & 0x00FFFFFF) | 0xFF000000; // Elimina a transparência.
            this.valor = valor;
            this.rotulo = rotulo;
        }

        public void desenhar(GraficoDeBarras grafico, int x, int y, Graphics2D g) {
            g.setColor(Color.BLACK);
            Color preenchimento = new Color(cor);

            // Desenha as bordas externas.
            int x1 = x;
            int x2 = x + grafico.larguraRetangulo - 1;
            int y1 = y + grafico.yRetangulo;
            int y2 = y + grafico.yRetangulo + grafico.alturaRetangulo - 1;
            g.drawLine(x1, y1, x2, y1);
            g.drawLine(x1, y1, x1, y2);
            g.drawLine(x2, y1, x2, y2);
            g.drawLine(x1, y2, x2, y2);

            // Prepara o desenho das barras 3d.
            int xBarra1 = x1 + grafico.xBaseBarra;
            int xBarra2 = x1 + grafico.xBaseBarra + grafico.larguraBarra;
            int yBarra1 = y1 + grafico.yBaseBarra;
            int yBarra2 = y1 + grafico.yBaseBarra - alturaBarra;

            // Se a altura for negativa, precisará inverter o yBarra2 e o yBarra1.
            if (yBarra2 > yBarra1) {
                int t = yBarra2;
                yBarra2 = yBarra1;
                yBarra1 = t;
            }

            // Desenha as bordas frontais das barras 3d.
            int[] xFrente = {xBarra1, xBarra1, xBarra2, xBarra2};
            int[] yFrente = {yBarra1, yBarra2, yBarra2, yBarra1};
            g.setColor(preenchimento);
            g.fillPolygon(xFrente, yFrente, 4);
            g.setColor(Color.BLACK);
            g.drawPolygon(xFrente, yFrente, 4);

            // Desenha as bordas laterais das barras 3d.
            int[] xLateral = {xBarra2, xBarra2, xBarra2 + grafico.profundidade, xBarra2 + grafico.profundidade};
            int[] yLateral = {yBarra1, yBarra2, yBarra2 - grafico.profundidade, yBarra1 - grafico.profundidade};
            g.setColor(preenchimento);
            g.fillPolygon(xLateral, yLateral, 4);
            g.setColor(Color.BLACK);
            g.drawPolygon(xLateral, yLateral, 4);

            // Desenha as bordas superiores das barras 3d.
            int[] xSuperior = {xBarra1, xBarra1 + grafico.profundidade, xBarra2 + grafico.profundidade, xBarra2};
            int[] ySuperior = {yBarra2, yBarra2 - grafico.profundidade, yBarra2 - grafico.profundidade, yBarra2};
            g.setColor(preenchimento);
            g.fillPolygon(xSuperior, ySuperior, 4);
            g.setColor(Color.BLACK);
            g.drawPolygon(xSuperior, ySuperior, 4);

            // Escreve os valores e os rótulos.
            FontMetrics fm = g.getFontMetrics();
            int larguraValor = fm.charsWidth(valor.toCharArray(), 0, valor.length());
            int larguraRotulo = fm.charsWidth(rotulo.toCharArray(), 0, rotulo.length());
            g.drawString(valor, x + (grafico.larguraRetangulo - larguraValor) / 2, y + grafico.yValor);
            g.drawString(rotulo, x + (grafico.larguraRetangulo - larguraRotulo) / 2, y + grafico.yRotulo);
        }
    }

    private BufferedImage desenharBarras(List<Barra> barras) {
        BufferedImage bi = new BufferedImage((larguraRetangulo - 1) * barras.size() + 1, alturaTotal, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        int x = 0;
        for (Barra b : barras) {
            b.desenhar(this, x, 0, g);
            x += larguraRetangulo - 1;
        }
        return bi;
    }

    public static final class Dado {
        private final int valor;
        private final String rotulo;

        public Dado(int valor, String rotulo) {
            this.valor = valor;
            this.rotulo = rotulo;
        }

        public int getValor() {
            return valor;
        }

        public String getRotulo() {
            return rotulo;
        }
    }

    public static BufferedImage desenhar(int alturaTotalDasBarras, List<Dado> dados) {
        if (dados == null || dados.isEmpty()) {
            throw new IllegalArgumentException("Só é possível gerar gráficos de listas com itens.");
        }
        if (alturaTotalDasBarras < 2) {
            throw new IllegalArgumentException("A altura total das barras 3d deve conter pelo menos 2.");
        }

        // Define detalhes fixos das dimensões do gráfico.
        int larguraBarra = 40;
        int profundidade = 10;
        int margem = 10;
        int yRetangulo = 20;

        // Encontra o maior e o menor valor e o tamanho da faixa de valores. Sempre considerando que 0 está dentro desta faixa.
        int max = 0;
        int min = 0;
        for (Dado d : dados) {
            int valor = d.getValor();
            if (valor > max) max = valor;
            if (valor < min) min = valor;
        }
        int variacao = Math.max(1, max - min); // Elimina a divisão por 0.

        // Calcula a altura da barra 3d
        List<Barra> lista = new ArrayList<Barra>(dados.size());
        for (Dado d : dados) {
            int valor = d.getValor();
            int altura = (int) (((double) valor) * alturaTotalDasBarras / variacao);
            Barra barra = new Barra(altura, valor >= 0 ? AZUL : VERMELHO, String.valueOf(d.getValor()), d.getRotulo());
            lista.add(barra);
        }

        // Recalcula os tamanhos das barras em pixels no lugars dos valores passados.
        int maxPixels = (int) (((double) max) * alturaTotalDasBarras / variacao);
        int minPixels = (int) (((double) min) * alturaTotalDasBarras / variacao);
        int variacaoPixels = Math.max(1, maxPixels - minPixels); 

        // Faz o cálculo do resto do gráfico.
        int larguraRetangulo = larguraBarra + profundidade + 2 * margem;
        int alturaRetangulo = variacaoPixels + profundidade + 2 * margem;
        int alturaTotal = alturaRetangulo + 40;
        int yBase = alturaRetangulo + minPixels - margem;
        int yRotulo = yRetangulo - 4;
        int yValor = alturaTotal - 4;

        // Desenha o gráfico.
        GraficoDeBarras g = new GraficoDeBarras(larguraRetangulo, alturaRetangulo, alturaTotal, yBase, margem, larguraBarra, profundidade, yRetangulo, yRotulo, yValor);
        return g.desenharBarras(lista);
    }

    public static BufferedImage desenharTamanhoFixo(int larguraTotal, int alturaTotal, List<Dado> dados) {
        if (dados == null || dados.isEmpty()) {
            throw new IllegalArgumentException("Apenas uma lista de dados não-vazia pode ter um gráfico gerado.");
        }

        int profundidade = 10;
        int margem = 10;
        int yRetangulo = 20;

        int alturaRetangulo = alturaTotal - 40;
        int alturaTotalDasBarras = alturaRetangulo - profundidade - 2 * margem;
        if (alturaTotalDasBarras <= 1) throw new IllegalArgumentException("Altura insuficiente.");
        int larguraRetangulo = 1 + ((larguraTotal - 1) / dados.size());
        int larguraBarra = larguraRetangulo - profundidade - 2 * margem;
        if (larguraBarra <= 1) throw new IllegalArgumentException("Largura insuficiente.");

        // Encontra o maior e o menor valor e o tamanho da faixa de valores. Sempre considerando que 0 está dentro desta faixa.
        int max = 0;
        int min = 0;
        for (Dado d : dados) {
            int valor = d.getValor();
            if (valor > max) max = valor;
            if (valor < min) min = valor;
        }
        int variacao = Math.max(1, max - min);

        // Crua as barras 3d
        List<Barra> lista = new ArrayList<Barra>(dados.size());
        for (Dado d : dados) {
            int valor = d.getValor();
            int altura = (int) (((double) valor) * alturaTotalDasBarras / variacao);
            Barra barra = new Barra(altura, valor >= 0 ? AZUL : VERMELHO, String.valueOf(d.getValor()), d.getRotulo());
            lista.add(barra);
        }

        // Recalcula os tamanhos das barras em pixels no lugar dos valores passados.
        int minPixels = (int) (((double) min) * alturaTotalDasBarras / variacao);

        // Monta o resto do gráfico.
        int yBase = alturaRetangulo + minPixels - margem;
        int yRotulo = yRetangulo - 4;
        int yValor = alturaTotal - 4;

        // Desenha o gráfico.
        GraficoDeBarras g = new GraficoDeBarras(larguraRetangulo, alturaRetangulo, alturaTotal, yBase, margem, larguraBarra, profundidade, yRetangulo, yRotulo, yValor);
        return g.desenharBarras(lista);
    }
}
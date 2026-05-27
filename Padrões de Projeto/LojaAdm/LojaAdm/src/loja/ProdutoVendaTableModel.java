package loja;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProdutoVendaTableModel extends AbstractTableModel {
    private ArrayList<Produto> produtos;
    private ArrayList<Integer> quant;
    private String[] colunas = {"Nome", "Preço", "Quantidade", "Total"};

    public ProdutoVendaTableModel(ArrayList<Produto> produtos, ArrayList<Integer> quant) {
        this.produtos = produtos;
        this.quant = quant;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return this.produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return produtos.get(rowIndex).getNome();
            case 1:
                return "R$" + String.format("%,.2f", produtos.get(rowIndex).getValor());
            case 2:
                return quant.get(rowIndex);
            case 3:
                return "R$" + String.format("%,.2f", (produtos.get(rowIndex).getValor() * quant.get(rowIndex)));
        }
        
        return null;
    }
    
}
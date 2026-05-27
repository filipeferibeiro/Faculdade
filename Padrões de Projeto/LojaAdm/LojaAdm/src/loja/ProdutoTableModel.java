package loja;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {
    private ArrayList<Produto> produtos;
    private String[] colunas = {"ID", "Nome", "Preço", "Estoque"};

    public ProdutoTableModel(ArrayList<Produto> produtos) {
        this.produtos = produtos;
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
                return produtos.get(rowIndex).getId();
            case 1:
                return produtos.get(rowIndex).getNome();
            case 2:
                return "R$" + String.format("%,.2f", produtos.get(rowIndex).getValor());
            case 3:
                return produtos.get(rowIndex).getEstoque();
        }
        
        return null;
    }
    
}

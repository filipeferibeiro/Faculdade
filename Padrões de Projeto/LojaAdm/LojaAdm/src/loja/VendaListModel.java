package loja;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class VendaListModel extends AbstractListModel {
    private ArrayList<Venda> vendas;

    public VendaListModel(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public int getSize() {
        return vendas.size();
    }

    @Override
    public Object getElementAt(int index) {
        return "Nº" + vendas.get(index).getId_venda() + " - " + vendas.get(index).getPagamento();
    }
    
}

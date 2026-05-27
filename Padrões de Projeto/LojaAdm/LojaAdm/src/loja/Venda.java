package loja;

import java.sql.Date;
import java.util.ArrayList;

public class Venda {
    private int id_func, id_venda;
    private String pagamento;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Integer> quant = new ArrayList<>();

    public Venda(int id_func) {
        this.id_func = id_func;
    }    

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public int getId_func() {
        return id_func;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Integer> getQuant() {
        return quant;
    }    

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getValor() * quant.get(i);
        }
        
        return total;
    }
    
    public int getTotalItens() {
        return this.produtos.size();
    }
}

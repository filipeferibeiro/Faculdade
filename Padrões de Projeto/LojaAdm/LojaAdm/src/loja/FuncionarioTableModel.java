package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTableModel extends AbstractTableModel {
    private HashMap<Integer, Funcionario> funcionarios;
    private ArrayList<Funcionario> funcionariosArray = new ArrayList<>();
    private String[] colunas = {"ID", "Nome", "Login", "Senha", "E-mail", "Nível de Acesso"};

    public FuncionarioTableModel(HashMap<Integer, Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
        
        //Adiciona os funcionários em um arraylist, para melhor iterar
        for (Map.Entry<Integer, Funcionario> entry : funcionarios.entrySet()) {
            Funcionario funcionario = entry.getValue();
            funcionariosArray.add(funcionario);           
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return this.funcionariosArray.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return funcionariosArray.get(rowIndex).getId();
            case 1:
                return funcionariosArray.get(rowIndex).getNome();
            case 2:
                return funcionariosArray.get(rowIndex).getLogin();
            case 3:
                return funcionariosArray.get(rowIndex).getSenha();
            case 4:
                return funcionariosArray.get(rowIndex).getEmail();
            case 5:
                return funcionariosArray.get(rowIndex).getNivelAcesso();
        }
        
        return null;
    }
    
}

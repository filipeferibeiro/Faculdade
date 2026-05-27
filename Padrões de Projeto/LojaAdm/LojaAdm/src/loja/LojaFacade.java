package loja;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;

public class LojaFacade {
    private int id, id_logado;
    private String nome, motd;
    private HashMap<Integer, Funcionario> funcionarios = new HashMap<>();
    private ArrayList<Produto> produtos = new ArrayList<>();
    private LojaInfoMemento lojaInfoMemento;
    
    private SQLConnectSingleton db = SQLConnectSingleton.getInstance(); //Instancia o banco de dados
    
    public LojaFacade() {
        //Faz a configuração inicial da aplicação
        createTables();  
        putLoja();
        putFuncionarios();
        putProdutos();
    }

    public int getId_logado() {
        return id_logado;
    }

    public void setId_logado(int id_logado) {
        this.id_logado = id_logado;
    }

    public void setLojaInfoMemento(LojaInfoMemento lojaInfoMemento) {
        this.lojaInfoMemento = lojaInfoMemento;
    }

    public LojaInfoMemento getLojaInfoMemento() {
        LojaInfoMemento memento = this.lojaInfoMemento;
        this.lojaInfoMemento = null;
        
        return memento;
    }   
    
    public LojaInfoMemento getLojaInfoMementoState() {
        return this.lojaInfoMemento;
    }   

    public HashMap<Integer, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMotd() {
        return motd;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public void createTables() {
        boolean connected = false;
        
        try {
            connected = db.connect();
            Statement stmt = db.createStatement();
            
            stmt.execute("CREATE TABLE IF NOT EXISTS Loja"
                    + "("
                    + "id integer PRIMARY KEY AUTOINCREMENT,"
                    + "nome text,"
                    + "motd text"
                    + ");");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS Funcionario"
                    + "("
                    + "id integer PRIMARY KEY AUTOINCREMENT,"
                    + "nome text,"
                    + "login text UNIQUE,"
                    + "senha text,"
                    + "email text UNIQUE,"
                    + "nivelAcesso text DEFAULT 'Funcionário',"
                    + "id_loja integer,"
                    + "FOREIGN KEY (id_loja) REFERENCES Loja(id)"
                    + ");");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS Produto"
                    + "("
                    + "id integer PRIMARY KEY AUTOINCREMENT,"
                    + "nome text,"
                    + "valor double precision,"
                    + "estoque integer,"
                    + "id_loja integer,"
                    + "FOREIGN KEY (id_loja) REFERENCES Loja(id)"
                    + ");");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS VendaFunc"
                    + "("
                    + "id integer PRIMARY KEY AUTOINCREMENT,"
                    + "id_func integer,"
                    + "pagamento text,"
                    + "FOREIGN KEY (id_func) REFERENCES Funcionario(id)"
                    + ");");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS ProdVenda"
                    + "("
                    + "id_venda integer,"
                    + "id_prod integer,"
                    + "quantidade integer,"
                    + "FOREIGN KEY (id_venda) REFERENCES VendaFunc(id),"
                    + "FOREIGN KEY (id_prod) REFERENCES Produto(id)"
                    + ");");
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public void addFuncionario(String nome, String login, String senha, String email, String nivelAcesso, int id_loja) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("INSERT INTO Funcionario"
                + "("
                + "nome,"
                + "login,"
                + "senha,"
                + "email,"
                + "nivelAcesso,"
                + "id_loja)"
                + " VALUES(?, ?, ?, ?, ?, ?);");            
            
        try {
            pstmt.setString(1, nome);
            pstmt.setString(2, login);
            pstmt.setString(3, senha);
            pstmt.setString(4, email);
            pstmt.setString(5, nivelAcesso);
            pstmt.setInt(6, id_loja);
            
            int resultado = pstmt.executeUpdate();
            
            if (resultado == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                
                this.funcionarios.put(id, new Funcionario(id, nome, login, senha, email, nivelAcesso, id_loja));
            }
            else {
                System.out.println("Problema ao inserir.");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public void addProduto(String nome, double valor, int estoque) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("INSERT INTO Produto"
                + "("
                + "nome,"
                + "valor,"
                + "estoque,"
                + "id_loja)"
                + " VALUES(?, ?, ?, ?);");            
            
        try {
            pstmt.setString(1, nome);
            pstmt.setDouble(2, valor);
            pstmt.setInt(3, estoque);
            pstmt.setInt(4, this.id);
            
            int resultado = pstmt.executeUpdate();
            
            
            if (resultado == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                
                this.produtos.add(new Produto(id, this.id, estoque, nome, valor));
            }
            else {
                System.out.println("Problema ao inserir.");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public void novaLoja(String nome, String motd) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("INSERT INTO Loja"
                + "("
                + "nome,"
                + "motd)"
                + " VALUES(?, ?);");            
            
        try {
            pstmt.setString(1, nome);
            pstmt.setString(2, motd);
            
            int resultado = pstmt.executeUpdate();
            
            
            if (resultado == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                
                this.id = id;
                this.nome = nome;
                this.motd = motd;
                
            }
            else {
                System.out.println("Problema ao criar loja.");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public void novaVenda(Venda venda, PagamentoCommand pagamento) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("INSERT INTO VendaFunc"
                + "("
                + "id_func,"
                + "pagamento)"
                + " VALUES(?, ?);");  
        
        PreparedStatement pstmt2 = db.createPrepareStatement("INSERT INTO ProdVenda"
                + "("
                + "id_venda,"
                + "id_prod,"
                + "quantidade)"
                + " VALUES(?, ?, ?);");  
        
        PreparedStatement pstmt3 = db.createPrepareStatement("UPDATE Produto "
                + "SET "
                + "estoque = ?"
                + " WHERE id = ?;");
            
        try {
            pstmt.setInt(1, venda.getId_func());
            pstmt.setString(2, venda.getPagamento());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            int id = rs.getInt(1);
            
            for (int i = 0; i < venda.getProdutos().size(); i++) {
                pstmt2.setInt(1, id);
                pstmt2.setInt(2, venda.getProdutos().get(i).getId());
                pstmt2.setInt(3, venda.getQuant().get(i));
                
                pstmt3.setInt(1, venda.getProdutos().get(i).getEstoque());
                pstmt3.setInt(2, venda.getProdutos().get(i).getId());
                
                pstmt2.executeUpdate();
                pstmt3.executeUpdate();
            }
            
            venda.setId_venda(id);
            
            pagamento.compra(venda);
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public void putFuncionarios() {
        boolean connected = false;
        
        try {
            connected = db.connect();
            Statement stmt = db.createStatement();
                        
            ResultSet rs = stmt.executeQuery("SELECT * FROM Funcionario;");
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String email = rs.getString("email");
                String nivelAcesso = rs.getString("nivelAcesso");
                int id_loja = rs.getInt("id_loja");
                
                this.funcionarios.put(id, new Funcionario(id, nome, login, senha, email, nivelAcesso, id_loja));
            }
            
        } catch (SQLException e) {
        System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public void putLoja() {
        boolean connected = false;
        
        try {
            connected = db.connect();
            Statement stmt = db.createStatement();
                        
            ResultSet rs = stmt.executeQuery("SELECT * FROM Loja;");
            
            rs.next();
            
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String motd = rs.getString("motd");
            
            this.id = id;
            this.nome = nome;
            this.motd = motd;
            
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(this.nome);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public void putProdutos() {
        boolean connected = false;
        this.produtos = new ArrayList<>();
        
        try {
            connected = db.connect();
            Statement stmt = db.createStatement();
                        
            ResultSet rs = stmt.executeQuery("SELECT * FROM Produto;");
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double valor = rs.getDouble("valor");
                int estoque = rs.getInt("estoque");
                int id_loja = rs.getInt("id_loja");
                
                this.produtos.add(new Produto(id, id_loja, estoque, nome, valor));
            }
            
        } catch (SQLException e) {
        System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
    }
    
    public ArrayList<Venda> putVendas(int id) {
        ArrayList<Venda> vendas = new ArrayList<>();
        
        boolean connected = false;
        
        try {
            connected = db.connect();
            PreparedStatement stmt = db.createPrepareStatement("SELECT * FROM VendaFunc"
                    + " WHERE id_func = ?;");
            
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id_venda = rs.getInt("id");
                int id_func = rs.getInt("id_func");
                String pagamento = rs.getString("pagamento");
                
                Venda venda = new Venda(id_func);
                venda.setId_venda(id_venda);
                venda.setPagamento(pagamento);
                
                PreparedStatement stmt2 = db.createPrepareStatement("SELECT * FROM ProdVenda"
                    + " WHERE id_venda = ?;");
            
                stmt2.setInt(1, id_venda);
                
                ResultSet rs2 = stmt2.executeQuery();
                
                while(rs2.next()) {
                    int id_prod = rs2.getInt("id_prod");
                    int quant = rs2.getInt("quantidade");
                    
                    for (int i = 0; i < this.produtos.size(); i++) {
                        if (this.produtos.get(i).getId() == id_prod) {
                            venda.getQuant().add(quant);
                            venda.getProdutos().add(this.produtos.get(i));
                        }
                    }
                }
                vendas.add(venda);
            }            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                db.disconnect();
            }
        }
        return vendas;
    }
    
    public Funcionario login(String login, String senha) {
        for (Map.Entry<Integer, Funcionario> entry : funcionarios.entrySet()) {
            Funcionario funcionario = entry.getValue();
            if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
                this.id_logado = funcionario.getId();
                return funcionario;
            }
            
        }
        return null;
    }
    
    public void getProdutosToCombo(JComboBox produtosCombo) {
        produtosCombo.removeAllItems();
        for (int i = 0; i < produtos.size(); i++) {
            produtosCombo.addItem(produtos.get(i).getNome() + " R$" + String.format("%,.2f", produtos.get(i).getValor()));
        }
    }
    
    public void editLoja(String nome, String motd) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("UPDATE Loja "
                + "SET "
                + "nome = ?,"
                + "motd = ?"
                + " WHERE id = ?;");            
            
        try {
            pstmt.setString(1, nome);
            pstmt.setString(2, motd);
            pstmt.setInt(3, this.id);
            
            pstmt.executeUpdate();
            
            this.nome = nome;
            this.motd = motd;
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                try {
                    pstmt.close();
                    db.disconnect();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
    
    public void editProduto(int id, String nome, double valor, int estoque, Produto produto) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("UPDATE Produto "
                + "SET "
                + "nome = ?,"
                + "valor = ?,"
                + "estoque = ?"
                + " WHERE id = ?;");            
            
        try {
            pstmt.setString(1, nome);
            pstmt.setDouble(2, valor);
            pstmt.setInt(3, estoque);
            pstmt.setInt(4, id);
            
            pstmt.executeUpdate();
            
            produto.setNome(nome);
            produto.setValor(valor);
            produto.setEstoque(estoque);
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                try {
                    pstmt.close();
                    db.disconnect();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
    
    public void editFuncionario(int id, String nome, String login, String senha, String email, String nivelAcesso, Funcionario funcionario) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("UPDATE Funcionario "
                + "SET "
                + "nome = ?,"
                + "login = ?,"
                + "senha = ?,"
                + "email = ?,"
                + "nivelAcesso = ?"
                + " WHERE id = ?;");            
            
        try {
            pstmt.setString(1, nome);
            pstmt.setString(2, login);
            pstmt.setString(3, senha);
            pstmt.setString(4, email);
            pstmt.setString(5, nivelAcesso);
            pstmt.setInt(6, id);
            
            pstmt.executeUpdate();
            
            funcionario.setNome(nome);
            funcionario.setLogin(login);
            funcionario.setSenha(senha);
            funcionario.setEmail(email);
            funcionario.setNivelAcesso(nivelAcesso);
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                try {
                    pstmt.close();
                    db.disconnect();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
    
    public void deleteProduto(int id, Produto produto) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("DELETE FROM Produto " 
                + " WHERE id = ?;");            
            
        try {
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
            this.produtos.remove(produto);
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                try {
                    pstmt.close();
                    db.disconnect();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
    
    public void deleteFuncionario(int id, Funcionario funcionario) {
        boolean connected = false;
        connected = db.connect();
            
        PreparedStatement pstmt = db.createPrepareStatement("DELETE FROM Funcionario " 
                + " WHERE id = ?;");            
            
        try {
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
            this.funcionarios.remove(id);
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (connected) {
                try {
                    pstmt.close();
                    db.disconnect();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

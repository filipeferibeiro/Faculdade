package loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectSingleton {
    private static SQLConnectSingleton instance;
    private Connection connection;
    
    private SQLConnectSingleton() {
        
    }
    
    public static SQLConnectSingleton getInstance() {
        if (instance == null) {
            instance = new SQLConnectSingleton();
        }
        
        return instance;
    }
    
    public boolean connect() {
        try { 
            String path = "jdbc:sqlite:banco.db";
            
            this.connection = DriverManager.getConnection(path);
            
        } catch(SQLException e) {
            System.err.println(e.getErrorCode());
            return false;
        }
        
        return true;
    }
    
    public boolean disconnect() {
        try {
            if (this.connection.isClosed() == false) {
                this.connection.close();
            }
        } catch(SQLException e) {
            System.err.println(e.getErrorCode());
            return false;
        }
        
        return true;
    }
    
    public Statement createStatement() {
        try {
            return this.connection.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public PreparedStatement createPrepareStatement(String sql) {
        try {
            return this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    
}

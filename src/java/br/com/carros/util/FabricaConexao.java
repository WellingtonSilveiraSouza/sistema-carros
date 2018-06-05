package br.com.carros.util;
// Importando as bibliotecas necessarias para conectar com o banco
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {
    // Criando parametro que recebera a conexao com o banco
    private static Connection conexao;
    // Definindo os parametros para conexao com o banco
    private static final String URL_CONEXAO = "jdbc:mysql://localhost://sistema-carros";
    private static final String USER = "root";
    private static final String PASSWORD = null;
    
// O metodo abaixo abri a conexao com o banco
    public static Connection getConexao() {
        if (conexao == null) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conexao = DriverManager.getConnection(URL_CONEXAO,USER,PASSWORD);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }
    // Metodo para fechar a conexao com o banco
    public static void fecharConexao(){
        if(conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexao = null;
        }
    }
}

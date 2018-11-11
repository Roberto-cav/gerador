package br.com.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static String status = "Não conectou ";
	
	public ConexaoMySQL() {
		
	}
	
	public static java.sql.Connection getConnectionMySQL() {
		Connection connection = null;
		System.out.println("Abrindo conexão com o banco de dados");
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost:3306";
			String database   = "oper21";
			String url = "jdbc:mysql://"+ serverName + "/" + database;
			String userName = "root";
			String password = "1234";
			
			connection = DriverManager.getConnection(url, userName, password);
			
			if (connection != null) {
				status = ("STATUS-->Conectado com sucesso!");
			} else {
				status = ("STATUS-->Não foi possível realizar a conexão");
			}
			System.out.println("Conexão aberta!");
			return connection;
		} catch(ClassNotFoundException e) {
			System.out.println("O driver especificado não foi encontrado!!");
			return null;
		} catch(SQLException e ) {
			System.out.println("O driver especificado não foi encontrado!!");
			return null;
		}
	}
	
	public static String statusConnection() {
		return status;
	}
	
	public static boolean FecharConexao() {
		System.out.println("Fechando conexão!!");
		try {

			ConexaoMySQL.getConnectionMySQL().close();
			System.out.println("Conexão fechada!!");
			return true;
        } catch (SQLException e) {
            return false;
        }
	 
    }
	
}

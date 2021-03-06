package br.com.livro.domain;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;


public class BaseDAO {
	
	public BaseDAO() {
		try {
			//Necess�rio para utilizar o driver JDBC do MySQL
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// Erro no driver JDBC (adicione o driver .jar do MySQL em /WEB-INF/lib)
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException {
		
		//URL de conex�o com o banco de dados
		String url = "jdbc:mysql://localhost/livro";
		
		// Conecta utilizando a URL, usu�rio e senha
		Connection conn = DriverManager.getConnection(url, "livro", "dev123");
		
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		BaseDAO db = new BaseDAO();
		
		//Testa conex�o 
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}

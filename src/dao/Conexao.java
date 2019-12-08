package dao;

import java.sql.*;

public class Conexao {
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/trello?useSSL=false", "root", "");
		} catch(Exception e) {
			System.err.println("Falha: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
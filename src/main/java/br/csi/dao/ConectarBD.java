package br.csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBD {
	public static Connection getConexao() {

		Connection conn = null;
		
		String host = "localhost";
		String database = "zsuperBD";
		String user = "postgres";
		String password = "vbs";
		
		String url = "jdbc:postgresql://" +host +":5432/" +database;

		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}

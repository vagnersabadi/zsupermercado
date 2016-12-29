package br.csi.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarPostGressFactory {

	
	public static void main(String args[]){
		ConectarPostGressFactory.getConexao();
		System.out.println("conexao aberta!");
	}
	
	public static Connection getConexao(){
		Connection c = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			String url ="jdbc:postgresql://localhost:5432/zsuperBD";
			String user = "postgres";
			String password = "vbs";
			c = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
}

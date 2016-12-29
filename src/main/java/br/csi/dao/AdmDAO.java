package br.csi.dao;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.ContentModelContainer;

import br.csi.model.util.ConectarPostGressFactory;
import br.csi.modelo.Adm;
import br.csi.modelo.Cliente;
import br.csi.modelo.Mercado;
import br.csi.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.text.StyledEditorKit.BoldAction;

public class AdmDAO {
	private Connection conn = (Connection) ConectarPostGressFactory.getConexao();
	private PreparedStatement stmt;
	private boolean autenticado = false;
	private String sql;
  
	public int LOGAR(Adm a) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "select id from login where nome =? and senha=?";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);
		pstmt.setString(1, a.getNome());
		pstmt.setString(2, a.getSenha());

		int id=0;
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();
		id = resultSet.getInt("id");
		a.setCodigo(id);
		//a.codigo=id;
		System.out.println("%%%Codigo%%"+id);

		if (id > 0)
			return id;
		else
			return 0;

	}
	public boolean VerificaAdm(Adm a) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "Select count(1) from login where nome = ? and senha = ?";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);
		pstmt.setString(1, a.getNome());
		pstmt.setString(2, a.getSenha());
		ResultSet resultSet = pstmt.executeQuery();
		
		 if(resultSet.next())
		      return (resultSet.getInt(1) > 0);
		  else
		      return false;


	}
	/*
	public Adm LOGAR(Adm a) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "select id from login where nome =? and senha=?";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);
		pstmt.setString(1, a.getNome());
		pstmt.setString(2, a.getSenha());

		int id=0;
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();
		id = resultSet.getInt("id");
		a.setCodigo(id);
		//a.codigo=id;
		System.out.println("%%%Codigo%%"+a.getCodigo());
		
			return a;

	}*/
	public boolean EditarMercado(Adm a,Mercado m) {
		boolean retorno = false;
		Connection c = null;
		PreparedStatement stmt = null;
		c = ConectarPostGressFactory.getConexao();
		// Adm a=new Adm();

		try {

			String sql = "";
			
				System.out.println("......... vai alterar ADM ............."+ a.getCodigo());
				System.out.println("......... vai alterar MERCADO ............."+m.getCodigo());

				sql = "UPDATE login SET nome =?, senha=? WHERE id =" + a.getCodigo() + ";"
						+ "UPDATE mercado SET nome =?, endereco=? WHERE codigo =" + m.getCodigo() + ";";
				
				stmt = c.prepareStatement(sql);
				stmt.setString(1, a.getNome());
				stmt.setString(2, a.getSenha());
				stmt.setString(3, m.getSupermercado());
				stmt.setString(4, m.getEndereco());

			stmt.execute();

			stmt.close();
			retorno = true;

		} catch (Exception e) {
			e.printStackTrace();
			return retorno;

		}

		return retorno;

	}
	public Adm BuscarAdm(Adm a) {
		System.out.println("dentro do BuscarAdm");
		try {

			PreparedStatement stmt = ConectarPostGressFactory.getConexao().prepareStatement("select  l.nome, l.senha "
					+ "from  login l  WHERE  l.id=?");
			stmt.setLong(1, a.getCodigo());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				a.setNome(rs.getString("nome"));
				a.setSenha(rs.getString("senha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}
	public boolean EditarAdm(Adm a,Mercado m) {
		boolean retorno = false;
		Connection c = null;
		PreparedStatement stmt = null;
		c = ConectarPostGressFactory.getConexao();
		// Adm a=new Adm();

		try {

			String sql = "";
			
				System.out.println("......... vai alterar ADM ............."+ a.getCodigo());
				System.out.println("......... vai alterar ADM ............."+m.getCodigo());

				sql = "UPDATE login SET nome =?, senha=? WHERE id =" + a.getCodigo() + ";";
				
				stmt = c.prepareStatement(sql);
				stmt.setString(1, a.getNome());
				stmt.setString(2, a.getSenha());


			stmt.execute();

			stmt.close();
			retorno = true;

		} catch (Exception e) {
			e.printStackTrace();
			return retorno;

		}

		return retorno;

	}
	public int BuscaID(Adm a) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "select id from login where nome =? and senha=?";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);
		pstmt.setString(1, a.getNome());
		pstmt.setString(2, a.getSenha());

		int id=0;
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();
		id = resultSet.getInt("id");
		a.setCodigo(id);
		//a.codigo=id;
		System.out.println("%%%Codigo%%"+a.getCodigo());
		
			return a.getCodigo();

	}
	public Adm BuscaAdm(Adm a,int id) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "select * from login where id="+id+";";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);

		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();
		
		a.setNome(resultSet.getString("nome"));
		a.setSenha(resultSet.getString("senha"));

		a.setCodigo(id);
		
		System.out.println("%%%Nome%%"+a.getNome());
		System.out.println("%%%Codigo com get%%"+a.getCodigo());
		System.out.println("%%%Codigo com id%%"+id);

		
			return a;

	}


	
	public boolean cadastrarAdm (Adm a,Mercado m) throws Exception{
		//Mercado mm = new Mercado();
				
		sql = " BEGIN; "  // inicio da transa��o
			+ " insert into login(nome,senha) values (?,?); ";  // primeiro inseri na tabela produtos
		
			sql = sql + " INSERT INTO mercado(nome,codigo_adm,endereco) "
					  + " values (?,(select max(id) from login),?);  ";
		
		sql = sql + " COMMIT; ";  // fecha transa��o
		
		stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, a.getNome());
		stmt.setString(2, a.getSenha());
		stmt.setString(3, m.getSupermercado());
		stmt.setString(4, m.getEndereco());
		
		try{
			stmt.execute();
			
			autenticado = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return autenticado;
	}
	
public boolean ExcluirAdm (Adm a) throws Exception{
		
		// Apaga primeiro  tabelas dependentes e depois na tabela login
		sql = "	BEGIN; "
				+ "DELETE FROM carrinho WHERE codigo_produto  not in "
				+ "(select codigo_adm from produto where codigo_adm=?);"
			//+ " DELETE FROM carrinho WHERE codigo_produto IN"
			//+ "(select codigo_adm from produto where codigo_adm=?);"
			+ "	DELETE FROM produto WHERE codigo_adm = ? ; "
			+ " DELETE FROM mercado WHERE codigo_adm = ? ; "
			+ " DELETE FROM login WHERE id = ? ; "
			+ " COMMIT; ";
				
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, a.getCodigo());
		stmt.setInt(2, a.getCodigo());
		stmt.setInt(3, a.getCodigo());
		stmt.setInt(4, a.getCodigo());
				
		try{
			stmt.execute();
					
			autenticado = true;
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return autenticado;
	}


}

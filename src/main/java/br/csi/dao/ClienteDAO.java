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

public class ClienteDAO {
	private Connection conn = (Connection) ConectarPostGressFactory.getConexao();
	private PreparedStatement stmt;
	private boolean autenticado = false;
	private String sql;
  
	public boolean VerificaCliente(Cliente c) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "Select count(1) from cliente where nome = ? and senha = ?";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);
		pstmt.setString(1, c.getNome());
		pstmt.setString(2, c.getSenha());
		ResultSet resultSet = pstmt.executeQuery();
		
		 if(resultSet.next())
		      return (resultSet.getInt(1) > 0);
		  else
		      return false;


	}
	public Cliente LOGARCliente(Cliente c) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "select codigo from cliente where nome =? and senha=?";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);
		pstmt.setString(1, c.getNome());
		pstmt.setString(2, c.getSenha());

		int id=0;
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();
		id = resultSet.getInt("codigo");
		c.setCodigo(id);
		System.out.println("%%%Codigo%%"+id);

		if (id > 0)
			return c;
		else
			return c;

	}
	public Cliente BuscaCli(Cliente a) {
		System.out.println("dentro do BuscarAdm");
		try {

			PreparedStatement stmt = ConectarPostGressFactory.getConexao().prepareStatement("select  l.nome, l.senha "
					+ "from  cliente l  WHERE  l.codigo=?");
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

	
	public boolean cadastrarCli (Mercado m,Cliente c) throws Exception{
		
		try {
			String query = "INSERT INTO cliente(nome,senha) VALUES (?,?);";
			PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);
			pstmt.setString(1, c.getNome());
			pstmt.setString(2, c.getSenha());

			pstmt.execute();

			pstmt.close();
			
		} catch (Exception e) {
			return false;		
			}
		return true;
	}
	public Cliente BuscaCli(Cliente a,int id) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";
		
		String query = "select * from cliente where codigo="+id+";";
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
public boolean ExcluirCliente (Cliente a) throws Exception{
		
		// Apaga primeiro  tabelas dependentes e depois na tabela login
	System.out.println("%%%Exxcluir Codigo com get%%"+a.getCodigo());

		sql = "	BEGIN; "
			+ "	DELETE FROM carrinho WHERE codigo_cliente = ? ; "
			+ " DELETE FROM cliente WHERE codigo= ? ; "
			+ " COMMIT; ";
				
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, a.getCodigo());
		stmt.setInt(2, a.getCodigo());
				
		try{
			stmt.execute();
					
			autenticado = true;
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return autenticado;
	}
public boolean EditadoCli(Cliente a) {
	boolean retorno = false;
	Connection c = null;
	PreparedStatement stmt = null;
	c = ConectarPostGressFactory.getConexao();
	// Adm a=new Adm();

	try {

		String sql = "";
		
			System.out.println("......... vai alterar ADM ............."+ a.getCodigo());

			sql = "UPDATE cliente SET nome =?, senha=? WHERE codigo =" + a.getCodigo() + ";";
			
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


}

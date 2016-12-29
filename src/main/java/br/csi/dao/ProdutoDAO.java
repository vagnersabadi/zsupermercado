package br.csi.dao;


import br.csi.model.util.ConectarPostGressFactory;
import br.csi.modelo.Adm;
import br.csi.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ProdutoDAO {
	private Connection conn = (Connection) ConectarPostGressFactory.getConexao();
	
	public boolean adicionarProduto(Produto p, int id) {
		boolean retorno = false;
		Connection c = null;
		PreparedStatement stmt = null;
		c = ConectarPostGressFactory.getConexao();
		// Adm a=new Adm();

		try {

			String sql = "";
	
				System.out.println("......... vai adicionar produto ID............."+id);
				sql = "INSERT INTO produto(codigo_adm, descricao, preco, promocao) VALUES (" + id + ",?,?,?);";
				stmt = c.prepareStatement(sql);
				// stmt.setInt(1, a.getCodigo());
				stmt.setString(1, p.getDescricao());
				stmt.setFloat(2, p.getPreco());
				stmt.setString(3, p.getPromocao());
			
			
			stmt.execute();

			stmt.close();
			retorno = true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

		return retorno;

	}
	public boolean EditarProduto(Produto p) {
		boolean retorno = false;
		Connection c = null;
		PreparedStatement stmt = null;
		c = ConectarPostGressFactory.getConexao();
		// Adm a=new Adm();

		try {

			String sql = "";
			
				System.out.println("......... vai alterar .............");
				sql = "UPDATE produto SET descricao =?, preco=?, promocao=? WHERE codigo =" + p.getCodigo() + "";
				stmt = c.prepareStatement(sql);
				stmt.setString(1, p.getDescricao());
				stmt.setFloat(2, p.getPreco());
				stmt.setString(3, p.getPromocao());

			stmt.execute();

			stmt.close();
			retorno = true;

		} catch (Exception e) {
			e.printStackTrace();
			return retorno;

		}

		return retorno;

	}

	public boolean ExcluirProduto(Produto p) {
		boolean retorno = false;
		Connection c = null;
		PreparedStatement stmt = null;
		c = ConectarPostGressFactory.getConexao();

		try {

			String sql = "";

			System.out.println("......... vai excluir produto ............." + p.getCodigo());
			sql = "delete from  carrinho where codigo_produto=?;"
					+ "delete from produto where codigo=?;";
				
			stmt = c.prepareStatement(sql);
			stmt.setInt(1, p.getCodigo());
			stmt.setInt(2, p.getCodigo());

			stmt.execute();

			stmt.close();
			retorno = true;

		} catch (Exception e) {
			e.printStackTrace();
			return retorno;

		}

		return retorno;

	}

	public boolean TirarPromocao(Produto p, int id) {
		boolean retorno = false;
		Connection c = null;
		PreparedStatement stmt = null;
		c = ConectarPostGressFactory.getConexao();

		try {

			String sql = "";

			System.out.println("......... vai TirarPromocao ............." + p.getCodigo());
			sql = "UPDATE produto SET promocao ='Não' WHERE codigo =?";
			stmt = c.prepareStatement(sql);
			stmt.setInt(1, p.getCodigo());

			stmt.execute();

			stmt.close();
			retorno = true;

		} catch (Exception e) {
			e.printStackTrace();
			return retorno;

		}

		return retorno;

	}
/*
	
	public ArrayList<Produto> BuscarProduto(Produto p) {
		ArrayList<Produto> Produtos = new ArrayList<Produto>();
		System.out.println("dentro do getProdutos()");
		try {

			PreparedStatement stmt = ConectarPostGressFactory.getConexao().prepareStatement("select * from produto where codigo=?;");
			stmt.setLong(1, p.getCodigo());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto t = new Produto();
				t.setCodigo(rs.getInt("codigo"));
				t.setDescricao(rs.getString("descricao"));
				t.setPreco(rs.getFloat("preco"));
				t.setPromocao(rs.getString("promocao"));
				System.out.println("Produto: " + t.getDescricao());
				Produtos.add(t);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Produtos;
	}*/
	public Produto BuscarProduto(Produto t) {
		System.out.println("dentro do busca produtos");
		try {

			PreparedStatement stmt = ConectarPostGressFactory.getConexao().prepareStatement("select * from produto where codigo=?;");
			stmt.setLong(1, t.getCodigo());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				t.setCodigo(rs.getInt("codigo"));
				t.setDescricao(rs.getString("descricao"));
				t.setPreco(rs.getFloat("preco"));
				t.setPromocao(rs.getString("promocao"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	public ArrayList<Produto> listaProdutos(int id) {
		ArrayList<Produto> pro = new ArrayList<Produto>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM produto where codigo_adm=" + id + "");

			/// stmt.setInt(1, a.getCodigo());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();

				p.setCodigo(rs.getInt("codigo"));
				p.setDescricao(rs.getString("descricao"));
				p.setPreco(rs.getFloat("preco"));
				p.setPromocao(rs.getString("promocao"));
				System.out.println("Dentro do listaprodutoDao " + p.getDescricao());
				
				pro.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro;
	}
	public ArrayList<Produto> BuscaPromo(int id) {
		ArrayList<Produto> pro = new ArrayList<Produto>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM produto where promocao='Sim' and codigo_adm="+id+";");

			/// stmt.setInt(1, a.getCodigo());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();

				p.setCodigo(rs.getInt("codigo"));
				p.setDescricao(rs.getString("descricao"));
				p.setPreco(rs.getFloat("preco"));
				p.setPromocao(rs.getString("promocao"));
				System.out.println("Dentro do listaprodutoDao " + p.getDescricao());
				
				pro.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro;
	}
	public ArrayList<Produto> listaTodosProdutos() {
		ArrayList<Produto> pro = new ArrayList<Produto>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM produto order by promocao='Não'");

			/// stmt.setInt(1, a.getCodigo());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodigo_Adm(rs.getInt("codigo_adm"));
				p.setCodigo(rs.getInt("codigo"));
				p.setDescricao(rs.getString("descricao"));
				p.setPreco(rs.getFloat("preco"));
				p.setPromocao(rs.getString("promocao"));
				System.out.println("Dentro do listaprodutoDao " + p.getDescricao());
				
				pro.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro;
	}

}

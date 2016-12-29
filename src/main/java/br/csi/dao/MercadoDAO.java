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

public class MercadoDAO {
	private Connection conn = (Connection) ConectarPostGressFactory.getConexao();
	private PreparedStatement stmt;
	private boolean autenticado = false;
	private String sql;
  
	public Mercado BuscaMercadoID(Adm a,Mercado m,int id) throws SQLException {
		// String query = "select count(1) from login where nome =? and
		// senha=?";select * from mercado where codigo_adm=2
		
		String query = "select nome,endereco,codigo from mercado where codigo_adm="+a.getCodigo()+";";
		PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);

		ResultSet resultSet = pstmt.executeQuery();
		//rs.next();
		while (resultSet.next()) {
		m.setSupermercado(resultSet.getString("nome"));
		m.setEndereco(resultSet.getString("endereco"));
		m.setCodigo(resultSet.getInt("codigo"));
		}
		//System.out.println("%%%Nome%%"+a.getNome());
		//System.out.println("%%%Codigo com get%%"+a.getCodigo());
		//System.out.println("%%%Codigo com id%%"+id);

		
			return m;

	}
	public ArrayList<Mercado> buscaMercado() {
		ArrayList<Mercado> pro = new ArrayList<Mercado>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM mercado ");

			/// stmt.setInt(1, a.getCodigo());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Mercado p = new Mercado();

				p.setCodigo(rs.getInt("codigo"));
				p.setSupermercado(rs.getString("nome"));
				p.setCodigoAdm(rs.getInt("codigo_adm"));
				p.setEndereco(rs.getString("endereco"));
				
				pro.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro;
	}
	public ArrayList<Produto> BuscarCarrinho(Cliente c,Mercado m) {
		ArrayList<Produto> pro = new ArrayList<Produto>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select *"
					+ "from produto,carrinho where "
					+ "carrinho.codigo_produto = "
					+ "produto.codigo and codigo_cliente=? ");

			stmt.setInt(1, c.getCodigo());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodigo(rs.getInt("codigo"));
				p.setDescricao(rs.getString("descricao"));
				p.setPromocao(rs.getString("promocao"));
				p.setPreco(rs.getFloat("preco"));
				
				pro.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro;
	}
	public Mercado BuscarCarrinhoMercado(Cliente c,Mercado m) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select *"
					+ "from produto,carrinho where "
					+ "carrinho.codigo_produto = "
					+ "produto.codigo and codigo_cliente=? ");
			
			stmt.setInt(1, c.getCodigo());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				//Mercado p = new Mercado();
				m.setCodigoCarrinho(rs.getInt("codigoCarrinho"));
				
		//	//pro.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
	public Mercado BuscarCarrinhoPrecoTotal(Cliente c,Mercado m) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select SUM(preco) AS SOMA "
					+ "from produto,carrinho where "
					+ "carrinho.codigo_produto = "
					+ "produto.codigo and codigo_cliente=? ");
			stmt.setInt(1, c.getCodigo());
			ResultSet rs = stmt.executeQuery();
			float somatorio=0; 
			while (rs.next()) {
				//Cliente cc = new Cliente();
				m.setTotal(rs.getFloat("SOMA"));
				 //somatorio = somatorio + rs.getFloat("preco");
				}
			System.out.println("......... SOma do ID ............." +m.getTotal());

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	public boolean RemoverCarrinho(Produto p,Mercado m) {
		boolean retorno = false;
		Connection c = null;
		PreparedStatement stmt = null;
		c = ConectarPostGressFactory.getConexao();

		try {

			String sql = "";

			System.out.println("......... vai  RemoverCarrinho ............." + m.getCodigoCarrinho());
			sql = "delete from carrinho where codigoCarrinho=?;";
			stmt = c.prepareStatement(sql);
			stmt.setInt(1, m.getCodigoCarrinho());

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

	
		public boolean AdicionarCarrinho(int cli ,Produto p) {
			boolean retorno = false;
			Connection c = null;
			PreparedStatement stmt = null;
			c = ConectarPostGressFactory.getConexao();
			// Adm a=new Adm();

			try {

				String sql = "";
		
					System.out.println("......... vai adicionar produto ID............."+p.getCodigo());
					//System.out.println("......... vai adicionar CL ID............."+cli.getCodigo());
					sql = "INSERT INTO carrinho(codigo_produto, valor_total,codigo_cliente) VALUES (?,?,"+cli+");";
					stmt = c.prepareStatement(sql);
					// stmt.setInt(1, a.getCodigo());
					stmt.setInt(1, p.getCodigo());
					stmt.setFloat(2, p.getPreco());
					//stmt.setInt(3, cli.getCodigo());
				
				
				stmt.execute();

				stmt.close();
				retorno = true;

			} catch (Exception e) {
				e.printStackTrace();
				return false;

			}

			return retorno;

		}
		public ArrayList<Produto> listaProdutosMercado(int id) throws SQLException {
			ArrayList<Produto> pro = new ArrayList<Produto>();
			System.out.println("......... Busca ID mercadp............."+id);

			
			String query = "select * from produto,login where produto.codigo_adm="+id+" "
					+ "and produto.codigo_adm=login.id;";
			PreparedStatement pstmt = ConectarPostGressFactory.getConexao().prepareStatement(query);

			ResultSet resultSet = pstmt.executeQuery();
			//rs.next();
			while (resultSet.next()) {
			Produto p=new Produto();
			p.setCodigo(resultSet.getInt("codigo"));
			p.setDescricao(resultSet.getString("descricao"));
			p.setPreco(resultSet.getFloat("preco"));
			p.setPromocao(resultSet.getString("promocao"));
			pro.add(p);
			}			
			return pro;

		}



}

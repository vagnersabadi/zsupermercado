package br.csi.controler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.csi.dao.ProdutoDAO;
import br.csi.dao.AdmDAO;
import br.csi.dao.ClienteDAO;
import br.csi.dao.MercadoDAO;
import br.csi.modelo.Adm;
import br.csi.modelo.Cliente;
import br.csi.modelo.Mercado;
import br.csi.modelo.Produto;

@Controller
public class Controler {

	private int id;
	private int idCli;
	/*
	 * @RequestMapping("logarAdm") public String Logar(Adm adm,HttpSession
	 * session) throws SQLException { System.out.println(
	 * ".... chamou o LogarAdm para produtos ... "); //new AdmDAO().LOGAR(adm)
	 * //if(retorno.size()>0) {
	 * 
	 * session.setAttribute("usuarioLogado", new AdmDAO().LOGAR(adm));
	 * 
	 * return "forward:listaProdutos"; // } //return "redirect:adm/login"; }
	 * public int BuscaIDLogin(Adm adm) throws SQLException {
	 * System.out.println(".... chamou o BuscaID ... ");
	 * 
	 * return new AdmDAO().BuscaID(adm); }
	 */

	@RequestMapping("login")
	public String login() {
		System.out.println("chamou o login");
		return "adm/login";
	}

	@RequestMapping("loginClientes")
	public String loginClientes() {
		System.out.println("chamou o login");
		return "cliente/loginCliente";
	}

	@RequestMapping("cadastraAdm")
	public String CadAdm() {
		System.out.println("chamou o cadastraAdm");
		return "adm/cadastrarAdm";
	}

	@RequestMapping("cadastraCli")
	public String CadCli() {
		System.out.println("chamou o cadastraCli");
		return "cliente/cadastrarCliente";
	}

	@RequestMapping("produtoscadastrar")
	public String ProdutoCadastro(Adm a) {
		System.out.println("chamou o login");
		return "produto/cadastrar";
	}

	@RequestMapping("indexRedireciona")
	public String voltarIndex() {
		System.out.println("chamou o index");
		return "home";
	}

	@RequestMapping("home")
	public String sair() {
		System.out.println("chamou o sair");
		id = 0;
		return "home";
	}

	@RequestMapping("BuscarProduto")
	public ModelAndView BuscaProduto(Produto p) {
		System.out.println(".... chamou o BuscarProduto ... ");
		System.out.println("....Produto " + p.getCodigo());
		ModelAndView mv = new ModelAndView("produto/editar");
		mv.addObject("p", new ProdutoDAO().BuscarProduto(p));
		return mv;
	}

	@RequestMapping("BuscaContaAdm")
	public ModelAndView BuscaContaAdm(Adm a, Mercado m) throws SQLException {
		System.out.println(".... chamou o BuscaContaAdm ... ");
		System.out.println("....Adm " + a.getCodigo());
		ModelAndView mv = new ModelAndView("adm/editarAdm");
		mv.addObject("adm", new AdmDAO().BuscarAdm(a));
		mv.addObject("mer", new MercadoDAO().BuscaMercadoID(a, m, id));
		return mv;
	}
	@RequestMapping("BuscaContaCli")
	public ModelAndView BuscaContaCli(Cliente a,@RequestParam(value = "codigo", required = true) 
	int userId, HttpServletRequest request) throws SQLException {
		System.out.println(".... chamou o BuscaContaCli ... ");
		System.out.println("....Adm " + a.getCodigo());
		ModelAndView mv = new ModelAndView("cliente/editarCliente");
		mv.addObject("c", new ClienteDAO().BuscaCli(a,userId));
		return mv;
	}
	

	@RequestMapping("PesquisarMercado")
	public ModelAndView PesquisarMercado(Produto p, Cliente a,
			@RequestParam(value = "IdMercado", required = true) int MercId, HttpServletRequest request)
			throws SQLException {
		System.out.println(".... chamou o listar produtos por mercado... " + MercId);
		System.out.println("....ID login listar produto " + a.getCodigo());
		ModelAndView mv = new ModelAndView("cliente/mercado");
		mv.addObject("produtos", new MercadoDAO().listaProdutosMercado(MercId));
		mv.addObject("mercados", new MercadoDAO().buscaMercado());
		mv.addObject("cli", a);
		return mv;
	}

	@RequestMapping("listaProdutos")
	public ModelAndView listaProduto(Produto p, Adm a) {
		System.out.println(".... chamou o listar produtos ... ");
		System.out.println("....ID login listar produto " + id);
		ModelAndView mv = new ModelAndView("produto/listar");
		mv.addObject("produtos", new ProdutoDAO().listaProdutos(id));
		mv.addObject("Adm", a);
		return mv;
	}

	@RequestMapping("MeuCarrinho")
	public ModelAndView MeuCarrinho(Cliente c, Mercado m,@RequestParam(value = "codigo", required = true) 
	int userId, HttpServletRequest request) throws SQLException {
		System.out.println(".... chamou o carrinho ... ");
		System.out.println("....Cliente " + c.getCodigo());
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		mv.addObject("cli", new ClienteDAO().BuscaCli(c, userId));
		mv.addObject("produtos", new MercadoDAO().BuscarCarrinho(c, m));
		mv.addObject("carrinho", new MercadoDAO().BuscarCarrinhoMercado(c, m));
		//float precoTotal=;
		//m.setTotal(precoTotal);
		//mv.addObject("cli",c);
		mv.addObject("mercado",new MercadoDAO().BuscarCarrinhoPrecoTotal(c, m));
		return mv;
	}

	@RequestMapping("produtoslistarClientes")
	public ModelAndView produtoslistarClientes(Produto p, Cliente c,
			@RequestParam(value = "codigo", required = true) int userId, HttpServletRequest request) {
		c.setCodigo(userId);
		System.out.println(".... chamou  produtoslistarClientes ... ");
		ModelAndView mv = new ModelAndView("cliente/listarProCli");
		mv.addObject("produtos", new ProdutoDAO().listaTodosProdutos());
		mv.addObject("cli", c);
		return mv;
	}

	@RequestMapping("mercados")
	public ModelAndView mercados(Produto p, Cliente c,Mercado m, @RequestParam(value = "codigo", required = true) int userId,
			HttpServletRequest request, HttpServletResponse response) {
		c.setCodigo(userId);
		System.out.println(".... chamou os mercados ... ");
		ModelAndView mv = new ModelAndView("cliente/mercado");
		mv.addObject("mercados", new MercadoDAO().buscaMercado());
		mv.addObject("cli", c);
		return mv;
	}

	@RequestMapping("adicionarAdm")
	public ModelAndView CadastarAdm(Adm adm, Mercado m, Model model) throws Exception {
		System.out.println(".... chamou o cadastrar adm ... ");

		if (!new AdmDAO().VerificaAdm(adm)) {
			boolean retorno = new AdmDAO().cadastrarAdm(adm, m);
			ModelAndView mv = new ModelAndView("adm/login");
			return mv;
			// return "adm/login";
		} else {
			// return "erro";s
			model.addAttribute("message", "Nome e Senha Já cadastrados");
			ModelAndView mv = new ModelAndView("adm/cadastrarAdm");
			return mv;
		}
	}

	@RequestMapping("adicionarCli")
	public String CadastarCli(Mercado m, Cliente c) throws Exception {
		System.out.println(".... chamou o cadastrar cli ... ");
		boolean retorno = new ClienteDAO().cadastrarCli(m, c);
		if (retorno) {
			return "cliente/loginCliente";
		} else {
			return "erro";
		}
	}

	@RequestMapping("AdicionarCarrinho")

	public ModelAndView AdicionarCarrinho(Produto p, Cliente c,
			@RequestParam(value = "codigoCli", required = true) int userId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println(".... chamou o cadastrar carrnho ***... " + p.getCodigo());
		System.out.println(".... chamou o cadastrar carrnho ***... " + userId);
		c.setCodigo(userId);
		boolean retorno = new MercadoDAO().AdicionarCarrinho(userId, p);
		if (retorno) {
			ModelAndView mv = new ModelAndView("cliente/listarProCli");
			mv.addObject("produtos", new ProdutoDAO().listaTodosProdutos());
			mv.addObject("cli", c);
			return mv;
		} else {
			return null;
		}

	}

	@RequestMapping("logarAdm")
	public ModelAndView Logar(Adm adm, Mercado m, Model model) throws SQLException {
		System.out.println(".... chamou o LogarAdm para produtos ... ");

		if (new AdmDAO().VerificaAdm(adm)) {

			int re = new AdmDAO().LOGAR(adm);
			id = re;// passa id do Adm logado
			ModelAndView mv = new ModelAndView("produto/listar");
			mv.addObject("adm", new AdmDAO().BuscaAdm(adm, id));
			mv.addObject("mer", new MercadoDAO().BuscaMercadoID(adm, m, id));
			mv.addObject("produtos", new ProdutoDAO().listaProdutos(id));
			return mv;
		} else {
			model.addAttribute("message", "Dados incorretos!");
			ModelAndView mv = new ModelAndView("adm/login");
			return mv;
		}

	}

	@RequestMapping("logarCli")
	public ModelAndView LogarCLi(Cliente c, Model model) throws SQLException {
		System.out.println(".... chamou o LogarAdm para produtos ... ");
		// idCli = cli.getCodigo();// passa id do Adm logado

		if (new ClienteDAO().VerificaCliente(c)) {
			Cliente cliw = new ClienteDAO().LOGARCliente(c);

			System.out.println("User Login sucesso de id " + cliw.getCodigo());
			ModelAndView mv = new ModelAndView("cliente/listarProCli");
			mv.addObject("produtos", new ProdutoDAO().listaTodosProdutos());
			mv.addObject("cli", c);

			// mv.addObject("cli", c);

			return mv;
		} else {
			model.addAttribute("message", "Dados incorretos!");
			ModelAndView mv = new ModelAndView("cliente/loginCliente");

			return mv;
		}
	}

	@RequestMapping("excluirContaAdm")
	public String excluirContaAdm(Adm a) throws Exception {
		System.out.println(".... chamou o ExcluirAdm ... ");
		boolean retorno = new AdmDAO().ExcluirAdm(a);
		if (retorno) {
			return "redirect:home";
		} else {
			return "erro";
		}
	}
	@RequestMapping("excluirContaCli")
	public String excluirContaCli(Cliente a) throws Exception {
		System.out.println(".... chamou o ExcluirAdm ... ");
		boolean retorno = new ClienteDAO().ExcluirCliente(a);
		if (retorno) {
			return "redirect:home";
		} else {
			return "erro";
		}
	}
	

	@RequestMapping("RemoverCarrinho")
	public ModelAndView RemoverCarrinho(Produto p, Mercado m, Cliente c,
			@RequestParam(value = "codigoCli", required = true) int userId, HttpServletRequest request)
			throws SQLException {
		c.setCodigo(userId);
		System.out.println(".... chamou o RemoverCarrinho CLIENTE ... " + c.getCodigo());

		boolean retorno = new MercadoDAO().RemoverCarrinho(p, m);
		if (retorno) {
			ModelAndView mv = new ModelAndView("cliente/carrinho");
			// ArrayList<Produto> list= new MercadoDAO().BuscarCarrinho(c);
			mv.addObject("produtos", new MercadoDAO().BuscarCarrinho(c, m));
			mv.addObject("carrinho", new MercadoDAO().BuscarCarrinhoMercado(c, m));
			// mv.addObject("produtos", new ProdutoDAO().listaTodosProdutos());
			mv.addObject("cli", c);
			mv.addObject("mercado",new MercadoDAO().BuscarCarrinhoPrecoTotal(c, m));

			return mv;
		} else {
			return null;
		}
	}

	@RequestMapping("ExcluirProduto")
	public String ExcluirProduto(Produto p, HttpServletResponse response) throws SQLException {
		System.out.println(".... chamou o ExcluirProduto ... ");
		boolean retorno = new ProdutoDAO().ExcluirProduto(p);
		if (retorno) {
			return "forward:listaProdutos";
		} else {
			return "erro";
		}
	}

	@RequestMapping("ProdutoEditado")
	public String EditarProduto(Produto p) throws SQLException {
		System.out.println(".... chamou o EditarProduto ... ");
		boolean retorno = new ProdutoDAO().EditarProduto(p);
		if (retorno) {
			return "forward:listaProdutos";
		} else {
			return "erro";
		}
	}

	@RequestMapping("editadoCli")
	public String editadoCli(Cliente a) throws SQLException {
		System.out.println(".... chamou o EditarProduto ... ");
		// boolean retorno = new AdmDAO().EditarAdm(a,m);
		boolean retorno = new ClienteDAO().EditadoCli(a);
		if (retorno) {
			return "cliente/loginCliente";
		} else {
			return "erro";
		}
	}
	@RequestMapping("SalvarAdmEdicao")
	public String SalvarAdmEdicao(Adm a, Mercado m) throws SQLException {
		System.out.println(".... chamou o EditarProduto ... ");
		// boolean retorno = new AdmDAO().EditarAdm(a,m);
		boolean retorno = new AdmDAO().EditarMercado(a, m);
		if (retorno) {
			return "forward:listaProdutos";
		} else {
			return "erro";
		}
	}

	@RequestMapping("TirarPromocao")
	public String TirarPromocao(Produto p, HttpServletResponse response) throws SQLException {
		System.out.println(".... chamou o TirarPromocao ... ");
		boolean retorno = new ProdutoDAO().TirarPromocao(p, id);
		if (retorno) {
			return "forward:produtoslistarPromocoes";
		} else {
			return "erro";
		}
	}

	@RequestMapping("produtoslistarPromocoes")
	public ModelAndView produtoslistarPromocoes(Produto p, Adm a) {
		System.out.println("+++++vai inserir com IdADM " + id);
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> list = dao.BuscaPromo(id);
		System.out.println(".... LISTA de produtos ... " + list);
		ModelAndView mv = new ModelAndView("produto/promocoes");
		mv.addObject("produtos", list);
		return mv;
		// return "forward:listaProdutos";

	}

	@RequestMapping("ProdutoInserir")
	public ModelAndView adiciona(Produto p, Adm a) {
		System.out.println("+++++vai inserir com IdADM " + id);
		boolean retorno = new ProdutoDAO().adicionarProduto(p, id);
		if (retorno) {
			ProdutoDAO dao = new ProdutoDAO();
			ArrayList<Produto> list = dao.listaProdutos(id);
			System.out.println(".... LISTA de produtos ... " + list);
			ModelAndView mv = new ModelAndView("produto/cadastrar");
			mv.addObject("produtos", list);
			return mv;
			// return "forward:listaProdutos";
		} else {
			ModelAndView mv = new ModelAndView("erro");
			return mv;
		}
	}

	@RequestMapping("ProdutoAlterar")
	public ModelAndView alterar(Produto p, Adm a) {
		System.out.println("+++++vai inserir com IdADM " + a.getCodigo());
		boolean retorno = new ProdutoDAO().EditarProduto(p);
		if (retorno) {
			ProdutoDAO dao = new ProdutoDAO();
			ArrayList<Produto> list = dao.listaProdutos(id);
			System.out.println(".... LISTA de produtos ... " + list);
			ModelAndView mv = new ModelAndView("produto/cadastrar");
			mv.addObject("produtos", list);
			return mv;
			// return "forward:listaProdutos";
		} else {
			ModelAndView mv = new ModelAndView("erro");
			return mv;
		}
	}

}

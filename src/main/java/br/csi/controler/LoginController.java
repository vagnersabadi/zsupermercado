package br.csi.controler;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.csi.dao.AdmDAO;
import br.csi.modelo.Adm;
@Controller
public class LoginController {
	/*@RequestMapping("loginCtrl")
	public String autenticarUsuario (Usuario usuario, HttpSession session) throws Exception{
		Usuario usuarioAutenticado = new ProjetoDAO().altenticarUsuario(usuario);
		
		if(usuarioAutenticado != null){
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			return "menu/menu-projeto";
		}
		else
			return "redirect:login";
	}*/
}

package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.Usuario;
import mvc.model.UsuarioDAO;

@Controller
public class LoginController {
	@RequestMapping("registro")
	public String registro() {
		return "formulario-registro";
	}

	@RequestMapping(value = "efetuaRegistro", method = RequestMethod.POST)
	public String upload(Usuario usuario) throws IOException {
		UsuarioDAO dao = new UsuarioDAO();
		dao.adiciona(usuario);
		return "redirect:loginForm";
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (new UsuarioDAO().existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario.getLogin());
			return "menu";
		}
		return "redirect:loginForm";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
	
	@RequestMapping(value = "getImage", method = RequestMethod.GET)
	public void showImage(@RequestParam("login") String login, HttpServletResponse
			response,HttpServletRequest request)
					throws ServletException, IOException{
		UsuarioDAO dao = new UsuarioDAO();
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(dao.buscaFoto(login));
		response.getOutputStream().close();
	}
	

}
package mvc.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.model.MandadorSMSal;
import mvc.model.Mensagem;
import mvc.model.Spoiler;
import mvc.model.Usuario;
import mvc.model.UsuarioDAO;

@Controller
public class MenuController {

	@RequestMapping("mandar")
	public String manda(String login, String nome, String numero, String temp) {
		Mensagem mensagem = new Mensagem();
		System.out.println("login: " + login);
		mensagem.setUserName(login);
		mensagem.setNome(nome);
		mensagem.setNumero_recebido(numero);
		mensagem.setTemp(temp);
		mensagem.setTexto(mensagem.getSpoillers(temp));
		MandadorSMSal.send(mensagem);
		//System.out.println(temp);
		
		return "redirect:efetuaLogin";
	}
	@RequestMapping(value = "/getHistory", method = RequestMethod.POST)
	public void getHistory(HttpServletResponse response, HttpServletRequest request){
		System.out.println("recebi request de history");
		UsuarioDAO dao = new UsuarioDAO(); 
		try {
			String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			JSONObject responseJson = new JSONObject();
			JSONObject json = new JSONObject(output);
			Object userJson = json.get("user");
			java.util.List<Mensagem> history = dao.getHistory(userJson.toString());
			System.out.println(history);
			responseJson.put("history", history);
			response.getWriter().println(responseJson);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@RequestMapping(value = "/getSpoilers", method = RequestMethod.POST)
	public void getSpoilers(HttpServletResponse response, HttpServletRequest request){
		System.out.println("recebi request de Spoilers");
		UsuarioDAO dao = new UsuarioDAO(); 
		try {
			String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			JSONObject responseJson = new JSONObject();
			JSONObject json = new JSONObject(output);
			Object tempJson = json.get("temp");
			java.util.List<Spoiler> spoilers = dao.getSpoilers(tempJson.toString());
			System.out.println(spoilers);
			responseJson.put("spoilers", spoilers);
			response.getWriter().println(responseJson);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//	
//	@RequestMapping("setSpoillersOption")
//	@ResponseBody
//	public void showSpoillers(@RequestParam("temp") String temp, HttpServletRequest request) throws IOException {
//		String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//		
// 		String spoiller = new String();
// 		
//		request.setAttribute("spoillers", spoiller);
//		
//	}
	
//	@RequestMapping(value = "getSpoillersOption", method = RequestMethod.GET)
//	public void showSpoillers(@RequestParam("temp") String temp, HttpServletResponse response, HttpServletRequest request)
//			throws ServletException, IOException {
//		Mensagem mensagem = new Mensagem();
//		response.setContentType("text/html");
//		request.setAttribute("spoillers", mensagem.getSpoillers(temp));
////		response.getOutputStream().write(mensagem.getSpoillers(temp));
//		response.getOutputStream().close();
//	}
	
}

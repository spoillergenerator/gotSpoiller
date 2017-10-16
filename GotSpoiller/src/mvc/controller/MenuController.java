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

//	@RequestMapping("mandar")
//	public String manda(String spoiler, String login, String nome, String numero, String temp) {
//		Mensagem mensagem = new Mensagem();
//		System.out.println("login: " + spoiler);
//		mensagem.setUserName(login);
//		mensagem.setNome(nome);
//		mensagem.setNumero_recebido(numero);
//		mensagem.setTemp(temp);
//		mensagem.setTexto(spoiler);
//		System.out.print("texto: " + spoiler);
////		MandadorSMSal.send(mensagem);
//		//System.out.println(temp);
//		
//		return "redirect:efetuaLogin";
//	}
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public void sendMessage(HttpServletResponse response, HttpServletRequest request){
		Mensagem mensagem = new Mensagem();
		
		try {
			String output = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			JSONObject responseJson = new JSONObject();
			JSONObject json = new JSONObject(output);
			Object nameJson = json.get("name");
			Object phoneJson = json.get("phone");
			Object tempJson = json.get("temp");
			Object spoilerJson = json.get("spoiler");
			Object loginJson = json.get("login");
			
			mensagem.setNome(nameJson.toString());
			mensagem.setNumero_recebido(phoneJson.toString());
			mensagem.setTemp(tempJson.toString());
			mensagem.setTexto(spoilerJson.toString());
			mensagem.setUserName(loginJson.toString());
			
//			MandadorSMSal.send(mensagem);
			
			responseJson.put("status", "sent");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(responseJson);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			response.setCharacterEncoding("UTF-8");
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
			System.out.println(json.toString());
			java.util.List<Spoiler> spoilers = dao.getSpoilers(tempJson.toString());
			responseJson.put("spoilers", spoilers);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(responseJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

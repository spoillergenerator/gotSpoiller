package mvc.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.MandadorSMSal;

@Controller
public class MenuController {

	@RequestMapping("mandar")
	public void manda(String nome, String numero) {
		
		MandadorSMSal.mandar(nome, numero);
		System.out.println("CHEGOU AQUI NO MANDAR PORRA CARALHO MERDA PQP");
	}
	
}

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
	public String manda(String nome, String numero, String temp) {
		
		MandadorSMSal.mandar(nome, numero, temp);
		//System.out.println(temp);
		
		return "redirect:efetuaLogin";
	}
	
}

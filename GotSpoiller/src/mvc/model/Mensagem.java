package mvc.model;

import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Mensagem {
	private String id;
	private String userName;
	private String numero_recebido;
	private String temp;
	private String texto;
	private String nome;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero_recebido() {
		return numero_recebido;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setNumero_recebido(String numero_recebido) {
		this.numero_recebido = numero_recebido;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getSpoillers(String temp){
	    String spoiller = new String();
	    
	    int temporada = Integer.parseInt(temp); 
	    
	    switch (temporada){
	    	case 1: spoiller = "Sabia que o Ned morre decapitado?";
	    	break;
	    	case 2: spoiller = "Sabia que o Tyrion vai liderar e ganhar a batalha contra o Stannis?";
	    	break;
	    	case 3: spoiller = "Sabia que o Rob e sua mae morrem num casamento que ficou conhecido como Red Wedding?";
	    	break;
	    	case 4: spoiller = "Sabia que a musica Shot in the Heart do Bon Jovi foi feita para Ygritte? ;)";
	    	break;
	    	case 5: spoiller = "Sabia que o Jon Snow eh um traidor? Levou umas facadineas no coracao por isso... :(";
	    	break;
	    	case 6: spoiller = "Sabia que... Hold the door! Hold door! Holdoor! Hodor! (morreu :) ).";
	    	break;
	    	case 7: spoiller = "Sabia que o Jon Snow é Targaryan? Ele chama Aegon e eh filho da Lyanna (irma do Ned) com o Rhaegar (irmao da Danerys).";
	    	break;
	    	default: spoiller = "Sabia que o Jon Snow é Targaryan? Ele chama Aegon e eh filho da Lyanna (irma do Ned) com o Rhaegar (irmao da Danerys).";
	    	break;
	    	
	    	
	    }
	    
	    return spoiller;
	}
	

}

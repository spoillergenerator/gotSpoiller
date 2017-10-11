package mvc.model;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class MandadorSMSal {
	// Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC9b7cabd8ab1f4b99615b6a2b94be36b0";
  public static final String AUTH_TOKEN = "8d7c0606d2fa159c4a3002385c8babc4";

  public static void mandar(String nome, String numero, String temp) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    
    String spoiler = new String();
    
    int temporada = Integer.parseInt(temp); 
    
    switch (temporada){
    	case 1: spoiler = "|| "+nome+", sabia que o Ned morre decapitado?";
    	break;
    	case 2: spoiler = "|| "+nome+", sabia que o Tyrion vai liderar e ganhar a batalha contra o Stannis?";
    	break;
    	case 3: spoiler = "|| "+nome+", sabia que o Rob e sua mae morrem num casamento que ficou conhecido como Red Wedding?";
    	break;
    	case 4: spoiler = "|| "+nome+", sabia que a musica Shot in the Heart do Bon Jovi foi feita para Ygritte? ;)";
    	break;
    	case 5: spoiler = "|| "+nome+", sabia que o Jon Snow eh um traidor? Levou umas facadineas no coracao por isso... :(";
    	break;
    	case 6: spoiler = "|| "+nome+", sabia que... Hold the door! Hold door! Holdoor! Hodor! (morreu :) ).";
    	break;
    	case 7: spoiler = "|| "+nome+", sabia que o Jon Snow é Targaryan? Ele chama Aegon e eh filho da Lyanna (irma do Ned) com o Rhaegar (irmao da Danerys).";
    	break;
    	default: spoiler = "|| "+nome+", sabia que o Jon Snow é Targaryan? Ele chama Aegon e eh filho da Lyanna (irma do Ned) com o Rhaegar (irmao da Danerys).";
    	break;
    	
    	
    }

    // to, from
    Message message = Message.creator(new PhoneNumber(numero),
        new PhoneNumber("+16513763380"), 
        spoiler).create();

    System.out.println(message.getSid());
    System.out.println(" "+nome+", toma aqui seu spoiler! ("+numero+")");
  }

}

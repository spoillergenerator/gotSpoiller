package mvc.model;
import java.io.IOException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber; 

public class MandadorSMSal {
	// Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC9b7cabd8ab1f4b99615b6a2b94be36b0";
  public static final String AUTH_TOKEN = "8d7c0606d2fa159c4a3002385c8babc4";

  public static void send(Mensagem mensagem) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    UsuarioDAO dao = new UsuarioDAO();


    Message message = Message.creator(new PhoneNumber(mensagem.getNumero_recebido()),
        new PhoneNumber("+16513763380"), 
        mensagem.getTexto()).create();
    try {
		dao.adicionaSMS(mensagem);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(message.getSid());
    System.out.println(" "+mensagem.getNome()+", toma aqui seu spoiler! ("+mensagem.getNumero_recebido()+")");
  }

}

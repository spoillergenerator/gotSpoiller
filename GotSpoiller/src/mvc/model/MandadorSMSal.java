package mvc.model;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class MandadorSMSal {
	// Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC9b7cabd8ab1f4b99615b6a2b94be36b0";
  public static final String AUTH_TOKEN = "8d7c0606d2fa159c4a3002385c8babc4";

  public static void mandar(String nome, String numero) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    // to, from
    Message message = Message.creator(new PhoneNumber(numero),
        new PhoneNumber("+16513763380"), 
        "|| "+nome+", sabia que o Jon Snow é Targaryan? Ele chama Aegon e eh filho da Lyanna (irma do Ned) com o Rhaegar (irmao da Danerys).").create();

    System.out.println(message.getSid());
    System.out.println(" "+nome+", toma aqui seu spoiler! ("+numero+")");
  }

}

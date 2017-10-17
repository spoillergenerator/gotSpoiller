package mvc.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

import mvc.model.FacebookUserDAO;
import mvc.model.Mensagem;
//import OAuth20Service;
import mvc.model.Usuario;
import mvc.model.UsuarioDAO;

@Controller
public class LoginController {
	private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/v2.8/me";
	private static final String PICTURE_URL = "https://graph.facebook.com/v2.8/me?fields=picture";

//	 @RequestMapping("/")
//	 public String inicial() {
//	 return "loginForm";
//	 }

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
	
	@RequestMapping("/efetuaLoginFacebook")
	public String efetuaLoginFacebook() {
		return "menu";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

	@RequestMapping(value = "getImage", method = RequestMethod.GET)
	public void showImage(@RequestParam("login") String login, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		boolean isFacebook = dao.isFacebook(login);
		System.out.println("isFacebook: " + dao.isFacebook(login));
		if(isFacebook){

			byte[] img = ImageConverter.getBytesFromUrl(dao.buscaFotofacebook(login));
			
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(img);
			response.getOutputStream().close();
			
		}
		else{
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(dao.buscaFoto(login));
			response.getOutputStream().close();
		}
	}

	@RequestMapping(value = "fblogin")
	public RedirectView fblogin() throws IOException, InterruptedException, ExecutionException {
		System.out.println("opa");
		// Replace these with your client id and secret
		final String clientId = "341972912918164";
		final String clientSecret = "90e3d5af558fc29fbdf07865a6492229";
		final String secretState = "secret" + new Random().nextInt(999_999);
		final OAuth20Service service = (OAuth20Service) new ServiceBuilder(clientId).apiSecret(clientSecret)
				.state(secretState).callback("http://localhost:8080/fblogin/callback").build(FacebookApi.instance());

		System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
		System.out.println();

		// Obtain the Authorization URL
		System.out.println("Fetching the Authorization URL...");
		final String authorizationUrl = service.getAuthorizationUrl();
		System.out.println("Got the Authorization URL!");
		System.out.println("Now go and authorize ScribeJava here:");
		System.out.println(authorizationUrl);
		return new RedirectView(authorizationUrl);
	}

	@RequestMapping(value = "fblogin/callback")
	public String callback(@RequestParam("code") String code, @RequestParam("state") String state, HttpSession session)
			throws IOException, InterruptedException, ExecutionException {
		System.out.println("Entrou");
		final String clientId = "341972912918164";
		final String clientSecret = "90e3d5af558fc29fbdf07865a6492229";
		final String secretState = "secret" + new Random().nextInt(999_999);
		final OAuth20Service service = (OAuth20Service) new ServiceBuilder(clientId).apiSecret(clientSecret)
				.state(secretState).callback("http://localhost:8080/fblogin/callback").build(FacebookApi.instance());

		// Trade the Request Token and Verfier for the Access Token
		System.out.println("Trading the Request Token for an Access Token...");
		final OAuth2AccessToken accessToken = service.getAccessToken(code);
		System.out.println("Got the Access Token!");
		System.out.println("(if your curious it looks like this: " + accessToken + ", 'rawResponse'='"
				+ accessToken.getRawResponse() + "')");
		System.out.println();

		// Now let's go and ask for a protected resource!
		System.out.println("Now we're going to access a protected resource...");
		final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		service.signRequest(accessToken, request);
		final Response response = service.execute(request);
		System.out.println("Got it! Lets see what we found...");
		System.out.println(response.getBody());
		JSONObject json;
		try {
			json = new JSONObject(response.getBody());
			Object idJson = json.get("id");
			Object nameJson = json.get("name");
			System.out.println("Id: " + idJson.toString());
			System.out.println("name: " + nameJson.toString());
			session.setAttribute("login", nameJson.toString());
			System.out.println("Convertendo imagem... ");
			
			URL url = new URL("https://graph.facebook.com/" + idJson.toString() + "/picture?type=large");
			
			System.out.println(url.toString());
			
			session.setAttribute("usuarioLogado", nameJson.toString());
			
			FacebookUserDAO fDAO = new FacebookUserDAO();
			
			Usuario usuario = new Usuario();
			usuario.setLogin(nameJson.toString());
			usuario.setIsFacebook("true");
			usuario.setLink(url.toString());
			
			if(!fDAO.existeUsuarioFacebook(usuario)){
				fDAO.adicionaFacebook(usuario);
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		System.out.println();
//		System.out.println("Profile Picture link:");
//		final OAuthRequest request2 = new OAuthRequest(Verb.GET, PICTURE_URL);
//		service.signRequest(accessToken, request2);
//		final Response response2 = service.execute(request2);
//		System.out.println(response2.getBody());
		return "redirect:http://localhost:8080/efetuaLoginFacebook";
		
		
	}


}
package mvc.model;
import org.springframework.web.multipart.MultipartFile;

public class Usuario {
	private String login;
	private String senha;
	private MultipartFile foto;
	private String isFacebook;
	private String link;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public MultipartFile getFoto() {
		return foto;
	}
	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}
	public String getIsFacebook() {
		return isFacebook;
	}
	public void setIsFacebook(String isFacebook) {
		this.isFacebook = isFacebook;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}

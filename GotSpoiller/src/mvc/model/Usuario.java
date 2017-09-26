package mvc.model;
import org.springframework.web.multipart.MultipartFile;

public class Usuario {
	private String login;
	private String senha;
	private MultipartFile foto;
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
	
	
}

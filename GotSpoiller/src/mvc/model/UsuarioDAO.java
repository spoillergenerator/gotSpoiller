package mvc.model;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class UsuarioDAO {
	private Connection connection = null;

	public UsuarioDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "Katchin98");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void adiciona(Usuario usuario) throws IOException {
		MultipartFile filePart = usuario.getFoto();
		/*
		 * Rotina para salvar o arquivo no servidor if (!filePart.isEmpty()) {
		 * String fileName = filePart.getOriginalFilename(); File uploads = new
		 * File("/tmp"); File file = new File(uploads, fileName); try
		 * (InputStream input = filePart.getInputStream()) { Files.copy(input,
		 * file.toPath()); } }
		 */
		try {
			String sql = "INSERT INTO usuario (login, senha, foto, isFacebook) values(?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, "false");
			stmt.setBinaryStream(3, filePart.getInputStream());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionaSMS(Mensagem mensagem) throws IOException {
//		String nome = mensagem.getNome();
//		String userName = mensagem.getUserName();
//		String numero_recebido = mensagem.getNumero_recebido();
//		String season = mensagem.getTemp();
//		String texto = mensagem.getTexto();
		/*
		 * Rotina para salvar o arquivo no servidor if (!filePart.isEmpty()) {
		 * String fileName = filePart.getOriginalFilename(); File uploads = new
		 * File("/tmp"); File file = new File(uploads, fileName); try
		 * (InputStream input = filePart.getInputStream()) { Files.copy(input,
		 * file.toPath()); } }
		 */
		try {
			String sql = "INSERT INTO Historico (numero_recebido, temp, texto, nome, username) values(?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, mensagem.getNumero_recebido());
			stmt.setString(2, mensagem.getTemp());
			stmt.setString(3, mensagem.getTexto());
			stmt.setString(4, mensagem.getNome());
			stmt.setString(5, mensagem.getUserName());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		System.out.println(usuario.getSenha());
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM usuario WHERE login=? AND senha=? LIMIT 1");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) != 0) {
					existe = true;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return existe;
	}

	public byte[] buscaFoto(String login) {
		byte[] imgData = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE login=? ");
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Blob image = rs.getBlob("foto");
				imgData = image.getBytes(1, (int) image.length());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return imgData;
	}
	
	public List<Mensagem> getHistory(String usuario){
		
		List<Mensagem> history = new ArrayList<Mensagem>();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Historico WHERE username=? ");
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mensagem mensagem = new Mensagem();
				mensagem.setNumero_recebido(rs.getString("numero_recebido"));
				mensagem.setTemp(rs.getString("temp"));
				mensagem.setTexto(rs.getString("texto"));
				mensagem.setNome(rs.getString("nome"));
				history.add(mensagem);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return history;
	}
	
	public List<Spoiler> getSpoilers(String temp){
		List<Spoiler> spoilers = new ArrayList<Spoiler>();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Spoilers WHERE temp=? ");
			stmt.setString(1, temp);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Spoiler spoiler = new Spoiler();
				spoiler.setTemp(rs.getString("temp"));
				spoiler.setTexto(rs.getString("texto"));
				spoilers.add(spoiler);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return spoilers;

	}
	
}
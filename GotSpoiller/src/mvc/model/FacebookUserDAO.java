package mvc.model;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class FacebookUserDAO {
	private Connection connection = null;

	public FacebookUserDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados?useUnicode=yes&characterEncoding=UTF-8" , "root", "Katchin98");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void adicionaFacebook(Usuario usuario) throws IOException {
		/*
		 * Rotina para salvar o arquivo no servidor if (!filePart.isEmpty()) {
		 * String fileName = filePart.getOriginalFilename(); File uploads = new
		 * File("/tmp"); File file = new File(uploads, fileName); try
		 * (InputStream input = filePart.getInputStream()) { Files.copy(input,
		 * file.toPath()); } }
		 */
		try {
			String sql = "INSERT INTO usuario (login, isFacebook, link) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getIsFacebook());
			stmt.setString(3, usuario.getLink());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public boolean existeUsuarioFacebook(Usuario usuario) {
		boolean existe = false;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM usuario WHERE login=? AND isFacebook=? LIMIT 1");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getIsFacebook());
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
	public String buscaFotofacebook(String login){
		String link = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE login=? ");
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				link = rs.getString("link");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return link;
	}
	
	
}

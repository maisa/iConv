package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Usuario;
import util.BdUtil;

public class UsuarioRepository {
	private Connection dbConnection;

	public UsuarioRepository() {
		dbConnection = BdUtil.getConnection();
	}

	public void save(String userName, String password, String firstName,
			String emailAddress, String perfil) {
		if (dbConnection != null) {
			try {
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("insert into usuario(id, senha, nome, email, perfil) values (?, ?, ?, ?, ?)");
				prepStatement.setString(1, userName);
				prepStatement.setString(2, password);
				prepStatement.setString(3, firstName);				
				
				prepStatement.setString(4, emailAddress);
				prepStatement.setString(5, perfil);

				prepStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean findByUserName(String userName) {
		if (dbConnection != null) {
			try {
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select count(*) from usuario where id = ?");
				prepStatement.setString(1, userName);

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						if (result.getInt(1) == 1) {
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Usuario findByLogin(String userName, String password) {
		Usuario usuario = new Usuario();
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select * from usuario where id = ?");
				prepStatement.setString(1, userName);

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						if (result.getString("senha").equals(password)) {
							usuario.setId(result.getString("id"));
							usuario.setNome(result.getString("nome"));
							usuario.setEmail(result.getString("email"));
							usuario.setPerfil(result.getString("perfil"));
							usuario.setSenha(result.getString("senha"));
							return usuario;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

}

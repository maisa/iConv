package service;

import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService() {
		usuarioRepository = new UsuarioRepository();
	}

	public String save(String userName, String password,
			String firstName, String emailAddress, String perfil) {
		if (usuarioRepository != null) {
			if (usuarioRepository.findByUserName(userName)) {
				return "SignupFailure-UserNameExists";
			}
			usuarioRepository.save(userName, password, firstName, emailAddress,
					perfil);
			return "SignupSuccess";
		} else {
			return "SignupFailure";
		}
	}

	public Usuario findByLogin(String userName, String password) {
		//String result = "LoginFailure";
		Usuario usuario = new Usuario();
		if (usuarioRepository != null) {
			usuario = usuarioRepository.findByLogin(userName, password);
			/*if (usuario == null) {
				result = "LoginFailure";
			} else {
				result = perfil;
			}*/
		}
		return usuario;
	}
}

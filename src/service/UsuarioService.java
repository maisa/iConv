package service;

import repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository studentRepository;

	public UsuarioService() {
		studentRepository = new UsuarioRepository();
	}

	public String save(String userName, String password,
			String firstName, String emailAddress, String perfil) {
		if (studentRepository != null) {
			if (studentRepository.findByUserName(userName)) {
				return "SignupFailure-UserNameExists";
			}
			studentRepository.save(userName, password, firstName, emailAddress,
					perfil);
			return "SignupSuccess";
		} else {
			return "SignupFailure";
		}
	}

	public String findByLogin(String userName, String password) {
		String result = "LoginFailure";
		if (studentRepository != null) {
			boolean status = studentRepository.findByLogin(userName, password);
			if (status) {
				result = "LoginSuccess";
			}
		}
		return result;
	}
}

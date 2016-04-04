package service;

import java.util.ArrayList;
import java.util.List;

import model.Convenio;
import model.PrestacaoContas;
import model.Usuario;
import repository.ConvenioRepository;

public class ConvenioService {

	private ConvenioRepository convenioRepository;

	public ConvenioService() {
		convenioRepository = new ConvenioRepository();
	}
	
	public void gravaArquivoPrestacao(byte[] bfile, String nr_convenio) {
		if (convenioRepository != null) {
			 convenioRepository.gravaArquivoPrestacao(bfile, nr_convenio);
			/*if (usuario == null) {
				result = "LoginFailure";
			} else {
				result = perfil;
			}*/
		}
	}

	public String save(String userName, String password,
			String firstName, String emailAddress, String perfil) {
		/*if (studentRepository != null) {
			if (studentRepository.findByUserName(userName)) {
				return "SignupFailure-UserNameExists";
			}
			studentRepository.save(userName, password, firstName, emailAddress,
					perfil);
			return "SignupSuccess";
		} else {
			return "SignupFailure";
		}*/
		return "teste";
	}

	public String listaConvenioByCpfProponente(String cpf_responsavel_proponente) {
		//String result = "LoginFailure";
		String lista = "";
		if (convenioRepository != null) {
			lista = convenioRepository.listaConvenioByCpfProponente(cpf_responsavel_proponente);
			/*if (usuario == null) {
				result = "LoginFailure";
			} else {
				result = perfil;
			}*/
		}
		return lista;
	}
	

	public Convenio findByNumero(String nr_convenio) {
		//String result = "LoginFailure";
		Convenio convenio = new Convenio();
		if (convenioRepository != null) {
			convenio = convenioRepository.findByNumero(nr_convenio);
			/*if (usuario == null) {
				result = "LoginFailure";
			} else {
				result = perfil;
			}*/
		}
		return convenio;
	}
	
	public List<PrestacaoContas> listaPrestacao(String nr_convenio) {
		//String result = "LoginFailure";
		PrestacaoContas prestacaoConta = new PrestacaoContas();
		List<PrestacaoContas> lista = new ArrayList<>();
		if (convenioRepository != null) {
			lista = convenioRepository.listaPrestacao(nr_convenio);
			/*if (usuario == null) {
				result = "LoginFailure";
			} else {
				result = perfil;
			}*/
		}
		return lista;
	}
	
	
}

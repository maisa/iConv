package service;

import java.util.ArrayList;
import java.util.List;

import model.AvaliacaoUsuario;
import model.Convenio;
import model.PrestacaoContaArquivo;
import model.PrestacaoContas;
import model.RankingAvaliacoes;
import model.Usuario;
import repository.ConvenioRepository;

public class ConvenioService {

	private ConvenioRepository convenioRepository;

	public ConvenioService() {
		convenioRepository = new ConvenioRepository();
	}
	
	public void gravaArquivoPrestacao(byte[] bfile, String nome, String tipo, String nr_convenio) {
		if (convenioRepository != null) {
			 convenioRepository.gravaArquivoPrestacao(bfile,nome, tipo, nr_convenio);
		}
	}

	public String listaConvenioByCpfProponente(String cpf_responsavel_proponente) {
		String lista = "";
		if (convenioRepository != null) {
			lista = convenioRepository.listaConvenioByCpfProponente(cpf_responsavel_proponente);
		}
		return lista;
	}
	

	public Convenio findByNumero(String nr_convenio) {
		Convenio convenio = new Convenio();
		if (convenioRepository != null) {
			convenio = convenioRepository.findByNumero(nr_convenio);
		}
		return convenio;
	}
	
	public List<PrestacaoContas> listaPrestacao(String nr_convenio) {
		List<PrestacaoContas> lista = new ArrayList<>();
		if (convenioRepository != null) {
			lista = convenioRepository.listaPrestacao(nr_convenio);
		}
		return lista;
	}
	
	public List<AvaliacaoUsuario> listaAvaliacoes(String nr_convenio) {
		List<AvaliacaoUsuario> lista = new ArrayList<>();
		if (convenioRepository != null) {
			lista = convenioRepository.listaAvaliacoes(nr_convenio);
		}
		return lista;
	}
	
	public List<RankingAvaliacoes> rankingAvaliacoes() {
		List<RankingAvaliacoes> lista = new ArrayList<>();
		if (convenioRepository != null) {
			lista = convenioRepository.rankingAvaliacoes();
		}
		return lista;
	}
	
	public List<PrestacaoContaArquivo> listaPrestacaoArquivo(String nr_convenio) {
		List<PrestacaoContaArquivo> lista = new ArrayList<>();
		if (convenioRepository != null) {
			lista = convenioRepository.listaPrestacaoArquivo(nr_convenio);
		}
		return lista;
	}
}

package model;

import java.io.File;


public class PrestacaoContaArquivo {
	private String nr_convenio;
	private File arquivo;
	private String nome_arquivo;
	private String tipo_arquivo;

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}

	public String getTipo_arquivo() {
		return tipo_arquivo;
	}

	public void setTipo_arquivo(String tipo_arquivo) {
		this.tipo_arquivo = tipo_arquivo;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}

	public String getNr_convenio() {
		return nr_convenio;
	}

	public void setNr_convenio(String nr_convenio) {
		this.nr_convenio = nr_convenio;
	}			
}

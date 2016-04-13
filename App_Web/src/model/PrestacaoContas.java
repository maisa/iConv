package model;

public class PrestacaoContas {
	private String data;
	private String valor;
	private String ordem_bancaria;
	private String tipo_movimentacao;
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getOrdem_bancaria() {
		return ordem_bancaria;
	}

	public void setOrdem_bancaria(String ordem_bancaria) {
		this.ordem_bancaria = ordem_bancaria;
	}

	public String getTipo_movimentacao() {
		return tipo_movimentacao;
	}

	public void setTipo_movimentacao(String tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}	
}

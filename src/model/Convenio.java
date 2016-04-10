package model;

import java.math.BigDecimal;

public class Convenio {
	private String nr_convenio;
	private String objeto;
	private String tx_situacao;
	private String tx_esfera_adm_proponente;
	private String uf_proponente;
	private String nm_municio_proponente;
	private String nm_orgao_concedente;
	private String area;
	private String dt_inicio_vigencia;
	private String dt_fim_vigencia;
	private String dt_ultimo_pgto;
	private BigDecimal vl_convenio;
	private BigDecimal vl_liberado;
	private BigDecimal vl_arepassar;
	
	public String getNr_convenio() {
		return nr_convenio;
	}
	
	public void setNr_convenio(String nr_convenio) {
		this.nr_convenio = nr_convenio;
	}
	
	public String getObjeto() {
		return objeto;
	}
	
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	
	public String getTx_situacao() {
		return tx_situacao;
	}
	
	public void setTx_situacao(String tx_situacao) {
		this.tx_situacao = tx_situacao;
	}
	
	public String getTx_esfera_adm_proponente() {
		return tx_esfera_adm_proponente;
	}
	
	public void setTx_esfera_adm_proponente(String tx_esfera_adm_proponente) {
		this.tx_esfera_adm_proponente = tx_esfera_adm_proponente;
	}
	
	public String getUf_proponente() {
		return uf_proponente;
	}
	
	public void setUf_proponente(String uf_proponente) {
		this.uf_proponente = uf_proponente;
	}
	
	public String getNm_municio_proponente() {
		return nm_municio_proponente;
	}
	
	public void setNm_municio_proponente(String nm_municio_proponente) {
		this.nm_municio_proponente = nm_municio_proponente;
	}
	
	public String getNm_orgao_concedente() {
		return nm_orgao_concedente;
	}
	
	public void setNm_orgao_concedente(String nm_orgao_concedente) {
		this.nm_orgao_concedente = nm_orgao_concedente;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getDt_inicio_vigencia() {
		return dt_inicio_vigencia;
	}
	
	public void setDt_inicio_vigencia(String dt_inicio_vigencia) {
		this.dt_inicio_vigencia = dt_inicio_vigencia;
	}
	
	public String getDt_fim_vigencia() {
		return dt_fim_vigencia;
	}
	
	public void setDt_fim_vigencia(String dt_fim_vigencia) {
		this.dt_fim_vigencia = dt_fim_vigencia;
	}
	
	public String getDt_ultimo_pgto() {
		return dt_ultimo_pgto;
	}
	
	public void setDt_ultimo_pgto(String dt_ultimo_pgto) {
		this.dt_ultimo_pgto = dt_ultimo_pgto;
	}
	
	public BigDecimal getVl_convenio() {
		return vl_convenio;
	}
	
	public void setVl_convenio(BigDecimal vl_convenio) {
		this.vl_convenio = vl_convenio;
	}
	
	public BigDecimal getVl_liberado() {
		return vl_liberado;
	}
	
	public void setVl_liberado(BigDecimal vl_liberado) {
		this.vl_liberado = vl_liberado;
	}
	
	public BigDecimal getVl_arepassar() {
		return vl_arepassar;
	}
	
	public void setVl_arepassar(BigDecimal vl_arepassar) {
		this.vl_arepassar = vl_arepassar;
	}
}

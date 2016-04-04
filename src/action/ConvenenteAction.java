package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Convenio;
import model.Usuario;
import model.PrestacaoContas;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import service.ConvenioService;
import service.UsuarioService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;

import java.io.IOException; 
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class ConvenenteAction extends ActionSupport {

	private String pageName;	
	private String nr_convenio; 
	private String tx_esfera_adm_proponente; 
	private String uf_proponente; 
	private String nm_municipio_proponente; 
	private String nm_orgao_concedente; 
	private String area; 
	private String dt_inicio_vigencia; 
	private String dt_fim_vigencia; 
	private String dt_ultimo_pgto; 
	private BigDecimal vl_convenio; 
	private BigDecimal vl_liberado;
	private BigDecimal vl_arepassar;
	private String objeto; 
	private String tx_situacao; 
	private String cpf_responsavel_proponente;
	private List<PrestacaoContas> listaPrestacaoContas;
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
    private String convenioSelecionado;

	public String getConvenioSelecionado() {
		return convenioSelecionado;
	}


	public void setConvenioSelecionado(String convenioSelecionado) {
		this.convenioSelecionado = convenioSelecionado;
	}


	@Action("convenente-input")
	public String input() throws Exception {		
		return "convenente";
	}
	

	@Override
	@Action("convenente")
	public String execute() throws Exception {
		ConvenioService convenioService = new ConvenioService();
		Convenio convenio = new Convenio();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String upload = request.getParameter("upload");
		String nr_convenio = request.getParameter("nr_convenio");	
		
		if (nr_convenio != null) {
			this.setConvenioSelecionado(nr_convenio);
		}
		
		System.out.println(this.getConvenioSelecionado()+" kkk "+this.getNr_convenio());

			if (convenioService != null) {
				
				if (upload!= null && upload.equals("S")) {
					File file = new File(myFile.getPath());
					 byte[] bFile = new byte[(int) file.length()];
					 
					 try {
						 FileInputStream fileInputStream = new FileInputStream(file);
						 fileInputStream.read(bFile);
						 fileInputStream.close();
						 } catch (Exception e) {
						 e.printStackTrace();
					 }
						
					 convenioService.gravaArquivoPrestacao(bFile, this.getConvenioSelecionado());
				}
				
				convenio = convenioService.findByNumero(this.getConvenioSelecionado());
				List<PrestacaoContas> lista = convenioService.listaPrestacao(this.getConvenioSelecionado()); 
				this.setNr_convenio(convenio.getNr_convenio());
				this.setObjeto(convenio.getObjeto());
				this.setTx_situacao(convenio.getTx_situacao());
				this.setUf_proponente(convenio.getUf_proponente());
				this.setNm_orgao_concedente(convenio.getNm_orgao_concedente());
				this.setDt_inicio_vigencia(convenio.getDt_inicio_vigencia());
				this.setDt_fim_vigencia(convenio.getDt_fim_vigencia());
				this.setVl_convenio(convenio.getVl_convenio());
				this.setVl_liberado(convenio.getVl_liberado());
				this.setVl_arepassar(convenio.getVl_arepassar());
				this.setListaPrestacaoContas(lista);

				return "ok";
			 
		}
			
		return SUCCESS;
	}



	public String getPageName() {
		return pageName;
	}



	public void setPageName(String pageName) {
		this.pageName = pageName;
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



	public String getNm_municipio_proponente() {
		return nm_municipio_proponente;
	}



	public void setNm_municipio_proponente(String nm_municipio_proponente) {
		this.nm_municipio_proponente = nm_municipio_proponente;
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



	public String getCpf_responsavel_proponente() {
		return cpf_responsavel_proponente;
	}



	public void setCpf_responsavel_proponente(String cpf_responsavel_proponente) {
		this.cpf_responsavel_proponente = cpf_responsavel_proponente;
	}



	public String getNr_convenio() {
		return nr_convenio;
	}



	public void setNr_convenio(String nr_convenio) {
		this.nr_convenio = nr_convenio;
	}
	
	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}
	
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	
	public List<PrestacaoContas> getListaPrestacaoContas() {
		return listaPrestacaoContas;
	}

	public void setListaPrestacaoContas(List<PrestacaoContas> listaPrestacaoContas) {
		this.listaPrestacaoContas = listaPrestacaoContas;
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

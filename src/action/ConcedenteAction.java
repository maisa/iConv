package action;

import javax.servlet.http.HttpServletRequest;

import model.AvaliacaoUsuario;
import model.RankingAvaliacoes;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import service.ConvenioService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import java.util.List;
import java.util.Map;


@SuppressWarnings("serial")
public class ConcedenteAction extends ActionSupport {

	private List<AvaliacaoUsuario> listaAvaliacoes;
	private List<RankingAvaliacoes> rankingAvaliacoes;
    private String convenioSelecionado;

	@Action("concedente-input")
	public String input() throws Exception {
		ConvenioService convenioService = new ConvenioService();
		if (convenioService != null) {
			
			List<RankingAvaliacoes> ranking = convenioService.rankingAvaliacoes();
			this.setRankingAvaliacoes(ranking);
			//List<AvaliacaoUsuario> listaAvaliacoes = convenioService.listaAvaliacoes(this.getConvenioSelecionado());
			//this.setListaAvaliacoes(listaAvaliacoes);
			return "concedente"; 
		}
		
		return "concedente";
	}

	@Override
	@Action("concedente")
	public String execute() throws Exception {
		ConvenioService convenioService = new ConvenioService();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String nr_convenio = request.getParameter("nr_convenio");	
		
		if (nr_convenio != null) {
			this.setConvenioSelecionado(nr_convenio);
		}
		


		if (convenioService != null) {
			
			List<RankingAvaliacoes> ranking = convenioService.rankingAvaliacoes();
			this.setRankingAvaliacoes(ranking);
			List<AvaliacaoUsuario> listaAvaliacoes = convenioService.listaAvaliacoes(this.getConvenioSelecionado());
			this.setListaAvaliacoes(listaAvaliacoes);
			return "ok"; 
		}
			
		return SUCCESS;
	}

	public List<AvaliacaoUsuario> getListaAvaliacoes() {
		return listaAvaliacoes;
	}


	public void setListaAvaliacoes(List<AvaliacaoUsuario> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}

	public String getConvenioSelecionado() {
		return convenioSelecionado;
	}


	public void setConvenioSelecionado(String convenioSelecionado) {
		this.convenioSelecionado = convenioSelecionado;
	}

	public List<RankingAvaliacoes> getRankingAvaliacoes() {
		return rankingAvaliacoes;
	}

	public void setRankingAvaliacoes(List<RankingAvaliacoes> rankingAvaliacoes) {
		this.rankingAvaliacoes = rankingAvaliacoes;
	}
	
}

package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import model.Convenio;
import model.Usuario;

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

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private String pageName;
	private String id;
	private String senha;

	@Action("login-input")
	public String input() throws Exception {
		return "login";
	}

	//@Action("login")
	@Override
	@Action(value = "login", results = { @Result(name = "convenente-input", location = "convenente-input", type = "redirect"),
			@Result(name = "concedente-input", location = "concedente-input", type = "redirect"),@Result(name = "convenente-teste", location = "convenente-teste", type = "redirect")})
	public String execute() throws Exception {
		
		Usuario usuario = new Usuario();
		UsuarioService usuarioService = new UsuarioService();
		
		String listaConvenios = "";
		ConvenioService convenioService = new ConvenioService();
		
		if (pageName != null && usuarioService != null) {
			if (pageName.equals("login")) {
				usuario = usuarioService.findByLogin(id, senha);
				if (usuario.getId() == null) {
					return "failure";
				} else {
					Map session = ActionContext.getContext().getSession();
					
					listaConvenios = convenioService.listaConvenioByCpfProponente(usuario.getId());
					
					session.put("listaConvenios",listaConvenios);
					session.put("id",usuario.getId());
					session.put("nome",usuario.getNome());
					
					if (usuario.getPerfil().equals("1")) 
						return "convenente-input";
					else if (usuario.getPerfil().equals("2"))
						return "concedente-input";
					else return "failure";
				}
			}
		}
		return SUCCESS;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getId() {
		return id;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "CPF é um campo obrigatório.")
	@StringLengthFieldValidator(type = ValidatorType.FIELD, maxLength = "11", minLength = "11", message = "O CPF deve ter 11 dígitos.")
	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Senha é um campo obrigatório.")
	@StringLengthFieldValidator(type = ValidatorType.FIELD, maxLength = "12", minLength = "6", message = "A senha deve ter entre 6 a 12 dígitos.")
	public void setSenha(String senha) {
		this.senha = senha;
	}

}

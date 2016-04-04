package action;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.convention.annotation.Action;

import service.UsuarioService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@SuppressWarnings("serial")
public class ConcedenteAction extends ActionSupport {

	private String pageName;
	private String id;
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Action("concedente-input")
	public String input() throws Exception {
		
		return "concedente";
	}

	@Action("concedente")
	public String execute() throws Exception {
		String result = "";
		UsuarioService studentService = new UsuarioService();

		if (pageName != null && studentService != null) {
			if (pageName.equals("concedente")) {
				/*result = studentService.findByLogin(id, senha);
				if (result.equals("LoginFailure")) {
					return "failure";
				} else {
					return "convenente";
				}*/
				System.out.print(id);
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

}

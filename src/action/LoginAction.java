package action;

import org.apache.struts2.convention.annotation.Action;

import service.UsuarioService;
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

	@Action("login")
	public String execute() throws Exception {
		String result = "";
		UsuarioService studentService = new UsuarioService();

		if (pageName != null && studentService != null) {
			if (pageName.equals("login")) {
				result = studentService.findByLogin(id, senha);
				if (result.equals("LoginFailure")) {
					return "failure";
				} else {
					return "success";
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

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "UserName is a required field")
	@StringLengthFieldValidator(type = ValidatorType.FIELD, maxLength = "12", minLength = "6", message = "UserName must be of length between 6 and 12")
	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Password is a required field")
	@StringLengthFieldValidator(type = ValidatorType.FIELD, maxLength = "12", minLength = "6", message = "Password must be of length between 6 and 12")
	public void setSenha(String senha) {
		this.senha = senha;
	}

}

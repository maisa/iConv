package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import service.UsuarioService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@SuppressWarnings("serial")
public class SignupAction extends ActionSupport {

	private String pageName;
	private String id;
	private String senha;
	private String nome;
	private String email;
	private String perfil = "1";

	@Action("signup-input")
	public String input() throws Exception {
		return "signup";
	}

	@Override
	@Action(value = "signup", results = { @Result(name = "login-input", location = "login-input", type = "redirect") })
	public String execute() throws Exception {
		String result = "";
		UsuarioService studentService = new UsuarioService();

		if (pageName != null && studentService != null) {
			if (pageName.equals("signup")) {
				result = studentService.save(id, senha, nome,
						email, perfil);
				if (result.equals("SignupSuccess")) {
					return "login-input";
				} else {
					return "failure";
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

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "CPF do gestor é um campo obrigatório.")
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

	public String getNome() {
		return nome;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "FirstName is a required field")
	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "EmailAddress is a required field")
	@EmailValidator(type = ValidatorType.FIELD, message = "Email Address must be valid")
	public void setEmail(String email) {
		this.email = email;
	}
}

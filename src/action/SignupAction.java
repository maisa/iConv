package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import service.UsuarioService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@SuppressWarnings("serial")
public class SignupAction extends ActionSupport {
	private String pageName;
	private String id;
	private String senha;
	private String nome;
	private String email;
	private String perfil;

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

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "CPF do gestor � um campo obrigat�rio.")
	@StringLengthFieldValidator(type = ValidatorType.FIELD, maxLength = "11", minLength = "11", message = "O CPF do gestor deve ter 11 d�gitos.")
	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Senha � um campo obrigat�rio.")
	@StringLengthFieldValidator(type = ValidatorType.FIELD, maxLength = "12", minLength = "6", message = "A senha deve ter entre 6 a 12 d�gitos")
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Nome � um campo obrigat�rio.")
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "E-mail � um campo obrigat�rio.")
	@EmailValidator(type = ValidatorType.FIELD, message = "O e-mail deve ser v�lido.")
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}

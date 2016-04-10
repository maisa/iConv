<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<sb:head includeScripts="false" includeScriptsValidation="false"
		includeStylesResponsive="true" />
	<sj:head jqueryui="true" />
	
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
	<link href="assets/css/bootstrap-united.css" rel="stylesheet" />


	<style>
		.error {
			color: #ff0000;
			font-size: 0.9em;
			font-weight: bold;
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
		
		input[type="text"],input[type="password"] {
			height: 40px;
		}
	</style>
	
	<title>iConv - Cadastro</title>

</head>

<body>

	<script src="bootstrap/js/bootstrap.js"></script>

	<div class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href=" ">Sobre</a></li>
				<li class="active"><a href="signup-input">Casdastre-se</a></li>
				<li><a href="login-input">Acesse</a></li>
			</ul>
		</div>
	</div>
	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<s:form id="myForm" action="signup" theme="bootstrap"
							validate="true" cssClass="bs-example form-horizontal"
							method="post">
							<fieldset>
								<legend>Cadastre-se. É super rápido!!</legend>
								<s:textfield label="CPF do Gestor" name="id"
									cssClass="col-lg-11" placeholder="CPF do Gestor" />
								<s:password label="Senha" name="senha"
									cssClass="col-lg-11" placeholder="Senha" />
								<s:textfield label="Nome" name="nome"
									cssClass="col-lg-11" placeholder="Nome" />
								<s:textfield label="E-mail" name="email"
									cssClass="col-lg-11" placeholder="E-mail" />
								<s:select label="Perfil" cssClass="col-lg-11" 
									list="#{'1':'Convenente','2':'Concedente'}" name="perfil">
								</s:select>
								<div class="col-lg-9 col-lg-offset-3">
									<s:submit cssClass="btn btn-default" value="Cancelar" />
									<s:submit cssClass="btn btn-primary" value="Cadastrar"/>
								</div>
								<s:hidden name="pageName" value="signup" />
							</fieldset>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");

			yesButton.click(function() {
				yesButton.button("loading");

				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};

				setTimeout(countDown, 100);
			});

		});
	</script>
</body>
</html>
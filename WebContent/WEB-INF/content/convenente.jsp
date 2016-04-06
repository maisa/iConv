<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sb:head includeScripts="false" includeScriptsValidation="false"
	includeStylesResponsive="true" />

<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />


<style>
.modalDialog {
  position: fixed;
  font-family: Arial, Helvetica, sans-serif;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background: rgba(0, 0, 0, 0.8);
  z-index: 99999;
  opacity: 0;
  -webkit-transition: opacity 400ms ease-in;
  -moz-transition: opacity 400ms ease-in;
  transition: opacity 400ms ease-in;
  pointer-events: none;
}
.modalDialog:target {
  opacity: 1;
  pointer-events: auto;
}
.modalDialog > div {
  width: 400px;
  position: relative;
  margin: 10% auto;
  padding: 5px 20px 13px 20px;
  border-radius: 10px;
  background: #fff;
  background: -moz-linear-gradient(#fff, #999);
  background: -webkit-linear-gradient(#fff, #999);
  background: -o-linear-gradient(#fff, #999);
}
.close {
  background: #606061;
  color: #FFFFFF;
  line-height: 25px;
  position: absolute;
  right: -12px;
  text-align: center;
  top: -10px;
  width: 24px;
  text-decoration: none;
  font-weight: bold;
  -webkit-border-radius: 12px;
  -moz-border-radius: 12px;
  border-radius: 12px;
  -moz-box-shadow: 1px 1px 3px #000;
  -webkit-box-shadow: 1px 1px 3px #000;
  box-shadow: 1px 1px 3px #000;
}
.close:hover {
  background: #00d9ff;
}

#sidebar-wrapper {
  top: 70px;
  left: -200px;
  width: 200px;
  background-color: #5677fc;
  color: white;
  position: absolute;
  height: 670px;;
  z-index: 1;
  overflow-y: scroll;
  
}
    
.sidebar-nav {
  position: absolute;
  top: 0;
  margin: 0;
  padding: 0;
  width: 250px;
  list-style: none;
}
.sidebar-nav li {
  text-indent: 20px;
  line-height: 50px;
}
.sidebar-nav li a {
  color: white;
  display: block;
  text-decoration: none;
}
.sidebar-nav li a:hover {
  background: rgba(255,255,255,0.25);
  color: white;
  text-decoration: none;
}
.sidebar-nav li a:active, .sidebar-nav li a:focus {
  text-decoration: none;
}

#sidebar-wrapper.sidebar-toggle {
  transition: all 0.3s ease-out;
  margin-left: -200px;
}
@media (min-width: 768px) {
  #sidebar-wrapper.sidebar-toggle {
    transition: 0s;
    left: 200px;
  }
}

</style>

<title>iConv - Acesso</title>

 <script type = "text/javascript" 
         src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		
<script type = "text/javascript" language = "javascript">

	function salvarArquivo() {
		var convenio = $('#nr_convenio').html();
		document.getElementsByName("convenioSelecionado")[0].value = convenio;
		
		var url = "convenente.action?upload=S"; 
		
		document.forms[0].action = url;
		document.forms[0].submit();
	}

  	function carregaListaConvenios() {
		var listaTransacoes = '<%= session.getAttribute("listaConvenios")%>';
		var lista = listaTransacoes.split(";");
		var i;
		
       	var items = '<ul class="sidebar-nav" > <li><b>Seus Convênios</b></li>';
       	for (i=0; i<(lista.length -1); i++) {
       		items += "<li><a href=\"convenente.action?upload=N&amp;nr_convenio="+lista[i] + "\">" + 
			lista[i] + "</a>";
				
       			
     }
       	

       	
       	items += '</ul>';
       	$('#sidebar-wrapper').append(items);
	}
</script>

</head>

<body  onload="carregaListaConvenios();">
	<script src="jquery-1.8.3.js"></script>

	<script src="bootstrap/js/bootstrap.js"></script>


	<nav class="navbar navbar-default" >
		<div class="container">
			<div class="navbar-header">
				<span class="navbar-brand" ><b>Perfil:</b> Convenente</span>
				<span class="navbar-brand" ><b>Gestor Responsável:</b> </span>
	  			<span class="navbar-brand" ><s:property value="#session.id"/></span>
	  			<span class="navbar-brand" >-</span>
				<span class="navbar-brand"><s:property value="#session.nome"/></span>
	  			
			</div>
			<div id="sidebar-wrapper" class="sidebar-toggle"> </div>  
		</div>		
	</nav>
	
	<div class="col-lg-10 col-lg-offset-2" >
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-10">
						<s:form id="myForm" action="convenente" theme="bootstrap"
							validate="true" cssClass="bs-example form-horizontal"
							method="post"  enctype="multipart/form-data">
							<fieldset>
								<legend>Informações do Convênio</legend>
								<table >
								<tr>
								<td>
								<s:label><b>Número:</b>
								<span id="nr_convenio" ><s:property value="nr_convenio"/></span>
								</s:label>
								</td>
								<td>
								
								<s:label><b>UF:</b>
								<span><s:property value="uf_proponente"/></span>
								</s:label>
								</td>
								<td>
								<s:label><b>Órgão Concedente:</b>
								<span><s:property value="nm_orgao_concedente"/></span>
								</s:label>
								</td>
								
								</tr>
								
								<tr>
								<td>
								<s:label><b>Ínicio Vigência:</b>
								<span><s:property value="dt_inicio_vigencia"/></span>
								</s:label>
								</td>
								<td>
								<s:label><b>Fim Vigência:</b>
								<span><s:property value="dt_fim_vigencia"/></span>
								</s:label>
								</td>
								<td>
								<s:label><b>Situação:</b>
								<span><s:property value="tx_situacao"/></span>	
								</s:label>
								</td>
								
								
								</tr>
								<tr>
								
								<td>
								
								<s:label><b>Valor do Convênio:</b>
								<span><s:property value="vl_convenio"/></span>
								</s:label>
								</td>
								<td>
								<s:label><b>Valor Liberado:</b>
								<span><s:property value="vl_liberado"/></span>
								</s:label>
								</td>
								<td>
								<s:label><b>Valor a Repassar:</b>
								<span><s:property value="vl_arepassar"/></span>
								</s:label>
								</td>
								</tr>
								
								
								</table>
								
								
								<s:label><b>Objeto:</b>
								<span><s:property value="objeto"/></span>	
								</s:label>
								
																
								<s:hidden name="pageName" value="convenente" />
								<s:hidden name="convenioSelecionado"/>
							    <legend>Informações sobre Pagamentos</legend>		
								<table class="table table-bordered">
								<tr>
								<th>Data
								</th>
								<th>Valor
								</th>
								<th>Editar
								</th>
								</tr>
								<s:iterator value="listaPrestacaoContas">
								<tr>
								<td><s:property value="data"/> </td>
								<td><s:property value="valor"/> </td>
								<td>
									<a href="#openModal">Editar</a>	

									<div id="openModal" class="modalDialog">
									  <div>
									    <a href="#close" title="Close" class="close">X</a>
									    <h2>Editar</h2>
									    <p>Em construção</p>
									  </div>
									</div> 								
								</td>
								</tr>
								</s:iterator>
								</table>
								<legend>Anexos</legend>
								<s:label>Adicione arquivos, podem ser fotos de execução, notas fiscais, recibos, etc.
								<b>Lembre-se, seu convênio está sendo fiscalizado pelos cidadãos!</b>
								</s:label>
								
      							<input type="file" name="myFile" />
      							<input type="button" onclick="salvarArquivo();" value="Enviar Anexo"/>
								
							</fieldset>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>	  	
</div>
	
</body>
</html>
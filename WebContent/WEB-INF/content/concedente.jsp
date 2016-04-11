<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<script src="js/jquery-1.8.3.js"></script>
<script src="js/excanvas.min.js"></script>
<script src="js/jquery.flot.min.js"></script>
<script src="js/jquery.flot.pie.min.js"></script>

<!-- CSS -->
<style type="text/css">
#flotcontainer {
    width: 600px;
    height: 400px;
    text-align: left;
}
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
  width: 660px;
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

</style>

<!-- Javascript -->

<script type="text/javascript">
$(function () {
	var listaResposta =  $('.tabela_resposta');
	var tamLista = listaResposta.length;
	var i = 0;
	var respostas = [];
	var quantidade = [];
	$('.tabela_resposta').each(
			function(){
			  respostas[i] = $(this).html();
			  i++;
			}
	);
	
	i=0;
	
	$('.tabela_quantidade').each(
			function(){
			  quantidade[i] = $(this).html();
			  i++;
			}
	);
	
	var dados = [];
	var tes;
	var sera;
	var out;
	
	for (i=0; i<tamLista; i++) {

		sera = respostas[i];
		out = quantidade[i];
		tes = {label: sera,data:out};
		dados[i] = tes;
	}

    var options = {
            series: {
                pie: {
                    show: true,
                    radius: 1,
                    tilt: 0.5,
                    label:{                        
                        radius: 3/4,
                        formatter: function (label, series) {
                            return '<div style="border:1px solid gray;font-size:8pt;text-align:center;padding:5px;color:white;">' + label + '<br/>' +   
                            Math.round(series.percent) + '%</div>';
                        },
                        background: {
                            opacity: 0.5,
                            color: '#000'
                        }
                    }
                }
            },
            legend: {
                show: false
            },
            grid: {
                hoverable: true,
                clickable: true
            }
         };
   
     if (tamLista > 0) {


    	
    $.plot($("#flotcontainer"), dados, options);  

    $("#flotcontainer").bind("plothover", function(event, pos, obj){
        if (!obj){return;}
        percent = parseFloat(obj.series.percent).toFixed(2);

        var html = [];
        html.push("<div style=\"flot:left;width:105px;height:20px;text-align:center;border:1px solid black;background-color:", obj.series.color, "\">",
                  "<span style=\"font-weight:bold;color:white\">", obj.series.label, " (", percent, "%)</span>",
                  "</div>");

        $("#showInteractive").html(html.join(''));        
    });
   $("#flotcontainer").bind("plotclick", function(event, pos, obj){
        if (!obj){return;}
        percent = parseFloat(obj.series.percent).toFixed(2);
        alert(obj.series.label + " ("+ percent+ "%)");

    });
    document.getElementById('linkmodal').click();
    }

     
});
</script>

<script>

function mostrarGrafico(a) {

	var nr_convenio = a.text;
	
	var url = "concedente.action?nr_convenio="+nr_convenio; 
	document.forms[0].action = url;
	document.forms[0].submit();
	
}

</script>
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
</head>
<body>


		<nav class="navbar navbar-default" >
			<div class="container" >
				<div class="navbar-header" >
					<span class="navbar-brand" ><b>Perfil:</b> Concedente</span>
					<span class="navbar-brand" ><b>Gestor Responsável:</b> </span>
		  			<span class="navbar-brand" ><s:property value="#session.id"/></span>
		  			<span class="navbar-brand" >-</span>
					<span class="navbar-brand"><s:property value="#session.nome"/></span>
		  			
				</div>
			</div>				
		</nav>
	
	
		<div class="well">
			<div class="container">
				<div class="row" >
					
						<s:form id="myForm" action="concedente" theme="bootstrap"
							validate="true" cssClass="bs-example form-horizontal"
							method="post"  enctype="multipart/form-data">
							<fieldset>
								
																
								<s:hidden name="pageName" value="concedente" />
								<s:hidden name="convenioSelecionado"/>
								
							    <legend align="center">Ranking dos convênios mais reprovados pelos cidadãos.</legend>		
								<table class="table table-bordered" id="tabelaDados">
									<tr >
										<th>Convênio</th>
										<th>Nome Concedente</th>
										<th>Nome Convenente</th>
										<th>Reprovações</th>
									</tr>
									<s:iterator value="rankingAvaliacoes">
										<tr>
											<td><a id="link" href="##" title="Click para visualizar o gráfico sobre os motivos das reprovações." onclick="mostrarGrafico(this)"><s:property value="nr_convenio"/></a></td>
											
								
											
											<td><s:property value="nome_concedente"/> </td>
											<td><s:property value="nome_convenente"/> </td>
											<td><s:property value="n_reprovacoes"/> </td>
										
										</tr>
									</s:iterator>
								</table>
								
								<table class="table table-bordered" id="tabelaDados" hidden="true">
									<tr>
										<th>Convênio</th>
										<th>Resposta</th>
										<th>Quantidade</th>
									</tr>
									<s:iterator id="listaAval" value="listaAvaliacoes">
										<tr>
											<td><s:property value="nr_convenio"/> </td>
											<td class="tabela_resposta"><s:property value="resposta"/> </td>
											<td class="tabela_quantidade"><s:property value="quantidade"/> </td>
									
										</tr>
									</s:iterator>
								</table>
								
							</fieldset>
						</s:form>
					
				</div>
						
				<a href="#openModal" id="linkmodal" hidden="true">Editar</a>	
				<div id="openModal" class="modalDialog">
					<div>
					    <a href="#close" title="Close" class="close">X</a>
					    <h2>Motivos das reprovações do convênio <s:property value="convenioSelecionado"/> </h2>
						<div id="flotcontainer" ></div>	
					</div>
				</div>
										
			</div>
		</div>
	
</body>
</html>


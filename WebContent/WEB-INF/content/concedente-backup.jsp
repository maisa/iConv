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
    }

});
</script>

<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
</head>
<body>


	<nav class="navbar navbar-default" >
		<div class="container">
			<div class="navbar-header">
				<span class="navbar-brand" ><b>Perfil:</b> Concedente</span>
				<span class="navbar-brand" ><b>Gestor Responsável:</b> </span>
	  			<span class="navbar-brand" ><s:property value="#session.id"/></span>
	  			<span class="navbar-brand" >-</span>
				<span class="navbar-brand"><s:property value="#session.nome"/></span>
	  			
			</div>
			<div id="sidebar-wrapper" class="sidebar-toggle"> 
			
			<ul class="sidebar-nav" > 
			    <li><b>FILTROS</b></li>

	       		<li><a href="concedente.action?upload=N&amp;nr_convenio=774037">BUSCAR</a></li>
					
	       	</ul>
			</div>
		</div>				
	</nav>
	
	<div id="frameDados" class="col-lg-10 col-lg-offset-2" >
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-10">
						<s:form id="myForm" action="concedente" theme="bootstrap"
							validate="true" cssClass="bs-example form-horizontal"
							method="post"  enctype="multipart/form-data">
							<fieldset>
								
																
								<s:hidden name="pageName" value="concedente" />
								<s:hidden name="convenioSelecionado"/>
								
							    <legend>Resultados</legend>		
								<table class="table table-bordered" id="tabelaDados">
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
				</div>
			</div>
			<div id="flotcontainer"></div>			
			
		</div>
	</div>	
	  	
</body>
</html>


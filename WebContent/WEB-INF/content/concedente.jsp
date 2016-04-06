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
#sidebar-wrapper {
  top: 52px;
  left: -200px;
  width: 200px;
  background-color: #5677fc;
  color: white;
  position: fixed;
  height: 100%;
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
         $(document).ready(function() {
        	 var url = "http://api.convenios.gov.br/siconv/v1/consulta/convenios.json?cpf_responsavel=";
        	 
        	 var cpf_responsavel = $('#cpf_responsavel span').text();
        	 
        	 var url = url+cpf_responsavel;
        	
        	 $.getJSON(url, function(data){
        	     var i;
        	     // <ul class="nav nav-pills nav-stacked" >
        	     var items = '<ul class="sidebar-nav" > ';
        		 for (i=0; i<data.convenios.length;i++){
        		 //for (i=0; i<5;i++){	 
        			 items += '<li><a href="#"> ' + data.convenios[i].id + ' - ' + data.convenios[i].valor_contra_partida + '</a></li>';
        			 //alert(data.convenios[i].valor_contra_partida); 
        	     }
        		 items += '</ul>';
        		 $('#sidebar-wrapper').append(items);
        	});
				
         });
      </script>

</head>

<body>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>


	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a id="menu-toggle" href="#" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				</a>
	  			<a class="navbar-brand" href="home.xhtml">
	  				CONCEDENTE
	  			</a>
			</div>
			<div id="sidebar-wrapper" class="sidebar-toggle">
			</div>
	  	</div>
	</nav>
	<div id="cpf_responsavel" style="display: none;">
		<span><s:property value="#session.id"/></span>
	</div>		    	
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

 <!-- Le styles -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="../css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<link href="css/style.css" rel="stylesheet" />
<title>Veterinaria - Clientes</title>

<SCRIPT type="text/javascript">

function verificarRegistroCliente(){	
	document.getElementById("frmValidar").src = "consultarServicioReniec?txtDNI=" + document.getElementById("txtDNI").value;
	document.getElementById("frmValidar").reload();
	//document.getElementById("frmValidar").contentWindow.navigate("consultarServicioReniec");	
	
}

function window_onload(){
	
	if(document.getElementById("_error").value == "0"){
		alert("EL DNI no existe!!!");
	}
	
}

</SCRIPT>

</head>
<body onload="window_onload()">

     

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="">
			<form id="frmIngreso" name="input" action="registrarCliente.html" method="post">
			
			<div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:100px">Id Cliente</label>
	          <div class="controls">
	            <input type="text" class="input-xlarge" value="${requestScope.model.codigo}" name="id" id="id">
	          </div>
    		</div>
    		
    		<div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:100px">DNI</label>	          
	          <div class="controls">
	            <input type="text" class="input-xlarge" value="${requestScope.model.dni}" id="txtDNI" name="txtDNI">
	            
	            <input type="button" class="btn btn-success" value="..." onclick="verificarRegistroCliente();">
	            
	          </div>
    		</div>
    
		    <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Nombre</label>
		          <div class="controls">
		            <input type="text" class="input-xlarge" value="${requestScope.model.nombre}" name="txtNombre" id="txtNombre">
		          </div>
		    </div>
		    
		    <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Ap. Paterno</label>
		          <div class="controls">
		            <input type="text"  class="input-xlarge" value="${requestScope.model.apellidopaterno}" name="txtApellidoPaterno" id="txtApellidoPaterno">
		          </div>
		    </div>
		    
		    <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Ap. Materno</label>
		          <div class="controls">
		            <input type="text"  class="input-xlarge" value="${requestScope.model.apellidomaterno}" name="txtApellidoMaterno" id="txtApellidoMaterno">
		          </div>
		    </div>
		    
		    <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Celular</label>
		          <div class="controls">
		            <input type="text" class="input-xlarge" name ="txtCelular">
		          </div>
		    </div>
		    
		    <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Telefono</label>
		          <div class="controls">
		            <input type="text" class="input-xlarge" name ="txtTelefono">
		          </div>
		    </div>
		    
		    <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Direccion</label>
		          <div class="controls">
		            <input type="text" class="input-xlarge" name ="txtDireccion">
		          </div>
		    </div>
		    
		    <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Email</label>
		          <div class="controls">
		            <input type="text" class="input-xlarge" name ="txtEmail">
		          </div>
		    </div>
		    
		    <div class="control-group">
				  <!-- Button -->
		          <div class="controls">
		            <input type="submit" value="Ingresar" class="btn btn-success" >
		            <input type="hidden" id="_error" value="${requestScope.model.error}" />
		          </div>
        	</div>
			
		
	</form>
      </div>
	<iframe id="frmValidar" style="display: none;">	
	</iframe>
</body>
</html>
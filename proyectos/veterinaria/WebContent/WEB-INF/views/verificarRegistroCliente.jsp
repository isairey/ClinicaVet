<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Insert title here</title>
<script type="text/JavaScript">
	
	function window_onload(){		
		
		if(document.getElementById("_error").value == "0"){
			clearValues();
			alert("EL DNI no existe!!!");			
		}else{			
			setValues();
		}
		
	}
	
	function setValues(){
		
		parent.document.getElementById("id").value = document.getElementById("id").value;
		parent.document.getElementById("txtNombre").value = document.getElementById("txtNombre").value;
		parent.document.getElementById("txtApellidoPaterno").value = document.getElementById("txtApellidoPaterno").value;
		parent.document.getElementById("txtApellidoMaterno").value = document.getElementById("txtApellidoMaterno").value;
		
	}
	
	function clearValues(){
		
		parent.document.getElementById("id").value = "";
		parent.document.getElementById("txtNombre").value = "";
		parent.document.getElementById("txtApellidoPaterno").value = "";
		parent.document.getElementById("txtApellidoMaterno").value = "";
		
	}
	
</script>
</head>
<body onload="window_onload();">
	<form id="frmIngreso" name="frmIngreso" >
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
	            <input type="text" class="input-xlarge" value="${requestScope.model.dni}" id="txtDNI" name="txtDNI" >            
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
				  <!-- Button -->
		          <div class="controls">
		            <input type="submit" value="Ingresar" class="btn btn-success" >
		            <input type="hidden" id="_error" value="${requestScope.model.error}" />
		          </div>
        	</div>  		  
			
	</form>
</body>
</html>
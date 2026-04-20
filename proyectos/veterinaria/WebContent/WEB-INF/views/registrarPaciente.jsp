<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Veterinaria - Mantenimiento de Doctores ::.. Agregar nuevo Doctor</title>
<link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>

<script>
	$(function() {
		$( "#datepicker" ).datepicker({ autoSize: true });
	});
</script>

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
    
    <script language="javascript" type="text/javascript" >
	function buscarcliente(){
		window.open("buscacliente","","width=600,height=600");
	}
	</script>

</head>
<body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Team Furious</a>
           <div class="btn-group pull-right">
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="icon-user"></i> ${sessionScope.username}
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">Profile</a></li>
              <li class="divider"></li>
              <li><a href="Login.jsp">Sign Out</a></li>
            </ul>
          </div>
          
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Inicio</a></li>
              <li><a href="listarcliente.jsp">Prospectos</a></li>
              <li><a href="listarcliente2.jsp">Clientes</a></li>
              <li><a href="listarpaciente.jsp">Pacientes</a></li>
      		  <li><a href="listardoctor.jsp">Doctores</a></li>
	          <li><a href="listarfacturas.jsp">Facturacion</a></li>
	                		   <li>
					<ul class="nav">
					  <li class="dropdown">
						    <a href="#"
						          class="dropdown-toggle"
						          data-toggle="dropdown">
						          Citas
						          <b class="caret"></b>
						    </a>
						    <ul class="dropdown-menu">
						    	<li><a href="verRegistroVacuna">Crear cita para vacunación</a></li>
						    	<li><a href="verRegistroTarea">Crear tarea en el calendario</a></li>
						    	<li><a href="listarVacuna">Ver calendario con las vacunas programadas</a></li>
						    	<li><a href="listarTarea">Ver calendario con las tareas asignadas</a></li>
						    	<li><a href="verRegistroNombreVacuna">Registrar Nombre de Vacuna</a></li>
						      
							</ul>
  						</li>
					</ul>
	           
	           </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
	  <div class="container" style="width: 1076px;">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
	
	<h3>Mantenimiento de Pacientes</h3><br />
	<form action="registrarPaciente.html" method="post">
	
			<div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Cliente:</label>
	          <div class="controls">
	            <input type="text" id="txtCliente" name="txtCliente" value="${requestScope.model.cliente}" readonly="readonly">
				<input type="button" id="imgcliente" name="imgcliente" onclick="buscarcliente();" value=" ... " class="btn btn-success">
				<input type="hidden" id="hiddencliente" name="hiddencliente" value="${requestScope.model.intidCliente}">
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Especie:</label>
	          <div class="controls">
	            <select name="cboEspecie" id="cboEspecie">
						<c:forEach items="${sessionScope.ESPECIE}" var="es" varStatus="i">
							<option value="${es.id}">${es.nombre}</option>
						</c:forEach>						
					</select> 
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Raza:</label>
	          <div class="controls">
	            <select name="cboRaza" id="cboRaza">
						<c:forEach items="${sessionScope.RAZA}" var="ra" varStatus="i">
							<option value="${ra.id}">${ra.nombre}</option>
						</c:forEach>						
					</select> 
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Genero:</label>
	          <div class="controls">
	           <select name="cboGenero" id="cboGenero">
						<c:forEach items="${sessionScope.GENERO}" var="gen" varStatus="i">
							<option value="${gen.id}">${gen.nombre}</option>
						</c:forEach>						
					</select> 
	          </div>
    		 </div>
    		  <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Tipo Sangre:</label>
	          <div class="controls">
	          <select name="cboTipoSangre" id="cboTipoSangre">
						<c:forEach items="${sessionScope.TIPOSANGRE}" var="ts" varStatus="i">
							<option value="${ts.id}">${ts.nombre}</option>
						</c:forEach>						
					</select>
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Esterilizado:</label>
	          <div class="controls">
	         <select id="cboEsterilizado" name="cboEsterilizado">
						<option value="0">No</option>
  						<option value="1">Si</option>
					</select>
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Tamaño:</label>
	          <div class="controls">
	         <select name="cboTamano" id="cboTamano">
						<c:forEach items="${sessionScope.TAMANO}" var="ta" varStatus="i">
							<option value="${ta.id}">${ta.nombre}</option>
						</c:forEach>						
					</select> 
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Actividad:</label>
	          <div class="controls">
	        <select name="cboActividad" id="cboActividad">
						<c:forEach items="${sessionScope.ACTIVIDAD}" var="ac" varStatus="i">
							<option value="${ac.id}">${ac.nombre}</option>
						</c:forEach>						
					</select> 
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Peso:</label>
	          <div class="controls">
	        <input id="txtPeso" name="txtPeso" /> 
	          </div>
    		 </div>
    		  <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Fecha Nacimiento:</label>
	          <div class="controls">
	        <input id="txtFechaNacimiento" name="txtFechaNacimiento" />
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Notas Medicas:</label>
	          <div class="controls">
	       <textarea rows="4" cols="30"  id="txtNotasMedicas" name="txtNotasMedicas" ></textarea>
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          <label class="control-label" for="input01" style="float:left;width:150px">Condiciones Especiales:</label>
	          <div class="controls">
	       <textarea rows="4" cols="30"  id="txtCondicionesEspeciales" name="txtCondicionesEspeciales" ></textarea>
	          </div>
    		 </div>
    		 <div class="control-group">
	          <!-- Text input-->
	          
	          <div class="controls">
	       <input type="submit" value="Ingresar" class="btn btn-success">
	          </div>
    		 </div>
    		 
	
	</form>
	</div>
	
	<div>
	<!-- end of center content -->
	      <footer>
        <p>&copy; Furious LLC 2013</p>
      </footer>

    </div> 
    

    
    
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/bootstrap.js"></script>
	
</body>
</html>
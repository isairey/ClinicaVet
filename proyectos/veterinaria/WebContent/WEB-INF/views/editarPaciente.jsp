<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Veterinaria - Mantenimiento de Pacientes::.. Editar un Paciente</title>
<link href="css/style.css" rel="stylesheet" />
<script src="../js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
<link href="../css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="../js/jquery-ui-1.8.20.custom.min.js" type="text/javascript" charset="utf-8"></script>

<script>

	$(document).ready(function () {

		$('#cboEspecie').val($('#_especieID').val());
		$('#cboRaza').val($('#_razaID').val());
		$('#cboGenero').val($('#_generoID').val());
		$('#cboTipoSangre').val($('#_tiposangreID').val());
		$('#cboEsterilizado').val($('#_esterilizadoID').val());
		$('#cboTamano').val($('#_tamanoID').val());
		$('#cboActividad').val($('#_actividadID').val());
	});
	
	function windows_onload(){
		
	}
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
</head>
<body >

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
              <i class="icon-user"></i> Username
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">Profile</a></li>
              <li class="divider"></li>
              <li><a href="#">Sign Out</a></li>
            </ul>
          </div>
          
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Inicio</a></li>
              <li><a href="forms/listarcliente.jsp">Clientes</a></li>
              <li><a href="forms/listardoctor.jsp">Doctores</a></li>
              <li><a href="forms/listarpaciente.jsp">Pacientes</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
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
<div class="hero-unit">
<h2>Mantenimiento de Pacientes</h2><br />
	<form name="form" id="form"  action="modificarPaciente.html" method="post" >
		
		<table>
		<tr>
				<td>Dueño:</td>
				<td>
					<input id="txtDueno" name="txtDueno" value="${requestScope.modelo.codigoDueno}"/></td>
			</tr>
			
			<tr>
				<td>Paciente:</td>
				<td>
					<input id="txtPaciente" name="txtPaciente" value="${requestScope.modelo.codigoPaciente}"/></td>
			</tr>
			<tr>
				<td>Especie:</td>
				<td>
					<select name="cboEspecie" id="cboEspecie">
						<c:forEach items="${sessionScope.ESPECIE}" var="ra" varStatus="i">
							<option value="${ra.id}">${ra.nombre}</option>
						</c:forEach>						
					</select> 
				</td>
			</tr>
			<tr>
				<td>Raza:</td>
				<td>
					<select name="cboRaza" id="cboRaza">
						<c:forEach items="${sessionScope.RAZA}" var="ra" varStatus="i">
							<option value="${ra.id}">${ra.nombre}</option>
						</c:forEach>						
					</select> 
				</td>
			</tr>
			<tr>
				<td>Genero:</td>
				<td>
					<select name="cboGenero" id="cboGenero">
						<c:forEach items="${sessionScope.GENERO}" var="gen" varStatus="i">
							<option value="${gen.id}">${gen.nombre}</option>
						</c:forEach>						
					</select> 
				</td>
			</tr>
			<tr>
				<td>Tipo Sangre:</td>
				<td>
					<select name="cboTipoSangre" id="cboTipoSangre">
						<c:forEach items="${sessionScope.TIPOSANGRE}" var="ts" varStatus="i">
							<option value="${ts.id}">${ts.nombre}</option>
						</c:forEach>						
					</select> 
				</td>
			</tr>
			<tr>
				<td>Esterilizado:</td>
				<td><select id="cboEsterilizado" name="cboEsterilizado">
						<option value="0">No</option>
  						<option value="1">Si</option>
					</select></td>
			</tr>
			<tr>
				<td>Tamaño:</td>
				<td>
					<select name="cboTamano" id="cboTamano">
						<c:forEach items="${sessionScope.TAMANO}" var="ta" varStatus="i">
							<option value="${ta.id}">${ta.nombre}</option>
						</c:forEach>						
					</select> 
				</td>
			</tr>
			<tr>
				<td>Actividad:</td>
				<td>
					<select name="cboActividad" id="cboActividad">
						<c:forEach items="${sessionScope.ACTIVIDAD}" var="ac" varStatus="i">
							<option value="${ac.id}">${ac.nombre}</option>
						</c:forEach>						
					</select> 
				</td>
			</tr>

			<tr>
				<td>Peso:</td>
				<td><input id="txtPeso" name="txtPeso" value="${requestScope.modelo.peso}"/></td>
			</tr>
			<tr>
				<td>Fecha Nacmiento:</td>
				<td><input id="txtFechaNacimiento" name="txtFechaNacimiento" value="${requestScope.modelo.fechaNacimiento}"/></td>
			</tr>
			<tr>
				<td>Notas Medicas:</td>
				<td><textarea rows="3" cols="20"  id="txtNotasMedicas" name="txtNotasMedicas">${requestScope.modelo.notasMedicas}</textarea></td>
			</tr>
			<tr>
				<td>Condiciones Especiales:</td>
				<td><textarea rows="3" cols="20"  id="txtCondicionesEspeciales" name="txtCondicionesEspeciales" >${requestScope.modelo.condicionesEspeciales}</textarea></td>
			</tr>			

			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Guardar" name="btnRegistrar" class="boton"/>
				</td>
			</tr>

		</table>
		
			<input type="hidden" id="_actividadID" name="_actividadID" value="${requestScope.modelo.actividadid}" />
			<input type="hidden" id="_tamanoID" name="_tamanoID" value="${requestScope.modelo.tamanoid}" />
			<input type="hidden" id="_esterilizadoID" name="_esterilizadoID" value="${requestScope.modelo.esterilizado}" />
			<input type="hidden" id="_tiposangreID" name="_tiposangreID" value="${requestScope.modelo.tipoSangreid}" />
			<input type="hidden" id="_generoID" name="_generoID" value="${requestScope.modelo.generoid}" />
			<input type="hidden" id="_razaID" name="_razaID" value="${requestScope.modelo.razaid}" />
			<input type="hidden" id="_especieID" name="_especieID" value="${requestScope.modelo.especieid}" />
	</form>
	</div>
	
	<div>
	<!-- end of center content -->
	      <footer>
        <p>&copy; Furious LLC 2013</p>
      </footer>

    </div> 
 </div> 
	
</body>
</html>
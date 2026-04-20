<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/DT_bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="../css/bootstrap-responsive.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>
<title>Veterinaria - Lista de Tareas asignadas</title>
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
      
		<h2>Lista de Tareas asignadas</h2> <br />
		<form action="verRegistroTarea" method="get">
			<input type="submit" name="btnNuevo" id="btnNuevo" value="Nueva Tarea"   class="btn btn-success" />
			<a href="menuCita.jsp" class="btn btn-success">Regresar al Menu</a>
		</form>
		<table cellpadding="0" cellspacing="0" border="0"  class="table table-striped table-bordered">
			<tr>
				<th>Fecha de la Tarea</th>
				<th>Codigo Cita</th>
				<th>Descripcion de la Tarea</th>
				<th>Doctor</th>
				<th>Cliente</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<th>Paciente</th>
				<td>Editar</td>
				<td>Eliminar</td>

			</tr>
			
			<c:forEach items="${model.tareas}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.fechaCita}</td>
				<td>${prod.codigoCita}</td>
				<td>${prod.descripcionCita}</td>
				<td>${prod.doctorPaterno},${prod.nombreDoctor}</td>
				<td>${prod.apellidoPaterno},${prod.nombresPersona}</td>
				<td>${prod.direccion}</td>
				<td>${prod.telefono}</td>
				<td>${prod.codigoPaciente}</td>
				<td align="center"><a
						href="editarTarea.jsp?idCita=${prod.codigoCita}"> <img
							src="images/editar.jpg" alt="" title="" border="0" /></a></td>
				<td align="center"><a
						href="eliminarTarea.jsp?idCita=${prod.codigoCita}"><img
							src="images/delete.gif" alt="" title="" border="0" /></a></td>
			</tr>
			</c:forEach>
			
		</table>
		</div>
		 <footer>
        <p>&copy; Furious LLC 2013</p>
      </footer>
      </div>
	</body>
</html>
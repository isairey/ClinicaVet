<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Consulta de Factura</title>
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
</head>
<body>
<form>
<h3>Consulta de Factura</h3><br>
		<div>
		
			<table>
				
				<tr>
					<td>Factura Nº:</td>
					<td><input type="text" id="txtfactura" value="${requestScope.model.codFactura}" readonly="readonly"></td>
					<td>Fecha:</td>
					<td><input type="text" id="txtfecha" value="${requestScope.model.feRegistro}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Cliente:</td>
					<td><input type="text" id="txtCliente" value="${requestScope.model.cliente}" readonly="readonly"></td>
					<td><input type="button" id="imgcliente" onclick="buscarcliente();" style="display: none" ></td>
					<td><input type="hidden" id="hiddencliente" value="${requestScope.model.intidCliente}"></td>
				</tr>
				<tr>
					<td>RUC:</td>
					<td><input type="text" id="txtruc" value="${requestScope.model.ruc}" readonly="readonly"></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div>
		<table>
				<tr>
					<td>Paciente:</td>
					<td><input type="text" id="txtpaciente" value="${requestScope.model.paciente}" readonly="readonly"></td>
					<td><img  id="imgpaciente"/></td>
					<td><input type="hidden" id="hiddenpaciente" value="${requestScope.model.idPaciente}"></td>
				</tr>
			</table>
		</div>
		
		<div>
			<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered">
				<thead>
		    	<tr>
		        	<th scope="col">Codigo</th>
		            <th scope="col">Producto</th>
		            <th scope="col">Cantidad</th>
		            <th scope="col">Precio</th>
		        </tr>
	    	</thead>
	    	<tbody>
				<c:forEach items="${requestScope.model.detalle}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.codProducto}</td>
				<td>${prod.producto}</td>
				<td>${prod.qtCantidad}</td>
				<td>${prod.precio}</td>
			</tr>
			</c:forEach>
				</tbody>
			
			</table>
		</div>
		</div>
		
	</form>
</body>
</html>
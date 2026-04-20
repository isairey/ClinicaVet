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
<title>Facturación</title>

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
	
			<H2><% if(request.getAttribute("mensaje")!=null){ %>
				<%= request.getAttribute("mensaje")%>
		<%	} %>
			</H2>
		
		<h2>Facturas</h2> <p>
		<form id="frmfacturacion" action="nuevafactura" method="get">
			<input type="submit" value="Registrar Factura" class="btn btn-primary btn-larg">
			<!--  <a href="Menu.jsp" class="btn btn-primary btn-larg">Menu</a>-->
		</form>
		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered">
			
			<thead>
		    	<tr>
		        	<th scope="col">Factura</th>
		            <th scope="col">Cliente</th>
		            <th scope="col">Fecha</th>
		            <th scope="col">Editar</th>
		            <th scope="col">Eliminar</th>

		        </tr>
	    	</thead>
			<tbody>
			<c:forEach items="${model.facturas}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.codigofactura}</td>
				<td>${prod.nombrecliente}</td>
				<td>${prod.fecharegistro}</td>
				<td align="center"><a
						href="verfactura?id=${prod.codigofactura}"> <img
							src="<%=request.getContextPath()%>/images/editar.jpg" alt="Consultar" title="" border="0" />
					</a></td>
				<td align="center"><a
						href="eliminarfactura?id=${prod.codigofactura}"><img
							src="<%=request.getContextPath()%>/images/delete.gif" alt="Eliminar" title="" border="0" /></a>
				</td>
			</tr>
			</c:forEach>
			<tbody>
		</table>
		</div>
		<footer>
        <p>&copy; Furious LLC 2013</p>
      </footer>
      </div>
</body>
</html>
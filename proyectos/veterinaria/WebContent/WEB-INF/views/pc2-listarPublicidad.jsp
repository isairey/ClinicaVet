<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <!DOCTYPE html >
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
  <!-- Le styles -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/DT_bootstrap.css" rel="stylesheet">
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
 
	<title>Lista de Publicidades</title>
</head>
	<body> 
	

	
	   <div class="container" style="width: 1076px;">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        <h2>Publicidad</h2> <p>
		
		<a class="btn btn-primary btn-larg" data-toggle="modal" href="#myModal" id="btnNew" flag="Prospecto">Nuevo</a>

		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
			<thead>	
				<tr>
					<th>Titulo</th>
					<th>Contenido</th>
					<th>Fecha Inicio</th>
					<th>Fecha Fin</th>
					<th>Tarifa</th>
					<th>Numero clicks</th>
					<th>Ubicacion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${model.publicidad}" var="prod" varStatus="i">
				<tr>
					<td width="100">${prod.titulo}</td>
					<td>${prod.contenido}</td>
					<td>${prod.fechaInicio}</td>
					<td>${prod.fechaFin}</td>
					<td>${prod.tarifa}</td>
					<td>${prod.numeroClicks}</td>
					<td></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
      </div>

      <footer>
        <p>&copy; Furious LLC 2012</p>
      </footer>
      
      
      <div class="modal hide" id="myModal">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal">×</button>
	    <h3>Ingresar Nuevo</h3>
	  </div>
	  <div class="modal-body">
	    <p>One fine body...</p>
	  </div>
	  <div class="modal-footer">
	    <!-- 
	    <a href="#" class="btn" data-dismiss="modal">Close</a>
	    <a href="#" class="btn btn-primary">Save changes</a>
	     -->
	  </div>
      
      

    </div> 
    
    
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" charset="utf-8" language="javascript" src="../js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf-8" language="javascript" src="../js/DT_bootstrap.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jas-script.js"></script>
	
	</body>
</html>
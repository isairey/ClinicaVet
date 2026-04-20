<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Team Furious</title>
    
    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
    
    
    <style type="text/css" media="screen">
            .slides_container {
                width:950px;
                height:463px;
            }
            .slides_container div {
                width:950px;
                height:463px;
                display:block;
            }
        </style>
    
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
              <i class="icon-user"></i> Username
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">Profile</a></li>
              <li class="divider"></li>
              <li><a href="forms/Login.jsp">Sign Out</a></li>
            </ul>
          </div>
          
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Inicio</a></li>
              <li><a href="forms/listarcliente.jsp">Prospectos</a></li>
              <li><a href="forms/listarcliente2.jsp">Clientes</a></li>
      		  <li><a href="forms/listardoctor.jsp">Doctores</a></li>
	          <li><a href="forms/listarfacturas.jsp">Facturacion</a></li>
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
						    	<li><a href="forms/verRegistroVacuna">Crear cita para vacunación</a></li>
						    	<li><a href="forms/verRegistroTarea">Crear tarea en el calendario</a></li>
						    	<li><a href="forms/listarVacuna">Ver calendario con las vacunas programadas</a></li>
						    	<li><a href="forms/listarTarea">Ver calendario con las tareas asignadas</a></li>
						    	<li><a href="forms/verRegistroNombreVacuna">Registrar Nombre de Vacuna</a></li>
						      
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
        <h2>Veterinaria Furious</h2>
      
        <div id="slides">
            <div class="slides_container">
                <div>
                    <img src="images/slides/01.jpg">
                </div>
                <div>
                    <img src="images/slides/02.jpg">
                </div>
                <div>
                    <img src="images/slides/03.jpg">
                </div>
            </div>
        </div>
        
        
        
        <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
      </div>

      <footer>
        <p>&copy; Furious LLC 2012</p>
      </footer>

    </div> 
    

    
    
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/slides.min.jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script language="javascript">

    $(function(){
    	window.location = "forms/Login";
        $("#slides").slides({
        	play: 5000,
        });
    });
    
    </script>
    
    
  </body>
</html>
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
<title>Veterinaria - Doctores</title>
<SCRIPT type="text/javascript">
function validar(){
	 var msg="";
	 var bol=true;
	 
	 if(document.getElementById("txtNombre").value=="") {
		 msg="Ingrese el Nombre!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtApellidoPaterno").value=="") {
		 msg=msg + "Ingrese Apellido Paterno!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtApellidoMaterno").value=="") {
		 msg=msg + "Ingrese Apellido Materno!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtEmail").value==""){
		 msg=msg + "Ingrese el email!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtEmail").value!=""){
		valor=document.getElementById("txtEmail").value;
		re=/^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,3})$/;
			if(!re.exec(valor))    {
				msg=msg + "Email Incorrecto!!! \n"; 
			    bol=false;
		    }
	 }
	 

	 
	 if(document.getElementById("txtUsuario").value=="") {
		 msg=msg + "Ingrese el usuario!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtPassword").value=="") {
		 msg=msg + "Ingrese la Contraseña!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("cboGrupo").value=="0") {
		 msg=msg + "Seleccione un grupo!!! \n"; 
		 bol=false;
	 }
	 		
	 if(msg.toString().length!=0){
		 alert(msg);
	 }
	 return bol;
}
</SCRIPT>
</head>
<body>

	<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Team Furious</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="../index.jsp">Inicio</a></li>
              <li><a href="listarcliente.jsp">Clientes</a></li>
              <li><a href="listardoctor.jsp">Doctores</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
     <div class="container" style="width: 1076px;">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
		<h3>Ingresar nuevo Doctor</h3>
			<form name="input" action="registrarDoctor.html" method="get">
		<table>
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th>Ingresar Datos</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td></td>
					<td><input type="submit" value="Ingresar" class="btn btn-primary btn-larg" onclick="return validar();" ></td>
				</tr>
			</tfoot>			
			<tr>
				<td>*</td>
				<td>Nombre</td>
				<td><input  id="txtnombre" name = "txtnombre"></td>
			</tr>
			<tr>
				<td>*</td>
				<td>Ap. Paterno</td>
				<td><input id="txtApellidoPaterno" name ="txtApellidoPaterno"></td>
			</tr>
			<tr>
				<td>*</td>
				<td>Ap. Materno</td>
				<td><input id="txtApellidoMaterno" name ="txtApellidoMaterno"></td>
			</tr>
			<tr>
				<td>*</td>
				<td>Email</td>
				<td><input id="txtEmail" name ="txtEmail"></td>
			</tr>
			<tr>
				<td></td>
				<td>Telefono</td>
				<td><input id="txtTelefono" name ="txtTelefono"></td>
			</tr>
			<tr>
				<td>*</td>
				<td>Usuario</td>
				<td><input id="txtUsuario" name ="txtUsuario"></td>
			</tr>
			<tr>
				<td>*</td>
				<td>Contraseña</td>
				<td><input id="txtPassword" name ="txtPassword" type="password"></td>
			</tr>
			<tr>
				<td>*</td>
				<td>Grupo</td>
				<td><select id="cboGrupo" name="cboGrupo">
						<option value="0">[SELECT]</option>
						<option value="1">Usuario</option>
  						<option value="2">Administrador</option>
					</select></td>
			</tr>
		</table>
	</form>
	</div>
	<footer>
        <p>&copy; Furious LLC 2013</p>
      </footer>

    </div> 

	<div class="center_content">
		
	</div>
</body>
</html>
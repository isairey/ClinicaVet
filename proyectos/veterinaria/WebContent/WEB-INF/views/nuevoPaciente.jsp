<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" />
<title>Veterinaria - Pacientes</title>
<SCRIPT type="text/javascript">
 function validar(){
	 var msg="";
	 var bol=true;
	 if(document.getElementById("txtNombre").value=="") {
		 msg="Ingrese Nombre del Prospecto!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtApellidoPaterno").value=="") {
		 msg=msg + "Ingrese Apellido Paterno del Prospecto!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtApellidoMaterno").value=="") {
		 msg=msg + "Ingrese Apellido Materno del Prospecto!!! \n"; 
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
		 msg=msg + "Ingrese usuario del doctor!!! \n"; 
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

	<div class="center_content">
		<h3>Ingresar nuevo Paciente</h3>
			<form name="input" action="registrarDoctor.html" method="get">
		<table border="1">
			<thead>
				<tr>
					<th></th>
					<th>Ingresar Datos</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td></td>
					<td><input type="submit" value="Ingresar"></td>
				</tr>
			</tfoot>			
			<tr>
				<td>Nombre</td>
				<td><input name = "txtnombre"></td>
			</tr>
			<tr>
				<td>Ap. Paterno</td>
				<td><input name ="txtApellidoPaterno"></td>
			</tr>
			<tr>
				<td>Ap. Materno</td>
				<td><input name ="txtApellidoMaterno"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name ="txtEmail"></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input name ="txtTelefono"></td>
			</tr>
			<tr>
				<td>Usuario</td>
				<td><input name ="txtUsuario"></td>
			</tr>
			<tr>
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

</body>
</html>
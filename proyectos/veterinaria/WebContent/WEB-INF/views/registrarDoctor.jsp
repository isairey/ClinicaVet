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
	/*$(function() {
		$( "#datepicker" ).datepicker({ autoSize: true });
	});
	*/
</script>


</head>
<body>

	<div class="center_content">
	<h3>Mantenimiento de Doctores</h3>
	<form action="registrarDoctor.html" method="post">
		<table>
		
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
			<td>Contraseña</td>
				<td><input name ="txtPassword" type="password"></td>
			</tr>
		</table>
	</form>
	</div>
	<!-- end of center content -->
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Veterinaria - Mantenimiento de Clientes ::.. Agregar nuevo Cliente</title>
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


</head>
<body>

	<div class="center_content">
	<h3>Mantenimiento de Clientes</h3>
	<form action="registrarCliente" method="post">
		<table>
		
			<tr>
				<td>Nombre:</td>
				<td><input id="txtNombre" name="txtNombre" /></td>
			</tr>
			<tr>
				<td>Apellido Paterno:</td>
				<td><textarea rows="3" cols="20" name="txtApellidoPaterno"
						id="txtDescripcion"></textarea></td>

			</tr>

			<tr>
				<td>Apellido Materno:</td>
				<td><textarea rows="3" cols="20" name="txtApellidoMaterno"
						id="txtApellidoMaterno"></textarea></td>

			</tr>
			<tr>
				<td>Raza:</td>
				<td><textarea rows="3" cols="20" name="txtRaza"
						id="txtRaza"></textarea></td>

			</tr>
		
			
			<tr>
				<td colspan="2"><input type="submit" value="Registrar"
					name="btnRegistrar" /></td>
			</tr>
		</table>
	</form>
	</div>
	
	
</body>
</html>
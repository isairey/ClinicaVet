<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" />
<title>Veterinaria - Doctor</title>
</head>
<body>
	<div class="center_content">
		<h3>Eliminar Doctor</h3>
		<form name="input" action="eliminarDoctor.html" method="POST">
		<input type ="hidden" name ="id" value="${USUARIOMOD.id}">
		<table border = "1">
			<thead>
				<tr>
					<th></th>
					<th>Datos actuales</th>
					
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td></td>
					<td><input type="submit" value = "Eliminar"></td>
				</tr>
			</tfoot>
			<tr>
				<td>Id Doctor</td>
				<td>${model.doctorID}</td>
				
			</tr>
			<tr>
				<td>Nombre</td>
				<td>${model.nombre}</td>
				
			</tr>
			<tr>
				<td>Ap. Paterno</td>
				<td>${model.paterno}</td>
				
			</tr>
			<tr>
				<td>Ap. Materno</td>
				<td>${model.materno}</td>
				
			</tr>
			<tr>
				<td>Email</td>
				<td>${model.email}</td>
				
			</tr>
			<tr>
				<td>Telefono</td>
				<td>${model.telefono}</td>
				
			</tr>
			<tr>
				<td>Usuario</td>
				<td>${model.usuario}</td>
				
			</tr>


		</table>
	</form>
	</div>

</body>
</html>
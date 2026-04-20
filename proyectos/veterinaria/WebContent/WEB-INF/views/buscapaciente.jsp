<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda de Pacientes</title>
<script type="text/javascript" language="javascript">
	function seleccionarpaciente(codigo,nombre){
		window.opener.document.getElementById("hiddenpaciente").value=codigo;
		window.opener.document.getElementById("txtpaciente").value=nombre;
		window.close();
	}
</script>
<style type="text/css">
#gradient-style
{
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;
	width: 480px;
	text-align: left;
	border-collapse: collapse;
}
#gradient-style th
{
	font-size: 13px;
	font-weight: normal;
	padding: 8px;
	background: #b9c9fe url('table-images/gradhead.png') repeat-x;
	border-top: 2px solid #d3ddff;
	border-bottom: 1px solid #fff;
	color: #039;
}
#gradient-style td
{
	padding: 8px; 
	border-bottom: 1px solid #fff;
	color: #669;
	border-top: 1px solid #fff;
	background: #e8edff url('table-images/gradback.png') repeat-x;
}
#gradient-style tfoot tr td
{
	background: #e8edff;
	font-size: 12px;
	color: #99c;
}
#gradient-style tbody tr:hover td
{
	background: #d0dafd url('table-images/gradhover.png') repeat-x;
	color: #339;
}
</style>
</head>
<body>
<div class="center_content">
		<h1>Buscador de Pacientes</h1> <p>
		<form action="" method="get">
		</form>
		<table id="gradient-style" summary="Meeting Results">
			<thead>
		    	<tr>
		        	<th scope="col">Codigo</th>
		            <th scope="col">Nombre</th>
		            <th scope="col">Seleccionar</th>
		        </tr>
	    	</thead>
			<tbody>
			<c:forEach items="${model.pacientes}" var="prod" varStatus="i">
			<tr>
				<td>${prod.codigoPaciente}</td>
				<td width="100">${prod.especie}</td>
				<td><a href="#" onclick='seleccionarpaciente("${prod.codigoPaciente}","${prod.especie}");'>Seleccionar</a></td>
			</tr>
			</c:forEach>
			</tbody>
			
		</table>
		</div>
</body>
</html>
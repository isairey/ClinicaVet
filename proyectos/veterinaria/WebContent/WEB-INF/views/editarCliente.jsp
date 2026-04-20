<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Veterinaria - Mantenimiento de Prospectos::.. Editar un Prospecto</title>
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
<SCRIPT type="text/javascript">
function validar(){
	 
	 if(confirm("Desea registrar el siguiente Prospecto?")){
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
		 
		 if(msg.toString().length!=0){
			 alert(msg);
		 }
		 return bol;
	 }else{
	 	return false;
	 }
		 
	 }
 
 function AbrirUpload(){
	 var codigo=document.getElementById("id").value;
	 window.open("../Upload.jsp?id=" + codigo,"","width=400,height=300");
 }
 function solonumbers(e){
		 var key;

		 if(window.event) // IE
		 {
		  key = e.keyCode;
		 }
		  else if(e.which) // Netscape/Firefox/Opera
		 {
		  key = e.which;
		 }
		
		 if (key < 48 || key > 57) 
		    {
		      return false;
		    }
		
		 return true;
	}
</SCRIPT>

</head>

<style>
<!--
.errors {
	color: red;
}
-->
</style>

</head>
<body>

	<div class="center_content">
	<h3>Mantenimiento de Prospectos</h3>
	<form action="guardarModificacionCliente.jsp" method="post">
		<table>
			<tr>
				<td>Código Prospecto:</td>
				<td><input id="id" name="id" value="${requestScope.model.codigo}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input id="txtNombre" name="txtNombre"  value="${requestScope.model.nombre}" maxlength="50"/></td>
			</tr>
			<tr>
				<td>Apellido Paterno:</td>
				<td><input name="txtApellidoPaterno"
						id="txtApellidoPaterno" value="${requestScope.model.apellidopaterno}" maxlength="50"/></td>

			</tr>
			
			<tr>
				<td>Apellido Materno:</td>
				<td><input name="txtApellidoMaterno"
						id="txtApellidoMaterno" value="${requestScope.model.apellidomaterno}" maxlength="50"/></td>

			</tr>
			<tr>
				<td>Dirección:</td>
				<td><textarea rows="3" cols="20" name="txtDireccion"
						id="txtDireccion"  maxlength="150">${requestScope.model.direccion}</textarea></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="txtEmail"
						id="txtEmail" value="${requestScope.model.email}" maxlength="30" /></td>
			</tr>
			<tr>
				<td>Teléfono:</td>
				<td><input name="txtTelefono"
						id="txtTelefono" value="${requestScope.model.telefono}" maxlength="15" onkeypress="javascript:return solonumbers(event);"/></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><input name="txtCelular"
						id="txtCelular" value="${requestScope.model.celular}" maxlength="15" onkeypress="javascript:return solonumbers(event);"/></td>
			</tr>
			<tr>
				<td>Foto:</td>
				<td>
				<img alt="" width="100px" height="100px" src="C:\\Users\\operador\\workspace\\HelloWorldSpring3\\WebContent\\Fotos\\'${requestScope.model.imagen}" />
				<input type="button" name="btnFoto" id="btnFoto" onclick="AbrirUpload();"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" onclick="return validar();"
					name="btnRegistrar" /> </td>
					<td><a href="listarcliente.jsp">Cancelar</a></td>
			</tr>
			
		</table>
	</form>
	</div>

	
</body>
</html>
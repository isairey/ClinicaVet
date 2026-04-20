<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Veterinaria - Editar una cita para vacunacion</title>
<link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>

<SCRIPT type="text/javascript">
 function validar()
 {
	 var msg="";
	 var bol=true;
	 if(document.getElementById("txtCodigoDoctor").value=="") {
		 msg=msg +"Ingrese Codigo del Doctor!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtCodigoCliente").value=="") {
		 msg=msg +"Ingrese Codigo del Cliente!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtCodigoPaciente").value=="") {
		 msg=msg +"Ingrese Codigo del Paciente!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtVacuna").value=="") {
		 msg=msg + "Ingrese nombre de la Vacuna!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtFecha").value=="") {
		 msg=msg + "Ingrese la Fecha de la Vacuna!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtFecha").value != "")
     {
		if(validarFecha(document.getElementById("txtFecha").value) == false)
		{
			 msg=msg + "Error en la fecha \n"; 
			 bol=false;
		}
     }
	 
	 if(msg.toString().length!=0){
		 alert(msg);
	 }
	 return bol;
 }
 function validarFecha(fecha) 
 { 
	 try{ var fecha = fecha.split("/"); var dia = fecha[0]; var mes = fecha[1]; var ano = fecha[2]; var estado = true; if ((dia.length == 2) && (mes.length == 2) && (ano.length == 4)) { switch (parseInt(mes)) { case 1:dmax = 31;break; case 2: if (ano % 4 == 0) dmax = 29; else dmax = 28; break; case 3:dmax = 31;break; case 4:dmax = 30;break; case 5:dmax = 31;break; case 6:dmax = 30;break; case 7:dmax = 31;break; case 8:dmax = 31;break; case 9:dmax = 30;break; case 10:dmax = 31;break; case 11:dmax = 30;break; case 12:dmax = 31;break; } dmax!=""?dmax:dmax=-1; if ((dia >= 1) && (dia <= dmax) && (mes >= 1) && (mes <= 12)) { for (var i = 0; i < fecha[0].length; i++) { diaC = fecha[0].charAt(i).charCodeAt(0); (!((diaC > 47) && (diaC < 58)))?estado = false:''; mesC = fecha[1].charAt(i).charCodeAt(0); (!((mesC > 47) && (mesC < 58)))?estado = false:''; } } for (var i = 0; i < fecha[2].length; i++) { anoC = fecha[2].charAt(i).charCodeAt(0); (!((anoC > 47) && (anoC < 58)))?estado = false:''; } }else estado = false; return estado; }catch(err){ alert("Error fecha"); 
 }
 }
</SCRIPT>

</head>
<body>

	<div class="center_content">
	<h3>Mantenimiento de Citas para vacunacion</h3>
	<form action="guardarVacuna" method="post">
		<table>
			<tr>
				<td>Código Cita:</td>
				<td><input id="idCita" name="idCita" value="${requestScope.model.codigoCita}" readonly="true"/></td>
			</tr>
			<tr>
				<td>Codigo Doctor:</td>
				<td><input name = "txtCodigoDoctor" id="txtCodigoDoctor" value="${requestScope.model.codigoDoctor}"></td>
			</tr>
			<tr>
				<td>Codigo Cliente:</td>
				<td><input name ="txtCodigoCliente" id="txtCodigoCliente" value="${requestScope.model.codigoPersona}"></td>
			</tr>
			<tr>
				<td>Codigo Paciente:</td>
				<td><input name ="txtCodigoPaciente" id="txtCodigoPaciente" value="${requestScope.model.codigoPaciente}"></td>
			</tr>
			<tr>
				<td>Nombre de Vacuna:</td>
				<td><input name ="txtVacuna" id="txtVacuna" value="${requestScope.model.nombreVacuna}"></td>
			</tr>
			<tr>
				<td>Notas:</td>
				<td><textarea rows="3" cols="20" name="txtDescripcion" id="txtDescripcion">${requestScope.model.descripcionCita}</textarea></td>
			</tr>
			<tr>
				<td>Fecha Vacuna (dd/mm/yyyy):</td>
				<td><input name ="txtFecha" id="txtFecha" value="${requestScope.model.fechaCita}"></td>
			</tr>
			
			
			<tr>
				<td colspan="2">
				  <input type="submit" value="Guardar Cita" name="btnRegistrar" onclick="return validar();" /></td>
				  <td><a href="menuCita">Cancelar</a></td>
			</tr>
			
		</table>
	</form>
	</div>

	
</body>
</html>
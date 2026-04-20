<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/DT_bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="../css/bootstrap-responsive.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>
<title>Facturación</title>
<script language="javascript" type="text/javascript" >
	function buscarcliente(){
		window.open("buscacliente","","width=600,height=600");
	}
	function buscarproducto(){
		window.open("buscaproducto","","width=600,height=400");
	}
	function buscarpaciente(){
		window.open("buscapaciente?idcliente="+ document.getElementById("hiddencliente").value,"","width=600,height=400");
	}
	
	function accion(valor){
		document.getElementById("Hiddenaccion").value=valor;
	}
	
	function detalle(){
		var msg="";
		if(document.getElementById("idproducto").value==""){
				msg="Seleccione un Producto\n";
		}
		if(document.getElementById("txtxcantidad").value==""){
				msg= msg + "Ingrese la cantidad a facturar\n";
		}
		if(msg.length!=0){
			alert(msg);
			return false;
		}
		
		document.getElementById("Hiddenaccion").value="0";
		return true;
	}
	
	function grabar(){
		if(confirm("Desea registrar esta Factura?")){
			var msg="";
			if(document.getElementById("hiddencliente").value=="0"){
				msg="Seleccione un Cliente\n";
			}
			if(document.getElementById("txtruc").value==""){
				msg=msg + "Ingrese RUC del Cliente\n";
			}else{
				if(document.getElementById("txtruc").value.length!=11){
					msg=msg + "RUC incorrecto\n";
				}
			}
			if(document.getElementById("hiddenpaciente").value=="0"){
			msg=msg + "Seleccione un Paciente\n";
			}
			
			if(document.getElementById("Hiddenaccion").value=="-1"){
			msg=msg + "Ingrese un Producto\n";
			}
			
			 if(msg.length!=0){
				 alert(msg);
				 return false;
			 }
			document.getElementById("Hiddenaccion").value="1";
			return true;
		}
		else{
			return false;
		}
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
</script>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/facturacion.js"></script>
</head>
<body>
 <div class="container" style="width: 1076px;">
<div class="hero-unit">
	<form action="recargafactura" method="post">
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
              <i class="icon-user"></i> ${sessionScope.username}
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">Profile</a></li>
              <li class="divider"></li>
              <li><a href="Login.jsp">Sign Out</a></li>
            </ul>
          </div>
          
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Inicio</a></li>
              <li><a href="listarcliente.jsp">Prospectos</a></li>
              <li><a href="listarcliente2.jsp">Clientes</a></li>
              <li><a href="listarpaciente.jsp">Pacientes</a></li>
      		  <li><a href="listardoctor.jsp">Doctores</a></li>
	          <li><a href="listarfacturas.jsp">Facturacion</a></li>
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
						    	<li><a href="verRegistroVacuna">Crear cita para vacunación</a></li>
						    	<li><a href="verRegistroTarea">Crear tarea en el calendario</a></li>
						    	<li><a href="listarVacuna">Ver calendario con las vacunas programadas</a></li>
						    	<li><a href="listarTarea">Ver calendario con las tareas asignadas</a></li>
						    	<li><a href="verRegistroNombreVacuna">Registrar Nombre de Vacuna</a></li>
						      
							</ul>
  						</li>
					</ul>
	           
	           </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
			<div class="control-group">
			<h3>Registro de Factura</h3>
	          <!-- Text input-->
	          
	          <div class="controls">
	            <input type="submit" value="Grabar" onclick="return grabar();" class="btn btn-primary btn-larg">
	            <input type="hidden" id="Hiddenaccion" name="Hiddenaccion" value="<%=request.getAttribute("accion")%>">
	          </div>
    		 </div>
    		   <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Factura Nº:</label>
		          <div class="controls">
		            <input type="text" id="txtfactura" name="txtfactura" value="${requestScope.model.codFactura}" readonly="readonly"/>
		          </div>
		       </div>
		       <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Fecha :</label>
		          <div class="controls">
		            <input type="text" id="txtfecha" name="txtfecha" value="${requestScope.model.feRegistro}" readonly="readonly"/>
		          </div>
		       </div>
		        <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Cliente:</label>
		          <div class="controls">
		            <input type="text" id="txtCliente" name="txtCliente" value="${requestScope.model.cliente}" readonly="readonly">
					<input type="button" id="imgcliente" name="imgcliente" onclick="buscarcliente();"  class="btn btn-success" value=" ... ">
					<input type="hidden" id="hiddencliente" name="hiddencliente" value="${requestScope.model.intidCliente}">
		          </div>
		       </div>
		       <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">RUC:</label>
		          <div class="controls">
		            <input type="text" id="txtruc" name="txtruc" value="${requestScope.model.ruc}" maxlength="11" onkeypress="javascript:return solonumbers(event);">
		            <a href="#" id="hlRucRest" >Comprobar Datos</a>
		          </div>
		       </div>
		       <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Paciente:</label>
		          <div class="controls">
		            <input type="text" id="txtpaciente" name="txtpaciente" value="${requestScope.model.paciente}" >
					<input type="button" id="imgcliente" name="imgcliente" onclick="buscarpaciente();" value=" ... " class="btn btn-success" >
					<input type="hidden" id="hiddenpaciente" name="hiddenpaciente" value="${requestScope.model.idPaciente}">
		          </div>
		       </div>
		         <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Producto::</label>
		          <div class="controls">
		            <input type="text" id="idproducto" name="idproducto" readonly="readonly">
					<input type="text" id="nombreproducto" name="nombreproducto" readonly="readonly" >
					<input type="button" value="Buscar producto" onclick="buscarproducto();" class="btn btn-success"> 
		          </div>
		       </div>
		         <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Precio:</label>
		          <div class="controls">
		            <input type="text" id="txtprecio" name="txtprecio" readonly="readonly">
		          </div>
		       </div>
		        <div class="control-group">
		          <!-- Text input-->
		          <label class="control-label" for="input01" style="float:left;width:100px">Cantidad:</label>
		          <div class="controls">
		            <input type="text" id="txtxcantidad" name="txtxcantidad" maxlength="5" onkeypress="javascript:return solonumbers(event);">
		          </div>
		       </div>
		        <div class="control-group">
		          <!-- Text input-->
		         
		          <div class="controls">
		           <input type="submit" value="Agregar" onclick="return detalle();" class="btn btn-success">
		          </div>
		       </div>
		
			<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered">
						
		    	<tr>
		        	<th scope="col">Codigo</th>
		            <th scope="col">Producto</th>
		            <th scope="col">Cantidad</th>
		            <th scope="col">Precio</th>
		        </tr>
	    	
				<c:forEach items="${requestScope.model.detalle}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.codProducto}</td>
				<td>${prod.producto}</td>
				<td>${prod.qtCantidad}</td>
				<td>${prod.precio}</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
		
	</form>
	</div>
	</div>
	</div>
</body>
</html>
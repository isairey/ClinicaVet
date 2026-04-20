<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>
	<title>Veterinaria - Citas de vacunas y tareas</title>
</head>
<body>
  <div class="center_content">
    <h1>Veterinaria - Citas de vacunas y tareas</h1> <p>
  </div>
   <div>
     <table>
                <tr>
					<td>
					  <form action="verRegistroVacuna" method="get">
			          <input type="submit" name="btnCrearCita" id="btnCrearCita" value="Crear cita para vacunación" />
		              </form>
					</td>
				</tr>
				<tr>
					<td>
					  <form action="verRegistroTarea" method="get">
			          <input type="submit" name="btnCrearTarea" id="btnCrearTarea" value="Crear tarea en el calendario" />
		              </form>
					</td>
				</tr>
				<tr>
					<td>
					  <form action="listarVacuna" method="get">
			          <input type="submit" name="btnListarVacunas" id="btnListarVacunas" value="Ver calendario con las vacunas programadas" />
		              </form>
                    </td>
				</tr>
				<tr>
					<td>
					  <form action="listarTarea" method="get">
			          <input type="submit" name="btnListarTareas" id="btnListarTareas" value="Ver calendario con las tareas asignadas" />
		              </form>
					</td>
				</tr>
				<tr>
					<td>
					  <form action="verRegistroNombreVacuna" method="get">
			          <input type="submit" name="btnVacuna" id="btnVacuna" value="Registrar Nombre de Vacuna" />
		              </form>
					</td>
				</tr>
			</table>
			<a href="Menu.jsp">Retornar al Menu</a>
  </div>
</body>
</html>
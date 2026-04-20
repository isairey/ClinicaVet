<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 3.0 MVC Series: Hi Furious</title>
</head>
<body>
      ${message}
<form action="accion" method="POST">
Introduce nombre:<br/>
<input type="text" name="nombre"/><br/>
Introduce Apellido Paterno:<br/>
<input type="text" name="apepat"/><br/>
Introduce Apellido Materno:<br/>
<input type="text" name="apemat"/><br/>
Introduce Raza:<br/>
<input type="text" name="raza"/><br/>
<input type="submit" value="Enviar">
</form>

</body>
</html>
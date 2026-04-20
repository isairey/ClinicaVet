<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<HEAD><TITLE>Actualizar Imagen</TITLE></HEAD>  
<% //  for uploading the file we used Encrypt type of multipart/form-data and input of file type to browse and submit the file %>
  <BODY> 
  <Form ACTION="SubirFoto.jsp" METHOD="post" ENCTYPE="multipart/form-data">
		<br><br><br>
	  <center><table border="2" >
	  				<tr><td colspan="2"><input type="hidden" name="hiddencodigo" id="hiddencodigo"  value="<% out.print(request.getParameter("id")); %>"></td></tr>  
                    <tr><td><b>Escoga una Imagen:</b></td>
                    <td><INPUT NAME="F1" TYPE="file"></td></tr>
                    <tr><td colspan="2"><p align="right"><INPUT TYPE="submit"  VALUE="Enviar Imagen" ></p></td></tr>
                           
             <table>
     </center>      
     </Form>
</BODY>
</html>
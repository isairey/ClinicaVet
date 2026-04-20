package net.vetfurious.util;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexionBD {

	public static Connection obtenerConexion() throws SQLException {

		Connection con = null;
		try {
			
			/* 
			 * no borrar -> cesar
			 * Class.forName("com.mysql.jdbc.Driver");
			 * con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinaria","root", "adminadmin");
			 * */
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://192.168.1.34:1433;database=Veterinaria;user=vetuser;password=vetuser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
}
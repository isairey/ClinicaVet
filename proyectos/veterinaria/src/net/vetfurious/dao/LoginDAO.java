package net.vetfurious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Login;
import net.vetfurious.util.ConexionBD;


public class LoginDAO  extends BaseDAO{
	
	public Login DAOobtenercredenciales(Login _login) throws DAOExcepcion{
		String query = "select doctorID,nombre + ' ' + paterno + ' ' + materno as Nombre,grupoID from Doctor where username=? and password=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, _login.getUsuario());
			stmt.setString(2, _login.getPassword());
			rs = stmt.executeQuery();
			while (rs.next()) {

				_login.setUsuarioID(rs.getShort("doctorID"));
				_login.setNombre(rs.getString("Nombre"));
				_login.setAdministrador(rs.getString("grupoID"));
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return _login;

	}

}

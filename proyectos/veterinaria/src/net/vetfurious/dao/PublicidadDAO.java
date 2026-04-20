package net.vetfurious.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Cliente;
import net.vetfurious.modelo.Publicidad;
import net.vetfurious.util.ConexionBD;

public class PublicidadDAO extends BaseDAO {
	
	
	public List<Publicidad> DAOlistarPublicidad() throws DAOExcepcion{
		String query = "SELECT Publicidad_Id,Titulo,Contenido,FechaInicio,FechaFin,Tarifa,NumeroClicks,Ubicacion_Id FROM Publicacidad";
		List<Publicidad> lista = new ArrayList<Publicidad>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicidad objPublicidad = new Publicidad();
				objPublicidad.setPublicidadId(rs.getInt("Publicidad_Id"));
				objPublicidad.setTitulo(rs.getString("Titulo"));
				objPublicidad.setTitulo(rs.getString("Contenido"));
				objPublicidad.setFechaInicio(rs.getDate("FechaInicio"));
				objPublicidad.setFechaInicio(rs.getDate("FechaFin"));
				objPublicidad.setTarifa(rs.getDouble("Tarifa"));
				objPublicidad.setNumeroClicks(rs.getInt("NumeroClicks"));
				objPublicidad.setUbicacionId(rs.getInt("Ubicacion_Id"));
				lista.add(objPublicidad);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}
	
	
	public void DAOgrabarPublicidad(Publicidad objPublicidad) throws DAOExcepcion{
		String query = "INSERT INTO Publicacidad (Titulo,Contenido,FechaInicio,FechaFin,Tarifa,NumeroClicks,Ubicacion_Id VALUES) (?,?,getdate(),getdate(),?,?,1)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, objPublicidad.getTitulo());
			stmt.setString(2, objPublicidad.getContenido());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
		
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
				
	}

}

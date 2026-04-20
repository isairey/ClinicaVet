package net.vetfurious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;
import net.vetfurious.util.ConexionBD;

public class DoctorDAO extends BaseDAO {


	public Doctor insertar(Doctor vo) throws DAOExcepcion {
		String query = "insert into Doctor(nombre,paterno,materno,email,telefono,username,password,grupoID) values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre().trim());
			stmt.setString(2, vo.getPaterno().trim());
			stmt.setString(3, vo.getMaterno().trim());
			stmt.setString(4, vo.getEmail().trim());
			stmt.setString(5, vo.getTelefono().trim());
			stmt.setString(6, vo.getUsuario().trim());
			stmt.setString(7, vo.getPassword().trim());
			stmt.setInt(8, vo.getGrupoID());			
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select @@Identity";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setDoctorID(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public Doctor obtener(int doctorID) throws DAOExcepcion {
		Doctor vo = new Doctor();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select doctorID,rtrim(ltrim(nombre)) nombre,rtrim(ltrim(paterno)) paterno, rtrim(ltrim(materno)) materno,rtrim(ltrim(email)) email,rtrim(ltrim(telefono)) telefono, rtrim(ltrim(username)) username,rtrim(ltrim(password)) password,grupoID from Doctor where doctorID=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, doctorID);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setDoctorID(rs.getInt(1));
				vo.setNombre(rs.getString(2).trim());
				vo.setPaterno(rs.getString(3).trim());
				vo.setMaterno(rs.getString(4).trim());
				vo.setEmail(rs.getString(5).trim());
				vo.setTelefono(rs.getString(6).trim());
				vo.setUsuario(rs.getString(7).trim());
				vo.setPassword(rs.getString(8).trim());
				vo.setGrupoID(rs.getInt(9));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	
	public Integer validarUsuario(Doctor objDoctor) throws DAOExcepcion {
		Integer contador = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select count(*) contador from Doctor where username=? and doctorID<>?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, objDoctor.getUsuario().trim());
			stmt.setInt(2, objDoctor.getDoctorID());
			rs = stmt.executeQuery();
			if (rs.next()) {				
				contador = rs.getInt("contador");				
			}			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return contador;
	}

	public Doctor actualizar(Doctor vo) throws DAOExcepcion {
		String query = "update doctor set nombre=?,paterno=?,materno=?,email=?,telefono=?,username=?,password=?,grupoID=? where doctorID=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre().trim());
			stmt.setString(2, vo.getPaterno().trim());
			stmt.setString(3, vo.getMaterno().trim());
			stmt.setString(4, vo.getEmail().trim());
			stmt.setString(5, vo.getTelefono().trim());
			stmt.setString(6, vo.getUsuario().trim());			
			stmt.setString(7, vo.getPassword().trim());
			stmt.setInt(8, vo.getGrupoID());
			stmt.setInt(9, vo.getDoctorID());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	
	public List<Doctor> DAOlistDoctores() throws DAOExcepcion{
		String query = "select doctorID,nombre,paterno,materno,email,telefono,username,(case when grupoID = 1 then 'Usuario' else 'Administrador' end) grupo from Doctor";
		List<Doctor> lista = new ArrayList<Doctor>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Doctor objDoctor = new Doctor();
				objDoctor.setDoctorID(rs.getInt("doctorID"));
				objDoctor.setNombre(rs.getString("nombre").trim());
				objDoctor.setPaterno(rs.getString("paterno").trim());
				objDoctor.setMaterno(rs.getString("materno").trim());
				objDoctor.setEmail(rs.getString("email").trim());
				objDoctor.setTelefono(rs.getString("telefono").trim());
				objDoctor.setUsuario(rs.getString("username").trim());
				objDoctor.setGrupo(rs.getString("grupo"));
				lista.add(objDoctor);
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

	public Integer elimnar(Doctor vo) throws DAOExcepcion {
		String query = "delete from Doctor where doctorID=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getDoctorID());
			
			i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo elimnar");
			}
			// Obtener el ultimo id
		/*	int id = 0;
			query = "select @@Identity";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setDoctorID(id);
			*/

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return i;
	}
	
}

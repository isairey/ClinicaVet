package net.vetfurious.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Cliente;
import net.vetfurious.util.ConexionBD;

public class ClienteDAO extends BaseDAO {

	public int DAOexisteprospecto(String codigo) throws DAOExcepcion {
		String query = "select count(*) as contador from Cliente where estado not in('X') and Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int contadorCliente=0;
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				contadorCliente=rs.getInt("contador");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return contadorCliente;
	}

	public void DAOdeleteprospecto(String codigo) throws DAOExcepcion {
		String query = "UPDATE Cliente SET estado='X' where Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}

		
	}

	public List<Cliente> DAOlistarprospectos() throws DAOExcepcion{
		String query = "select Persona_Id,Nombres,apellido_paterno,apellido_materno,email,telefono,direccion,imagen,celular from Cliente where estado not in('X') and tipo_persona='P'";
		List<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente objCliente = new Cliente();
				objCliente.setCodigo(rs.getString("Persona_Id"));
				objCliente.setNombre(rs.getString("Nombres"));
				objCliente.setApellidopaterno(rs.getString("apellido_paterno"));
				objCliente.setApellidomaterno(rs.getString("apellido_materno"));
				objCliente.setDireccion(rs.getString("direccion"));
				objCliente.setEmail(rs.getString("email"));
				objCliente.setImagen(rs.getString("imagen"));
				objCliente.setTelefono(rs.getString("telefono"));
				objCliente.setCelular(rs.getString("celular"));
				lista.add(objCliente);
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

	public void DAOgrabarprospecto(Cliente objCliente) throws DAOExcepcion{
		String query = "INSERT INTO Cliente(Persona_Id,Nombres,apellido_paterno,apellido_materno,email,direccion,telefono,celular,tipo_persona,estado) values (?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, objCliente.getCodigo());
			stmt.setString(2, objCliente.getNombre());
			stmt.setString(3, objCliente.getApellidopaterno());
			stmt.setString(4, objCliente.getApellidomaterno());
			stmt.setString(5, objCliente.getEmail());
			stmt.setString(6, objCliente.getDireccion());
			stmt.setString(7, objCliente.getTelefono());
			stmt.setString(8, objCliente.getCelular());
			stmt.setString(9,"P");
			stmt.setString(10,"A");
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

	public void DAOmodificarprospecto(Cliente objCliente) throws DAOExcepcion{
		String query = "update Cliente set Nombres=?,apellido_paterno=?,apellido_materno=?,email=?,direccion=?,telefono=?,celular=? where Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, objCliente.getNombre());
			stmt.setString(2, objCliente.getApellidopaterno());
			stmt.setString(3, objCliente.getApellidomaterno());
			stmt.setString(4, objCliente.getEmail());
			stmt.setString(5, objCliente.getDireccion());
			stmt.setString(6, objCliente.getTelefono());
			stmt.setString(7, objCliente.getCelular());
			stmt.setString(8, objCliente.getCodigo());
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
				
	}

	public Cliente DAOobtenerprospecto(String codigo) throws DAOExcepcion{
		String query = "select Persona_Id,Nombres,apellido_paterno,apellido_materno,email,telefono,direccion,imagen,celular from Cliente where estado not in('X') and Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente objCliente =null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				objCliente = new Cliente();
				objCliente.setCodigo(rs.getString("Persona_Id"));
				objCliente.setNombre(rs.getString("Nombres"));
				objCliente.setApellidopaterno(rs.getString("apellido_paterno"));
				objCliente.setApellidomaterno(rs.getString("apellido_materno"));
				objCliente.setDireccion(rs.getString("direccion"));
				objCliente.setEmail(rs.getString("email"));
				objCliente.setImagen(rs.getString("imagen"));
				objCliente.setTelefono(rs.getString("telefono"));
				objCliente.setCelular(rs.getString("celular"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return objCliente;

	}

	public String DAOgetlastcodigo() throws DAOExcepcion{
		String query = "SELECT ISNULL((SELECT MAX(Persona_Id) FROM CLIENTE),'0') AS CODIGO";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String lastcodigo="0";
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				lastcodigo=rs.getString("CODIGO");
			}
			
			lastcodigo=Integer.toString(Integer.parseInt(lastcodigo) +1) ;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return lastcodigo;
	}

	
	public Boolean DAOchangeProspectoToCliente(String codigo) throws DAOExcepcion
	{
		Boolean answer = false;
		
		String query = "UPDATE Cliente SET tipo_persona = 'C' WHERE Persona_Id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,Integer.parseInt(codigo));
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo Actualizar");
			}
			else
			{
				answer = true;
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return answer;
	}
	
	public List<Cliente> DAOlistClientes() throws DAOExcepcion
	{
		String query = "SELECT Persona_Id,Nombres,apellido_paterno,apellido_materno,email,telefono,direccion,imagen,celular FROM Cliente WHERE estado <> 'X' AND tipo_persona='C'";
		List<Cliente> list = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente objCliente = new Cliente();
				objCliente.setCodigo(rs.getString("Persona_Id"));
				objCliente.setNombre(rs.getString("Nombres"));
				objCliente.setApellidopaterno(rs.getString("apellido_paterno"));
				objCliente.setApellidomaterno(rs.getString("apellido_materno"));
				objCliente.setDireccion(rs.getString("direccion"));
				objCliente.setEmail(rs.getString("email"));
				objCliente.setImagen(rs.getString("imagen"));
				objCliente.setTelefono(rs.getString("telefono"));
				objCliente.setCelular(rs.getString("celular"));
				list.add(objCliente);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(list.size());
		return list;

	}
	
	public void UpdateFoto(String codigo,String foto) throws DAOExcepcion{
		String query = "update Cliente set imagen=? where Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,foto);
			stmt.setString(2,codigo);
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
				
	}
	
}

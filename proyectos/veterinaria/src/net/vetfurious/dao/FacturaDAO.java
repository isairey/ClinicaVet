package net.vetfurious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.vetfurious.modelo.FacturaCliente;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Factura;
import net.vetfurious.modelo.FacturaDetalle;
import net.vetfurious.modelo.Paciente;
import net.vetfurious.util.ConexionBD;

public class FacturaDAO extends BaseDAO{
	

	public List<FacturaCliente> DAOlistarFactura() throws DAOExcepcion{
		String query = "SELECT F.CODFACTURA,(C.apellido_paterno  + SPACE(1) +  C.apellido_materno + ',' +C.Nombres) AS CLIENTE,F.FEREGISTRO  FROM FacturaCab AS F " +
					   "INNER JOIN Cliente AS C ON F.IDCLIENTE=C.Persona_Id  where F.status not in('X') ORDER BY (C.apellido_paterno  + SPACE(1) +  C.apellido_materno + ',' +C.Nombres)";
		List<FacturaCliente> lista = new ArrayList<FacturaCliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				FacturaCliente objFacturaCliente = new FacturaCliente();
				objFacturaCliente.setCodigofactura(rs.getInt("CODFACTURA"));
				objFacturaCliente.setNombrecliente(rs.getString("CLIENTE"));
				objFacturaCliente.setFecharegistro(rs.getString("FEREGISTRO"));
				lista.add(objFacturaCliente);
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
	

	public Factura DAOVerFactura(int codFactura) throws DAOExcepcion{
		String query = "SELECT F.CODFACTURA,F.idCliente,(C.apellido_paterno  + SPACE(1) +  C.apellido_materno + ',' +C.Nombres) " +
		"AS CLIENTE,F.FEREGISTRO,F.idPaciente,P.Especie_Id as nombre,F.RUC " +  
		"FROM FacturaCab AS F " +  
		"INNER JOIN Cliente AS C ON F.IDCLIENTE=C.Persona_Id " +  
		"INNER JOIN [Paciente] AS P ON P.[Paciente_id]=F.idPaciente " +  
		"WHERE F.codFactura=? " +  
		"ORDER BY (C.apellido_paterno  + SPACE(1) +  C.apellido_materno + ',' +C.Nombres)";

		String query2 ="SELECT D.CODFACTURA,D.CODPRODUCTO,P.NOMBREPRODUCTO,D.QTCANTIDAD,D.PRECIO " +
		"FROM FacturaDet AS D " + 
		"INNER JOIN producto AS P ON D.CODPRODUCTO=P.IDPRODUCTO " +
		"WHERE D.CODFACTURA=?";
		
		Factura objFactura = null;
		ArrayList<FacturaDetalle> Detalle=new ArrayList<FacturaDetalle>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query2);
			stmt.setInt(1, codFactura);
			rs = stmt.executeQuery();
			while (rs.next()) {
				FacturaDetalle objFacturaDetalle = new FacturaDetalle();
				objFacturaDetalle.setCodFactura(rs.getInt("CODFACTURA"));
				objFacturaDetalle.setCodProducto(rs.getInt("CODPRODUCTO"));
				objFacturaDetalle.setProducto(rs.getString("NOMBREPRODUCTO"));
				objFacturaDetalle.setQtCantidad(rs.getInt("QTCANTIDAD"));
				objFacturaDetalle.setPrecio(rs.getDouble("PRECIO"));
				Detalle.add(objFacturaDetalle);
			}
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codFactura);
			rs = stmt.executeQuery();
			while (rs.next()) {
				objFactura = new Factura();
				objFactura.setCodFactura(rs.getInt("CODFACTURA"));
				objFactura.setIntidCliente(rs.getInt("idCliente"));
				objFactura.setCliente(rs.getString("CLIENTE"));
				objFactura.setIdPaciente(rs.getInt("idPaciente"));
				objFactura.setPaciente(rs.getString("nombre"));
				objFactura.setFeRegistro(rs.getString("FEREGISTRO"));
				objFactura.setRuc(rs.getString("RUC"));
				objFactura.setDetalle(Detalle);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return objFactura;
	}
	
	public int ExisteFactura(int codFactura) throws DAOExcepcion {
		String query = "select count(codFactura) as contador from FacturaCab where codFactura=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int contadorCliente=0;
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codFactura);
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

	public void AddFactura(Factura objFactura) throws DAOExcepcion {
		String query = "INSERT INTO FacturaCab(codFactura,idCliente,idPaciente,feRegistro,RUC,status) values (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, objFactura.getCodFactura());
			stmt.setInt(2, objFactura.getIntidCliente());
			stmt.setInt(3, objFactura.getIdPaciente());
			stmt.setString(4, objFactura.getFeRegistro());
			stmt.setString(5, objFactura.getRuc());
			stmt.setString(6, "A");
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			
			ArrayList<FacturaDetalle> Lista=objFactura.getDetalle();
		 
			for(int x=0;x<=Lista.size()-1;x++){
				FacturaDetalle objDetalle=(FacturaDetalle)Lista.get(x);
				query = "INSERT INTO FacturaDet(codFactura,codProducto,qtCantidad,precio) values (?,?,?,?)";
				stmt = con.prepareStatement(query);
				stmt.setInt(1, objDetalle.getCodFactura());
				stmt.setInt(2, objDetalle.getCodProducto());
				stmt.setDouble(3, objDetalle.getQtCantidad());
				stmt.setDouble(4, objDetalle.getPrecio());
								
				i = stmt.executeUpdate();
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


	public void DeleteFactura(int codFactura) throws DAOExcepcion {
		String query = "Update FacturaCab set status='X' where codFactura=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
			try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codFactura);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
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
	
	
	public int ActivaFactura(int codFactura) throws DAOExcepcion {
		String query = "select count(codFactura) as contador from FacturaCab where codFactura=? and status='A'";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int contadorCliente=0;
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codFactura);
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


	public void AddFacturaDetalle(FacturaDetalle objDetalle) throws DAOExcepcion {
		String query = "INSERT INTO FacturaDetWork(codFactura,codProducto,qtCantidad,precio) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, objDetalle.getCodFactura());
			stmt.setInt(2, objDetalle.getCodProducto());
			stmt.setDouble(3, objDetalle.getQtCantidad());
			stmt.setDouble(4, objDetalle.getPrecio());
							
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo agregar");
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
	
	public ArrayList<FacturaDetalle> VerDetalleWork(int codfactura) throws DAOExcepcion {
		String query ="SELECT D.CODFACTURA,D.CODPRODUCTO,P.NOMBREPRODUCTO,D.QTCANTIDAD,D.PRECIO " +
				"FROM FacturaDetWork AS D " + 
				"INNER JOIN producto AS P ON D.CODPRODUCTO=P.IDPRODUCTO " +
				"WHERE D.CODFACTURA=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<FacturaDetalle> Detalle=new ArrayList<FacturaDetalle>();
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codfactura);						
			rs = stmt.executeQuery();
			while (rs.next()) {
				FacturaDetalle objFacturaDetalle = new FacturaDetalle();
				objFacturaDetalle.setCodFactura(rs.getInt("CODFACTURA"));
				objFacturaDetalle.setCodProducto(rs.getInt("CODPRODUCTO"));
				objFacturaDetalle.setProducto(rs.getString("NOMBREPRODUCTO"));
				objFacturaDetalle.setQtCantidad(rs.getInt("QTCANTIDAD"));
				objFacturaDetalle.setPrecio(rs.getDouble("PRECIO"));
				Detalle.add(objFacturaDetalle);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return Detalle;
	}
	
	public int DAOgetlastcodigoFactura() throws DAOExcepcion{
		String query = "SELECT ISNULL((SELECT MAX(codFactura) FROM FacturaCab),'0') AS CODIGO";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int lastcodigo=0;
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				lastcodigo=rs.getInt("CODIGO");
			}
			
			lastcodigo=(lastcodigo +1) ;
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


	public List<Paciente> listarpacientesxcliente(int codcliente) throws DAOExcepcion {
		String query = "SELECT Paciente_Id,'sultan' as nombre from  dbo.Paciente WHERE Dueno_Id=?";
	List<Paciente> lista = new ArrayList<Paciente>();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setInt(1, codcliente);
		rs = stmt.executeQuery();
		while (rs.next()) {
			Paciente objPaciente = new Paciente();
			objPaciente.setCodigoPaciente(rs.getInt("Paciente_Id"));
			objPaciente.setEspecie(rs.getString("nombre"));
			lista.add(objPaciente);
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
	
	public void DeleteDetalleWork(int codFactura) throws DAOExcepcion {
		String query = "delete from FacturaDetWork where codFactura=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
			try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codFactura);
			//int i = 
			stmt.executeUpdate();
			/*if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}*/
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
				
	}


	public void DeleteItemDetalle(FacturaDetalle objFacturaDetalle) throws DAOExcepcion {
		String query = "delete from FacturaDetWork where codFactura=? and codProducto=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
			try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, objFacturaDetalle.getCodFactura());
			stmt.setInt(1, objFacturaDetalle.getCodProducto());
			stmt.executeUpdate();
			
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

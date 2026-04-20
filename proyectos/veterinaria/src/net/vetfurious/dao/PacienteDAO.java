package net.vetfurious.dao;

        import java.sql.CallableStatement;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Types;
        import java.util.ArrayList;
        import java.util.List;
        import net.vetfurious.excepcion.DAOExcepcion;
        import net.vetfurious.modelo.*;
import net.vetfurious.util.ConexionBD;

public class PacienteDAO extends BaseDAO {      
        
		/*
		Paciente_Id 
	Dueno_Id    
	Dueno
	Especie_Id
	Especie
	Raza_Id
	Raza
	Genero_Id
	Genero
	TipoSangre_Id
	Tipo
	Sangre
	Esterilizado
	Tamano_Id
	Tamaño
	Actividad_Id
	Actividad
	Peso
	FechaNacimiento 
	NotasMedicas  
		 */
                 public Paciente DAOinsertarPacientes(Paciente objPaciente) throws DAOExcepcion {
                        String query = "INSERT INTO PACIENTE(Dueno_Id,Especie_Id,Raza_Id,Genero_Id,TipoSangre_Id,Esterilizado,Tamano_Id,Actividad_Id,peso,fechaNacimiento,NotasMedicas,CondicionesEspeciales) values (?,?,?,?,?,?,?,?,?,?,?,?)";
                        Connection con = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;
                        try {
                                con = ConexionBD.obtenerConexion();
                                stmt = con.prepareStatement(query);
                                stmt.setInt(1, objPaciente.getCodigoDueno());
                                stmt.setInt(2, objPaciente.getespecieid());
                                stmt.setInt(3, objPaciente.getrazaid());
                                stmt.setInt(4, objPaciente.getgeneroid());
                                stmt.setInt(5, objPaciente.gettipoSangreid());
                                stmt.setString(6, objPaciente.getEsterilizado());
                                stmt.setInt(7, objPaciente.gettamanoid());
                                stmt.setInt(8, objPaciente.getactividadid());
                                stmt.setString(9, objPaciente.getPeso());
                                stmt.setString(10, objPaciente.getFechaNacimiento());
                                stmt.setString(11, objPaciente.getNotasMedicas());
                                stmt.setString(12, objPaciente.getCondicionesEspeciales());


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
                        return objPaciente;
                }


                 public Paciente obtenerPaciente(int codigoPaciente) throws DAOExcepcion {

                	Paciente objPaciente = new Paciente();
                        Connection con = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;
                        try {
                                con = ConexionBD.obtenerConexion();

                     			CallableStatement cstm = null;
                       			cstm =  con.prepareCall("{call UP_GetPaciente(?)}");
                       			cstm.setInt(1, codigoPaciente);
                       			rs = cstm.executeQuery();

                                if (rs.next()) {
                                        objPaciente.setCodigoPaciente(rs.getInt(1));
                                        objPaciente.setCodigoDueno(rs.getInt(2));
                                        objPaciente.setnombrePaciente(rs.getString(3));
                                        objPaciente.setespecieid(rs.getInt(4));
                                        objPaciente.setEspecie(rs.getString(5));
                                        objPaciente.setrazaid(rs.getInt(6));
                                        objPaciente.setRaza(rs.getString(7));
                                        
                                        objPaciente.setgeneroid(rs.getInt(8));
                                        objPaciente.setGenero(rs.getString(9));
                                        
                                        objPaciente.settipoSangreid(rs.getInt(10));
                                        objPaciente.setTipoSangre(rs.getString(11));
                                        
                                        objPaciente.setEsterilizado(rs.getString(12));
                                        
                                        objPaciente.settamanoid(rs.getInt(13));
                                        objPaciente.setTamano(rs.getString(14));
                                        objPaciente.setactividadid(rs.getInt(15));
                                        objPaciente.setActividad(rs.getString(16));
                                        objPaciente.setPeso(rs.getString(17));
                                        objPaciente.setFechaNacimiento(rs.getString(18));
                                        objPaciente.setNotasMedicas(rs.getString(19));
                                        objPaciente.setCondicionesEspeciales(rs.getString(20));
                                }
                        } catch (SQLException e) {
                                System.err.println(e.getMessage());
                                throw new DAOExcepcion(e.getMessage());
                        } finally {
                                this.cerrarResultSet(rs);
                                this.cerrarStatement(stmt);
                                this.cerrarConexion(con);
                        }
                        return objPaciente;
                }

                public void eliminarPaciente(int codigoPaciente) throws DAOExcepcion {
                        String query = "delete from paciente WHERE Paciente_Id=?";
                        Connection con = null;
                        PreparedStatement stmt = null;
                        try {
                                con = ConexionBD.obtenerConexion();
                                stmt = con.prepareStatement(query);
                                stmt.setInt(1, codigoPaciente);
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

                public Paciente modificarPaciente(Paciente objPaciente) throws DAOExcepcion {
                        String query = "update paciente set Dueno_Id=?,Especie_Id=?,Raza_Id=?,Genero_Id=?,TipoSangre_Id=?,Esterilizado=?,Tamano_Id=?,Actividad_Id=?,peso=?,fechaNacimiento=?,NotasMedicas=?,CondicionesEspeciales=? where Paciente_Id=?";
                        Connection con = null;
                        PreparedStatement stmt = null;

                        try {
                                con = ConexionBD.obtenerConexion();
                                stmt = con.prepareStatement(query);
           
                                stmt.setInt(1, objPaciente.getCodigoDueno());                          
                                stmt.setInt(2, objPaciente.getespecieid());
                                stmt.setInt(3, objPaciente.getrazaid());
                                stmt.setInt(4, objPaciente.getgeneroid());
                                stmt.setInt(5, objPaciente.gettipoSangreid());
                                stmt.setString(6, objPaciente.getEsterilizado());
                                stmt.setInt(7, objPaciente.gettamanoid());
                                stmt.setInt(8, objPaciente.getactividadid());
                                stmt.setString(9, objPaciente.getPeso());
                                stmt.setString(10, objPaciente.getFechaNacimiento());
                                stmt.setString(11, objPaciente.getNotasMedicas());
                                stmt.setString(12, objPaciente.getCondicionesEspeciales());
                                stmt.setInt(13, objPaciente.getCodigoPaciente());
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
                        return objPaciente;
                }

                public List<Paciente> listarPacientes() throws DAOExcepcion {
                    List<Paciente> lista = new ArrayList<Paciente>();
                        Connection con = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;
                        try {
                              con = ConexionBD.obtenerConexion();

                   			  CallableStatement cstm = null;
                   		    
                   			  cstm =  con.prepareCall("{call UP_ListarPaciente()}");
                   			  rs = cstm.executeQuery();

                                while (rs.next()) {
                                        Paciente oPaciente = new Paciente();
                                        oPaciente.setnombrePaciente(rs.getString("Dueno"));
                                        oPaciente.setCodigoPaciente(rs.getInt("Paciente_Id"));
                                        oPaciente.setEspecie(rs.getString("Especie"));
                                        oPaciente.setRaza(rs.getString("Raza"));
                                        oPaciente.setGenero(rs.getString("Genero"));
                                        oPaciente.setTipoSangre(rs.getString("TipoSangre"));
                                        lista.add(oPaciente);
                                }

                        } catch (SQLException e) {
                                System.err.println(e.getMessage());
                                throw new DAOExcepcion(e.getMessage());
                        } finally {
                                this.cerrarResultSet(rs);
                                this.cerrarStatement(stmt);
                                this.cerrarConexion(con);
                        }
                        return lista;
                }

           
            	public int DAOexistepaciente(int codigo) throws DAOExcepcion {
            		String query = "select count(*) as contador from Paciente where  Paciente_Id=?";
            		Connection con = null;
            		PreparedStatement stmt = null;
            		ResultSet rs = null;
            		int contadorCliente=0;
            		try {
            			
            			con = ConexionBD.obtenerConexion();
            			stmt = con.prepareStatement(query);
            			stmt.setInt(1, codigo);
            			rs = stmt.executeQuery();
            			while (rs.next()) {
            				contadorCliente = rs.getInt("contador");
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
            	
                public List<Control> GetDataCombo(String Entidad) throws DAOExcepcion {
                    List<Control> lista = new ArrayList<Control>();
                        Connection con = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;
                        try {
                                con = ConexionBD.obtenerConexion();
                     			CallableStatement cstm = null;
                       			cstm =  con.prepareCall("{call UP_GetCombo(?)}");
                       			cstm.setString(1, Entidad);
                       			rs = cstm.executeQuery();
                   			 	
                                while (rs.next()) {
                                        Control oControl = new Control();
                                        oControl.setCodigo(rs.getInt("id"));
                                        oControl.setNombre(rs.getString("nombre"));
                                        lista.add(oControl);
                                }

                        } catch (SQLException e) {
                                System.err.println(e.getMessage());
                                throw new DAOExcepcion(e.getMessage());
                        } finally {
                                this.cerrarResultSet(rs);
                                this.cerrarStatement(stmt);
                                this.cerrarConexion(con);
                        }
                        return lista;
                }
        }

package net.vetfurious.negocio;

import java.util.List;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Cliente;

public interface ICliente {

	public abstract Cliente ObtenerProspecto(String codigo) throws DAOExcepcion;
	public abstract void deleteprospecto(String codigo) throws DAOExcepcion;
	public abstract List<Cliente> listarprospectos() throws DAOExcepcion;
	public abstract void GrabarModificarProspecto(String codigo, String nombre,
			String apellidopaterno, String apellidomaterno, String email,
			String direccion, String imagen, String telefono, String celular)
			throws DAOExcepcion;
	public abstract void GrabarModificarProspecto(Cliente cli)
			throws DAOExcepcion;
	public abstract Boolean changeProspectoToCliente(String codigo)
			throws DAOExcepcion;
	public abstract List<Cliente> listClientes() throws DAOExcepcion;

}
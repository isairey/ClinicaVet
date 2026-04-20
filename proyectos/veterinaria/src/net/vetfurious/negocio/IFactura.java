package net.vetfurious.negocio;

import java.util.ArrayList;
import java.util.List;

import net.vetfurious.modelo.FacturaCliente;
import net.vetfurious.modelo.FacturaDetalle;
import net.vetfurious.modelo.Paciente;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Factura;

public interface IFactura {

	public abstract void GrabarFactura(Factura objFactura) throws DAOExcepcion;

	public abstract void ElimnarFactura(int codFactura) throws DAOExcepcion;

	public abstract List<FacturaCliente> ListarFacturas() throws DAOExcepcion;
	public abstract void GrabarFacturaDetalle(FacturaDetalle objFacturaDetalle) throws DAOExcepcion;
	public abstract Factura VerFactura(int codFactura) throws DAOExcepcion;

	public abstract net.vetfurious.modelo.Factura RecargarFactura(
			net.vetfurious.modelo.Factura objFactura,
			FacturaDetalle objFacturaDetalle) throws DAOExcepcion;

	public abstract int GetCodigoFactura() throws DAOExcepcion;

	public abstract List<Paciente> listarpacientesxcliente(int codcliente) throws DAOExcepcion;

	public abstract ArrayList<FacturaDetalle> verdetallework(int codfactura) throws DAOExcepcion;

	public abstract Factura iniciarfactura() throws DAOExcepcion;

	public abstract void DeleteFacturaDetalle(FacturaDetalle objFacturaDetalle)
			throws DAOExcepcion;

	public abstract Factura RecargarFactura2(Factura objFactura) throws DAOExcepcion;

}
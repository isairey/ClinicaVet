package net.vetfurious.negocio;

import net.vetfurious.modelo.FacturaCliente;
import net.vetfurious.modelo.FacturaDetalle;
import net.vetfurious.modelo.Paciente;
import net.vetfurious.dao.FacturaDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Factura;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class AdmFactura implements IFactura {

	/* (non-Javadoc)
	 * @see net.vetfurious.negocio.IFactura#GrabarFactura(net.vetfurious.modelo.Factura)
	 */
	@Override
	public void GrabarFactura(Factura objFactura) throws DAOExcepcion {
		System.out.println("entro a grabar factura");
		FacturaDAO objFacturaDAO= new FacturaDAO();
		if(objFacturaDAO.ExisteFactura(objFactura.getCodFactura())==0){
			System.out.println("entro");
			ArrayList<FacturaDetalle> detalle=objFacturaDAO.VerDetalleWork(objFactura.getCodFactura());
			System.out.println("hya detalle");
			objFactura.setDetalle(detalle);
			objFacturaDAO.AddFactura(objFactura);
		}else{
			System.out.println("ya exsite");
		}
	
	}

	/* (non-Javadoc)
	 * @see net.vetfurious.negocio.IFactura#ElimnarFactura(int)
	 */
	@Override
	public void ElimnarFactura(int codFactura) throws DAOExcepcion{
		FacturaDAO objFacturaDAO= new FacturaDAO();
		if(objFacturaDAO.ActivaFactura(codFactura)==1){
			objFacturaDAO.DeleteFactura(codFactura);
		}else{
			
		}
		
	}
	
	
	/* (non-Javadoc)
	 * @see net.vetfurious.negocio.IFactura#ListarFacturas()
	 */
	@Override
	public List<FacturaCliente> ListarFacturas() throws DAOExcepcion{
		List<FacturaCliente> Listafacturas;
		FacturaDAO objFacturaDAO= new FacturaDAO();
		Listafacturas=objFacturaDAO.DAOlistarFactura();
		return Listafacturas;
	}
	
	@Override
	public Factura VerFactura(int codFactura) throws DAOExcepcion{
		FacturaDAO objFacturaDAO= new FacturaDAO();
		return objFacturaDAO.DAOVerFactura(codFactura);
		
	}
	
	@Override
	public void GrabarFacturaDetalle(FacturaDetalle objFacturaDetalle) throws DAOExcepcion {
		FacturaDAO objFacturaDAO= new FacturaDAO();
		objFacturaDAO.AddFacturaDetalle(objFacturaDetalle);

	}

	@Override
	public Factura RecargarFactura(Factura objFactura,FacturaDetalle objFacturaDetalle) throws DAOExcepcion{
		FacturaDAO objFacturaDAO= new FacturaDAO();
		objFacturaDAO.AddFacturaDetalle(objFacturaDetalle);
		
		ArrayList<FacturaDetalle> detalle=objFacturaDAO.VerDetalleWork(objFactura.getCodFactura());
		objFactura.setDetalle(detalle);
		return objFactura;
	}
	
	@Override
	public Factura RecargarFactura2(Factura objFactura) throws DAOExcepcion{
		FacturaDAO objFacturaDAO= new FacturaDAO();
				
		ArrayList<FacturaDetalle> detalle=objFacturaDAO.VerDetalleWork(objFactura.getCodFactura());
		objFactura.setDetalle(detalle);
		return objFactura;
	}

	@Override
	public int GetCodigoFactura() throws DAOExcepcion {
		FacturaDAO objFacturaDAO= new FacturaDAO();
		return objFacturaDAO.DAOgetlastcodigoFactura();
	}

	@Override
	public List<Paciente> listarpacientesxcliente(int codcliente)
			throws DAOExcepcion {
		FacturaDAO objFacturaDAO= new FacturaDAO();
		return objFacturaDAO.listarpacientesxcliente(codcliente);
	}
	
	@Override
	public ArrayList<FacturaDetalle> verdetallework(int codfactura)
			throws DAOExcepcion {
		FacturaDAO objFacturaDAO= new FacturaDAO();
		return objFacturaDAO.VerDetalleWork(codfactura);
	}
	
	@Override
	public Factura iniciarfactura()
			throws DAOExcepcion {
		   FacturaDAO objFacturaDAO= new FacturaDAO();
		   Factura objNewFactura=new Factura();
		   
	       objNewFactura.setCodFactura(objFacturaDAO.DAOgetlastcodigoFactura());
	       java.util.Date utilDate = new java.util.Date(); //fecha actual
	       long lnMilisegundos = utilDate.getTime();
	       java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
	       objNewFactura.setFeRegistro(sqlDate.toString());
	       
	       objFacturaDAO.DeleteDetalleWork(objNewFactura.getCodFactura());
		   
	       return objNewFactura;
	}
	
	@Override
	public void DeleteFacturaDetalle(FacturaDetalle objFacturaDetalle) throws DAOExcepcion {
		FacturaDAO objFacturaDAO= new FacturaDAO();
		objFacturaDAO.DeleteItemDetalle(objFacturaDetalle);

	}

}

package net.vetfurious.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import net.vetfurious.dao.ProductoDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Producto;;

@Service 
public class AdmProducto implements IProducto {
	
	/* (non-Javadoc)
	 * @see net.vetfurious.negocio.IProducto#listarproductos()
	 */
	@Override
	public List<Producto> listarproductos() throws DAOExcepcion{
		ProductoDAO objProdcutoDAO=new ProductoDAO();
		return objProdcutoDAO.DAOlistarproductos();
	}

}

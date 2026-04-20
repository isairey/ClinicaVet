package net.vetfurious.negocio;

import java.util.List;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Producto;

public interface IProducto {

	public abstract List<Producto> listarproductos() throws DAOExcepcion;

}
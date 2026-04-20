package net.vetfurious.negocio;

import java.util.Date;
import java.util.List;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Publicidad;

public interface IPublicidad {
	
	public abstract List<Publicidad> listarpublicidad() throws DAOExcepcion;
	
	public abstract void GrabarModificarPublicidad(Publicidad publi)
			throws DAOExcepcion;

}

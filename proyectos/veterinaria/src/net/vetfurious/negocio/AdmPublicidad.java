package net.vetfurious.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;


@Service
public class AdmPublicidad implements IPublicidad
{
	
	@Override
	public List<Publicidad> listarpublicidad() throws DAOExcepcion{
		PublicidadDAO objPublicidadDAO=new PublicidadDAO();
		return objPublicidadDAO.DAOlistarPublicidad();
	}
	
	@Override
	public void GrabarModificarPublicidad(Publicidad publi) throws DAOExcepcion{
		
		
		PublicidadDAO objPublicidadDAO=new PublicidadDAO();
		
		objPublicidadDAO.DAOgrabarPublicidad(publi);
		
		
	}

}

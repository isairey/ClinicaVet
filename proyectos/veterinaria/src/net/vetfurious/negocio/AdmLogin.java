package net.vetfurious.negocio;

import org.springframework.stereotype.Service;

import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;


@Service
public class AdmLogin implements ILogin{

	@Override
	public Login ObtenerCredenciales(Login _login) throws DAOExcepcion {
		Login objLogin = null;
		LoginDAO objLoginDAO = new LoginDAO();
		
		objLogin = objLoginDAO.DAOobtenercredenciales(_login);
		
		return objLogin;
	}


}

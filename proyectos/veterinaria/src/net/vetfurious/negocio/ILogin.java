package net.vetfurious.negocio;


import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Login;

public interface ILogin {

	public abstract Login ObtenerCredenciales(Login _login) throws DAOExcepcion;

}

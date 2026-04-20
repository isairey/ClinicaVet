package net.vetfurious.negocio;

import java.util.List;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.*;

public interface ICombo{
	public abstract List<Control> GetDataCombo(String Entidad) throws DAOExcepcion;
	
}

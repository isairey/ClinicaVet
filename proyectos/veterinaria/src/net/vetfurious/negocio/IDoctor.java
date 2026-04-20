package net.vetfurious.negocio;

import java.util.List;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

public interface IDoctor {

	
	public abstract Doctor insertar(Doctor oDoctor) throws DAOExcepcion;
/**/
	public abstract Doctor obtener(int doctorID) throws DAOExcepcion;
	
	public abstract Doctor actualizar(Doctor oDoctor) throws DAOExcepcion;
			
	public abstract List<Doctor> listDoctores() throws DAOExcepcion;
	
	public abstract Integer eliminar(Doctor oDoctor) throws DAOExcepcion;	

}
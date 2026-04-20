package net.vetfurious.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import net.vetfurious.dao.DoctorDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;

@Service 
public class AdmDoctor implements IDoctor {


	@Override
	public Doctor insertar(Doctor oDoctor) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		Doctor objDoctor = new Doctor();		
		String errMensaje = validarCamposObligatorios(oDoctor);
		if(errMensaje.equals("")){
			if(dao.validarUsuario(oDoctor) > 0){
				errMensaje = "El usuario ya existe"; 				
			}
		}
		if(errMensaje.equals("")){
			objDoctor = dao.insertar(oDoctor);
		}else{
			objDoctor.setErrMensaje(errMensaje);			
		}
		return objDoctor;
	}


	@Override
	public Doctor obtener(int idCategoria) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		return dao.obtener(idCategoria);
	}
/**/
	@Override
	public Doctor actualizar(Doctor oDoctor) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		Doctor objDoctor = new Doctor();
		String errMensaje = validarCamposObligatorios(oDoctor);
		if(errMensaje.equals("")){
			if(dao.validarUsuario(oDoctor) > 0){
				errMensaje = "El usuario ya existe"; 				
			}
		}			
		
		if(errMensaje.equals("")){
			objDoctor = dao.actualizar(oDoctor);
		}else{
			objDoctor.setErrMensaje(errMensaje);			
		}
		return objDoctor;		
	}
	
	
	//@Override
	/* (non-Javadoc)
	 * @see net.vetfurious.negocio.IDoctor#listDoctores()
	 */
	@Override
	public List<Doctor> listDoctores() throws DAOExcepcion{
		DoctorDAO objDoctorDAO=new DoctorDAO();
		return objDoctorDAO.DAOlistDoctores();
	}
	
	@Override
	public Integer eliminar(Doctor oDoctor) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		return dao.elimnar(oDoctor);
	}
	
	public String validarCamposObligatorios(Doctor oDoctor) {
		Integer varCount = 0;
		String errMensaje = "";
		if(oDoctor.getNombre().equals(null) | oDoctor.getNombre().equals("")){				
			varCount += 1;
		}
		if(oDoctor.getPaterno().equals(null) | oDoctor.getPaterno().equals("")){				
			varCount += 1;
		}
		if(oDoctor.getMaterno().equals(null) | oDoctor.getMaterno().equals("")){				
			varCount += 1;
		}
		if(oDoctor.getEmail().equals(null) | oDoctor.getEmail().equals("")){				
			varCount += 1;
		}
		if(oDoctor.getUsuario().equals(null) | oDoctor.getUsuario().equals("")){				
			varCount += 1;
		}
		if(oDoctor.getPassword().equals(null) | oDoctor.getPassword().equals("")){				
			varCount += 1;
		}		
		if(oDoctor.getGrupoID().equals(null) | oDoctor.getGrupoID().equals(0)){				
			varCount += 1;
		}
		
		if(varCount > 0){
			errMensaje = "Ingresar los campos obligatorios";			
		}
		
		return errMensaje;
		
	}
}

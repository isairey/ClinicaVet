package net.vetfurious.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import net.vetfurious.dao.CitaDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Cita;

@Service
public class AdmCita implements ICita  {

	@Override
	public void GrabarModificarCita(String codigoCita,
									String codigoPersona, 
									String codigoPaciente,
									String codigoDoctor,
									String tipoCita,
									String descripcionCita,
									String nombreVacuna,
									String fechaCita) throws DAOExcepcion
	{
		
		Cita objCita=new Cita(codigoCita,
				              codigoPersona,
				              codigoPaciente,
				              codigoDoctor,
				              tipoCita,
				              descripcionCita,
				              nombreVacuna,
				              fechaCita);
		CitaDAO objCitaDAO=new CitaDAO();
		if(objCitaDAO.DAOexisteCita(codigoCita) == 0)
		{
			String nuevoCodigoCita=(objCitaDAO.DAOobtenerUltimoCodigo());
			objCita.setCodigoCita(nuevoCodigoCita);
			objCitaDAO.DAOgrabarCita(objCita);
		}
		if(objCitaDAO.DAOexisteCita(codigoCita) == 1)
		{
			objCitaDAO.DAOmodificarCita(objCita);
		}
		
	}
	
	@Override
	public void InsertarVacuna(String nombreVacuna) throws DAOExcepcion
	{	
		CitaDAO objCitaDAO = new CitaDAO();
		objCitaDAO.DAOinsertarVacuna(nombreVacuna);	
	}
	
    @Override
	public void GrabarModificarCita(Cita objCita) throws DAOExcepcion
	{	
		CitaDAO objCitaDAO = new CitaDAO();
		
		if(objCitaDAO.DAOexisteCita(objCita.getCodigoCita())==0)
		{
			String newcodigo=(objCitaDAO.DAOobtenerUltimoCodigo());
			objCita.setCodigoCita(newcodigo);
			objCitaDAO.DAOgrabarCita(objCita);
		}
		if(objCitaDAO.DAOexisteCita(objCita.getCodigoCita())==1)
		{
			objCitaDAO.DAOmodificarCita(objCita);
		}
		
	}

	@Override
	public Cita ObtenerCita(String codigoCita) throws DAOExcepcion  
	{
		Cita objCita=null;
		CitaDAO objCitaDAO=new CitaDAO();
		if(objCitaDAO.DAOexisteCita(codigoCita) == 1)
		{
			objCita=(Cita)objCitaDAO.DAOobtenerCita(codigoCita);
		}
		return objCita;
	}

	@Override
	public void BorrarCita(String codigoCita) throws DAOExcepcion
	{
		CitaDAO objCitaDAO=new CitaDAO();
		int contadorCita= objCitaDAO.DAOexisteCita(codigoCita);
		
		if(contadorCita==1)
		{
			objCitaDAO.DAOborrarCita(codigoCita);
		}
		
	}

	@Override
	public List<Cita> ListarCitaVacunas() throws DAOExcepcion
	{
		CitaDAO objCitaDAO=new CitaDAO();
		return objCitaDAO.DAOlistarCitaVacunas();
	}

	@Override
	public List<Cita> ListarCitaTareas() throws DAOExcepcion
	{
		CitaDAO objCitaDAO=new CitaDAO();
		return objCitaDAO.DAOlistarCitaTareas();
	}
}

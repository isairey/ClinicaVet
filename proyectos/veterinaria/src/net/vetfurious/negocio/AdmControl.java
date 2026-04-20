package net.vetfurious.negocio;

import java.util.List;

import net.vetfurious.dao.PacienteDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Control;
import org.springframework.stereotype.Service;


@Service
public class AdmControl implements ICombo {
	
	@Override
	public List<Control> GetDataCombo(String Entidad) throws DAOExcepcion{
		PacienteDAO daoPaciente = new PacienteDAO();
		return daoPaciente.GetDataCombo(Entidad);
	}

	
}

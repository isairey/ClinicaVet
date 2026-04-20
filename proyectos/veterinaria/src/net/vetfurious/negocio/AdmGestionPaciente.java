package net.vetfurious.negocio;

import java.util.List;
import org.springframework.stereotype.Service;
import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;

@Service
public class AdmGestionPaciente implements IPaciente  {
        

        /* (non-Javadoc)
		 * @see net.vetfurious.negocio.IPaciente#insertarPaciente(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
		 */

		@Override
		public void insertarPaciente(Paciente pac) throws DAOExcepcion {

                PacienteDAO objPacienteDAO = new PacienteDAO();

            	objPacienteDAO.DAOinsertarPacientes(pac);
           }

        /* (non-Javadoc)
		 * @see net.vetfurious.negocio.IPaciente#obtenerPaciente(java.lang.String)
		 */

		@Override
		public Paciente obtenerPaciente(int codigoPaciente) throws DAOExcepcion {
            	 
        	PacienteDAO dao = new PacienteDAO();
                return dao.obtenerPaciente(codigoPaciente);
        }

        /* (non-Javadoc)
		 * @see net.vetfurious.negocio.IPaciente#deleteaciente(java.lang.String)
		 */
 
		@Override
		public void deletepaciente(int codigoPaciente) throws DAOExcepcion {
                PacienteDAO objPaciente = new PacienteDAO();
                objPaciente.eliminarPaciente(codigoPaciente);
        }

        /* (non-Javadoc)
		 * @see net.vetfurious.negocio.IPaciente#GrabarModificarPaciente(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
		 */
  
		@Override
		public void GrabarModificarPaciente(Paciente pac) throws DAOExcepcion {
                PacienteDAO dao = new PacienteDAO();
                
                PacienteDAO objPacienteDAO=new PacienteDAO();
        		if(objPacienteDAO.DAOexistepaciente(pac.getCodigoPaciente())==0){
        			objPacienteDAO.DAOinsertarPacientes(pac);
        		}
        		if(objPacienteDAO.DAOexistepaciente(pac.getCodigoPaciente())==1){
        			objPacienteDAO.modificarPaciente(pac);
        		}
        }

      
        /* (non-Javadoc)
		 * @see net.vetfurious.negocio.IPaciente#listarPacientes()
		 */

		@Override
		public List<Paciente> listarPacientes() throws DAOExcepcion {
                PacienteDAO objPacienteDAO = new PacienteDAO();
                return objPacienteDAO.listarPacientes();
        }


}

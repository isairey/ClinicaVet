package net.vetfurious.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import net.vetfurious.modelo.*;
import net.vetfurious.dao.*;
import net.vetfurious.excepcion.DAOExcepcion;

@Service 
public class AdmCliente implements ICliente {

	
	@Override
	public Cliente ObtenerProspecto(String codigo) throws DAOExcepcion  {
		Cliente objCliente=null;
		ClienteDAO objClienteDAO=new ClienteDAO();
		if(objClienteDAO.DAOexisteprospecto(codigo)==1){
			objCliente=(Cliente)objClienteDAO.DAOobtenerprospecto(codigo);
		}
		return objCliente;
	}

	
	@Override
	public void deleteprospecto(String codigo) throws DAOExcepcion{
		ClienteDAO objClienteDAO=new ClienteDAO();
		int countcliente= objClienteDAO.DAOexisteprospecto(codigo);
		
		if(countcliente==1){
			objClienteDAO.DAOdeleteprospecto(codigo);
		}
		
	}

	@Override
	public List<Cliente> listarprospectos() throws DAOExcepcion{
		ClienteDAO objClienteDAO=new ClienteDAO();
		return objClienteDAO.DAOlistarprospectos();
	}


	@Override
	public void GrabarModificarProspecto(String codigo, String nombre,
			String apellidopaterno, String apellidomaterno, String email,
			String direccion, String imagen, String telefono, String celular) throws DAOExcepcion{
		
		Cliente objCliente=new Cliente(codigo,nombre,apellidopaterno,apellidomaterno,email,direccion,imagen, telefono, celular);
		ClienteDAO objClienteDAO=new ClienteDAO();
		if(objClienteDAO.DAOexisteprospecto(codigo)==0){
			String newcodigo=(objClienteDAO.DAOgetlastcodigo());
			objCliente.setCodigo(newcodigo);
			objClienteDAO.DAOgrabarprospecto(objCliente);
		}
		if(objClienteDAO.DAOexisteprospecto(codigo)==1){
			objClienteDAO.DAOmodificarprospecto(objCliente);
		}
		
	}
	
	public void GrabarModificarProspecto(Cliente cli) throws DAOExcepcion{
		
		ClienteDAO objClienteDAO=new ClienteDAO();
		if(objClienteDAO.DAOexisteprospecto(cli.getCodigo())==0){
			String newcodigo=(objClienteDAO.DAOgetlastcodigo());
			//objCliente.setCodigo(newcodigo);
			//objClienteDAO.DAOgrabarprospecto(objCliente);
			cli.setCodigo(newcodigo);
			objClienteDAO.DAOgrabarprospecto(cli);
		}
		if(objClienteDAO.DAOexisteprospecto(cli.getCodigo())==1){
			//objClienteDAO.DAOmodificarprospecto(objCliente);
			objClienteDAO.DAOmodificarprospecto(cli);
		}
		
	}

	@Override
	public Boolean changeProspectoToCliente(String codigo) throws DAOExcepcion
	{
		Boolean answer = false;
		
		ClienteDAO objClienteDAO =  new ClienteDAO();
		int clienteExists = objClienteDAO.DAOexisteprospecto(codigo);
		
		if(clienteExists == 1)
		{
			if(objClienteDAO.DAOchangeProspectoToCliente(codigo)) answer = true;
		}
		
		return answer; 
	}
	

	@Override
	public List<Cliente> listClientes() throws DAOExcepcion
	{
		ClienteDAO objClienteDAO = new ClienteDAO();
		return objClienteDAO.DAOlistClientes();
	}


}

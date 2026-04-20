package net.furious.service;
import net.furious.domain.Persona;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service  
public class AdmPersona implements IPersona{
	
	List<Persona> lista = new ArrayList<Persona>();
	
	
	public List<Persona> getListPersona(){
		
		//Persona objPersona1 =null;
		
		/*objPersona = new Persona();
		objPersona.setId(1);
		objPersona.setNombre("Victor");
		objPersona.setApellidoPaterno("Aguayo");
		objPersona.setApellidoMaterno("Seminario");
		objPersona.setRaza("Hulk");
		lista.add(objPersona);
		
		Persona objPersona1 =null;
		objPersona1 = new Persona();
		objPersona1.setId(2);
		objPersona1.setNombre("Rodrigo");
		objPersona1.setApellidoPaterno("Aguayo");
		objPersona1.setApellidoMaterno("Seminario");
		objPersona1.setRaza("Spiderman");
		lista.add(objPersona1);*/
		
		return lista;
	}


	public Persona insertarPersona(Persona per)
	{
		/*Persona Opersona = new Persona();
		objPersona1 = new Persona();
		objPersona1.setId(2);
		objPersona1.setNombre("Rodrigo");
		objPersona1.setApellidoPaterno("Aguayo");
		objPersona1.setApellidoMaterno("Seminario");
		objPersona1.setRaza("Spiderman");
		return Opersona;*/
		return per;
	}
	public Persona obtenerPorIdPersona(int idPersona)
	{
		Persona objPersona1 =null;
		objPersona1 = new Persona();
		objPersona1.setId(2);
		objPersona1.setNombre("Rodrigo");
		objPersona1.setApellidoPaterno("Aguayo");
		objPersona1.setApellidoMaterno("Seminario");
		objPersona1.setRaza("Spiderman");
		return objPersona1;
	}
	public Persona modificarPersona(Persona per) 
	{
		Persona objPersona1 =null;
		objPersona1 = new Persona();
		objPersona1.setId(2);
		objPersona1.setNombre(per.getNombre());
		objPersona1.setApellidoPaterno(per.getApellidoPaterno());
		objPersona1.setApellidoMaterno(per.getApellidoMaterno());
		objPersona1.setRaza(per.getRaza());
		return objPersona1;
	}
	public void eliminarPersona(Persona per) 
	{
		
	}
}


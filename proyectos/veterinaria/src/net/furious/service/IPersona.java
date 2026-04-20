package net.furious.service;

import java.util.List;


import net.furious.domain.Persona;

public interface IPersona {

	public List<Persona> getListPersona();
	public Persona insertarPersona(Persona per);
	public Persona obtenerPorIdPersona(int idPersona);
	public Persona modificarPersona(Persona per) ;
	public void eliminarPersona(Persona per) ;
}

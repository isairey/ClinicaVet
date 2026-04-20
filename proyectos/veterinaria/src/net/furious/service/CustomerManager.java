package net.furious.service;

import net.furious.domain.Persona;

	public interface CustomerManager {

	    public void addCustomer(Persona persona);
	    public void removeCustomer(Long personaId);
	    public Persona[] listPersonas();


	}



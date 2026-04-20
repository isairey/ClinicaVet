package net.vetfurious.negocio;

import java.util.List;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Paciente;

public interface IPaciente {

	public abstract void insertarPaciente(Paciente pac)
			throws DAOExcepcion;

	public abstract Paciente obtenerPaciente(int codigoPaciente)
			throws DAOExcepcion;

	public abstract void deletepaciente(int codigoDueno) throws DAOExcepcion;

	public abstract void GrabarModificarPaciente(Paciente pac)
			throws DAOExcepcion;

	public abstract List<Paciente> listarPacientes() throws DAOExcepcion;

}
package net.vetfurious.modelo;

import java.util.Date;

public class Publicidad {
	
	int publicidadId;
	String titulo;
	String contenido;
	Date fechaInicio;
	Date fechaFin;
	Double tarifa;
	int numeroClicks;
	int ubicacionId;
	
	
	public Publicidad(int publicidadId, String titulo, String contenido,
			Date fechaInicio, Date fechaFin, Double tarifa, int numeroClicks,
			int ubicacionId) {
		super();
		this.publicidadId = publicidadId;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tarifa = tarifa;
		this.numeroClicks = numeroClicks;
		this.ubicacionId = ubicacionId;
	}
	
	public Publicidad()
	{
		super();
	
	}

	public int getPublicidadId() {
		return publicidadId;
	}

	public void setPublicidadId(int publicidadId) {
		this.publicidadId = publicidadId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public int getNumeroClicks() {
		return numeroClicks;
	}

	public void setNumeroClicks(int numeroClicks) {
		this.numeroClicks = numeroClicks;
	}

	public int getUbicacionId() {
		return ubicacionId;
	}

	public void setUbicacionId(int ubicacionId) {
		this.ubicacionId = ubicacionId;
	}


	
	

}


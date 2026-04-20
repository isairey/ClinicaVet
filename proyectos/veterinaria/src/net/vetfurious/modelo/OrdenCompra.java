package net.vetfurious.modelo;

import java.util.Date;

public class OrdenCompra {

	private int idOrdenCompra;
	private Date fecha;
	private double total;
	
	public OrdenCompra()
	{
		super();
	}

	public int getIdOrdenCompra() {
		return idOrdenCompra;
	}

	public void setIdOrdenCompra(int idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}

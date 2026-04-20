package net.vetfurious.modelo;

public class Producto {

	
	private int idproducto;
	private String nombreproducto;
	private double precio;
	
	public Producto() {
		super();
	}

	public Producto(int idproducto, String nombreproducto, double precio) {
		this.idproducto = idproducto;
		this.nombreproducto = nombreproducto;
		this.precio = precio;
	}
	
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombreproducto() {
		return nombreproducto;
	}
	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	} 
	
	
}

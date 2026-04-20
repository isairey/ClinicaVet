package net.vetfurious.modelo;

public class FacturaDetalle {

	private int codFactura;
	private int codProducto;
	private String producto;
	private double qtCantidad;
	private double precio;
	
	public FacturaDetalle() {
		super();
	}
	
	public FacturaDetalle(int codFactura, int codProducto, String producto,
			double qtCantidad, double precio) {
		this.codFactura = codFactura;
		this.codProducto = codProducto;
		this.producto = producto;
		this.qtCantidad = qtCantidad;
		this.precio = precio;
	}

	public int getCodFactura() {
		return codFactura;
	}
	public void setCodFactura(int codFactura) {
		this.codFactura = codFactura;
	}
	public int getCodProducto() {
		return codProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public double getQtCantidad() {
		return qtCantidad;
	}
	public void setQtCantidad(double qtCantidad) {
		this.qtCantidad = qtCantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}

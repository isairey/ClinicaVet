package net.vetfurious.modelo;

public class FacturaCliente {
	
	private int codigofactura;
	private String nombrecliente;
	private String fecharegistro;

	
	
	public FacturaCliente() {
		super();
	}
	public FacturaCliente(int codigofactura, String nombrecliente,
			String fecharegistro) {
		this.codigofactura = codigofactura;
		this.nombrecliente = nombrecliente;
		this.fecharegistro = fecharegistro;
	}
	public int getCodigofactura() {
		return codigofactura;
	}
	public void setCodigofactura(int codigofactura) {
		this.codigofactura = codigofactura;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	public String getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	
	

}

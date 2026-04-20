package net.vetfurious.modelo;

import java.util.ArrayList;

public class Factura {

	
	private int codFactura;
	private int intidCliente;
	private String cliente;
	private int idPaciente ;
	private String paciente;
	private String feRegistro;
	private String ruc;
	private String status;
	private ArrayList<FacturaDetalle> detalle;
	
	
	public Factura() {
		super();
	}

	public Factura(int codFactura, int intidCliente, String cliente,
			int idPaciente, String paciente, String feRegistro, String ruc,
			String status, ArrayList<FacturaDetalle> detalle) {
		
		this.codFactura = codFactura;
		this.intidCliente = intidCliente;
		this.cliente = cliente;
		this.idPaciente = idPaciente;
		this.paciente = paciente;
		this.feRegistro = feRegistro;
		this.ruc = ruc;
		this.status = status;
		this.detalle = detalle;
	}

	public int getCodFactura() {
		return codFactura;
	}
	public void setCodFactura(int codFactura) {
		this.codFactura = codFactura;
	}
	public int getIntidCliente() {
		return intidCliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public void setIntidCliente(int intidCliente) {
		this.intidCliente = intidCliente;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getFeRegistro() {
		return feRegistro;
	}
	public void setFeRegistro(String feRegistro) {
		this.feRegistro = feRegistro;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<FacturaDetalle> getDetalle() {
		return detalle;
	}
	public void setDetalle(ArrayList<FacturaDetalle> detalle) {
		this.detalle = detalle;
	}
	 
	
	
}

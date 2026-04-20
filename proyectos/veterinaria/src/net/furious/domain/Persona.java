package net.furious.domain;


public class Persona {
	private int id;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String raza;
    
  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidomaterno) {
		this.apellidoMaterno = apellidomaterno;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidopaterno) {
		this.apellidoPaterno = apellidopaterno;
	}
	
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

}

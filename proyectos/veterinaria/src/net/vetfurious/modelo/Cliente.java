package net.vetfurious.modelo;

public class Cliente {

	String codigo;
	String nombre; 
	String apellidopaterno;
	String apellidomaterno;
	String email; 
	String direccion;
	String imagen; 
	String telefono; 
	String celular;
	String dni;
	String error;
	
	public Cliente(String codigo,String nombre, String apellidopaterno,String apellidomaterno,String email, String direccion,
			String imagen, String telefono, String celular) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.apellidopaterno=apellidopaterno;
		this.apellidomaterno=apellidomaterno;
		this.email=email;
		this.direccion=direccion;
		this.imagen=imagen;
		this.telefono= telefono;
		this.celular=celular;
	}
	
	public Cliente() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni){
		this.dni = dni;		
	}
	
	public String getError(){
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	
}

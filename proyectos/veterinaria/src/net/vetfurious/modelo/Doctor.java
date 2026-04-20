package net.vetfurious.modelo;

public class Doctor {
	
	public Doctor() {
		super();
	}
	
	public Doctor(Integer doctorID, String nombre, String paterno,
			String materno, String email, String telefono, String usuario, Integer grupoID, String password) {
		super();
		this.doctorID = doctorID;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.email = email;
		this.telefono = telefono;
		this.usuario = usuario;
		this.grupoID = grupoID;
		this.password = password;
	}



	private Integer doctorID;
	private String nombre;
	private String paterno;
	private String materno;
	private String email;
	private String telefono;
	private String usuario;
	private Integer grupoID;
	private String password;
	private String grupo;
	private String errMensaje;
	
	public String getErrMensaje() {
		return errMensaje;
	}

	public void setErrMensaje(String errMensaje) {
		this.errMensaje = errMensaje;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public Integer getGrupoID() {
		return grupoID;
	}

	public void setGrupoID(Integer grupoID) {
		this.grupoID = grupoID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	

}

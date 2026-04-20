package net.vetfurious.modelo;

public class Login {
	
	int usuarioid;
	String usuario;
	String password; 
	String nombre;
	String administrador;
	
	public Login() {}
	
	public Login(String _usuario,String _password) {
		this.usuario = _usuario;
		this.password = _password;

	}
	
	public Login(int _usuarioid,String _usuario,String _password, String _nombre,String _administrador) {
		this.usuarioid = _usuarioid;
		this.usuario = _usuario;
		this.password = _password;
		this.nombre = _nombre;
		this.administrador = _administrador;

	}
	
	
	public int getUsuarioID() {
		return usuarioid;
	}
	public void setUsuarioID(int UsuarioId) {
		this.usuarioid = UsuarioId;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String Usuario) {
		this.usuario = Usuario;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre= Nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password= Password;
	}

	public String getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(String Administrador) {
		this.administrador= Administrador;
	}

}

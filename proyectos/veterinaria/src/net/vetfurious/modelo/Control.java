package net.vetfurious.modelo;

public class Control {

	int id;
	String nombre; 
	
	
	public Control(int codigo,String nombre) {
		this.id=codigo;
		this.nombre=nombre;

	}
	
	public Control() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setCodigo(int codigo) {
		this.id = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

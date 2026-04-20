package net.vetfurious.modelo;


public class Paciente {
	
	int especieid;
	int razaid;
	int generoid; 
	int tipoSangreid; 
	int tamanoid; 
	int actividadid;
	String nombrePaciente;
	
	int codigoDueno;
	int codigoPaciente; 
	String especie;
	String raza;
	String genero; 
	String tipoSangre;
	String esterilizado; 
	String tamano; 
	String actividad;
	String peso;
	String fechaNacimiento;
	String notasMedicas;
	String condicionesEspeciales;
	
	public Paciente(int codigoDueno, int codigoPaciente, String especie, 
			String raza, String genero, String tipoSangre, String esterilizado, 
			String tamano, String actividad, String peso, String fechaNacimiento) {

		this.codigoDueno = codigoDueno;
		this.codigoPaciente = codigoPaciente;
		this.especie = especie;
		this.raza = raza;
		this.genero = genero;
		this.tipoSangre = tipoSangre;
		this.esterilizado = esterilizado;
		this.tamano = tamano;
		this.actividad = actividad;
		this.peso = peso;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoDueno() {
		return codigoDueno;
	}

	public void setCodigoDueno(int codigoDueno) {
		this.codigoDueno= codigoDueno;
	}
	
	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie= especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza= raza;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero= genero;
	}
	
	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre= tipoSangre;
	}

	public String getEsterilizado() {
		return esterilizado;
	}

	public void setEsterilizado(String esterilizado) {
		this.esterilizado= esterilizado;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano= tamano;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad= actividad;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso= peso;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento= fechaNacimiento;

	}
	
	///////////////////////////////////////////////////////////////////
	
	
	public int getespecieid() {
		return especieid;
	}

	public void setespecieid(int especieid) {
		this.especieid = especieid;
	}
	
	public int getrazaid() {
		return razaid;
	}

	public void setrazaid(int razaid) {
		this.razaid = razaid;
	}
	
	public int getgeneroid() {
		return generoid;
	}

	public void setgeneroid(int generoid) {
		this.generoid = generoid;
	}
	
	public int gettipoSangreid() {
		return tipoSangreid;
	}

	public void settipoSangreid(int tipoSangreid) {
		this.tipoSangreid = tipoSangreid;
	}
	
	public int gettamanoid() {
		return tamanoid;
	}

	public void settamanoid(int tamanoid) {
		this.tamanoid = tamanoid;
	}

	public int getactividadid() {
		return actividadid;
	}

	public void setactividadid(int actividadid) {
		this.actividadid = actividadid;
	}

	
	public String getNotasMedicas() {
		return notasMedicas;
	}

	public void setNotasMedicas(String NotasMedicas) {
		this.notasMedicas= NotasMedicas;
	}
	
	
	public String getCondicionesEspeciales() {
		return condicionesEspeciales;
	}

	public void setCondicionesEspeciales(String CondicionesEspeciales) {
		this.condicionesEspeciales= CondicionesEspeciales;
	}
	
	
	public String getnombrePaciente() {
		return nombrePaciente;
	}

	public void setnombrePaciente(String nombrePaciente) {
		this.nombrePaciente= nombrePaciente;
	}
	
	

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}


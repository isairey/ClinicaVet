
	function validar() {
		if (document.form.txtNombre.value == "") {
			alert('Ingrese nombre');
			return false;
		} else if (document.form.txtNombre.value == "") {
			alert('Ingrese clave');
			return false;
		} else if (document.form.txtDescripcion.value == "") {
			alert('Ingrese la descripcion');
			return false;
		} 
		return true;
	}

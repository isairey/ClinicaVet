function myCallBack(data) {
	if ( data.nombre != ""){
		alert("El nombre del titular del Ruc es: " + data.nombre + "y su dni es "+ data.dni);
	}
	else{
		alert("El ruc no se encuentra registrado");
	}
}

$(document).ready(function() {
	setearRucRest();
});

function setearRucRest() {

	$('a#hlRucRest').on('click', function(e){
		e.preventDefault();

		var ruc = $("input#txtruc").val();
		if (ruc.length > 0) {
			var myUrl = "http://localhost:9080/rest/webresources/rucrest/get2/"
					+ ruc;

			$.ajax({
				url : myUrl,
				type : 'GET',
				crossDomain : true,
				dataType : 'script',
				jsonp : false,
				jsonpCallback : "myCallBack",
				error : function(httpReq, status, exception) {
				}
			});
		} else {
			alert("debe ingresar un ruc");
		}
		
	});
	

}

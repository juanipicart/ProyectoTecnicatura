// Mi código JavaScript:


// Carga de Tipo de Cambio:
$.ajax({
	url: "https://ha.edu.uy/api/rates",
	success : function (data) {
		$("#rate span").text(data.uyu);
	}
});

function getCorsiPerStudente() {
var studente = "studente=" + localStorage.getItem("utente");


  $.ajax({
		url: "http://logoscloud.ddns.net:8080/logos/GetCorsiPerStudenteServlet",
		method: 'post',
        data: studente
	})
	.done(function(esito){
		var corsi = JSON.parse(esito);
      var allHtml = "<thead class=\"text-warning\"><tr><th>Titolo</th><th>Docente</th><th>Prossima lezione</th><th>Ore Totali</th><th>% Assenze</th></tr></thead><tbody>";
      corsi.forEach(function(element){
           console.log(element)
          console.log()
        var htmlIgnect = "<tr><td>" + element.titolo + "</td><td>docente</td><td>" + element.leziones[element.lezioneEffettuate].data + 
            "</td><td>" + element.oreTotali + "</td><td>ore assenza</td></tr>" ;
         allHtml = allHtml + htmlIgnect;
      });
       $("#lista-corsi-lista-corsi-studente").html(allHtml + "</tbody>")
	})
	.fail(function(err) {
		console.error('qualcosa e andato storto nella richiesta dei corsi per studente ' + err)
	});
}
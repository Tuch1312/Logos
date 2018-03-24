         
            
                //questa sezione viene eseguita solo al refresh della pagina
                var codice = localStorage.getItem("utente");
            	if (!codice || codice.length != 32) {
			    alert("Sessione scaduta, accedere nuovamente")
                window.location.href = 'index.html';
			} else {
                var s = {};
                s.codicePersona=codice;
			         $.ajax({
                         url: "http://logoscloud.ddns.net:8080/LogosWeb/GetPersonaServlet",
                         method: 'post',
                         data: s
                     })
                .done(function (esito) {
                       var utente = JSON.parse(esito)
                       	       if (utente.ruolo == "D" || utente.ruolo == "d") {
			        $(".card-main").css("display", "none");
			       $("#tabbed-liste-docente").css("display", "block")
			           $("#menu-docente").css("display", "block");
			       } else {
			          $(".card-main").css("display", "none");
			       $("#lista-corsi-studente").css("display", "block")
			             $("#menu-studente").css("display", "block");
                       getCorsiPerStudente();
			        
			       }
                     })
		
			
			
			}
            
		
            
            
            //menu studente
                //i miei corsi
            $("#menu-studente-corsi").click(function () {
                 $(".card-main").css("display", "none");
			     $("#lista-corsi-studente").css("display", "block")
                 $(".menu-item").removeClass("active");
                $("#menu-studente-corsi").addClass("active");
                getCorsiPerStudente();
                
            });
                //dashboard
              $("#menu-studente-dash").click(function () {
                 $(".card-main").css("display", "none");
			     $("#tabbed-dashboard-studente").css("display", "block")
                   $(".menu-item").removeClass("active");
                $("#menu-studente-dash").addClass("active");
                
            });
                //iscriviti
               $("#menu-studente-iscriviti").click(function () {
                 $(".card-main").css("display", "none");
			     $("#isciriviti-corso-studente").css("display", "block")
                $(".menu-item").removeClass("active")
                $("#menu-studente-iscriviti").addClass("active");
                
            });
            
            
            //menu docente
                //i miei corsi
            $("#menu-docente-corsi").click(function () {
                 $(".card-main").css("display", "none");
			     $("#tabbed-liste-docente").css("display", "block")
                 $(".menu-item").removeClass("active");
                $("#menu-docente-corsi").addClass("active");
                
            });
                //dashboard
              $("#menu-docente-dash").click(function () {
                 $(".card-main").css("display", "none");
			     $("#dashboard-corsi-docente").css("display", "block")
                   $(".menu-item").removeClass("active");
                $("#menu-docente-dash").addClass("active");
                
            });
                //iscriviti
               $("#menu-docente-nuovo").click(function () {
                 $(".card-main").css("display", "none");
			     $("#docente-crea-corso").css("display", "block")
                    $(".menu-item").removeClass("active");
                $("#menu-docente-nuovo").addClass("active");
                
            });
            
            
                



// --------------------------------------------


//Gestisce "i mie corsi" di studente
function getCorsiPerStudente() {
var studente = "codicePersona=" + localStorage.getItem("utente");


  $.ajax({
		url: "http://logoscloud.ddns.net:8080/LogosWeb/GetCorsiPerStudenteServlet",
		method: 'post',
        data: studente
	})
	.done(function(esito){
		var corsi = JSON.parse(esito);
      var allHtml = "<thead class=\"text-warning\"><tr><th>Titolo</th><th>Docente</th><th>Prossima lezione</th><th>Ore Totali</th><th>% Assenze</th></tr></thead><tbody>";
      corsi.forEach(function(element){
           sessionStorage.setItem("c" + element.idCorso, JSON.stringify(element))
        var htmlIgnect = "<tr id=\"acab\" class=\"elemento-lista-corsi-studente\" hIdCorso=\"" + element.idCorso + "\"><td>" + element.titolo + "</td><td>docente</td><td>" + element.leziones[element.lezioneEffettuate].data + 
            "</td><td>" + element.oreTotali + "</td><td>ore assenza</td></tr>" ;
         allHtml = allHtml + htmlIgnect;
      });
       $("#lista-corsi-lista-corsi-studente").html(allHtml + "</tbody>")
	})
	.fail(function(err) {
		console.error('qualcosa e andato storto nella richiesta dei corsi per studente ' + err)
	});
}


//gestione della dashbaord studente
function initDashboardStudente(idcorso) {
    var corso = JSON.parse(sessionStorage.getItem("c" + idcorso))
    //&per ogni lezoine in ezione crea tre tabelle: argomenti passati, argomenti futuri, tutte le lezioni
    var oggi = Date.now();
    var pstCount = 0;
    var ftrCount = 0;
    var allHtmlPst = "<thead class=\"text-primary\"><tr><th>N° lezione</th><th>Argomenti</th></tr></thead><tbody>"
    var allHtmlFtr = "<thead class=\"text-primary\"><tr><th>N° lezione</th><th>Argomenti</th></tr></thead><tbody>"
    var allHtmlLez = "<thead class=\"text-warning\"><tr><th>N° Lezione</th><th>Argomenti</th><th>Data</th><th>Ora</th><th>Aula</th></tr></thead><tbody>"
   
    corso.leziones.forEach(function(element) {
        
        //se la data della lezione è minore di oggi segna gli argomenti nella teblla passato
        if (element.data < oggi && pstCount < 5) {
            html = "<tr><td>" + element.numeroLezione + "</td><td>" + element.argomenti + "</td></tr>"
            allHtmlPst = allHtmlPst + html;
            pstCount++;
        //altirimenti nella tabella futuro    
        } else if (element.data > oggi && ftrCount < 5){
            html = "<tr><td>" + element.numeroLezione + "</td><td>" + element.argomenti + "</td></tr>"
            allHtmlFtr = allHtmlFtr + html;
            ftrCount++;
        }
      
        
        
        //e per ogni lezione crea anche la tabella tutte le lezioniù
        html = "<tr><td>" + element.numeroLezione + "</td><td>" + element.argomenti + "</td><td>" + element.data + "</td><td>" + element.oraInizio + "</td><td>" + element.aula + "</td></tr>";
        allHtmlLez = allHtmlLez + html;
    })
      $("#tabella-argomenti-passati-dashboard-studente").html(allHtmlPst + "</tbody>");
      $("#tabella-argomenti-prossimi-dashboard-studente").html(allHtmlFtr + "</tbody>");
    $("#lista-lezioni-dashboard-studente").html(allHtmlLez + "</tbody>");
    
     $("#ore-totali-dashboard-studenti").html((corso.numeroGiorni * corso.lezionePerGiorno)* corso.durataLezione)
    $("#ore-trascorse-dashboard-studente").html((corso.lezioneCorrente -1) * corso.durataLezione)

    
}

//gestione iscrizione per studenye
$("#button-iscriviti-studente").click(
function () {
        $("#success-iscrizione-studente").css("display","none")
     $("#error-iscrizione-studente").css("display","none")
    var codicecors = $("#input-iscriviti-studente").val();
    var student = localStorage.getItem("utente");
    var dati = {}
    
    dati.codicePersona = student;
    dati.codiceCorso = codicecors;
    console.log(dati)
    $.ajax({
		url: "http://logoscloud.ddns.net:8080/LogosWeb/IscrivitiServlet",
		method: 'post',
        data: dati
	})
	.done(function(esito){
        		console.log(esito)
          if (esito.includes("true")) {
              $("#success-iscrizione-studente").css("display","block")
          } else {
              $("#error-iscrizione-studente").css("display","block")
          }
          })
		
	.fail(function(err) {
		console.error('qualcosa e andato storto nella iscirzione per studente ' + err)
	})
    


});

$("body").on("click", "#lista-corsi-lista-corsi-studente tr", function () {
$(".card-main").css("display", "none");
$("#tabbed-dashboard-studente").css("display", "block")
initDashboardStudente($(this).attr("hIdCorso"))
});






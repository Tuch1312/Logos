
//Passa da login a registraione
$("#registrati-on").click(function() {
    $("#register-card").css("display", "block");
    $("#login-card").css("display", "none");

});

//Passa da registrazione a login
$("#login-on").click(function() {
    $("#login-card").css("display", "block");
    $("#register-card").css("display", "none");

});

//Inizio Area Login

$("#submit-login").click( function() {

if(validateEmail($("#input-mail-login").val())) {
    var utente = {}
utente.mail = $("#input-mail-login").val();
utente.password = $("#input-password-login").val()
$.ajax({
		url: 'http://logoscloud.ddns.net:8080/LogosWeb/LoginServlet',
		method: 'post',
		data: utente
	})
	.done(function(esito){
		console.log(esito);
    if (esito == "123456789") {
         $("#login-fallito").css("display", "block")
        eliminaerrore();
        
    } else {
        localStorage.setItem('utente', esito);
        $('#myModal').modal('toggle');
    }
		
	})
	.fail(function() {
		console.error('qualcosa è andato storto.')
	});
} else {
     $("#error-login-mail").css("display", "block")
    $("#error-login-mail").html("E-mail non corretta")
}

;

});

$("#input-mail-login").click(function () {
    $("#error-login-mail").css("display", "none")
})


//Fine area Login

function validateEmail(email) {
    //var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    var re = /.*/;
    return re.test(String(email).toLowerCase());
}

function eliminaerrore() {
         setTimeout(function(){
             $("#login-fallito").css("display", "none")
              $("#registrazione-fallita").css("display", "block")
        }, 2000);
}

function eliminaGiaLoggato() {
         setTimeout(function(){
             $("#gia-loggato").css("display", "none");
              $('#myModal').modal('toggle');
        }, 1500);
}

//Inzio are registrazione

$("#submit-registrazione").click( function() {
    
//Costrusco l'oggetto utente
if(validateEmail($("#input-mail-registrati").val())){
var utente = {}
utente.nome = $("#input-nome-registrati").val();
utente.cognome = $("#input-cognome-registrati").val();
utente.mail = $("#input-mail-registrati").val();
utente.password = $("#input-password-registrati").val();
utente.isDocente = $('input[name="tipo"]:checked').val();
    
    //chiamo la servlket di registrazione, restituosce true o false
    $.ajax({
		url: 'http://logoscloud.ddns.net:8080/LogosWeb/RegistrazioneServlet',
		method: 'post',
		data: utente
	})
    //se va a buon fine
	.done(function(esito){
		console.log(esito);
    //ma restitusce false
    if (esito == false) {
         $("#registrazione-fallita").css("display", "block")
        eliminaerrore()
    } else {
        var uLogin = {}
        uLogin.mail = utente.mail;
        uLogin.password = utente.password;
    //altriemnti se la registrazione è andata a buon fine eseguo il login chre mi restituisce il codice della persona
        $.ajax({
            url: 'http://logoscloud.ddns.net:8080/LogosWeb/LoginServlet',
            method: 'post',
		  data: uLogin
        })
        .done (function (esito) {
        //salvo il codice della persona nell browser
        localStorage.setItem('utente', esito);
        //chiudo il modal
        $('#myModal').modal('toggle');
        //cambio la scritta login con il nome e il cognom edell'utente

        $("#login-button").html("<i class=\"material-icons\">person</i>" + utente.nome + " " + utente.cognome)
             
        })
    }
		
	})
	.fail(function() {
		console.error('qualcosa è andato storto.')
	});
   
        
    
} else {
     $("#error-registrati-mail").css("display", "block")
    $("#error-registrati-mail").html("E-mail non valida")
}

})

$("#input-mail-registrati").click(function () {
    $("#error-registrati-mail").css("display", "none")
})

//Fine area registrazione

//Se sei già registrato e clicchi su Login
$("#login-button").click( function () {
    if (localStorage.getItem("utente") != null) {
    if (localStorage.getItem("utente").length == 32) {
                  $("#login-card").css("display", "none")
                  $("#register-card").css("display", "none")
                $("#gia-loggato").css("display", "block")
                eliminaGiaLoggato()

                
              } else {
                   $("#login-card").css("display", "block")
                  $("#register-card").css("display", "none")
                $("#gia-loggato").css("display", "none")
              }
    }
}
);







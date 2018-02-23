
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


//Login

$("#submit-login").click( function() {
    function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
if(validateEmail($("#input-mail-login").val())) {
    var utente = {}
utente.mail = $("#input-mail-login").val();
utente.password = $("#input-password-login").val()
} else {
     $("#error-login-mail").css("display", "block")
    $("#error-login-mail").html("E-mail non corretta")
}

;

});

$("#input-mail-login").click(function () {
    $("#error-login-mail").css("display", "none")
})




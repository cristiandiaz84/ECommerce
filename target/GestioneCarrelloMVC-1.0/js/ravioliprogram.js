function mostraProdotti(nome) {
    if (nome.length == 0)
    {
        //se l'input è vuoto non resistuisco niente  
        document.getElementById("parteajax").innerHTML = "";
        return;
    }
    var xmlHttp = new XMLHttpRequest();
    //definizione di callback
    xmlHttp.onreadystatechange = function () {
        // verrà eseguita quando il server invia la risposta
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //la risposta della servlet viene messa nel div 
            document.getElementById("parteajax").innerHTML = xmlHttp.responseText;
        }
    };
// faccio la richiesta con tipo,chi fa la richiesta e se è asincrona    
    xmlHttp.open("GET", "getProdotti.do?nome=" + nome, true);
    xmlHttp.send();
}

var app = (function(){
               
var validaCampi = function(){
var userName = document.getElementById('userName').value;
var password = document.getElementById('password').value;
    if ((userName ==="")){

        toastr.error("Username non corretta");

        toastr.options = {
        "closeButton": false,
                "debug": false,
                "positionClass": "toast-top-right",
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "600",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
        };
        return false;
    } else{
       if ((password ==="")){
           toastr.error("Password non corretta");

        toastr.options = {
        "closeButton": false,
                "debug": false,
                "positionClass": "toast-top-right",
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "600",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
        };
        return false;
       }
       return true;
    }
};

    return {
        // nome proprietà dell'oggetto JSON che sto tornando il cui valore è caricaNomi
        validaCampi : validaCampi
    };

})();



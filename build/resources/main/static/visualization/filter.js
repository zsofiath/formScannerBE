var userButtons = document.getElementsByClassName('user_button');
var typeButtons = document.getElementsByClassName('type_button');

var users = [];
var types = [];

const ENDPOINT = "http://localhost:8080/";


for(var i = 0; i < userButtons.length; i++){
    let element = userButtons[i];
    element.addEventListener('click', function(){
        if(users.includes(element.innerHTML)) {
            users.splice(users.indexOf(element.innerHTML), 1);
            element.setAttribute( 'class', '' );
        } else {
            users.push(element.innerHTML);
            http();            
            element.setAttribute( 'class', 'myCssClass' );
        }
    });
}

for(var i = 0; i < typeButtons.length; i++){
    let element = typeButtons[i];
    element.addEventListener('click', function(){
        if(types.includes(element.innerHTML)) {
            types.splice(types.indexOf(element.innerHTML), 1);
            element.setAttribute( 'class', '' );
        } else {
            types.push(element.innerHTML);
            http();            
            element.setAttribute( 'class', 'myCssClass' );
        }
    });
}

function http(){
    http1();
    http2();
    http3();
    http4();
}

function http1(){
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == XMLHttpRequest.DONE) {
            //alert(xhttp.responseText);
        }
    }

    xhttp.open("GET", ENDPOINT+"task-durations"+BuildParams(), true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send();

}
function http2(){
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == XMLHttpRequest.DONE) {
            //alert(xhttp.responseText);
        }
    }

    xhttp.open("GET", ENDPOINT+"opened-closed"+BuildParams(), true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send();

}
function http3(){
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == XMLHttpRequest.DONE) {
            //alert(xhttp.responseText);
        }
    }

    xhttp.open("GET", ENDPOINT+"idle-active"+BuildParams(), true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send();

}
function http4(){
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == XMLHttpRequest.DONE) {
            //alert(xhttp.responseText);
        }
    }

    xhttp.open("GET", ENDPOINT+"task-fields"+BuildParams(), true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send();

}

function BuildParams(){
    var u = users.join(',');
    var t = types.join(',');

    return '?users='+u+'&tasktypes='+t;
}
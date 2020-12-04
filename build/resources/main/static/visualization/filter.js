var buttonBox = document.getElementById('users');
var buttonBox2 = document.getElementById('types');


for (let index = 0; index < 10; index++) {
    let btn = document.createElement('button');
    btn.innerHTML = "User "+index;
    btn.addEventListener('click', function(){
        alert(btn.innerHTML);
    });
    buttonBox.appendChild(btn);
}

for (let index = 0; index < 12; index++) {
    let btn = document.createElement('button');
    btn.innerHTML = "Type "+index;
    btn.addEventListener('click', function(){
        alert(btn.innerHTML);
    });
    buttonBox2.appendChild(btn);
}

function http(){
    var xhttp = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            alert(xhr.responseText);
        }
    }

    xhttp.open("GET", ENDPOINT+"save-usage", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(USAGE_PACKAGE));
    USAGE_PACKAGE.eventList = [];
}
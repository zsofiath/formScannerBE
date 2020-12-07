var ctx = document.getElementById('myChart').getContext('2d');
var ctx2 = document.getElementById('myChart2').getContext('2d');
var ctx3 = document.getElementById('myChart3').getContext('2d');
var ctx4 = document.getElementById('myChart4').getContext('2d');

var rest = '#faeabe';
var info = '#befabf';
var stroke = '#4d594d'

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
            http();
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
http();

function http(){
    http1();
    http2();
    http3();
    http4();
}

function formatresponse(response){
    let labels = [];
    let values = [];

    var json = JSON.parse(response);

    for (const key of Object.keys(json)) {
        labels.push(key);
        var f = parseFloat(json[key]);
        values.push(f);
    }

    return {
        labels: labels,
        values: values        
    };
}

function http1(){
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == XMLHttpRequest.DONE) {
            let data = formatresponse(xhttp.responseText);
            chart1Label = data.labels;
            chart1Value = data.values;
            console.log(chart1Label, chart1Value);

            var chart = new Chart(ctx, {
                // The type of chart we want to create
                type: 'horizontalBar',
            
                // The data for our dataset
                data: {
                    labels: chart1Label,
                    datasets: [{
                        label: 'Task times',
                        backgroundColor: rest,
                        borderColor: stroke,
                        borderWidth:1,
                        data: chart1Value
                    }]
                },
            
                // Configuration options go here
                options: {
                    onClick: function (e){
                        console.log(e);
                    }
                },
                
            });
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
            let data = formatresponse(xhttp.responseText);
            chart2Label = data.labels;
            chart2Value = data.values;

            var chart2 = new Chart(ctx2, {
                // The type of chart we want to create
                type: 'pie',
            
                // The data for our dataset
                data: {
                    labels: chart2Label,
                    datasets: [{
                        label: 'Ratio of closed and ongoing tasks',
                        backgroundColor: [rest, info],
                        borderColor: stroke,
                        borderWidth:1,
                        data: chart2Value
                    }]
                },
            
                // Configuration options go here
                options: {}
            });
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

            let data = formatresponse(xhttp.responseText);
            chart3Label = data.labels;
            chart3Value = data.values;

            var chart4 = new Chart(ctx4, {
                // The type of chart we want to create
                type: 'pie',
            
                // The data for our dataset
                data: {
                    labels: chart3Label,
                    datasets: [{
                        label: 'Ratio of idle and active times',
                        backgroundColor: [info, rest],
                        borderColor: stroke,
                        borderWidth:1,
                        data: chart3Value
                    }]
                },
            
                // Configuration options go here
                options: {}
            });
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
            let data = formatresponse(xhttp.responseText);
            chart4Label = data.labels;
            chart4Value = data.values;

            var chart3 = new Chart(ctx3, {
                // The type of chart we want to create
                type: 'bar',
            
                // The data for our dataset
                data: {
                    labels: chart4Label,
                    datasets: [{
                        label: 'Number of actions on <Selected> task type fileds',
                        backgroundColor: rest,
                        borderColor: stroke,
                        borderWidth:1,
                        data: chart4Value
                    }]
                },
            
                // Configuration options go here
                options: {}
            });

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
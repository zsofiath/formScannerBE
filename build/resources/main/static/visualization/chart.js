var ctx = document.getElementById('myChart').getContext('2d');
var ctx2 = document.getElementById('myChart2').getContext('2d');
var ctx3 = document.getElementById('myChart3').getContext('2d');
var ctx4 = document.getElementById('myChart4').getContext('2d');

var rest = '#faeabe';
var info = '#befabf';
var stroke = '#4d594d'

var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'horizontalBar',

    // The data for our dataset
    data: {
        labels: ['Type 1', 'Type 2', 'Type 3', 'Type 4', 'Type 5', 'Type 6', 'Type 7'],
        datasets: [{
            label: 'Task times',
            backgroundColor: rest,
            borderColor: stroke,
            borderWidth:1,
            data: [0, 10, 5, 2, 20, 30, 45]
        }]
    },

    // Configuration options go here
    options: {
        onClick: function (e){
            console.log(e);
        }
    },
    
});

var chart2 = new Chart(ctx2, {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
        labels: ['Done', 'Opened',],
        datasets: [{
            label: 'Ratio of closed and ongoing tasks',
            backgroundColor: [rest, info],
            borderColor: stroke,
            borderWidth:1,
            data: [50,20]
        }]
    },

    // Configuration options go here
    options: {}
});
var chart3 = new Chart(ctx3, {
    // The type of chart we want to create
    type: 'bar',

    // The data for our dataset
    data: {
        labels: ['Field 1', 'Field 2', 'Field 3', 'Field 4', 'Field 5', 'Field 6', 'Field 7'],
        datasets: [{
            label: 'Number of actions on <Selected> task type fileds',
            backgroundColor: rest,
            borderColor: stroke,
            borderWidth:1,
            data: [0, 10, 5, 2, 20, 30, 45]
        }]
    },

    // Configuration options go here
    options: {}
});
var chart4 = new Chart(ctx4, {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
        labels: ['Active', 'Idle'],
        datasets: [{
            label: 'Ratio of idle and active times',
            backgroundColor: [info, rest],
            borderColor: stroke,
            borderWidth:1,
            data: [30, 45]
        }]
    },

    // Configuration options go here
    options: {}
});
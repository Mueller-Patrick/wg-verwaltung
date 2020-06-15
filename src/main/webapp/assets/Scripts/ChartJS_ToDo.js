var ctx = document.getElementById('myChartTodo').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [{
            label: 'Meine offenen ToDos',
            backgroundColor: 'rgb(182,255,99)',
            borderColor: 'rgb(182,255,99)',
            data: [0, 5, 3, 0, 1, 2, 4]
        }]
    },

    // Configuration options go here
    options: {}
});
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    indexAxis: 'y',
    data: {
        labels: ['RAM', 'CPU', 'Disco'],
        datasets: [{
            label: "nº de ocorrências",
            data: [8, 10, 5],
            backgroundColor: [
                'rgba(15,125,146, 1)',
                'rgba(241, 96, 50, 1)',
                'rgba(15,125,146, 1)',
            ],
            borderColor: [
                'rgba(24,179,194, 1)',
                'rgba(241, 96, 50, 1)',
                'rgba(24,179,194, 1)',
            ],
            borderWidth: 1
        }]
    }, options: {
        indexAxis : 'y',
        title: {
            text: "Registros de alerta",
            display: true,
            fontSize: 15,
        }, legend: {
            display: false
        },
        tooltips: {
            enabled: false
        },
        elements: {
            bar: {
                borderWidth: 2,
            }
        },
        scales: {
            xAxes: [{
                ticks: {
                    beginAtZero: true
                },
                gridLines: {
                    color: "rgba(0, 0, 0, 0)",
                }
            }],
            yAxes: [{
                ticks: {
                    min: 0,
                },
             }],
        }
    }
});

var ctx = document.getElementById('chartMaquinas').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['00/04', '4/08', '08/12', '12/16', '16/20', '20/24'],
        datasets: [{
            label: "nº de ocorrências",
            data: [3, 15, 5, 8, 14, 6],
            backgroundColor: [
                'rgba(15,125,146, 1)',
                'rgba(241, 96, 50, 1)',
                'rgba(15,125,146, 1)',
                'rgba(15,125,146, 1)',
                'rgba(15,125,146, 1)',
                'rgba(15,125,146, 1)'
            ],
            borderColor: [
                'rgba(24,179,194, 1)',
                'rgba(241, 96, 50, 1)',
                'rgba(24,179,194, 1)',
                'rgba(24,179,194, 1)',
                '   ',
                'rgba(24,179,194, 1)'
            ],
            borderWidth: 1
        }]
    }, options: {
        title: {
            text: "Sem papel x hora",
            display: true,
            fontSize: 15,
        },
        legend: {
            display: false
        },
        tooltips: {
            enabled: false
        },
        scales: {
            xAxes: [{
                ticks: {
                    beginAtZero: true
                },
                gridLines: {
                    color: "rgba(0, 0, 0, 0)",
                }
            }],
            yAxes: [{
               beginAtZero: true
            }],
        }
    }
});

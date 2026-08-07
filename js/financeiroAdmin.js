const ctx = document.getElementById("graficoDespesas");

new Chart(ctx, {
    type: "doughnut",
    data: {
        labels: [

            "Jan",
            "Fev",
            "Mar",
            "Abr",
            "Mai",
            "Jun",
            "Jul",
            "Ago",
            "Set",
            "Out",
            "Nov",
            "Dez"

        ],
        datasets: [{
            label: "Despesas (R$)",
            data: [

                12000,
                14500,
                17000,
                19000,
                21000,
                23500,
                22300,
                0,
                0,
                0,
                0,
                0
            ],
            borderColor: "none",
            backgroundColor: [
                "#FF6A00",
                "#F57C00",
                "#FFC107",
                "#4CAF50",
                "#2196F3",
                "#9C27B0",
                "#E91E63"
            ],
            fill: true,
            tension: 0.4
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false
    }
});
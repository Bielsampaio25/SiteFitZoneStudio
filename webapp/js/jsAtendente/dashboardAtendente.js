const ctx = document.getElementById("graficoNovosAlunos");

new Chart(ctx, {
    type: "line",
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
            label: "Novos Alunos",
            data: [

                42,
                35,
                48,
                55,
                61,
                58,
                67,
                0,
                0,
                0,
                0,
                0
            ],
            borderColor: "#FF6A00",
            backgroundColor: "rgba(255,106,0,0.15)",
            fill: true,
            tension: 0.4
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false
    }
});
// --- 1. Gráfico Financeiro (Linha/Barra) ---
const ctxFinanceiro = document.getElementById("graficoFinanceiro");

new Chart(ctxFinanceiro, {
    type: "line", // Pode alterar para "bar" se preferir barras
    data: {
        labels: [
            "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", 
            "Jul", "Ago", "Set", "Out", "Nov", "Dez"
        ],
        datasets: [{
            label: "Receita (R$)",
            data: [15000, 18000, 20000, 22000, 25000, 28000, 27000, 0, 0, 0, 0, 0],
            borderColor: "#FF6A00",
            backgroundColor: "rgba(255, 106, 0, 0.2)",
            fill: true,
            tension: 0.4
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false
    }
});

// --- 2. Gráfico de Despesas (Rosca) ---
const ctxDespesas = document.getElementById("graficoDespesas");

new Chart(ctxDespesas, {
    type: "doughnut",
    data: {
        labels: [
            "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", 
            "Jul", "Ago", "Set", "Out", "Nov", "Dez"
        ],
        datasets: [{
            label: "Despesas (R$)",
            data: [
                12000, 14500, 17000, 19000, 21000, 23500, 
                22300, 0, 0, 0, 0, 0
            ],
            borderColor: "transparent",
            backgroundColor: [
                "#FF6A00", "#F57C00", "#FFC107", "#4CAF50",
                "#2196F3", "#9C27B0", "#E91E63"
            ]
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false
    }
});
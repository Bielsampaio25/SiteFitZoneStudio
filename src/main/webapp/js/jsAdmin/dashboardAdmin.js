const ctx = document.getElementById("graficoFinanceiro");

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
            label: "Receita (R$)",
            data: [

                12000,
                14500,
                17000,
                19000,
                21000,
                23500,
                25000,
                0,
                0,
                0,
                0,
                0
            ],
            borderColor:"#FF6A00",
            backgroundColor:"rgba(255,106,0,0.15)",
            fill:true,
            tension:0.4
        }]
    },
    options:{
        responsive:true,
        maintainAspectRatio:false
    }
});

async function TotalFuncionariosAtivos(){
    try{
        const resposta = await fetch("/SiteFitZoneStudio/api/dashboard");
        const dados = await resposta.json();
        document.getElementById("funcionariosAtivos").innerHTML = dados.FuncionariosAtivos;
    }catch(erro){
        console.error("Erro ao exibir o total de funcionarios ativos", erro);
    }
}

window.addEventListener("DOMContentLoaded", () => {
    TotalFuncionariosAtivos();
});
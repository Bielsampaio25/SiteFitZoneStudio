async function TotalFuncionarios() {
    try {
        const resposta = await fetch("/SiteFitZoneStudio/api/funcionarios?situacao=total");
        const dados = await resposta.json();
        document.getElementById("totalFuncionarios").innerHTML = dados.TotalFuncionarios;
    } catch (erro) {
        console.error("Erro ao exibir o total de funcionarios", erro);
    }
}

async function TotalFuncionariosAtivos() {
    try {
        const resposta = await fetch("/SiteFitZoneStudio/api/funcionarios?situacao=ativos");
        const dados = await resposta.json();
        document.getElementById("funcionariosAtivos").innerHTML = dados.FuncionariosAtivos;
    } catch (erro) {
        console.error("Erro ao exibir o total de funcionarios ativos", erro);
    }
}

async function TotalFuncionariosDesligados() {
    try {
        const resposta = await fetch("/SiteFitZoneStudio/api/funcionarios?situacao=desligados");
        const dados = await resposta.json();
        document.getElementById("funcionariosDesligados").innerHTML = dados.FuncionariosDesligados;
    } catch (erro) {
        console.error("Erro ao exibir o total de funcionarios desligados", erro);
    }
}

async function ListarFuncionarios() {
    try {
        const resposta = await fetch(
            "/SiteFitZoneStudio/api/funcionarios?situacao=listar"
        );

        const funcionarios = await resposta.json();

        const tabelaFuncionarios =
            document.getElementById("corpoTabela");

        let linhas = "";

        funcionarios.forEach(funcionario => {
            linhas += `
                <tr>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.codigo}</td>
                    <td>${funcionario.cargo}</td>
                    <td>${funcionario.telefone}</td>
                    <td>${funcionario.email}</td>
                    <td>${funcionario.situacao}</td>
                    <td>${funcionario.dtaAdmissao}</td>
                    <td><div class="tabela-acoes"><img src="../../assets/icons/icone_remover.png" alt="botão para remover o funcionário" id="btnRemover"></div></td>
                </tr>
            `;
        });

        tabelaFuncionarios.innerHTML = linhas;

    } catch (erro) {
        console.error("Erro ao listar funcionário:", erro);
    }
}

window.addEventListener("DOMContentLoaded", () => {
    TotalFuncionarios();
    TotalFuncionariosAtivos();
    TotalFuncionariosDesligados();
    ListarFuncionarios();
});



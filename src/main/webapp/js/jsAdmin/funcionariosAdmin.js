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
                <tr data-codigo="${funcionario.codigo}">
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.codigo}</td>
                    <td>${funcionario.cargo}</td>
                    <td>${funcionario.telefone}</td>
                    <td>${funcionario.email}</td>
                    <td>${funcionario.situacao}</td>
                    <td>${funcionario.dtaAdmissao}</td>
                    <td><div><img src="../../assets/icons/icone_remover.png" alt="botão para remover o funcionário" class="btnRemover" data-codigo="${funcionario.codigo}"></div></td>
                </tr>
            `;
        });
        tabelaFuncionarios.innerHTML = linhas;
        document.addEventListener("click", async (event) => {

            if (!event.target.classList.contains("btnRemover")) {
                return;
            }

            const codigo = event.target.dataset.codigo;
            const response = await fetch(`/SiteFitZoneStudio/api/funcionarios/${codigo}`, {
                method: "DELETE"
            });
            if (response.ok) {
                const linha = event.target.closest("tr");
                linha.remove();
            }
        });
    } catch (erro) {
        console.error("Erro ao listar funcionário:", erro);
    }
}

const btnBuscar = document.getElementById("btnBuscar");

btnBuscar.addEventListener("click", BuscarFuncionario);

async function BuscarFuncionario() {

    console.log("Botão clicado!");

    const codigo = document.getElementById("codigo").value.trim();

    console.log("Código:", codigo);

    if (!codigo) {
        alert("Digite o código do funcionário.");
        return;
    }

    try {

        const resposta = await fetch(
            `/SiteFitZoneStudio/api/funcionarios?codigo=${codigo}&situacao=buscar`
        );

        console.log("Status:", resposta.status);

        if (!resposta.ok) {
            throw new Error("Erro ao buscar funcionário.");
        }

        const funcionario = await resposta.json();

        console.log("Funcionário:", funcionario);

        if (!funcionario) {
            alert("Funcionário não encontrado.");
            return;
        }

        document.querySelectorAll("input[name]").forEach(input => {

            if (input.name === "codigo") {
                return;
            }

            const valor = funcionario[input.name];

            if (valor !== undefined && valor !== null) {
                input.placeholder = valor;
            }

        });

        document.getElementById("sexo").value = funcionario.sexo || "";

        document.getElementById("turno").textContent =
            funcionario.turno || "";

        document.getElementById("salario").placeholder =
            funcionario.salario || "";

        document.getElementById("users").placeholder =
            funcionario.nomeUsuario || "";

        document.getElementById("password").placeholder =
            funcionario.senha || "";

    } catch (erro) {

        console.error("Erro:", erro);

    }
}

document.getElementById("btnBuscar").addEventListener(
    "click",
    BuscarFuncionario
);

window.addEventListener("DOMContentLoaded", () => {
    TotalFuncionarios();
    TotalFuncionariosAtivos();
    TotalFuncionariosDesligados();
    ListarFuncionarios();
});



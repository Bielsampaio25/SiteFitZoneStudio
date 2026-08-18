package controller;

import java.io.IOException;

import dao.funcionariosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.funcionariosModel;

@WebServlet("/cadastarFuncionario")
public class funcionariosController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String dtaNascimento = request.getParameter("dtaNascimento");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String sexo = request.getParameter("sexo");
        String cargo = request.getParameter("cargo");
        String salario = request.getParameter("salario");
        String dtaAdmissao = request.getParameter("dtaAdmissao");
        String turno = request.getParameter("turno");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String cep = request.getParameter("cep");
        String bairro = request.getParameter("bairro");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String nomeUsuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");

        funcionariosModel model = new funcionariosModel();

        model.setNome(nome);
        model.setCpf(cpf);
        model.setRg(rg);
        model.setDtaNascimento(dtaNascimento);
        model.setTelefone(telefone);
        model.setEmail(email);
        model.setSexo(sexo);
        model.setCargo(cargo);
        model.setSalario(salario);
        model.setdtaAdmissao(dtaAdmissao);
        model.setTurno(turno);
        model.setEstado(estado);
        model.setCidade(cidade);
        model.setCep(cep);
        model.setBairro(bairro);
        model.setEndereco(endereco);
        model.setNumero(numero);
        model.setComplemento(complemento);
        model.setnomeUsuario(nomeUsuario);
        model.setSenha(senha);
        model.setSituacao("Ativo");

        funcionariosDAO dao = new funcionariosDAO();

        boolean sucesso = dao.cadastrarFuncionario(model);

        if (sucesso) {
            System.out.println("Funcionário cadastrado com sucesso!");

            response.sendRedirect(
                request.getContextPath() +
                "/pages/htmlAdmin/funcionariosAdmin.html"
            );

        } else {
            System.out.println("Erro ao cadastrar funcionário.");

            response.sendRedirect(
                request.getContextPath() +
                "/pages/htmlAdmin/cadastrarFuncionarioAdmin.html"
            );
        }
    }
}
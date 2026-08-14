package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.funcionariosModel;

@WebServlet("/cadastarFuncionario")
public class funcionariosController extends HttpServlet{
    
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response)
        throws IOException, ServletException{

            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String dtaNascimento = request.getParameter("dtaNascimento");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String sexo = request.getParameter("sexo");
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

            System.out.println(nome + " " + 
            cpf + " " 
            + rg + " " + 
            dtaNascimento + " " + 
            telefone + " " + 
            email + " " + 
            sexo + " " + 
            salario + " " +
            dtaAdmissao + " " +
            turno + " " +
            estado + " " +
            cidade + " " +
            cep + " " +
            bairro + " " +
            endereco + " " +
            numero + " " +
            complemento + " " +
            nomeUsuario + " " +
            senha);
        }
}

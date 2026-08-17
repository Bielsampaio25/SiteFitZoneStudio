package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.connectionFactory;
import model.funcionariosModel;

public class funcionariosDAO {
    public boolean cadastrarFuncionario(funcionariosModel model) {

    String sql = "INSERT INTO Funcionarios " +
        "(nome, cpf, rg, dta_nascimento, telefone, email, sexo, salario, " +
        "dta_admissao, turno, estado, cidade, cep, bairro, endereco, " +
        "numero, complemento, nome_usuario, senha) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (
        Connection conn = connectionFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, model.getNome());
        ps.setString(2, model.getCpf());
        ps.setString(3, model.getRg());
        ps.setString(4, model.getDtaNascimento());
        ps.setString(5, model.getTelefone());
        ps.setString(6, model.getEmail());
        ps.setString(7, model.getSexo());
        ps.setString(8, model.getSalario());
        ps.setString(9, model.getdtaAdmissao());
        ps.setString(10, model.getTurno());
        ps.setString(11, model.getEstado());
        ps.setString(12, model.getCidade());
        ps.setString(13, model.getCep());
        ps.setString(14, model.getBairro());
        ps.setString(15, model.getEndereco());
        ps.setString(16, model.getNumero());
        ps.setString(17, model.getComplemento());
        ps.setString(18, model.getnomeUsuario());
        ps.setString(19, model.getSenha());

        ps.executeUpdate();

        return true;

    } catch (Exception e) {

        e.printStackTrace();
        System.out.println("Falha ao inserir dados no banco");

        return false;
    }
}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.connectionFactory;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.funcionariosModel;

public class funcionariosDAO {
    public boolean cadastrarFuncionario(funcionariosModel model) {

    String sql = "INSERT INTO Funcionarios " +
        "(nome, cpf, rg, dta_nascimento, telefone, email, sexo, cargo, salario, " +
        "dta_admissao, turno, estado, cidade, cep, bairro, endereco, " +
        "numero, complemento, nome_usuario, senha, situacao) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
        ps.setString(8, model.getCargo());
        ps.setString(9, model.getSalario());
        ps.setString(10, model.getdtaAdmissao());
        ps.setString(11, model.getTurno());
        ps.setString(12, model.getEstado());
        ps.setString(13, model.getCidade());
        ps.setString(14, model.getCep());
        ps.setString(15, model.getBairro());
        ps.setString(16, model.getEndereco());
        ps.setString(17, model.getNumero());
        ps.setString(18, model.getComplemento());
        ps.setString(19, model.getnomeUsuario());
        ps.setString(20, model.getSenha());
        ps.setString(21, model.getSituacao());

        ps.executeUpdate();

        return true;

    } catch (Exception e) {

        e.printStackTrace();
        System.out.println("Falha ao inserir dados no banco");

        return false;
    }
}
    
    public List<funcionariosModel> listarFuncionarios() {
        List<funcionariosModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM Funcionarios";

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                funcionariosModel model = new funcionariosModel();
                
                
                model.setCodigo(rs.getInt("codigo"));
                model.setNome(rs.getString("nome"));
                model.setCargo(rs.getString("cargo"));
                model.setTelefone(rs.getString("telefone"));
                model.setEmail(rs.getString("email"));
                model.setSituacao(rs.getString("situacao"));
                model.setdtaAdmissao(rs.getString("dta_admissao"));
                
                lista.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
   
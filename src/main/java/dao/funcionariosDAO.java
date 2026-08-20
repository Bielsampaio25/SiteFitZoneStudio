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

        String sql = "INSERT INTO Funcionarios "
                + "(nome, cpf, rg, dta_nascimento, telefone, email, sexo, cargo, salario, "
                + "dta_admissao, turno, estado, cidade, cep, bairro, endereco, "
                + "numero, complemento, nome_usuario, senha, situacao) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

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

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

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

    public boolean removerFuncionario(String codigo) {

        String sql = "DELETE FROM Funcionarios WHERE codigo = ?";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);

            int linhasAfetadas = ps.executeUpdate();

            return linhasAfetadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public funcionariosModel BuscarFuncionario(int codigo) {

    funcionariosModel model = null;

    String sql = "SELECT * FROM Funcionarios WHERE codigo = ?";

    try (
        Connection conn = connectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)
    ) {

        stmt.setInt(1, codigo);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                model = new funcionariosModel();

                model.setCodigo(rs.getInt("codigo"));
                model.setNome(rs.getString("nome"));
                model.setCpf(rs.getString("cpf"));
                model.setRg(rs.getString("rg"));
                model.setDtaNascimento(rs.getString("dta_nascimento"));
                model.setTelefone(rs.getString("telefone"));
                model.setEmail(rs.getString("email"));
                model.setSexo(rs.getString("sexo"));
                model.setCargo(rs.getString("cargo"));
                model.setSalario(rs.getString("salario"));
                model.setdtaAdmissao(rs.getString("dta_admissao"));
                model.setTurno(rs.getString("turno"));
                model.setEstado(rs.getString("estado"));
                model.setCidade(rs.getString("cidade"));
                model.setCep(rs.getString("cep"));
                model.setBairro(rs.getString("bairro"));
                model.setEndereco(rs.getString("endereco"));
                model.setNumero(rs.getString("numero"));
                model.setComplemento(rs.getString("complemento"));
                model.setnomeUsuario(rs.getString("nome_usuario"));
                model.setSenha(rs.getString("senha"));
                model.setSituacao(rs.getString("situacao"));
            }

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return model;
}
}

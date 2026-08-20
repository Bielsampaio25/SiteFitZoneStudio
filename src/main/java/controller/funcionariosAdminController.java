package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import connection.connectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.google.gson.Gson;
import dao.funcionariosDAO;
import model.funcionariosModel;
import java.util.List;

@WebServlet("/api/funcionarios/*")
public class funcionariosAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        funcionariosDAO funcionariosDAO = new funcionariosDAO();
        funcionariosModel funcionariosModel = new funcionariosModel();

        String situacao = request.getParameter("situacao");

        if ("total".equals(situacao)) {
            TotalFuncionarios(response);
        } else if ("ativos".equals(situacao)) {
            FuncionariosAtivos(response);

        } else if ("desligados".equals(situacao)) {
            FuncionariosDesligados(response);

        } else if ("listar".equals(situacao)) {

            List<funcionariosModel> listarFuncionarios
                    = funcionariosDAO.listarFuncionarios();

            String json = new Gson().toJson(listarFuncionarios);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            response.getWriter().write(json);

        } else if ("buscar".equals(situacao)) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));

            funcionariosModel funcionario
                    = funcionariosDAO.BuscarFuncionario(codigo);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            String json = new Gson().toJson(funcionario);

            response.getWriter().write(json);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String codigo = request.getPathInfo().substring(1);

        funcionariosDAO dao = new funcionariosDAO();

        boolean removido = dao.removerFuncionario(codigo);

        if (removido) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void TotalFuncionarios(HttpServletResponse response) throws IOException {
        String sql = "SELECT COUNT(*) AS total FROM Funcionarios";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            int TotalFuncionarios = 0;

            if (rs.next()) {
                TotalFuncionarios = rs.getInt("total");
            }

            var dados = new java.util.HashMap<String, Object>();
            dados.put("TotalFuncionarios", TotalFuncionarios);

            String json = new Gson().toJson(dados);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FuncionariosAtivos(HttpServletResponse response) throws IOException {
        String sql = "SELECT COUNT(*) AS ativos FROM Funcionarios WHERE situacao = 'Ativo'";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            int FuncionariosAtivos = 0;

            if (rs.next()) {
                FuncionariosAtivos = rs.getInt("ativos");
            }

            var dados = new java.util.HashMap<String, Object>();
            dados.put("FuncionariosAtivos", FuncionariosAtivos);

            String json = new Gson().toJson(dados);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FuncionariosDesligados(HttpServletResponse response) throws IOException {
        String sql = "SELECT COUNT(*) AS desligados FROM Funcionarios WHERE situacao = 'Desligado'";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            int FuncionariosDesligados = 0;

            if (rs.next()) {
                FuncionariosDesligados = rs.getInt("desligados");
            }

            var dados = new java.util.HashMap<String, Object>();
            dados.put("FuncionariosDesligados", FuncionariosDesligados);

            String json = new Gson().toJson(dados);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

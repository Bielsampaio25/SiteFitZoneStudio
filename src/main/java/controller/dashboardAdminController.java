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

@WebServlet("/api/dashboard")
public class dashboardAdminController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sql = "SELECT COUNT(*) AS total FROM Funcionarios WHERE situacao = 'Ativo'";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            int FuncionariosAtivos = 0;
            
            if(rs.next()){
                FuncionariosAtivos = rs.getInt("total");
            }
            
            var dados = new java.util.HashMap<String, Object>();
            dados.put("FuncionariosAtivos", FuncionariosAtivos);
            
            String json = new Gson().toJson(dados);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (Exception e) {

        }
    }
}

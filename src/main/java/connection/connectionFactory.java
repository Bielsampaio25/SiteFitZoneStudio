package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {

private static String URL = "jdbc:mysql://localhost:3309/FitZoneStudio?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
private static String USER = "root";
private static String SENHA = "cimatec";
private static String DRIVER = "com.mysql.cj.jdbc.Driver";

public static Connection getConnection(){
        Connection conn = null;
        try{
        if(URL == null || USER == null || SENHA == null){
            System.out.println("Problemas com as variaveis de ambiente");
            return null;
     }
         Class.forName(DRIVER);
         conn = DriverManager.getConnection(URL, USER, SENHA);
            System.out.println("Banco De Dados Conectado!");
        }catch(ClassNotFoundException e){
            System.out.println("Erro na conexão JDBC");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Banco De Dados não conectado");
            e.printStackTrace();
        }
        return conn;
}
}

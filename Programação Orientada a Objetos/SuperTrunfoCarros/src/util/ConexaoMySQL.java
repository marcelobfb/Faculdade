package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * UTIL — Fábrica de conexões com o MySQL.
 *
 * ⚠️  Altere USER e PASSWORD conforme o seu ambiente antes de rodar.
 */
public class ConexaoMySQL {

    private static final String URL      =
        "jdbc:mysql://localhost:3306/supertrunfo_carros" +
        "?useSSL=false&serverTimezone=America/Sao_Paulo&allowPublicKeyRetrieval=true";
    private static final String USER     = "root";
    private static final String PASSWORD = "root";   // ← altere aqui

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL (mysql-connector-j) não encontrado no classpath!", e);
        }
    }

    /** Retorna uma nova conexão. Use sempre com try-with-resources. */
    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private ConexaoMySQL() { /* utilitária */ }
}

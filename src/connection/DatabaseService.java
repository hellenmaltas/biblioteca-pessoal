package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    public Connection iniciarConexao() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(
                    "URL_DO_BANCO",
                    "USUARIO",
                    "SENHA"
            );

            System.out.println("Conexão com o banco realizada com sucesso!");

            return conexao;

        } catch (ClassNotFoundException ex) {

            System.out.println("Driver do banco de dados não localizado.");

        } catch (SQLException ex) {

            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }

        return null;
    }
}

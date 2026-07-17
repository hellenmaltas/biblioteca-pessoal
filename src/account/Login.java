package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    private Connection conexao;
    private Register register;

    public Login(Connection conexao, Register register) {
        this.conexao = conexao;
        this.register = register;
    }

    public User login(Scanner scanner) {

        boolean tentarNovamente = true;

        while (tentarNovamente) {

            System.out.println("""
                    -------- LOGIN --------
                    """);

            System.out.println("Digite seu nome de usuário:");
            String nomeusuario = scanner.nextLine();

            System.out.println("Digite sua senha:");
            String senha = scanner.nextLine();

            String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha_usuario = ?";

            try {

                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setString(1, nomeusuario);
                stmt.setString(2, senha);

                ResultSet resultado = stmt.executeQuery();

                if (resultado.next()) {

                    System.out.println("Login realizado com sucesso!");

                    return new User(
                            resultado.getString("nome_usuario"),
                            resultado.getString("senha_usuario")
                    );

                } else {

                    System.out.println("""
                            Não foi possível realizar o login.

                            Usuário ou senha incorretos.

                            [1] Tentar novamente
                            [2] Fazer cadastro
                            """);

                    String escolha = scanner.nextLine();

                    switch (escolha) {

                        case "1":
                            break;

                        case "2":
                            return register.cadastrar(scanner);

                        default:
                            System.out.println("Comando inválido! Escolha entre [1] e [2]");
                    }
                }

                resultado.close();
                stmt.close();

            } catch (SQLException ex) {

                System.out.println("Erro ao realizar login: " + ex.getMessage());
                return null;
            }
        }

        return null;
    }
}

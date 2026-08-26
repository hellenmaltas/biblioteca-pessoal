package account;

import java.sql.*;
import java.util.Scanner;

public class Register {

    private Connection conexao;

    public Register(Connection conexao) {
        this.conexao = conexao;
    }

    public User cadastrar(Scanner scanner) {

        System.out.println("""
       
        --------CADASTRO DA BIBLIOTECA--------
        
        """);

        while (true) {

            System.out.println("Digite o nome de usuário que deseja criar:");
            String nomeusuario = scanner.nextLine();

            System.out.println("Digite a senha do seu usuário:");
            String senha = scanner.nextLine();

            boolean letraMaiuscula = false;
            boolean temNumero = false;
            boolean letraMinuscula = false;

            for (int i = 0; i < senha.length(); i++) {

                char c = senha.charAt(i);

                if (Character.isUpperCase(c)) {
                    letraMaiuscula = true;
                }

                if (Character.isLowerCase(c)) {
                    letraMinuscula = true;
                }

                if (Character.isDigit(c)) {
                    temNumero = true;
                }
            }

            if (!nomeusuario.isEmpty()
                    && nomeusuario.length() <= 9
                    && senha.length() <= 9
                    && letraMaiuscula
                    && letraMinuscula
                    && temNumero) {

                String sql = "INSERT INTO usuario (nome_usuario, senha_usuario) VALUES (?, ?)";

                try (PreparedStatement stmt = conexao.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS)) {

                    stmt.setString(1, nomeusuario);
                    stmt.setString(2, senha);

                    stmt.executeUpdate();

                    try (ResultSet resultado = stmt.getGeneratedKeys()) {

                        if (resultado.next()) {

                            int id = resultado.getInt(1);

                            System.out.println("""
                            
                            Carregando....

                            --------CADASTRO REALIZADO--------

                            Sua conta foi criada com sucesso.
                            """);

                            return new User(id, nomeusuario, senha);
                        }
                    }

                } catch (SQLException ex) {

                    System.out.println("Erro ao cadastrar usuário: " + ex.getMessage());
                }
            }

            System.out.println("""
                    
                    Usuário ou senha inválidos!
                    
                    Usuário:
                    • Não pode ficar vazio.
                    • Até 9 caracteres.
                    
                    Senha:
                    • Até 9 caracteres.
                    • Pelo menos 1 letra maiúscula.
                    • Pelo menos 1 letra minúscula.
                    • Pelo menos 1 número.
                    
                    Tente novamente.
                    """);
        }
    }
}
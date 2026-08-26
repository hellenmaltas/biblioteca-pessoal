package library;

import account.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LibraryService {

    private final Connection conexao;
    private final User user;

    public LibraryService(Connection conexao, User user) {
        this.conexao = conexao;
        this.user = user;
    }

    public void adicionarLivro(Scanner scanner) {

        System.out.println("Digite o nome do livro:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o nome do Autor:");
        String nomeAutor = scanner.nextLine();

        System.out.println("Digite o nome da Editora:");
        String nomeEditora = scanner.nextLine();

        try {

            String sql = "INSERT INTO autor (nome_autor) VALUES (?)";

            int idAutor;

            try (PreparedStatement stmt = conexao.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                stmt.setString(1, nomeAutor);
                stmt.executeUpdate();

                try (ResultSet resultadoAutor = stmt.getGeneratedKeys()) {

                    resultadoAutor.next();
                    idAutor = resultadoAutor.getInt(1);
                }
            }

            String sqlEditora = "INSERT INTO editora (nome_editora) VALUES (?)";

            int idEditora;

            try (PreparedStatement stmtEditora = conexao.prepareStatement(
                    sqlEditora,
                    Statement.RETURN_GENERATED_KEYS)) {

                stmtEditora.setString(1, nomeEditora);
                stmtEditora.executeUpdate();

                try (ResultSet resultadoEditora = stmtEditora.getGeneratedKeys()) {

                    resultadoEditora.next();
                    idEditora = resultadoEditora.getInt(1);
                }
            }

            String sqlLivro =
                    "INSERT INTO livro (titulo, id_autor, id_editora, id_usuario) " +
                            "VALUES (?, ?, ?, ?)";

            try (PreparedStatement stmtLivro = conexao.prepareStatement(sqlLivro)) {

                stmtLivro.setString(1, titulo);
                stmtLivro.setInt(2, idAutor);
                stmtLivro.setInt(3, idEditora);
                stmtLivro.setInt(4, user.getId());

                stmtLivro.executeUpdate();
            }

            System.out.println("Livro cadastrado com sucesso!");

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar livro.");
            e.printStackTrace();
        }
    }

    public void listarLivros() {

        System.out.println("\n========== MINHA BIBLIOTECA ==========\n");

        String sql =
                "SELECT livro.id_livro, livro.titulo, autor.nome_autor, " +
                        "editora.nome_editora, livro.lido " +
                        "FROM livro " +
                        "JOIN autor ON livro.id_autor = autor.id_autor " +
                        "JOIN editora ON livro.id_editora = editora.id_editora " +
                        "WHERE livro.id_usuario = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, user.getId());

            try (ResultSet resultado = stmt.executeQuery()) {

                int contador = 0;

                while (resultado.next()) {

                    int idLivro = resultado.getInt("id_livro");
                    String titulo = resultado.getString("titulo");
                    String autor = resultado.getString("nome_autor");
                    String editora = resultado.getString("nome_editora");

                    String status = resultado.getBoolean("lido")
                            ? "Lido"
                            : "Não lido";

                    System.out.printf("""
                            
                            ID: %d
                            Título: %s
                            Autor: %s
                            Editora: %s
                            Status: %s
                            
                            """,
                            idLivro,
                            titulo,
                            autor,
                            editora,
                            status
                    );

                    contador++;
                }

                if (contador == 0) {
                    System.out.println("Nenhum livro cadastrado.");
                }
            }

        } catch (Exception e) {

            System.out.println("Erro ao listar livros.");
            e.printStackTrace();
        }
    }

    public void removerLivro(Scanner scanner) {

        listarLivros();

        try {

            System.out.println("Digite o ID do livro que deseja remover:");

            int idLivro = Integer.parseInt(scanner.nextLine());

            String sql =
                    "DELETE FROM livro WHERE id_livro = ? AND id_usuario = ?";

            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setInt(1, idLivro);
                stmt.setInt(2, user.getId());

                int linhasAlteradas = stmt.executeUpdate();

                if (linhasAlteradas > 0) {
                    System.out.println("Livro removido com sucesso!");
                } else {
                    System.out.println("Livro não encontrado.");
                }
            }

        } catch (NumberFormatException e) {

            System.out.println("Entrada inválida. Digite apenas números.");

        } catch (Exception e) {

            System.out.println("Erro ao remover livro.");
            e.printStackTrace();
        }
    }

    public void marcarComoLido(Scanner scanner) {

        listarLivros();

        try {

            System.out.println("Digite o ID do livro que você leu:");

            int idLivro = Integer.parseInt(scanner.nextLine());

            String sql =
                    "UPDATE livro SET lido = true " +
                            "WHERE id_livro = ? AND id_usuario = ?";

            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setInt(1, idLivro);
                stmt.setInt(2, user.getId());

                int linhasAlteradas = stmt.executeUpdate();

                if (linhasAlteradas > 0) {
                    System.out.println("Livro marcado como lido!");
                } else {
                    System.out.println("Livro não encontrado.");
                }
            }

        } catch (NumberFormatException e) {

            System.out.println("Digite apenas números.");

        } catch (Exception e) {

            System.out.println("Erro ao marcar livro como lido.");
            e.printStackTrace();
        }
    }

    public void mostrarEstatisticas() {

        try {

            String sqlTotal =
                    "SELECT COUNT(*) FROM livro WHERE id_usuario = ?";

            int total;

            try (PreparedStatement stmtTotal =
                         conexao.prepareStatement(sqlTotal)) {

                stmtTotal.setInt(1, user.getId());

                try (ResultSet resultadoTotal = stmtTotal.executeQuery()) {

                    resultadoTotal.next();
                    total = resultadoTotal.getInt(1);
                }
            }

            String sqlLidos =
                    "SELECT COUNT(*) FROM livro " +
                            "WHERE lido = true AND id_usuario = ?";

            int lidos;

            try (PreparedStatement stmtLidos =
                         conexao.prepareStatement(sqlLidos)) {

                stmtLidos.setInt(1, user.getId());

                try (ResultSet resultadoLidos = stmtLidos.executeQuery()) {

                    resultadoLidos.next();
                    lidos = resultadoLidos.getInt(1);
                }
            }

            int naoLidos = total - lidos;

            System.out.println("\n========== ESTATÍSTICAS ==========");
            System.out.println("Total de livros: " + total);
            System.out.println("Livros lidos: " + lidos);
            System.out.println("Livros não lidos: " + naoLidos);

        } catch (Exception e) {

            System.out.println("Erro ao mostrar estatísticas.");
            e.printStackTrace();
        }
    }
}
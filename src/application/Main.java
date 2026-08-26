package application;

import account.Login;
import account.Register;
import account.User;
import connection.DatabaseService;
import library.LibraryService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DatabaseService databaseService = new DatabaseService();
        Connection conexao = databaseService.iniciarConexao();

        if (conexao == null) {
            System.out.println("Não foi possível conectar ao banco de dados.");
            return;
        }

        Register register = new Register(conexao);
        Login login = new Login(conexao, register);

        User user = null;

        while (user == null) {

            System.out.println("----TELA INICIAL----");
            System.out.println("Como deseja entrar?");
            System.out.println("[1] Login");
            System.out.println("[2] Cadastro");

            String entrar = scanner.nextLine();

            switch (entrar) {

                case "1":
                    user = login.login(scanner);
                    break;

                case "2":
                    user = register.cadastrar(scanner);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
            }
        }

        LibraryService libraryService = new LibraryService(conexao, user);

        System.out.println("--------------------------------------");
        System.out.println("Bem vindo(a), " + user.getNomeusuario() + "!");
        System.out.println("à sua biblioteca pessoal!!");

        int opcao = -1;

        do {

            System.out.println("--------------------------------------");
            System.out.println("[1] - Adicionar livro");
            System.out.println("[2] - Listar livros");
            System.out.println("[3] - Remover livro");
            System.out.println("[4] - Marcar como lido");
            System.out.println("[5] - Mostrar estatísticas");
            System.out.println("[0] - Sair");

            System.out.print("Escolha uma opção: ");
            String entrada = scanner.nextLine();

            System.out.println("_________________________________");

            try {

                opcao = Integer.parseInt(entrada);

                switch (opcao) {

                    case 1:
                        libraryService.adicionarLivro(scanner);
                        break;

                    case 2:
                        libraryService.listarLivros();
                        break;

                    case 3:
                        libraryService.removerLivro(scanner);
                        break;

                    case 4:
                        libraryService.marcarComoLido(scanner);
                        break;

                    case 5:
                        libraryService.mostrarEstatisticas();
                        break;

                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {

                System.out.println("Aceitamos somente números!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
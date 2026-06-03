package application;

import account.User;
import library.LibraryService;
import account.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        User user = userService.cadastrar();

        LibraryService libraryService = new LibraryService();

        System.out.println("--------------------------------------");
        System.out.println("Bem vindo(a), " +
        user.getNomeusuario() + "!" );
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

            try{

                opcao = Integer.parseInt(entrada); // Tenta transformar o texto em número


                switch (opcao) {

                    case 1:
                        libraryService.adicionarLivro();
                        break;
                    case 2:
                        libraryService.listarLivros();
                        break;
                    case 3:
                        libraryService.removerLivro();
                        break;
                    case 4:
                        libraryService.marcarComoLido();
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

            }  catch (NumberFormatException e) {
                // Se não for número, cai aqui
                System.out.println("Aceitamos somente números!");
            }

        } while (opcao != 0);
    }
}
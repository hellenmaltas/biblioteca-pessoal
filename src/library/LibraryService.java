package library;
import java.util.ArrayList;
import java.util.Scanner;


public class LibraryService {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Book> livros = new ArrayList<>();

    public void adicionarLivro() {

        System.out.println("Digite o nome do livro que deseja adicionar:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o nome do Autor:");
        String autor = scanner.nextLine();

       Book livro = new Book(titulo, autor);

        livros.add(livro);

    }

    public void listarLivros() {

        System.out.println("LISTA DE LIVROS");
        System.out.println("_________________________________\n");

        for (int i = 0; i < livros.size(); i++) {

            Book livro = livros.get(i);

            System.out.println( i +

                    "- Livro: " + livro.getTitulo() +
                    "- \nAutor: " + livro.getAutor()
            );

            if (livro.isLido()) {
                System.out.println("Status: Leitura completa");
            } else {
                System.out.println("Status: Não lido");
            }
            System.out.println("\n");
        }
   }

    public void removerLivro() {

       listarLivros();

        System.out.println("Escolha qual livro deseja remover: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < livros.size()) {
            livros.remove(index);
            System.out.println("Livro removido com susseso.");

        }else System.out.println("Esse livro não existe.");

    }

    public void marcarComoLido() {

        listarLivros();

        System.out.println("Escolha o número do livro que você leu:");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < livros.size()) {
            livros.get(index).setLido(true);
        } else {
            System.out.println("Número inválido, nenhum livro foi marcado.");
        }
    }

    public void mostrarEstatisticas() {
        int total = livros.size();
        int lidos = 0;

        for (Book livro : livros) {
            if (livro.isLido()) {
                lidos++;
            }
        }

        int naoLidos = total - lidos;

        System.out.println("------ ESTATÍSTICAS ------");
        System.out.println("Total de livros: " + total);
        System.out.println("Livros lidos: " + lidos);
        System.out.println("Livros não lidos: " + naoLidos);
    }
}


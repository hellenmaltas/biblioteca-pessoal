package library;

public class Book {

    private int idLivro;
    private String titulo;
    private boolean lido;
    private Author autor;
    private Publisher editora;

    public Book(String titulo, Author autor, Publisher editora) {

        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.lido = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public Author getAutor() {
        return autor;
    }

    public Publisher getEditora() {
        return editora;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }
}
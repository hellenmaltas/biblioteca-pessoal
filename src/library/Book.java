package library;

public class Book {
    private String titulo;
    private boolean lido;
    private String autor;

    public Book(String titulo, String autor){
        this.titulo = titulo;
        this.lido = false;
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public String getAutor() {
        return  this.autor;
    }
}
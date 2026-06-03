package library;

public class Book {
    private String nome;
    private String escritor;
    private boolean lido;

    public Book(String nome, String escritor){
        this.nome = nome;
        this.escritor = escritor;
        this.lido = false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEscritor() {
        return this.escritor;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }
}
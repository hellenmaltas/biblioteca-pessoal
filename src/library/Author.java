package library;

public class Author {

    private int idAutor;
    private String nomeAutor;

    public Author(int idAutor, String nomeAutor) {
        this.idAutor = idAutor;
        this.nomeAutor = nomeAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}

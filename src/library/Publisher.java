package library;

public class Publisher {

    private int idEditora;
    private String nomeEditora;

    public Publisher(int idEditora, String nomeEditora) {
        this.idEditora = idEditora;
        this.nomeEditora = nomeEditora;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }
}
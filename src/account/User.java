package account;

public class User {

    private int id;
    private String nomeusuario;
    private String senha;

    public User(int id, String nomeusuario, String senha) {
        this.id = id;
        this.nomeusuario = nomeusuario;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public String getSenha() {
        return senha;
    }
}
package account;

public class User {
    private String nomeusuario;
    private String senha;

    public User(String nomeusuario, String senha) {
        this.nomeusuario = nomeusuario;
        this.senha = senha;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public String getSenha() {
        return senha;
    }
}

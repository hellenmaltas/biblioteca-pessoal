package conta;

public class Usuario {
    private String nomeusuario;
    private String senha;

    public Usuario( String nomeusuario, String senha) {
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

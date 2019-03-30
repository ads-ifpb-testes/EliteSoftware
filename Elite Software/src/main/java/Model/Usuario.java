package Model;

public class Usuario {

    private String nome;
    private String cpf;
    private String senha;
    private String user;
    private boolean isAdmin;

    public Usuario(String nome, String cpf, String senha, String user, boolean isAdmin) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.user = user;
        this.isAdmin = isAdmin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                ", user='" + user + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}

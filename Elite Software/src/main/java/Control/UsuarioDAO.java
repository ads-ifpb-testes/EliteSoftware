package Control;

import Model.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {

    private static ArrayList<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<Usuario>();
    }


    public Usuario buscaUsuario(String username){
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(username)){
                return usuario;
            }
        }
        return null;
    }

    public boolean addUsuario (String nome, String cpf, String senha, String user, boolean isAdmin){
        String[] invalidos = new String[10];
        invalidos[0] = "&";
        invalidos[1] = "[";
        invalidos[2] = "]";
        invalidos[3] = "{";
        invalidos[4] = "}";
        invalidos[5] = "$";
        invalidos[6] = "%";
        invalidos[7] = ")";
        invalidos[8] = "!";
        invalidos[9] = "(";
        int cont = -1;
        while (cont < 9) {
            cont++;
            if (nome.contains(invalidos[cont])){
                System.out.println("Nome inválido");
                return false;
            }
            if (cpf.contains(invalidos[cont])){
                System.out.println("Cpf inválido");
                return false;
            }
            if (senha.contains(invalidos[cont])){
                System.out.println("Senha inválida");
                return false;
            }
            if (user.contains(invalidos[cont])){
                System.out.println("Username inválido");
                return false;
            }
        }
        if (isAdmin != false && isAdmin != true){
            System.out.println("por favor, insira true or false");
            return false;
        }
        if (nome.equals("") || cpf.equals("") || senha.equals("") || user.equals("")){
            System.out.println("Todos os campos são obrigatórios");
            return false;
        }

       if (usuarios.add(new Usuario(nome, cpf, senha, user, isAdmin))){
           System.out.println("Usuario Cadastrado com sucesso");
           return true;
       }
       return false;
    }

    public boolean removeUsuario (int index, Usuario usuariologado){
        if (index < 0 || index > usuarios.size()-1){
            System.out.println("Insira um índice dentro do escopo");
            return false;
        }
        if (!usuariologado.isAdmin() && usuarios.get(index).isAdmin()){
            System.out.println("Você não pode apagar um usuário administrador");
            return false;
        }
        if (usuarios.remove(usuarios.get(index))){
            System.out.println("Deletado com sucesso");
            return true;
        }
        return false;
    }

    public static boolean isLogged(String username, String senha){

        for (Usuario usuario : usuarios) {
            if (username.equals(usuario.getUser()) && senha.equals(usuario.getSenha())){
                return true;
            }
        }
        return false;

    }

    public void listarUsuarios(){

        int cont = 0;

        for (Usuario usuario : usuarios) {
            cont++;
            System.out.println(cont + ": " + usuario.toString());
        }
    }

}

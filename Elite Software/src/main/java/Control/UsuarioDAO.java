package Control;

import Model.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {

    private ArrayList<Usuario> usuarios;

    public UsuarioDAO(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario (Usuario usuario){
        usuarios.add(usuario);
    }

    public void removeUsuario (int index){
        usuarios.remove(index);
    }

}

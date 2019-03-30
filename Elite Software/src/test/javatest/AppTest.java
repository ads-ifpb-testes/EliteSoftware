package javatest;

import Control.GastosDAO;
import Control.UsuarioDAO;
import Model.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private UsuarioDAO usuarios;
    private GastosDAO gastos;

    @Before
    public void setUp() throws Exception{
        usuarios = new UsuarioDAO();
        gastos = new GastosDAO();
    }

    @Test
    public void testeCadastroValido(){
        String nome = "a";
        String cpf = "a";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        Assert.assertTrue(usuarios.addUsuario(nome, cpf, senha, user, admin));
    }

    @Test
    public void testeCadastroInvalido(){
        String nome = "a";
        String cpf = "a";
        String senha = "a][";
        String user = "a";
        boolean admin = true;
        Assert.assertFalse(usuarios.addUsuario(nome, cpf, senha, user, admin));
    }

    @Test
    public void testeCadastroEmBranco(){
        String nome = "a";
        String cpf = "";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        Assert.assertFalse(usuarios.addUsuario(nome, cpf, senha, user, admin));
    }

}

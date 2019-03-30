package javatest;

import Control.GastosDAO;
import Control.UsuarioDAO;
import Model.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UsuarioDAOTest {

    private UsuarioDAO usuarios;

    @Before
    public void setUp() throws Exception{
        usuarios = new UsuarioDAO();
    }

    @Test
    public void testeLoginValido(){
        String nome = "a";
        String cpf = "a";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        String testuser = "a";
        String testsenha = "a";
        usuarios.addUsuario(nome, cpf, senha, user, admin);
        Assert.assertEquals(true, usuarios.isLogged(testuser, testsenha));
    }

    @Test
    public void testeLoginInvalido(){
        String nome = "a";
        String cpf = "a";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        String testuser = "b";
        String testsenha = "b";
        usuarios.addUsuario(nome, cpf, senha, user, admin);
        Assert.assertNotEquals(true, usuarios.isLogged(testuser, testsenha));
    }

    @Test
    public void testeLoginCampoVazio(){
        String nome = "a";
        String cpf = "a";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        String testuser = "";
        String testsenha = "";
        usuarios.addUsuario(nome, cpf, senha, user, admin);
        Assert.assertNotEquals(true, usuarios.isLogged(testuser, testsenha));
    }

    @Test
    public void testeExclusãoDeUsuarioForaDoEscopo(){
        String nome = "a";
        String cpf = "a";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        String userlogin = user;
        Usuario usuariologado = usuarios.buscaUsuario(userlogin);
        int testeexclusao = 2;
        usuarios.addUsuario(nome, cpf, senha, user, admin);
        Assert.assertEquals(false, usuarios.removeUsuario(testeexclusao, usuariologado));
    }

    @Test
    public void testeExclusãoDeUsuarioAdminByANotAdmin(){
        String nome = "a";
        String cpf = "a";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        String nome2 = "b";
        String cpf2 = "b";
        String senha2 = "b";
        String user2 = "b";
        boolean admin2 = false;
        usuarios.addUsuario(nome, cpf, senha, user, admin);
        usuarios.addUsuario(nome2, cpf2, senha2, user2, admin2);
        String userlogin = user2;
        Usuario usuariologado = usuarios.buscaUsuario(userlogin);
        int testeexclusao = 1;
        Assert.assertEquals(false, usuarios.removeUsuario(testeexclusao-1, usuariologado));
    }

    @Test
    public void testeDeExclusãoValido(){
        String nome = "a";
        String cpf = "a";
        String senha = "a";
        String user = "a";
        boolean admin = true;
        String nome2 = "b";
        String cpf2 = "b";
        String senha2 = "b";
        String user2 = "b";
        boolean admin2 = true;
        usuarios.addUsuario(nome, cpf, senha, user, admin);
        usuarios.addUsuario(nome2, cpf2, senha2, user2, admin2);
        String userlogin = user2;
        Usuario usuariologado = usuarios.buscaUsuario(userlogin);
        int testeexclusao = 1;
        Assert.assertEquals(true, usuarios.removeUsuario(testeexclusao-1, usuariologado));
    }

}

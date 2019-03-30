package javatest;

import Control.GastosDAO;
import Control.UsuarioDAO;
import Model.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GastosDAOTest {

    private GastosDAO gastos;

    @Before
    public void setUp() throws Exception{
        gastos = new GastosDAO();
    }

    @Test
    public void testeInserirGastoComValorZero(){
        float valor = 0;
        String user = "teste";
        Assert.assertFalse(gastos.addGasto(valor, user));
    }

    @Test
    public void testeInserirGastoComValorNegativo(){
        float valor = -213;
        String user = "teste";
        Assert.assertFalse(gastos.addGasto(valor, user));
    }

    @Test
    public void testeInserirGastoValido(){
        float valor = 3242;
        String user = "teste";
        Assert.assertTrue(gastos.addGasto(valor, user));
    }

    @Test
    public void testeDeletarGastoValido(){
        float valor = 213;
        String user = "teste";
        gastos.addGasto(valor, user);
        Assert.assertTrue(gastos.removeGasto(0));
    }

    @Test
    public void testeDeletarGastoInexistente(){
        float valor = 213;
        String user = "teste";
        gastos.addGasto(valor, user);
        Assert.assertFalse(gastos.removeGasto(1));
    }

}

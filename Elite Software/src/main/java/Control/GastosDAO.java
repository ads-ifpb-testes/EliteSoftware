package Control;

import Model.Gasto;

import java.util.ArrayList;

public class GastosDAO {

    private ArrayList<Gasto> gastos;

    public GastosDAO() {
        gastos = new ArrayList<Gasto>();
    }

    public boolean addGasto (float valor, String user){

        if(valor == 0 || valor < 0){
            System.out.println("Valor não pode ser 0 ou negativo");
            return false;
        }

        if (gastos.add(new Gasto(valor, user))){
            System.out.println("Gasto inserido com sucesso");
            return true;
        }
        return false;

    }

    public boolean removeGasto (int index){
        if (index < 0 || index > gastos.size()-1 ){
            System.out.println("Informe um índice dentro do escopo");
            return false;
        }
        if (gastos.remove(gastos.get(index))) {
            return true;
        }
        return false;
    }

    public void listarGastos(){
        int cont = 0;

        for (Gasto gasto : gastos) {
            cont++;
            System.out.println(cont + ": " + gasto.toString());
        }
    }

}

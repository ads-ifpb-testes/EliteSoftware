package Control;

import Model.Gasto;

import java.util.ArrayList;

public class GastosDAO {

    private ArrayList<Gasto> gastos;

    public void addGasto (Gasto gasto){
        gastos.add(gasto);
    }

    public void removeGasto (int index){
        gastos.remove(index);
    }

}

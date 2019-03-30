package Model;

import java.time.LocalDate;
import java.util.Date;

public class Gasto {

    private LocalDate data;
    private float gasto;
    private String usuario;

    public Gasto(float gasto, String usuario) {
        this.data = LocalDate.now();
        this.gasto = gasto;
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getGasto() {
        return gasto;
    }

    public void setGasto(float gasto) {
        this.gasto = gasto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "data = " + data +
                ", gasto = " + gasto +
                ", usuario = '" + usuario + '\'' +
                '}';
    }
}

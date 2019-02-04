package Model;

import java.time.LocalDate;
import java.util.Date;

public class Gasto {

    private LocalDate data;
    private float gasto;
    private String descricao;
    private Usuario usuario;

    public Gasto(LocalDate data, float gasto, String descricao, Usuario usuario) {
        this.data = data;
        this.gasto = gasto;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

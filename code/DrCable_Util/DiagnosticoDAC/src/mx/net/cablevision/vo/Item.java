package mx.net.cablevision.vo;

import java.io.Serializable;


public class Item implements Serializable{

    private static final long serialVersionUID = 1L;

    protected String numeroSerie;
    protected String status;
    protected String producto;

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }
}

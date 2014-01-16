package mx.net.cablevision.dto;

import java.io.Serializable;

public class TransmitPower implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private float valor;
    private String unidad;

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }
}

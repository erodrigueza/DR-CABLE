package mx.net.cablevision.dto;

import java.io.Serializable;

import mx.net.cablevision.vo.QamUnidad;

public class Qam implements Serializable {

    private static final long serialVersionUID = 0L;

    private float valor;
    private QamUnidad unidad;

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setUnidad(QamUnidad unidad) {
        this.unidad = unidad;
    }

    public QamUnidad getUnidad() {
        return unidad;
    }
}


package mx.net.cablevision.vo;

import java.io.Serializable;


public class Diagnostico implements Serializable{

    private static final long serialVersionUID = 1L;
    
    protected int codigo;
    protected String texto;
    protected String explicacion;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getExplicacion() {
        return explicacion;
    }
}

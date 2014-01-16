package mx.net.cablevision.vo;

import java.io.Serializable;

public class Direccion implements Serializable{

    private static final long serialVersionUID = 1L;
    
    protected String hub;
    protected String retorno;

    public void setHub(String hub) {
        this.hub = hub;
    }

    public String getHub() {
        return hub;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getRetorno() {
        return retorno;
    }
}

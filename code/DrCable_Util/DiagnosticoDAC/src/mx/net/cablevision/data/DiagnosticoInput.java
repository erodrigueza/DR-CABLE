package mx.net.cablevision.data;

import java.io.Serializable;

import mx.net.cablevision.vo.Direccion;
import mx.net.cablevision.vo.Items;
import mx.net.cablevision.vo.ResponseDACVO;

public class DiagnosticoInput implements Serializable{

    private static final long serialVersionUID = 1L;
    
    protected String numSerieDiagnostico;
    protected Items itemsServicio;
    protected Items itemsFacturacion;
    protected Direccion direccionPrincipal;
    protected ResponseDACVO responseDACVO;

    public void setNumSerieDiagnostico(String numSerieDiagnostico) {
        this.numSerieDiagnostico = numSerieDiagnostico;
    }

    public String getNumSerieDiagnostico() {
        return numSerieDiagnostico;
    }

    public void setItemsServicio(Items itemsServicio) {
        this.itemsServicio = itemsServicio;
    }

    public Items getItemsServicio() {
        return itemsServicio;
    }

    public void setItemsFacturacion(Items itemsFacturacion) {
        this.itemsFacturacion = itemsFacturacion;
    }

    public Items getItemsFacturacion() {
        return itemsFacturacion;
    }

    public void setDireccionPrincipal(Direccion direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public Direccion getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setResponseDACVO(ResponseDACVO responseDACVO) {
        this.responseDACVO = responseDACVO;
    }

    public ResponseDACVO getResponseDACVO() {
        return responseDACVO;
    }
}

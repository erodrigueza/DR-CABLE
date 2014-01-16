package mx.net.cablevision.dto;

import java.io.Serializable;


public class StatusGeneral implements Serializable {

    private static final long serialVersionUID = 0L;

    private StatusFromModem internet;
    private StatusHFC hfc;
    private StatusBillingProvisioning billProv;
    private StatusFromTelephony telefonia;
    private StatusFromCMTS cmts;
    private String mac;
    private String hub;

    public void setInternet(StatusFromModem internet) {
        this.internet = internet;
    }

    public StatusFromModem getInternet() {
        return internet;
    }

    public void setHfc(StatusHFC hfc) {
        this.hfc = hfc;
    }

    public StatusHFC getHfc() {
        return hfc;
    }

    public void setBillProv(StatusBillingProvisioning billProv) {
        this.billProv = billProv;
    }

    public StatusBillingProvisioning getBillProv() {
        return billProv;
    }

    public void setTelefonia(StatusFromTelephony telefonia) {
        this.telefonia = telefonia;
    }

    public StatusFromTelephony getTelefonia() {
        return telefonia;
    }

    public void setCmts(StatusFromCMTS cmts) {
        this.cmts = cmts;
    }

    public StatusFromCMTS getCmts() {
        return cmts;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMac() {
        return mac;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public String getHub() {
        return hub;
    }
}

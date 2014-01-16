package mx.net.cablevision.dto;

import java.io.Serializable;

public class StatusHFC implements Serializable {

    private static final long serialVersionUID = 0L;

    private String node;
    private String currentStatus;
    private String lastDetectedOutage;
    private String docsisDeviceOnline;
    private String mtaAvailable;

    public void setNode(String node) {
        this.node = node;
    }

    public String getNode() {
        return node;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setLastDetectedOutage(String lastDetectedOutage) {
        this.lastDetectedOutage = lastDetectedOutage;
    }

    public String getLastDetectedOutage() {
        return lastDetectedOutage;
    }

    public void setDocsisDeviceOnline(String docsisDeviceOnline) {
        this.docsisDeviceOnline = docsisDeviceOnline;
    }

    public String getDocsisDeviceOnline() {
        return docsisDeviceOnline;
    }

    public void setMtaAvailable(String mtaAvailable) {
        this.mtaAvailable = mtaAvailable;
    }

    public String getMtaAvailable() {
        return mtaAvailable;
    }
}

package mx.net.cablevision.dto;

import java.io.Serializable;

import mx.net.cablevision.vo.BatteryStatus;
import mx.net.cablevision.vo.LastDiagnostic;
import mx.net.cablevision.vo.StateLine;

public class LineasTelefonicas implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private String batteryStatus;
    private String maintenanceState;
    private String lastDiagnostic;

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setMaintenanceState(String maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public String getMaintenanceState() {
        return maintenanceState;
    }

    public void setLastDiagnostic(String lastDiagnostic) {
        this.lastDiagnostic = lastDiagnostic;
    }

    public String getLastDiagnostic() {
        return lastDiagnostic;
    }
}

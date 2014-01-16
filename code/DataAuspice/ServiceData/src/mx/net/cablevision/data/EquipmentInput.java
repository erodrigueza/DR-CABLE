package mx.net.cablevision.data;

import java.io.Serializable;

public class EquipmentInput implements Serializable {

    private static final long serialVersionUID = 0L;

    private String macAddress;

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }
}

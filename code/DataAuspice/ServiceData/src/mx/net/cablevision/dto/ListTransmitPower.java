package mx.net.cablevision.dto;

import java.io.Serializable;

import java.util.List;

public class ListTransmitPower implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private List<TransmitPower> transmitPower;


    public void setTransmitPower(List<TransmitPower> transmitPower) {
        this.transmitPower = transmitPower;
    }

    public List<TransmitPower> getTransmitPower() {
        return transmitPower;
    }
}

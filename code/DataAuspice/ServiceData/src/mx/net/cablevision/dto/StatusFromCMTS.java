package mx.net.cablevision.dto;

import java.io.Serializable;

import mx.net.cablevision.vo.StatusModem;

public class StatusFromCMTS implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private String upStreamChannel;
    private String upstreamChannelMode;
    private String modemStatus;

    public void setUpStreamChannel(String upStreamChannel) {
        this.upStreamChannel = upStreamChannel;
    }

    public String getUpStreamChannel() {
        return upStreamChannel;
    }

    public void setUpstreamChannelMode(String upstreamChannelMode) {
        this.upstreamChannelMode = upstreamChannelMode;
    }

    public String getUpstreamChannelMode() {
        return upstreamChannelMode;
    }

    public void setModemStatus(String modemStatus) {
        this.modemStatus = modemStatus;
    }

    public String getModemStatus() {
        return modemStatus;
    }
}

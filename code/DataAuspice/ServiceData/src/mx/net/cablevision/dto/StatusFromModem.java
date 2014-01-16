package mx.net.cablevision.dto;

import java.io.Serializable;

import java.util.List;

public class StatusFromModem implements Serializable {

    private static final long serialVersionUID = 0L;

    private String systemDescription;
    private String systemUpTime; // dias en linea
    private TransmitPower upstreamTransmitPower; // Valor de updstream
    private ListTransmitPower downstreamReceivePower; // valor de dowstream
    private int resets; // reset que lleva el equipo
    private int lostSyncs; // perdida de sincronia
    private ListTransmitPower downstreamSignalNoiseRatio; // ruido
    private String dHCPServer; // IP
    private String timeServer; // NTP
    private String cmTFTPServer; // confg File
    private String cmConfigurationFile; // config
    private String bpiStatus; // es importante
    private int qosProfile; //  es importante
    private TransmitPower maximumUpstreamBandwidth; // ancho de subida
    private TransmitPower guaranteedUpstreamBandwidth; // es importante
    private TransmitPower MaximumDownstreamBandwidth; // ancho bajada
    private TransmitPower upstreamChannelFrequency; // frecuencia en up
    private ListTransmitPower downstreamChannelFrequency; // frecuancia en down

    public void setSystemDescription(String systemDescription) {
        this.systemDescription = systemDescription;
    }

    public String getSystemDescription() {
        return systemDescription;
    }

    public void setSystemUpTime(String systemUpTime) {
        this.systemUpTime = systemUpTime;
    }

    public String getSystemUpTime() {
        return systemUpTime;
    }

    public void setUpstreamTransmitPower(TransmitPower upstreamTransmitPower) {
        this.upstreamTransmitPower = upstreamTransmitPower;
    }

    public TransmitPower getUpstreamTransmitPower() {
        return upstreamTransmitPower;
    }

    public void setDownstreamReceivePower(ListTransmitPower downstreamReceivePower) {
        this.downstreamReceivePower = downstreamReceivePower;
    }

    public ListTransmitPower getDownstreamReceivePower() {
        return downstreamReceivePower;
    }

    public void setResets(int resets) {
        this.resets = resets;
    }

    public int getResets() {
        return resets;
    }

    public void setLostSyncs(int lostSyncs) {
        this.lostSyncs = lostSyncs;
    }

    public int getLostSyncs() {
        return lostSyncs;
    }

    public void setDownstreamSignalNoiseRatio(ListTransmitPower downstreamSignalNoiseRatio) {
        this.downstreamSignalNoiseRatio = downstreamSignalNoiseRatio;
    }

    public ListTransmitPower getDownstreamSignalNoiseRatio() {
        return downstreamSignalNoiseRatio;
    }

    public void setDHCPServer(String dHCPServer) {
        this.dHCPServer = dHCPServer;
    }

    public String getDHCPServer() {
        return dHCPServer;
    }

    public void setTimeServer(String timeServer) {
        this.timeServer = timeServer;
    }

    public String getTimeServer() {
        return timeServer;
    }

    public void setCmTFTPServer(String cmTFTPServer) {
        this.cmTFTPServer = cmTFTPServer;
    }

    public String getCmTFTPServer() {
        return cmTFTPServer;
    }

    public void setCmConfigurationFile(String cmConfigurationFile) {
        this.cmConfigurationFile = cmConfigurationFile;
    }

    public String getCmConfigurationFile() {
        return cmConfigurationFile;
    }

    public void setBpiStatus(String bpiStatus) {
        this.bpiStatus = bpiStatus;
    }

    public String getBpiStatus() {
        return bpiStatus;
    }

    public void setQosProfile(int qosProfile) {
        this.qosProfile = qosProfile;
    }

    public int getQosProfile() {
        return qosProfile;
    }

    public void setMaximumUpstreamBandwidth(TransmitPower maximumUpstreamBandwidth) {
        this.maximumUpstreamBandwidth = maximumUpstreamBandwidth;
    }

    public TransmitPower getMaximumUpstreamBandwidth() {
        return maximumUpstreamBandwidth;
    }

    public void setGuaranteedUpstreamBandwidth(TransmitPower guaranteedUpstreamBandwidth) {
        this.guaranteedUpstreamBandwidth = guaranteedUpstreamBandwidth;
    }

    public TransmitPower getGuaranteedUpstreamBandwidth() {
        return guaranteedUpstreamBandwidth;
    }

    public void setMaximumDownstreamBandwidth(TransmitPower MaximumDownstreamBandwidth) {
        this.MaximumDownstreamBandwidth = MaximumDownstreamBandwidth;
    }

    public TransmitPower getMaximumDownstreamBandwidth() {
        return MaximumDownstreamBandwidth;
    }

    public void setUpstreamChannelFrequency(TransmitPower upstreamChannelFrequency) {
        this.upstreamChannelFrequency = upstreamChannelFrequency;
    }

    public TransmitPower getUpstreamChannelFrequency() {
        return upstreamChannelFrequency;
    }

    public void setDownstreamChannelFrequency(ListTransmitPower downstreamChannelFrequency) {
        this.downstreamChannelFrequency = downstreamChannelFrequency;
    }

    public ListTransmitPower getDownstreamChannelFrequency() {
        return downstreamChannelFrequency;
    }
}

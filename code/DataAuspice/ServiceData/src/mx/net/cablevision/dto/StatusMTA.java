package mx.net.cablevision.dto;

import java.io.Serializable;

public class StatusMTA implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private String pingStatus;
    private String serialNumber;
    private String modelNumber;
    private String hwVersion;
    private String swVersion;
    private String configFile;
    private String fqdn;
    private String voiceEnabled;
    private String provisioningCounter;
    private String provisioningState;
    private String dns_1;
    private String dns_2;
    private String snmpEntity;
    private String kerberosRealm;

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setHwVersion(String hwVersion) {
        this.hwVersion = hwVersion;
    }

    public String getHwVersion() {
        return hwVersion;
    }

    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setFqdn(String fqdn) {
        this.fqdn = fqdn;
    }

    public String getFqdn() {
        return fqdn;
    }

    public void setVoiceEnabled(String voiceEnabled) {
        this.voiceEnabled = voiceEnabled;
    }

    public String getVoiceEnabled() {
        return voiceEnabled;
    }

    public void setProvisioningCounter(String provisioningCounter) {
        this.provisioningCounter = provisioningCounter;
    }

    public String getProvisioningCounter() {
        return provisioningCounter;
    }

    public void setProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
    }

    public String getProvisioningState() {
        return provisioningState;
    }

    public void setDns_1(String dns_1) {
        this.dns_1 = dns_1;
    }

    public String getDns_1() {
        return dns_1;
    }

    public void setDns_2(String dns_2) {
        this.dns_2 = dns_2;
    }

    public String getDns_2() {
        return dns_2;
    }

    public void setSnmpEntity(String snmpEntity) {
        this.snmpEntity = snmpEntity;
    }

    public String getSnmpEntity() {
        return snmpEntity;
    }

    public void setKerberosRealm(String kerberosRealm) {
        this.kerberosRealm = kerberosRealm;
    }

    public String getKerberosRealm() {
        return kerberosRealm;
    }
}

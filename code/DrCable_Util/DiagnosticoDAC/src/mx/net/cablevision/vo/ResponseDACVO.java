package mx.net.cablevision.vo;

import java.io.Serializable;

public class ResponseDACVO implements Serializable{

    private static final long serialVersionUID = 1L;

    protected String vcmHandle;
    protected String activatedFlag;
    protected String creditAllowed;
    protected String downstreamPlantHandle;
    protected String equipType;
    protected String installDate;
    protected String maxPackCost;
    protected String onPlantFlag;
    protected String purchasesAllowed;
    protected String respondingFlag;
    protected String serialNUmber;
    protected String unitAddress;
    protected String upstreamPlantHandle;
    protected String packageAuthorizations;
    protected String programAuthorizations;
    protected String serviceAuthorizations;

    public void setVcmHandle(String vcmHandle) {
        this.vcmHandle = vcmHandle;
    }

    public String getVcmHandle() {
        return vcmHandle;
    }

    public void setActivatedFlag(String activatedFlag) {
        this.activatedFlag = activatedFlag;
    }

    public String getActivatedFlag() {
        return activatedFlag;
    }

    public void setCreditAllowed(String creditAllowed) {
        this.creditAllowed = creditAllowed;
    }

    public String getCreditAllowed() {
        return creditAllowed;
    }

    public void setDownstreamPlantHandle(String downstreamPlantHandle) {
        this.downstreamPlantHandle = downstreamPlantHandle;
    }

    public String getDownstreamPlantHandle() {
        return downstreamPlantHandle;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setMaxPackCost(String maxPackCost) {
        this.maxPackCost = maxPackCost;
    }

    public String getMaxPackCost() {
        return maxPackCost;
    }

    public void setOnPlantFlag(String onPlantFlag) {
        this.onPlantFlag = onPlantFlag;
    }

    public String getOnPlantFlag() {
        return onPlantFlag;
    }

    public void setPurchasesAllowed(String purchasesAllowed) {
        this.purchasesAllowed = purchasesAllowed;
    }

    public String getPurchasesAllowed() {
        return purchasesAllowed;
    }

    public void setRespondingFlag(String respondingFlag) {
        this.respondingFlag = respondingFlag;
    }

    public String getRespondingFlag() {
        return respondingFlag;
    }

    public void setSerialNUmber(String serialNUmber) {
        this.serialNUmber = serialNUmber;
    }

    public String getSerialNUmber() {
        return serialNUmber;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUpstreamPlantHandle(String upstreamPlantHandle) {
        this.upstreamPlantHandle = upstreamPlantHandle;
    }

    public String getUpstreamPlantHandle() {
        return upstreamPlantHandle;
    }

    public void setPackageAuthorizations(String packageAuthorizations) {
        this.packageAuthorizations = packageAuthorizations;
    }

    public String getPackageAuthorizations() {
        return packageAuthorizations;
    }

    public void setProgramAuthorizations(String programAuthorizations) {
        this.programAuthorizations = programAuthorizations;
    }

    public String getProgramAuthorizations() {
        return programAuthorizations;
    }

    public void setServiceAuthorizations(String serviceAuthorizations) {
        this.serviceAuthorizations = serviceAuthorizations;
    }

    public String getServiceAuthorizations() {
        return serviceAuthorizations;
    }
}

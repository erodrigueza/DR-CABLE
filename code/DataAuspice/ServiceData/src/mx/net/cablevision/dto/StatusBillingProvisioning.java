package mx.net.cablevision.dto;

import java.io.Serializable;

public class StatusBillingProvisioning implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private String vendor;
    private String cmts;
    private String cmMACAddress;
    private String customerAccount;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String cmFQDN;

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setCmts(String cmts) {
        this.cmts = cmts;
    }

    public String getCmts() {
        return cmts;
    }

    public void setCmMACAddress(String cmMACAddress) {
        this.cmMACAddress = cmMACAddress;
    }

    public String getCmMACAddress() {
        return cmMACAddress;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCmFQDN(String cmFQDN) {
        this.cmFQDN = cmFQDN;
    }

    public String getCmFQDN() {
        return cmFQDN;
    }
}

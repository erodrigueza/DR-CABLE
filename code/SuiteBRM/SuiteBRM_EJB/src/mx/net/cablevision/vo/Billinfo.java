package mx.net.cablevision.vo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

public class Billinfo implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String typeCode;
    private String accountNo;
    private String status;
    private String source;
    private String currency;
    private List<Bill> bills;
    private BigDecimal currentTotal;

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setCurrentTotal(BigDecimal currentTotal) {
        this.currentTotal = currentTotal;
    }

    public BigDecimal getCurrentTotal() {
        return currentTotal;
    }
}

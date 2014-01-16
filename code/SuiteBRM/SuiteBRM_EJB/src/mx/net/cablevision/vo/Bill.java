package mx.net.cablevision.vo;

import java.io.Serializable;

import java.math.BigDecimal;

public class Bill implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String guid;
    private String invoiceNo;
    private BigDecimal currentTotal;
    private BigDecimal previousTotal;
    private BigDecimal totalDebits;
    private String billNo;
    private String createdDate;
    private String dueDate;
    private String endDate;
    private String startDate;

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setCurrentTotal(BigDecimal currentTotal) {
        this.currentTotal = currentTotal;
    }

    public BigDecimal getCurrentTotal() {
        return currentTotal;
    }

    public void setPreviousTotal(BigDecimal previousTotal) {
        this.previousTotal = previousTotal;
    }

    public BigDecimal getPreviousTotal() {
        return previousTotal;
    }

    public void setTotalDebits(BigDecimal totalDebits) {
        this.totalDebits = totalDebits;
    }

    public BigDecimal getTotalDebits() {
        return totalDebits;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }
}

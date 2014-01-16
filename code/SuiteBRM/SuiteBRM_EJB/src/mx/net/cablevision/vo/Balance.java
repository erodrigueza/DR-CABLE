package mx.net.cablevision.vo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

public class Balance implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private BigDecimal amountNotOverdue;
    private BigDecimal totalCharges;
    private BigDecimal lastPaymentAmt;
    private String lastPayment;
    private Integer auditFlag;
    private String lastBill;
    private String accountNo;
    private BigDecimal creditLimit;
    private BigDecimal totalDebits;
    private BigDecimal currentBal;
    private List<Bucket> buckets;

    public void setAmountNotOverdue(BigDecimal amountNotOverdue) {
        this.amountNotOverdue = amountNotOverdue;
    }

    public BigDecimal getAmountNotOverdue() {
        return amountNotOverdue;
    }

    public void setTotalCharges(BigDecimal totalCharges) {
        this.totalCharges = totalCharges;
    }

    public BigDecimal getTotalCharges() {
        return totalCharges;
    }

    public void setLastPaymentAmt(BigDecimal lastPaymentAmt) {
        this.lastPaymentAmt = lastPaymentAmt;
    }

    public BigDecimal getLastPaymentAmt() {
        return lastPaymentAmt;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setLastBill(String lastBill) {
        this.lastBill = lastBill;
    }

    public String getLastBill() {
        return lastBill;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setTotalDebits(BigDecimal totalDebits) {
        this.totalDebits = totalDebits;
    }

    public BigDecimal getTotalDebits() {
        return totalDebits;
    }

    public void setCurrentBal(BigDecimal currentBal) {
        this.currentBal = currentBal;
    }

    public BigDecimal getCurrentBal() {
        return currentBal;
    }

    public void setBuckets(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    public List<Bucket> getBuckets() {
        return buckets;
    }
}

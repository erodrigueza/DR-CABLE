package mx.net.cablevision.data;

import java.io.Serializable;

import mx.net.cablevision.vo.Balance;
import mx.net.cablevision.vo.Billinfo;

public class BalanceInfoOutput implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String resultMsg;
    private Balance balance;
    private Billinfo billinfo;

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBillinfo(Billinfo billinfo) {
        this.billinfo = billinfo;
    }

    public Billinfo getBillinfo() {
        return billinfo;
    }
}

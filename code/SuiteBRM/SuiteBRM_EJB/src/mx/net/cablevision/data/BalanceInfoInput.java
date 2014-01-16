package mx.net.cablevision.data;

import java.io.Serializable;

public class BalanceInfoInput implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String accountNo;

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }
}

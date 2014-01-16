package mx.net.cablevision.vo;

import java.io.Serializable;

public class Refresh implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String accountNo;
    private String deviceId;
    private String dacIdentifier;
    private String login;
    private Integer flag;
    private String order;
    private String orderId;

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDacIdentifier(String dacIdentifier) {
        this.dacIdentifier = dacIdentifier;
    }

    public String getDacIdentifier() {
        return dacIdentifier;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}

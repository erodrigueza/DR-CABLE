package mx.net.cablevision.data;

import java.io.Serializable;

public class HelpDeskInput implements Serializable{

    private static final long serialVersionUID = 0L;
    
    private String incidentNumber;
    private String account;

    public void setIncidentNumber(String incidentNumber) {
        this.incidentNumber = incidentNumber;
    }

    public String getIncidentNumber() {
        return incidentNumber;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
}

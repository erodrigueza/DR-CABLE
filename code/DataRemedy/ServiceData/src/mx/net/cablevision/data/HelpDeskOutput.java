package mx.net.cablevision.data;

import java.io.Serializable;

import java.util.List;

public class HelpDeskOutput implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String resultMsg;
    private List<Incident> incident;
    
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setIncident(List<Incident> incident) {
        this.incident = incident;
    }

    public List<Incident> getIncident() {
        return incident;
    }
}

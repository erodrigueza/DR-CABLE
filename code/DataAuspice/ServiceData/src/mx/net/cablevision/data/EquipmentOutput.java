package mx.net.cablevision.data;

import java.io.Serializable;

import mx.net.cablevision.dto.StatusGeneral;

public class EquipmentOutput implements Serializable {

    private static final long serialVersionUID = 0L;

    private String resultMsg;
    
    private StatusGeneral status;

    public void setStatus(StatusGeneral status) {
        this.status = status;
    }

    public StatusGeneral getStatus() {
        return status;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}

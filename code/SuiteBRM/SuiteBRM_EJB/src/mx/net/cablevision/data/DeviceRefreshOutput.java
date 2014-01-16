package mx.net.cablevision.data;

import java.io.Serializable;

public class DeviceRefreshOutput implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String resultMsg;

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }

}

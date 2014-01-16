package mx.net.cablevision.data;

import java.io.Serializable;

import mx.net.cablevision.vo.Refresh;

public class DeviceRefreshInput implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Refresh dataRefresh;

    public void setDataRefresh(Refresh dataRefresh) {
        this.dataRefresh = dataRefresh;
    }

    public Refresh getDataRefresh() {
        return dataRefresh;
    }
}

package mx.net.cablevision.dto;

import java.io.Serializable;

public class StatusFromTelephony implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private StatusMTA statusMTA;
    private StatusMTAExt statusMTAExt;

    public void setStatusMTA(StatusMTA statusMTA) {
        this.statusMTA = statusMTA;
    }

    public StatusMTA getStatusMTA() {
        return statusMTA;
    }

    public void setStatusMTAExt(StatusMTAExt statusMTAExt) {
        this.statusMTAExt = statusMTAExt;
    }

    public StatusMTAExt getStatusMTAExt() {
        return statusMTAExt;
    }
}

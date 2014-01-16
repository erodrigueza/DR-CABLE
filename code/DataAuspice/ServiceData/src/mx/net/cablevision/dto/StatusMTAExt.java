package mx.net.cablevision.dto;

import java.io.Serializable;

import java.util.List;

public class StatusMTAExt implements Serializable {

    private static final long serialVersionUID = 0L;
    
    private String vendor;
    private List<LineasTelefonicas> lineasTelefonicas;


    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setLineasTelefonicas(List<LineasTelefonicas> lineasTelefonicas) {
        this.lineasTelefonicas = lineasTelefonicas;
    }

    public List<LineasTelefonicas> getLineasTelefonicas() {
        return lineasTelefonicas;
    }
}

package mx.net.cablevision.data;

import java.io.Serializable;

public class DiagnosticoOutput implements Serializable{

    private static final long serialVersionUID = 1L;
    
    protected Integer result;
    protected String msg;
    protected String detError;

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setDetError(String detError) {
        this.detError = detError;
    }

    public String getDetError() {
        return detError;
    }
}

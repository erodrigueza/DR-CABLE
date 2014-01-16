package mx.net.cablevision.common;

import java.util.Map;
import java.util.TreeMap;

import com.portal.pcm.EBufException;

public class SuiteBRMException extends Exception {

    private static final long serialVersionUID = 1L;
    protected Map<String, String> messages;

    public SuiteBRMException() {
        super();
        messages = new TreeMap<String, String>();
    }

    public SuiteBRMException(String message) {
        super(message);
        messages = new TreeMap<String, String>();
    }

    public SuiteBRMException(Map<String, String> messages) {
        this.messages = messages;
    }

    public SuiteBRMException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuiteBRMException(String message, EBufException cause) {
        super(message + " MessageID ["+cause.getMessageID()+"]"
        		+ " Error [" + cause.getError() + "]"
        		+ " ApplicationError ["+cause.getErrorString()+"]");
    }
    
    public SuiteBRMException(Throwable cause) {
        super(cause);
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }
}

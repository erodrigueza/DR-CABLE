package mx.net.cablevision.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.ResourceBundle;

/**
 * @author Latbc - EFRA
 * @date 17/10/2013
 */
public class Messages {

    static ResourceBundle msg = ResourceBundle.getBundle("messages");

    public static String getMsg(String key) {
        return msg.getString(key);
    }

    public static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}

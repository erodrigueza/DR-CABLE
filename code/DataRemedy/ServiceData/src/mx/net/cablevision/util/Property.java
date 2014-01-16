package mx.net.cablevision.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.ResourceBundle;

public class Property {

    static ResourceBundle jdbc = ResourceBundle.getBundle("configJDBC");

    public static String getJdbc(String key) {
        return jdbc.getString(key);
    }

    public static String getStackTrace(Exception e)
    {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}

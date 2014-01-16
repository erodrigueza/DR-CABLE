package mx.net.cablevision.vo;

import java.util.HashMap;
import java.util.Map;

public class Hub {
    
    public static Map<String,String> hubs = new HashMap<String,String>();
    
    static{
        hubs.put("CU", "CUATITLAN");
        hubs.put("PL", "POLANCO");
        hubs.put("TL", "TLALPAN");
        hubs.put("CO", "IZTAPALAPA");
        hubs.put("TI", "IZTAPALAPA");
        hubs.put("IZ", "IZTAPALAPA");
        hubs.put("VA", "VALLE");
        hubs.put("VO", "VALLEJO");
        hubs.put("KI", "SANTA FE");
        hubs.put("SA", "SEVILLA");
        hubs.put("CA", "CENTRO DE ACOPIO");
        hubs.put("AB", "ARBOLEDAS");
        hubs.put("ST", "SATELITE");
        hubs.put("AR", "ARAGON");
        hubs.put("CE", "CENTRO");
        
    }
}

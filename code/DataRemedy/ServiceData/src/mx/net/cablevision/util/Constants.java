package mx.net.cablevision.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public final static Integer ASSIGNEDGROUP = 1000000217;
    public final static Integer DESCRIPTION = 1000000000;
    public final static Integer INCIDENTNUMBER = 1000000161;
    public final static Integer LASTMODIFIEDBY = 5;
    public final static Integer LASTMODIFIEDDATE = 6;
    public final static Integer PRODUCTCATTIER1 = 200000003;
    public final static Integer PRODUCTCATTIER2 = 200000004;
    public final static Integer RESOLUTION = 1000000156;
    public final static Integer STATUS = 7;
    public final static Integer SUBMITDATE = 3;
    public final static Integer SUBMITTER = 2;
    public final static Integer SUMMARY = 1000000000;
    
    public final static Integer DETAILED_DES = 1000000151;
    
    public final static Map<String, String> states = new HashMap<String, String>();
    
    static{
        states.put("0", "Nuevo");
        states.put("1", "Asignado");
        states.put("2", "En curso");
        states.put("3", "Pendiente");
        states.put("4", "Resuelto");
        states.put("5", "Cerrado");
        states.put("6", "Cancelado");
    }
    
    
}

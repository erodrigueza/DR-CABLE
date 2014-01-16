package mx.net.cablevision.dao.util;

import java.util.ArrayList;
import java.util.List;

import mx.net.cablevision.dto.LineasTelefonicas;
import mx.net.cablevision.dto.ListTransmitPower;
import mx.net.cablevision.dto.TransmitPower;

import mx.net.cablevision.util.Constants;

import mx.net.cablevision.util.Property;

import org.apache.log4j.Logger;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ReaderHtmlAssembler {

    private static Logger LOG = Logger.getLogger("ReaderHtmlAssembler");
    
    public static String getValueHtml(String str, String key, int numWords){
        StringBuffer buffer = new StringBuffer();
        try {
        int keyLen = key.length();
        if(str.indexOf(key) >= 0){
            int position = str.indexOf(key) + keyLen + 1;
            char []chars = str.substring(position, str.length()).toCharArray();
            int count = 1;
            for(char character: chars){
                if(character == ' '){
                    if(count == numWords)
                        break;
                    count++;
                }
                buffer.append(character);
            }
        }
        } catch (Exception e) {
            LOG.error(Property.getStackTrace(e));
            buffer.append("");
        }
        return buffer.toString();
    }
    
    public static String getNextValue(String str, String key){
        return getValuePoint(str, key, 1);
    }

    public static String getValuePoint(String str, String key, int point){
        String res = "";
        try {
        String []array = str.split("\\|");
        for(int i=0;i<array.length;i++){
            if(key.equals(array[i])){
                res = array[i+point];
                break;
            }
        }
        } catch (Exception e) {
            LOG.error(Property.getStackTrace(e));
            res = "";
        }
        return res;
    }
    
    public static String[] getValueUnidad(String str, String key){
        String []trans = new String[2];
        String []array = str.split("\\|");
        try {
        for(int i=0;i<array.length;i++){
            if(key.equals(array[i])){
                trans[0] = array[i+1];
                trans[1] = array[i+2];
                break;
            }
        }
        } catch (Exception e) {
            LOG.error(Property.getStackTrace(e));
            trans[0] = "";
            trans[1] = "";
        }
        return trans;
    }

    public static String getValuePlus(String str, String key, int plus){
        String val = "";
        try{
        String []array = str.split("\\|");
        for(int i=0;i<array.length;i++){
            if(key.equals(array[i])){
                for(int j=1;j<=plus;j++){
                    val = val + array[i+j] + " ";
                }
                break;
            }
        }
        } catch (Exception e) {
            LOG.error(Property.getStackTrace(e));
            val = "";
        }
        return val.trim();
    }

    public static int getInteger(String textP, String key){
        return getInteger(getNextValue(textP, key));
    }
    
    protected static int getInteger(String str){
        int ent = 0;
        if(str instanceof String && !str.isEmpty() && isInteger(str)){
            ent = Integer.valueOf(str);    
        }
        return ent;
    }
    
    public static TransmitPower getTransmitPower(String textP, String key){
        TransmitPower res = new TransmitPower();
        String trans[] = getValueUnidad(textP, key);
        if(trans[0] instanceof String && !trans[0].isEmpty()
           && trans[1] instanceof String && !trans[1].isEmpty()){
            res = createTransmitPower(trans[0], trans[1]);
        }
        return res;
    }
    
    protected static TransmitPower createTransmitPower(String val, String unidad){
        TransmitPower trans = new TransmitPower();
        if(isFloat(val)){
            trans.setValor(Float.valueOf(val));
            trans.setUnidad(unidad);
        }else{
            trans.setValor(0);
            trans.setUnidad(" ");
        }
        return trans;
    }

    public static ListTransmitPower getListTransmitPower(String str, String key){
        ListTransmitPower listT = new ListTransmitPower();
        listT.setTransmitPower(getListTransmit(str, key));
        return listT;
    }
    protected static List<TransmitPower> getListTransmit(String str, String key){
        List<TransmitPower> listTrans = new ArrayList<TransmitPower>();
        String unidad = "";
        List<String> values = new ArrayList<String>();
        String []array = str.split("\\|");
        for(int i=0;i<array.length;i++){
            if(key.equals(array[i])){
                for(int j=1;j<array.length;j++){
                    if(!array[i+j].isEmpty()){
                        if(isFloat(array[i+j])){
                            values.add(array[i+j]);
                        }else{
                            unidad = array[i+j];
                            break;
                        }
                    }
                }
                break;
            }
        }

        if(values.isEmpty()){
            listTrans.add(createTransmitPower("0", " "));
        }else if(values.size()%2 == 0){
            for(int i=1;i<values.size();i+=2){
                listTrans.add(createTransmitPower(values.get(i), unidad));
            }
        }else{
            listTrans.add(createTransmitPower(values.get(0), unidad));
        }

        return listTrans;
    }
    
    
    /* ------------- Methods Private ------------ */

    private static boolean isInteger(String val){
        try{
            Integer.valueOf(val);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    
    private static boolean isFloat(String val){
        try{
            Float.valueOf(val);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /* ------------- Especific Getters ------------ */
    
    public static String getConfigurationFile(Document doc, int position){
        String res = "";
        Elements links = doc.select("input");
        Elements outs = new Elements();
        for (org.jsoup.nodes.Element link : links) {
            if("scroll_text".equals(link.attr("class"))){
            outs.add(link);
            }
        }
        LOG.info("Tamanio Final: "+outs.size());
        if(outs.size() == 1 && position == 3){
            LOG.info("value : [" + outs.get(0).attr("value").trim() + "]");   
            res = outs.get(0).attr("value").trim();
        }else if(outs.size() == 4){
            LOG.info("value : [" + outs.get(position).attr("value").trim() + "]");   
            res = outs.get(position).attr("value").trim();
        }
        return res;
    }

    public static List<LineasTelefonicas> getLineasTelefonicas(String str){
        
    List<LineasTelefonicas> lineasTelefonicas = new ArrayList<LineasTelefonicas>();
    String [] battery = getValueUnidad(str, "Battery Status");
    
    LineasTelefonicas linea1 = new LineasTelefonicas();
    linea1.setBatteryStatus(Constants.getBatteryStatus(battery[0]));
    linea1.setMaintenanceState(Constants.getStateLine(getValuePoint(str, "Maintenance State", 1)));
    linea1.setLastDiagnostic(Constants.getLastDiagnostic(getValuePoint(str, "Diagnostic", 2)));
    lineasTelefonicas.add(linea1);
    
    LineasTelefonicas linea2 = new LineasTelefonicas();
    linea2.setBatteryStatus(Constants.getBatteryStatus(battery[1]));
    linea2.setMaintenanceState(Constants.getStateLine(getValuePoint(str, "Maintenance State", 2)));
    linea2.setLastDiagnostic(Constants.getLastDiagnostic(getValuePoint(str, "Diagnostic", 3)));
    lineasTelefonicas.add(linea2);
        
    return lineasTelefonicas;
    
    }
    
}

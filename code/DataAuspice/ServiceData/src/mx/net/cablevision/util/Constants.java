package mx.net.cablevision.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String UNDEF = "UNDEF";

    /* Modem Status */
    
    public static final String NO_DATA = "NO DATA";
    public static final String OTHER_OFFLINE = "OTHER(OFFLINE)";
    public static final String OFFLINE = "OFFLINE";
    public static final String ON_LINE = "ONLINE";
    public static final String RANGING = "RANGING";
    public static final String RANGING_ABORTED = "RANGING ABORTED";
    public static final String RANGING_COMPLETE = "RANGING COMPLETE";
    public static final String IP_COMPLETE = "IP COMPLETE";
    public static final String REG_COMPLETE = "REG COMPLETE";
    public static final String ACCESS_DENIED = "ACCESS DENIED";
    public static final String OPERATIONAL = "OPERATIONAL";
    public static final String BPI_INITIALZING = "BPI INITIALIZING";

    public static final Map<String, String> estados =
        new HashMap<String, String>();
    static {
        estados.put(NO_DATA, "NO_DATA");
        estados.put(OTHER_OFFLINE, "OTHER_OFFLINE");
        estados.put(OFFLINE, "OFFLINE");
        estados.put(RANGING_ABORTED, "RANGING_ABORTED");
        estados.put(RANGING_COMPLETE, "RANGING_COMPLETE");
        estados.put(IP_COMPLETE, "IP_COMPLETE");
        estados.put(REG_COMPLETE, "REG_COMPLETE");
        estados.put(ACCESS_DENIED, "ACCESS_DENIED");
        estados.put(OPERATIONAL, "OPERATIONAL");
        estados.put(BPI_INITIALZING, "BPI_INITIALZING");
        estados.put(RANGING, "RANGING");
        estados.put(ON_LINE, "ON_LINE");
    }

    public static String getModemStatus(String status) {
        if (status != null) {
            if (status.toUpperCase().contains(NO_DATA)) {
                status = estados.get(NO_DATA);
            } else if (status.toUpperCase().contains(OTHER_OFFLINE)) {
                status = estados.get(OTHER_OFFLINE);
            } else if (status.toUpperCase().contains(RANGING_ABORTED)) {
                status = estados.get(RANGING_ABORTED);
            } else if (status.toUpperCase().contains(RANGING_COMPLETE)) {
                status = estados.get(RANGING_COMPLETE);
            } else if (status.toUpperCase().contains(IP_COMPLETE)) {
                status = estados.get(IP_COMPLETE);
            } else if (status.toUpperCase().contains(REG_COMPLETE)) {
                status = estados.get(REG_COMPLETE);
            } else if (status.toUpperCase().contains(ACCESS_DENIED)) {
                status = estados.get(ACCESS_DENIED);
            } else if (status.toUpperCase().contains(OPERATIONAL)) {
                status = estados.get(OPERATIONAL);
            } else if (status.toUpperCase().contains(BPI_INITIALZING)) {
                status = estados.get(BPI_INITIALZING);
            } else if (status.toUpperCase().contains(RANGING)) {
                status = estados.get(RANGING);
            } else if (status.toUpperCase().contains(ON_LINE)) {
                status = estados.get(ON_LINE);
            } else if (status.toUpperCase().contains(OFFLINE)) {
                    status = estados.get(OFFLINE);
            } else {
                status = UNDEF;
            }
        } else {
            status = UNDEF;
        }
        return status;
    }
    
    /* Provisioning State */
    
    public static final String PASS_WITH_WARNING = "PASS WITH WARNING";
    public static final String FAIL_CONFIG_FILE_ERROR = "FAIL CONFIG FILE ERROR";
    public static final String IN_PROGRESS = "IN PROGRESS";
    
    public static final Map<String, String> provisioningState =
        new HashMap<String, String>();
    static {
        provisioningState.put(PASS_WITH_WARNING, "PASS_WITH_WARNING");
        provisioningState.put(FAIL_CONFIG_FILE_ERROR, "FAIL_CONFIG_FILE_ERROR");
        provisioningState.put(IN_PROGRESS, "IN_PROGRESS");
    }

    public static String getProvisioningState(String state) {
        if (state != null) {
            if (state.toUpperCase().contains(PASS_WITH_WARNING)) {
                state = provisioningState.get(PASS_WITH_WARNING);
            } else if (state.toUpperCase().contains(FAIL_CONFIG_FILE_ERROR)) {
                state = provisioningState.get(FAIL_CONFIG_FILE_ERROR);
            } else if (state.toUpperCase().contains(IN_PROGRESS)) {
                state = provisioningState.get(IN_PROGRESS);
            } else {
                state = UNDEF;
            }
        } else {
            state = UNDEF;
        }
        return state;
    }

    /* Battery Status */
    public static final String TLM_NORMAL = "TLM-NORMAL";
    public static final String BATTERY_MISSING = "MISSING";
    public static final String BATTERY_LOW = "LOW";
    public static final String BATTERY_REPLACE = "REPLACE";
    
    public static final Map<String, String> batteryStatus =
        new HashMap<String, String>();
    static {
        batteryStatus.put(TLM_NORMAL, "TLM_NORMAL");
        batteryStatus.put(BATTERY_MISSING, "BATTERY_MISSING");
        batteryStatus.put(BATTERY_LOW, "BATTERY_LOW");
        batteryStatus.put(BATTERY_REPLACE, "BATTERY_REPLACE");
    }

    public static String getBatteryStatus(String state) {
        if (state != null) {
            if (state.toUpperCase().contains(TLM_NORMAL)) {
                state = batteryStatus.get(TLM_NORMAL);
            } else if (state.toUpperCase().contains(BATTERY_MISSING)) {
                    state = batteryStatus.get(BATTERY_MISSING);
            } else if (state.toUpperCase().contains(BATTERY_LOW)) {
                state = batteryStatus.get(BATTERY_LOW);
            } else if (state.toUpperCase().contains(BATTERY_REPLACE)) {
                state = batteryStatus.get(BATTERY_REPLACE);
            } else {
                state = UNDEF;
            }
        } else {
            state = UNDEF;
        }
        return state;
    }

    /* State Line */
    
    public static final String ISNR = "ISNR";
    public static final String OSSTRBL_LCPRT = "OSSTRBL";
                                                           
    public static final Map<String, String> stateLine =
        new HashMap<String, String>();
    static {
        stateLine.put(ISNR, "ISNR");
        stateLine.put(OSSTRBL_LCPRT, "OSSTRBL_LCPRT");
    }

    public static String getStateLine(String state) {
        if (state != null) {
            if (state.toUpperCase().contains(ISNR)) {
                state = stateLine.get(ISNR);
            } else if (state.toUpperCase().contains(OSSTRBL_LCPRT)) {
                state = stateLine.get(OSSTRBL_LCPRT);
            } else {
                state = UNDEF;
            }
        } else {
            state = UNDEF;
        }
        return state;
    }
    
    /* Last Diagnostic */
    
    public static final String FAILED = "FAILED";
    public static final String PASSED = "PASSED";
                                                     
    public static final Map<String, String> lastDiagnostic =
        new HashMap<String, String>();
    static {
        lastDiagnostic.put(FAILED, "FAILED");
        lastDiagnostic.put(PASSED, "PASSED");
    }

    public static String getLastDiagnostic(String diagnostic) {
        if (diagnostic != null) {
            if (diagnostic.toUpperCase().contains(FAILED)) {
                diagnostic = lastDiagnostic.get(FAILED);
            } else if (diagnostic.toUpperCase().contains(PASSED)) {
                diagnostic = lastDiagnostic.get(PASSED);
            } else {
                diagnostic = UNDEF;
            }
        } else {
            diagnostic = UNDEF;
        }
        return diagnostic;
    }        
    
}

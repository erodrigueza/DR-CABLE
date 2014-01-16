package mx.net.cablevision.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.jws.WebService;

import mx.net.cablevision.brm.service.DeviceService;
import mx.net.cablevision.common.SuiteBRMException;
import mx.net.cablevision.data.DeviceRefreshInput;
import mx.net.cablevision.data.DeviceRefreshOutput;
import mx.net.cablevision.util.Constants;
import mx.net.cablevision.util.Messages;

import org.apache.log4j.Logger;


@Stateless
@WebService(
serviceName = "TskNOCDoDeviceRefresh", 
portName = "TskNOCDoDeviceRefreshPort", 
endpointInterface = "mx.net.cablevision.port.TskNOCDoDeviceRefreshPort", 
targetNamespace = "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/TskNOCDoDeviceRefresh")
public class TskNOCDoDeviceRefresh {
    
    private static Logger LOG = Logger.getLogger(TskNOCDoDeviceRefresh.class);
    
    @EJB
    DeviceService device;
    
    public DeviceRefreshOutput doDeviceRefresh(DeviceRefreshInput input) {
        LOG.info("Se invoca el metodo doDeviceRefresh(DeviceRefreshInput)");
        DeviceRefreshOutput output = new DeviceRefreshOutput();
        try {
            if(device.doRefresh(input.getDataRefresh()) == Constants.OK){
                output.setResultMsg("OK");
            }else {
                output.setResultMsg("ERROR");
            }
        } catch (SuiteBRMException e) {
            LOG.error(Messages.getStackTrace(e));
            output.setResultMsg(e.getMessage());
        }
        LOG.info("Termina el metodo doDeviceRefresh(DeviceRefreshInput)");
        return output;
    }

}

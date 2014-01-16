package mx.net.cablevision.port;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mx.net.cablevision.data.DeviceRefreshInput;
import mx.net.cablevision.data.DeviceRefreshOutput;


@WebService(
name = "TskNOCDoDeviceRefreshPort", 
targetNamespace = "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/TskNOCDoDeviceRefresh")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TskNOCDoDeviceRefreshPort {

    @WebMethod
    @WebResult(name = "DeviceRefreshResponse", partName = "response")
    DeviceRefreshOutput doDeviceRefresh(
        @WebParam(name = "DeviceRefreshRequest", partName = "resquest") DeviceRefreshInput input);
}

package mx.net.cablevision.port;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mx.net.cablevision.data.BalanceInfoInput;
import mx.net.cablevision.data.BalanceInfoOutput;


@WebService(
name = "DasNOCGetBalanceInfoPort", 
targetNamespace = "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/DasNOCGetBalanceInfo")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface DasNOCGetBalanceInfoPort {

    @WebMethod
    @WebResult(name = "BalanceInfoResponse", partName = "response")
    BalanceInfoOutput getBalanceInfo(
        @WebParam(name = "BalanceInfoRequest", partName = "resquest") BalanceInfoInput input);
}

package mx.net.cablevision.port;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mx.net.cablevision.data.DiagnosticoInput;
import mx.net.cablevision.data.DiagnosticoOutput;


@WebService(
name = "TskDiagnosticoDACPort", 
targetNamespace = "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/TskDiagnosticoDAC")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TskDiagnosticoDACPort {

    @WebMethod
    @WebResult(name = "DiagnosticoResponse", partName = "response")
    DiagnosticoOutput getDiagnosticoDAC(
        @WebParam(name = "DiagnosticoRequest", partName = "resquest") DiagnosticoInput input);
}

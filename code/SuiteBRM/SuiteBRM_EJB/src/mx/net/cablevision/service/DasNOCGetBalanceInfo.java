package mx.net.cablevision.service;


import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.jws.WebService;

import mx.net.cablevision.brm.service.BalanceService;
import mx.net.cablevision.common.SuiteBRMException;
import mx.net.cablevision.data.BalanceInfoInput;
import mx.net.cablevision.data.BalanceInfoOutput;
import mx.net.cablevision.port.DasNOCGetBalanceInfoPort;
import mx.net.cablevision.util.Messages;

import org.apache.log4j.Logger;

@Stateless
@WebService(
serviceName = "DasNOCGetBalanceInfo", 
portName = "DasNOCGetBalanceInfoPort", 
endpointInterface = "mx.net.cablevision.port.DasNOCGetBalanceInfoPort", 
targetNamespace = "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/DasNOCGetBalanceInfo")
public class DasNOCGetBalanceInfo implements DasNOCGetBalanceInfoPort{

    private static Logger LOG = Logger.getLogger(DasNOCGetBalanceInfo.class);
    
    @EJB
    BalanceService balance;
    
    public BalanceInfoOutput getBalanceInfo(BalanceInfoInput input) {
        LOG.info("Se invoca el metodo getBalanceInfo(BalanceInfoInput)");
        LOG.info("Numero de cuenta: "+input.getAccountNo());
        BalanceInfoOutput output = new BalanceInfoOutput();
        try {
            output.setBalance(balance.getBalance(input.getAccountNo()));
            output.setBillinfo(balance.getBillinfo(input.getAccountNo()));
            output.setResultMsg("OK");
        } catch (SuiteBRMException e) {
            LOG.error(Messages.getStackTrace(e));
            output.setResultMsg(e.getMessage());
        }
        LOG.info("Termina el metodo getBalanceInfo(BalanceInfoInput)");
        return output;
    }

}

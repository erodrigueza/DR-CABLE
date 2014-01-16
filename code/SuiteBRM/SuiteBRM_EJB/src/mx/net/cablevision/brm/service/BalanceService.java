package mx.net.cablevision.brm.service;

import javax.ejb.Local;

import mx.net.cablevision.common.SuiteBRMException;
import mx.net.cablevision.vo.Balance;
import mx.net.cablevision.vo.Billinfo;

@Local
public interface BalanceService {
    
    public Balance getBalance(String account) throws SuiteBRMException;
    
    public Billinfo getBillinfo(String account) throws SuiteBRMException;
}

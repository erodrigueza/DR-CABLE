package mx.net.cablevision.brm.service;

import javax.ejb.Local;

import mx.net.cablevision.common.SuiteBRMException;
import mx.net.cablevision.vo.Refresh;

@Local
public interface DeviceService {
    
    public Integer doRefresh(Refresh refresh) throws SuiteBRMException;
    
}

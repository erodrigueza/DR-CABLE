package mx.net.cablevision.brm.service.impl;

import com.portal.custom.CustomOp;
import com.portal.custom.CvFldDacIdentifier;
import com.portal.pcm.EBufException;
import com.portal.pcm.FList;
import com.portal.pcm.Poid;
import com.portal.pcm.fields.FldAccountNo;
import com.portal.pcm.fields.FldDeviceId;
import com.portal.pcm.fields.FldFlags;
import com.portal.pcm.fields.FldLogin;
import com.portal.pcm.fields.FldOrder;
import com.portal.pcm.fields.FldOrderId;
import com.portal.pcm.fields.FldPoid;

import java.math.BigDecimal;

import javax.ejb.Stateless;

import mx.net.cablevision.brm.service.DeviceService;
import mx.net.cablevision.common.SuiteBRMException;
import mx.net.cablevision.util.Constants;
import mx.net.cablevision.vo.Refresh;

import org.apache.log4j.Logger;

@Stateless
public class DeviceServiceEJB extends GenericService implements DeviceService{

    private static Logger LOG = Logger.getLogger(DeviceServiceEJB.class);
    
    public Integer doRefresh(Refresh refresh) throws SuiteBRMException{

        FList inFlist, outFlist;
        Integer result = Constants.ERROR;

        try {
            inFlist = getFListSendRefresh(refresh);
        } catch (EBufException e) {
            LOG.error(e.getMessage(), e);
            throw new SuiteBRMException("Error al parsear los datos de entrada.",e);
        }

        outFlist = executeOpcode(CustomOp.CRM_POL_DEVICE_REFRESH, inFlist);
        
        if(outFlist != null){
            result = Constants.OK;    
        }
        
        return result;
    }

    public static FList getFListSendRefresh(Refresh refresh) throws EBufException {

        FList flist = new FList();

        flist.set(CvFldDacIdentifier.getInst(), refresh.getDacIdentifier());
        flist.set(FldDeviceId.getInst(), refresh.getDeviceId());
        flist.set(FldAccountNo.getInst(), refresh.getAccountNo());
        flist.set(FldLogin.getInst(), refresh.getLogin());
        flist.set(FldPoid.getInst(), new Poid(1, -1, "/account"));
        flist.set(FldFlags.getInst(), refresh.getFlag());

        return flist;

    }

}

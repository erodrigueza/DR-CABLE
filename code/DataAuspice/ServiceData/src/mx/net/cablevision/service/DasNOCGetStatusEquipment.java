package mx.net.cablevision.service;

import org.apache.log4j.Logger;

import javax.jws.WebMethod;

import javax.jws.WebService;

import mx.net.cablevision.dao.ReaderHtmlDAO;
import mx.net.cablevision.dao.exception.DAOException;
import mx.net.cablevision.dao.impl.ReaderHtmlDAOimpl;
import mx.net.cablevision.data.EquipmentInput;
import mx.net.cablevision.data.EquipmentOutput;
import mx.net.cablevision.util.Property;

@WebService(
serviceName = "DasNOCGetStatusEquipment", 
portName = "DasNOCGetStatusEquipmentPort", 
targetNamespace = "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/DasNOCGetStatusEquipment")
public class DasNOCGetStatusEquipment {
    
    private static Logger LOG = Logger.getLogger("DasNOCGetStatusEquipment");

    @WebMethod
    public EquipmentOutput getStatus(EquipmentInput equipmentIn) {
        LOG.info("\n\tInicia peticion al servicio DasNOCGetStatusEquipment");
        LOG.info("Mac Address: " + equipmentIn.getMacAddress());

        EquipmentOutput equipment = new EquipmentOutput();
        try {
            ReaderHtmlDAO dao = new ReaderHtmlDAOimpl();
            equipment = dao.getStatus(equipmentIn);
            if(equipment.getStatus().getBillProv().getCmMACAddress().isEmpty()){
                equipment.setResultMsg("Auspice no puede obtener el estado del equipo con mac "+equipmentIn.getMacAddress());
            }else{
                equipment.setResultMsg("OK");
            }
        } catch (DAOException eDao) {
            LOG.error(Property.getStackTrace(eDao));
            equipment.setResultMsg(eDao.getMessage() + ": "+ eDao.detalle);
        } catch (Exception e) {
            LOG.error(Property.getStackTrace(e));
            equipment.setResultMsg(e.getMessage());
        }
        LOG.info("Responde el servicio DasNOCGetStatusEquipment.");
        return equipment;
    }
}

package mx.net.cablevision.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.net.cablevision.dao.HelpDeskDAO;
import mx.net.cablevision.dao.exception.DAOException;
import mx.net.cablevision.dao.impl.HelpDeskDAOAPIimpl;
import mx.net.cablevision.data.HelpDeskInput;
import mx.net.cablevision.data.HelpDeskOutput;

import org.apache.log4j.Logger;

@WebService(
serviceName = "DasNOCSearchHelpDesk", 
portName = "DasNOCSearchHelpDeskPort", 
targetNamespace = "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/DasNOCSearchHelpDesk")
public class DasNOCSearchHelpDesk {
    
    private static Logger LOG = Logger.getLogger(DasNOCSearchHelpDesk.class);

    @WebMethod
    public HelpDeskOutput searchIncidentByTicket(HelpDeskInput helpDesk) {
        LOG.info("Se invoca el metodo searchIncident(HelpDeskInput)");
        // DAO para consultas por JDBC
        // HelpDeskDAO dao = new HelpDeskDAOimpl();
        HelpDeskOutput help = new HelpDeskOutput();
        try {
            // DAO para consultas por API
            HelpDeskDAO dao = new HelpDeskDAOAPIimpl();
            help = dao.findByTicket(helpDesk);
            help.setResultMsg("OK");
        } catch (DAOException eDao) {
            help.setResultMsg(eDao.getMessage() + ": "+ eDao.detalle);
        } catch (Exception e) {
            help.setResultMsg(e.getMessage());
        }
        LOG.info("Termina el metodo searchIncident(HelpDeskInput)");
        return help;
    }
    
    @WebMethod
    public HelpDeskOutput searchIncidentByAccount(HelpDeskInput helpDesk) {
        LOG.info("Se invoca el metodo searchIncidents(HelpDeskInput)");
        HelpDeskOutput help = new HelpDeskOutput();
        try {
            HelpDeskDAO dao = new HelpDeskDAOAPIimpl();
            help = dao.findBy7DayBefore(helpDesk);
            help.setResultMsg("OK");
        } catch (DAOException eDao) {
            help.setResultMsg(eDao.getMessage() + ": "+ eDao.detalle);
        } catch (Exception e) {
            help.setResultMsg(e.getMessage());
        }
        LOG.info("Termina el metodo searchIncident(HelpDeskInput)");
        return help;
    }

}

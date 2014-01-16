package mx.net.cablevision.dao.impl;

import com.bmc.arsys.api.ARException;
import com.bmc.arsys.api.ARServerUser;

import com.bmc.arsys.api.ArithmeticOrRelationalOperand;
import com.bmc.arsys.api.Entry;

import com.bmc.arsys.api.EntryListInfo;
import com.bmc.arsys.api.QualifierInfo;
import com.bmc.arsys.api.RelationalOperationInfo;
import com.bmc.arsys.api.Timestamp;
import com.bmc.arsys.api.Value;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mx.net.cablevision.dao.HelpDeskDAO;
import mx.net.cablevision.dao.exception.DAOException;
import mx.net.cablevision.data.Comments;
import mx.net.cablevision.data.HelpDeskInput;
import mx.net.cablevision.data.HelpDeskOutput;
import mx.net.cablevision.data.Incident;
import mx.net.cablevision.util.Constants;
import mx.net.cablevision.util.Property;

import org.apache.log4j.Logger;

public class HelpDeskDAOAPIimpl implements HelpDeskDAO {

    private static Logger LOG = Logger.getLogger(HelpDeskDAOAPIimpl.class);
    private ARServerUser arServer = null;
    private static String schemaName = "HPD:Help Desk";
    private static String schemaNameWL = "HPD:WorkLog";

    public HelpDeskDAOAPIimpl() throws DAOException {
        arServer =
                new ARServerUser(Property.getJdbc("user"), Property.getJdbc("pass"),
                                 Property.getJdbc("locale"),
                                 Property.getJdbc("host"));
        try {
            arServer.login();
            LOG.info("Login a Remedy exitoso.!!");
        } catch (ARException e) {
            LOG.error("Error al conectarse a Remedy.");
            LOG.error(Property.getStackTrace(e));
            throw new DAOException("No es posible conectarse con Remedy.", "", e);
        }
    }
    
    /**
     * Obtiene el detalle de un incidente a partir del numero de ticket
     * @param helpDesk
     * @return
     * @throws DAOException
     */
    public HelpDeskOutput findByTicket(HelpDeskInput helpDesk) throws DAOException {
        LOG.info("TROUBLE_TICKET_ID: " + helpDesk.getIncidentNumber());
        return getDataEntry(getEntryID(helpDesk.getIncidentNumber()));
    }

    /**
     * Obtiene el detalle de un incidente a partir del numero de cuenta Siebel
     * Con limite de 7 dias atras de su consulta
     * @param helpDesk
     * @return
     * @throws DAOException
     */
    public HelpDeskOutput findBy7DayBefore(HelpDeskInput helpDesk) throws DAOException {
        LOG.info("NUMERO DE CUENTA: " + helpDesk.getAccount());
        return getDataEntry(getEntryIDAccount(helpDesk.getAccount()));
    }
    
    /**
     * Obtiene el detalle del incidente en la tabla HDP:HelpDesk <br/>
     * Como parametro de entrada enviamos su identificador unico (EntryID)
     * @param entryIDs
     * @return
     * @throws DAOException
     */
    protected HelpDeskOutput getDataEntry(List<String> entryIDs) throws DAOException {
        HelpDeskOutput help = new HelpDeskOutput();
        List<Incident> incidents = new ArrayList<Incident>();
        
        for(String entryID : entryIDs){
            Entry record = null;
            try {
                record = arServer.getEntry(schemaName, entryID, null);
            } catch (ARException e) {
                LOG.error("Error al obtener el detalle del incidente, EntryID ["+entryID+"]");
                LOG.error(Property.getStackTrace(e));
                throw new DAOException(DAOException.FIND,
                                       "Error al obtener el detalle del incidente, EntryID ["+entryID+"]", e);
            }
            Incident incident = new Incident();
            if (record != null && !record.isEmpty()) {
                incident.setAssignedGroup(getString(record.get(Constants.ASSIGNEDGROUP)));
                incident.setDescription(getString(record.get(Constants.DESCRIPTION)));
                incident.setIncidentNumber(getString(record.get(Constants.INCIDENTNUMBER)));
                incident.setLastModifiedBy(getString(record.get(Constants.LASTMODIFIEDBY)));
                incident.setLastModifiedDate(getDate(record.get(Constants.LASTMODIFIEDDATE)));
                incident.setProductCatTier1(getString(record.get(Constants.PRODUCTCATTIER1)));
                incident.setProductCatTier2(getString(record.get(Constants.PRODUCTCATTIER2)));
                incident.setResolution(getString(record.get(Constants.RESOLUTION)));
                incident.setStatus(Constants.states.get(getString(record.get(Constants.STATUS))));
                incident.setSubmitDate(getDate(record.get(Constants.SUBMITDATE)));
                incident.setSubmitter(getString(record.get(Constants.SUBMITTER)));
                incident.setSummary(getString(record.get(Constants.SUMMARY)));
                incident.setComments(getComments(incident.getIncidentNumber()));
                incidents.add(incident);

            } else {
                LOG.error(DAOException.FIND_EMPTY);
                throw new DAOException(DAOException.FIND_EMPTY,
                                       "No es posible obtener el detallle del incidente.");
            }
            LOG.info("Se obtiene el detalle del incidente, EntryID ["+entryID+"]");
        }
        help.setIncident(incidents);
        arServer.clear();
        return help;
    }
    
    /**
     * Obtiene el Identificador Unico (EntryID) del incidente en la tabla HPD:Help Desk <br/>
     * Como parametro de entrada enviamos el numero de Ticket asociado en Auspice
     * @param incident
     * @return
     * @throws DAOException
     */
    protected List<String> getEntryID(String incident) throws DAOException {
        List<String> entryIDs = new ArrayList<String>();
        ArithmeticOrRelationalOperand operleft = new ArithmeticOrRelationalOperand(1000000161);
        ArithmeticOrRelationalOperand operright = new ArithmeticOrRelationalOperand(new Value(incident));
        RelationalOperationInfo op = new RelationalOperationInfo(
                                com.bmc.arsys.api.Constants.AR_REL_OP_EQUAL, operleft, operright);
        QualifierInfo qual = new QualifierInfo(op);
        LOG.info("API Query: " + qual.toString());
        try {
            List<EntryListInfo> lista =
                arServer.getListEntry(schemaName, qual, 0, 1, null, null, false, null);
            if (lista.size() > 0) {
                entryIDs.add(lista.get(0).getEntryID());
            } else {
                LOG.error(DAOException.FIND_EMPTY);
                throw new DAOException(DAOException.FIND_EMPTY,
                                       "No se encontraron registros con el tickect " + incident);
            }
        } catch (ARException e) {
            LOG.error("Error al consultar el numero de ticket.");
            LOG.error(Property.getStackTrace(e));
            throw new DAOException(DAOException.FIND,
                                   "Error al consultar el numero de ticket.", e);
        }
        return entryIDs;
    }

    /**
     * Obtiene los Identificadores Unicos (EntryID) de los incidentes en la tabla HPD:Help Desk <br/>
     * Como parametro de entrada enviamos el numero de Cuenta Siebel
     * @param account
     * @return
     * @throws DAOException
     */
    protected List<String> getEntryIDAccount(String account) throws DAOException {
        List<String> entryIDs = new ArrayList<String>();
        ArithmeticOrRelationalOperand operleft1 = new ArithmeticOrRelationalOperand(536871263);
        ArithmeticOrRelationalOperand operright1 = new ArithmeticOrRelationalOperand(new Value(account));
        RelationalOperationInfo op1 = new RelationalOperationInfo(com.bmc.arsys.api.Constants.AR_REL_OP_EQUAL, operleft1, operright1);
        QualifierInfo qual1 = new QualifierInfo(op1);

        Calendar when = Calendar.getInstance();
        when.add(Calendar.DAY_OF_MONTH, -7);
        Timestamp createDate = new Timestamp(when.getTime());
        ArithmeticOrRelationalOperand operleft2 = new ArithmeticOrRelationalOperand(3);
        ArithmeticOrRelationalOperand operright2 = new ArithmeticOrRelationalOperand(new Value(createDate));
        RelationalOperationInfo op2 = new RelationalOperationInfo(com.bmc.arsys.api.Constants.AR_REL_OP_GREATER_EQUAL, operleft2, operright2);
        QualifierInfo qual2 = new QualifierInfo(op2);

        QualifierInfo qual = new QualifierInfo(QualifierInfo.AR_COND_OP_AND, qual1, qual2);

        LOG.info("API Query: " + qual.toString());
        try {
            List<EntryListInfo> lista =
                arServer.getListEntry(schemaName, qual, 0, 100, null, null, false, null);
            if (lista.size() > 0) {
                for (EntryListInfo info : lista) {
                    entryIDs.add(info.getEntryID());
                }
            } else {
                LOG.error(DAOException.FIND_EMPTY);
                throw new DAOException(DAOException.FIND_EMPTY,
                                       "No se encontraron incidentes con el numero de cuenta " + account);
            }
        } catch (ARException e) {
            LOG.error("Error al consultar por numero de cuenta.");
            LOG.error(Property.getStackTrace(e));
            throw new DAOException(DAOException.FIND,
                                   "Error al consultar por numero de cuenta.", e);
        }
        return entryIDs;
    }

    /**
     * Metodo Wrapper reponsable de obtener el Objeto Comments
     * @param incident
     * @return
     * @throws DAOException
     */
    protected Comments getComments(String incident) throws DAOException {
        Comments comments = new Comments();
        comments.setComment(getDataEntryWorkLog(getEntryIDWorkLog(incident)));
        return comments;
    }
    
    /**
     * Obtiene el detalle de los comentarios en la tabla HDP:WorkLog <br/>
     * Como parametro de entrada enviamos su identificador unico (EntryID)
     * @param entryIDs
     * @return
     * @throws DAOException
     */
    protected List<String> getDataEntryWorkLog(List<String> entryIDs) throws DAOException {
        List<String> comments = new ArrayList<String>();

        for(String entryID : entryIDs){
            Entry record = null;
            try {
                record = arServer.getEntry(schemaNameWL, entryID, null);
            } catch (ARException e) {
                LOG.error("Error al obtener el detalle del comentario, EntryID ["+entryID+"]");
                LOG.error(Property.getStackTrace(e));
                throw new DAOException(DAOException.FIND,
                                       "Error al obtener el detalle del comentario, EntryID ["+entryID+"]", e);
            }

            if (record != null && !record.isEmpty()) {
                comments.add(getString(record.get(Constants.DETAILED_DES)));

            } else {
                LOG.error(DAOException.FIND_EMPTY);
                throw new DAOException(DAOException.FIND_EMPTY,
                                       "No es posible obtener el detallle del comentario.");
            }
            LOG.info("Se obtiene el detalle del comentario, EntryID ["+entryID+"]");
        }
        return comments;
    }

    /**
     * Obtiene el Identificador Unico (EntryID) de los comentario relacionados al
     * incidente en la tabla HPD:WorkLog <br/>
     * Como parametro de entrada enviamos el numero de Incidente
     * @param incident
     * @return
     * @throws DAOException
     */
    protected List<String> getEntryIDWorkLog(String incident) throws DAOException {
        List<String> entryIDs = new ArrayList<String>();
        ArithmeticOrRelationalOperand operleft = new ArithmeticOrRelationalOperand(1000000161);
        ArithmeticOrRelationalOperand operright= new ArithmeticOrRelationalOperand(new Value(incident));
        RelationalOperationInfo op = new RelationalOperationInfo(com.bmc.arsys.api.Constants.AR_REL_OP_EQUAL, operleft, operright);
        QualifierInfo qual = new QualifierInfo(op);

        LOG.info("API Query: " + qual.toString());
        try {
            List<EntryListInfo> lista =
                arServer.getListEntry(schemaNameWL, qual, 0, 100, null, null, false, null);
            if (lista.size() > 0) {
                for (EntryListInfo info : lista) {
                    entryIDs.add(info.getEntryID());
                    if(entryIDs.size()==7)
                        break;
                }
            } else {
                LOG.error(DAOException.FIND_EMPTY);
                LOG.error("No se encontraron comentarios con el numero de incidente " + incident);
            }
        } catch (ARException e) {
            LOG.error("Error al consultar los comentarios.");
            LOG.error(Property.getStackTrace(e));
            throw new DAOException(DAOException.FIND,
                                   "Error al consultar los comentarios.", e);
        }
        return entryIDs;
    }
    
    /* 
     * Metodos Auxiliares, unicos para esta clase.
     */
    private String getString(Object value) {
        return value.toString() == null ? "" : value.toString();
    }
    
    private String getDate(Object value) {
        String rs = getString(value);
        if(value != null){
            rs = rs.replace("[Timestamp=", "").replace("]", "");
            Long time = Long.valueOf(rs);
            Date date = new Date(time * 1000);
            rs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        }
        return rs;
    }
}
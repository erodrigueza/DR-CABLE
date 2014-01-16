package mx.net.cablevision.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;

import mx.net.cablevision.dao.HelpDeskDAO;
import mx.net.cablevision.dao.exception.DAOException;
import mx.net.cablevision.dao.util.Conexion;
import mx.net.cablevision.data.HelpDeskInput;
import mx.net.cablevision.data.HelpDeskOutput;

import mx.net.cablevision.data.Incident;

import org.apache.log4j.Logger;

public class HelpDeskDAOimpl implements HelpDeskDAO {

    private static Logger LOG = Logger.getLogger(HelpDeskDAOimpl.class);

    private static final String SQL_INCIDENT = "SELECT " + 
                                "\"HD\".\"Incident Number\", " + 
                                "\"HD\".\"Assigned Group\", " + 
                                "\"HD\".\"Status\", " + 
                                "\"HD\".\"Product Categorization Tier 1\", " + 
                                "\"HD\".\"Product Categorization Tier 2\", " + 
                                "\"HD\".\"Submitter\", " + 
                                "\"HD\".\"Submit Date\", " + 
                                "\"HD\".\"Last Modified Date\", " + 
                                "\"HD\".\"Last Modified By\", " + 
                                "\"HD\".\"Description\", " + 
                                "\"HD\".\"Resolution\" " + 
                                "FROM \"HPD:Help Desk\" \"HD\" " + 
                                "WHERE \"HD\".\"Incident Number\"='?'";

    @Override
    public HelpDeskOutput findByTicket(HelpDeskInput helpDesk) throws DAOException {
        HelpDeskOutput help = new HelpDeskOutput();
        List<Incident> incidents = new ArrayList<Incident>();
        Connection conn = null;
        Statement sth = null;
        String sql = null;
        try {
            conn = Conexion.getInstance().getConexion();
            LOG.info("TROUBLE_TICKET_ID: " + helpDesk.getIncidentNumber());
            sql = SQL_INCIDENT.replace("?", helpDesk.getIncidentNumber());
            sth = conn.createStatement();
            ResultSet rs = sth.executeQuery(sql);

            Incident incident = new Incident();
            if (rs.next()) {
                incident.setIncidentNumber(rs.getString(1));
                incident.setAssignedGroup(rs.getString(2));
                incident.setStatus(rs.getString(3));
                incident.setProductCatTier1(rs.getString(4));
                incident.setProductCatTier2(rs.getString(5));
                incident.setSubmitter(rs.getString(6));
                incident.setSubmitDate(rs.getString(7));
                incident.setLastModifiedDate(rs.getString(8));
                incident.setLastModifiedBy(rs.getString(9));
                incident.setDescription(rs.getString(10));
                incident.setResolution(rs.getString(11));
                incidents.add(incident);
            } else {
                LOG.error(DAOException.FIND_EMPTY);
                throw new DAOException(DAOException.FIND_EMPTY, SQL_INCIDENT);
            }

        } catch (SQLException e) {
            LOG.error("SQL:\n" + sql);
            LOG.error("SQLException: ", e);
            throw new DAOException(DAOException.FIND, SQL_INCIDENT, e);
        } finally {
            Conexion.getInstance().liberaConexion(conn);
        }

        return help;
    }

    public HelpDeskOutput findBy7DayBefore(HelpDeskInput helpDesk) throws DAOException {
        LOG.info("NUMERO DE CUENTA: " + helpDesk.getAccount());
        return new HelpDeskOutput();
    }
}

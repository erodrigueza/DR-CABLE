package mx.net.cablevision.dao;

import mx.net.cablevision.dao.exception.DAOException;
import mx.net.cablevision.data.HelpDeskInput;
import mx.net.cablevision.data.HelpDeskOutput;


public interface HelpDeskDAO {
    public HelpDeskOutput findByTicket(HelpDeskInput helpDesk) throws DAOException;

    public HelpDeskOutput findBy7DayBefore(HelpDeskInput helpDesk) throws DAOException;
}

package mx.net.cablevision.dao;

import mx.net.cablevision.dao.exception.DAOException;
import mx.net.cablevision.data.EquipmentInput;
import mx.net.cablevision.data.EquipmentOutput;

public interface ReaderHtmlDAO {
    EquipmentOutput getStatus(EquipmentInput equipmentIn) throws DAOException;
}

package mx.net.cablevision.dao.impl;

import java.io.IOException;

import mx.net.cablevision.dao.ReaderHtmlDAO;
import mx.net.cablevision.dao.exception.DAOException;
import mx.net.cablevision.dao.util.ReaderHtmlAssembler;
import mx.net.cablevision.data.EquipmentInput;
import mx.net.cablevision.data.EquipmentOutput;
import mx.net.cablevision.dto.StatusBillingProvisioning;
import mx.net.cablevision.dto.StatusFromCMTS;
import mx.net.cablevision.dto.StatusFromModem;
import mx.net.cablevision.dto.StatusFromTelephony;
import mx.net.cablevision.dto.StatusGeneral;
import mx.net.cablevision.dto.StatusHFC;
import mx.net.cablevision.dto.StatusMTA;
import mx.net.cablevision.dto.StatusMTAExt;
import mx.net.cablevision.util.Constants;
import mx.net.cablevision.util.Property;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class ReaderHtmlDAOimpl implements ReaderHtmlDAO {

    private static Logger LOG = Logger.getLogger("ReaderHtmlDAOimpl");
    
    public EquipmentOutput getStatus(EquipmentInput equipmentIn) throws DAOException {
        
        EquipmentOutput equipmentOut = new EquipmentOutput(); 
        Document doc = getConnection(equipmentIn.getMacAddress());
        if(doc != null){
            String textP = doc.body().textPipe();
            String text  = doc.body().text();
            StatusGeneral status = new StatusGeneral();
            
            status.setBillProv(getbillProv(textP));
            status.setCmts(getCmts(textP));
            status.setHfc(getHfc(textP));
            status.setInternet(getInternet(textP, doc));
            status.setMac(equipmentIn.getMacAddress());
            status.setTelefonia(getTelefonia(textP, doc));
            status.setHub(ReaderHtmlAssembler.getValueHtml(text, "CMTS :", 1));
            
            equipmentOut.setStatus(status);
            
        }else{
            LOG.error("Error en get status: "+ DAOException.DOC_NULL + equipmentIn.getMacAddress());
            throw new DAOException(DAOException.DOC_NULL + equipmentIn.getMacAddress());    
        }
        return equipmentOut;
    }
    
    private Document getConnection(String macAddress){
        Document doc = null;
        LOG.info("Inicia getConnection(String macAddress)");
        String username = Property.get("username");
        String password = Property.get("password");
        String login = username + ":" + password;
        String base64login = new String(Base64.encodeBase64(login.getBytes()));

        String url = Property.get("url");
        String mac = Property.get("mac") + macAddress;
        String instance = Property.get("instance");
        String mac_button = Property.get("mac_button");

        try {
            doc = Jsoup.connect(url + mac + instance + mac_button)
                .header("Authorization", "Basic " + base64login)
                .timeout(60000)
                .get();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        LOG.info("Se obtiene Conexion de forma exitosa.");
        return doc;
    }


    private StatusBillingProvisioning getbillProv(String textP) {
        StatusBillingProvisioning status = new StatusBillingProvisioning();
        status.setCustomerAccount(ReaderHtmlAssembler.getNextValue(textP, "Customer Account #"));
        status.setCustomerAddress(ReaderHtmlAssembler.getNextValue(textP, "Customer Address"));
        status.setCmts(ReaderHtmlAssembler.getNextValue(textP, "CMTS"));
        status.setCmFQDN(ReaderHtmlAssembler.getNextValue(textP, "CM FQDN"));
        status.setCmMACAddress(ReaderHtmlAssembler.getNextValue(textP, "CM MAC Address"));
        status.setCustomerName(ReaderHtmlAssembler.getNextValue(textP, "Customer Name"));
        status.setCustomerPhone(ReaderHtmlAssembler.getNextValue(textP, "Customer Phone #"));
        status.setVendor(ReaderHtmlAssembler.getNextValue(textP, "Vendor"));
        LOG.debug("Se obtiene StatusBillingProvisioning  de getbillProv");
        return status;
    }

    private StatusFromCMTS getCmts(String textP) {
        StatusFromCMTS status = new StatusFromCMTS();
        status.setUpstreamChannelMode(ReaderHtmlAssembler.getNextValue(textP, "Upstream Channel Mode"));
        status.setModemStatus(Constants.getModemStatus(ReaderHtmlAssembler.getNextValue(textP, "Modem Status")));
        status.setUpStreamChannel(ReaderHtmlAssembler.getValuePlus(textP, "Upstream Channel", 2));
        LOG.debug("Se obtiene StatusFromCMTS de getCmts");
        return status;
    }

    private StatusHFC getHfc(String textP) {
        StatusHFC status = new StatusHFC();
        status.setCurrentStatus(ReaderHtmlAssembler.getValuePlus(textP, "Current Status", 4));
        status.setDocsisDeviceOnline(ReaderHtmlAssembler.getValuePlus(textP, "DOCSIS Devices Online", 4));
        status.setLastDetectedOutage(ReaderHtmlAssembler.getValuePlus(textP, "Last Detected Outage", 4));
        status.setMtaAvailable(ReaderHtmlAssembler.getValuePlus(textP, "MTAs Available", 4));
        status.setNode(ReaderHtmlAssembler.getNextValue(textP, "Node"));
        LOG.debug("Se obtiene StatusHFC de getHfc");
        return status;
    }

    private StatusFromModem getInternet(String textP, Document doc) {
        StatusFromModem status = new StatusFromModem();
        status.setBpiStatus(ReaderHtmlAssembler.getNextValue(textP, "BPI Status"));
        status.setCmConfigurationFile(ReaderHtmlAssembler.getConfigurationFile(doc,3));
        status.setDHCPServer(ReaderHtmlAssembler.getNextValue(textP, "DHCP Server"));
        status.setDownstreamReceivePower(ReaderHtmlAssembler.getListTransmitPower(textP, "Downstream Receive Power"));
        status.setDownstreamChannelFrequency(ReaderHtmlAssembler.getListTransmitPower(textP, "Downstream Channel Frequency"));
        status.setGuaranteedUpstreamBandwidth(ReaderHtmlAssembler.getTransmitPower(textP, "Guaranteed Upstream Bandwidth"));
        status.setLostSyncs(ReaderHtmlAssembler.getInteger(textP, "Lost Syncs"));
        status.setMaximumUpstreamBandwidth(ReaderHtmlAssembler.getTransmitPower(textP, "Maximum Upstream Bandwidth"));
        status.setMaximumDownstreamBandwidth(ReaderHtmlAssembler.getTransmitPower(textP, "Maximum Downstream Bandwidth"));
        status.setQosProfile(ReaderHtmlAssembler.getInteger(textP, "Qos Profile"));
        status.setResets(ReaderHtmlAssembler.getInteger(textP, "Resets"));
        status.setDownstreamSignalNoiseRatio(ReaderHtmlAssembler.getListTransmitPower(textP, "Downstream Signal to Noise Ratio"));
        status.setSystemDescription(ReaderHtmlAssembler.getValuePlus(textP, "System Description", 5));
        status.setSystemUpTime(ReaderHtmlAssembler.getNextValue(textP, "System Up Time"));
        status.setCmTFTPServer(ReaderHtmlAssembler.getNextValue(textP, "CM TFTP Server"));
        status.setTimeServer(ReaderHtmlAssembler.getNextValue(textP, "Time Server"));
        status.setUpstreamTransmitPower(ReaderHtmlAssembler.getTransmitPower(textP, "Upstream Transmit Power"));
        status.setUpstreamChannelFrequency(ReaderHtmlAssembler.getTransmitPower(textP, "Upstream Channel Frequency"));
        
        LOG.debug("Se obtiene StatusFromModem de getInternet");
        return status;
    }

    private StatusFromTelephony getTelefonia(String textP, Document doc) {
        StatusFromTelephony status = new StatusFromTelephony();
        StatusMTA statusMTA = new StatusMTA();
        statusMTA.setConfigFile(ReaderHtmlAssembler.getConfigurationFile(doc,1));
        statusMTA.setDns_1(ReaderHtmlAssembler.getNextValue(textP, "DNS Primary Server"));
        statusMTA.setDns_2(ReaderHtmlAssembler.getNextValue(textP, "DNS Secondary Server"));
        statusMTA.setFqdn(ReaderHtmlAssembler.getConfigurationFile(doc,2));
        statusMTA.setHwVersion(ReaderHtmlAssembler.getNextValue(textP, "HW Version"));
        statusMTA.setKerberosRealm(ReaderHtmlAssembler.getNextValue(textP, "Kerberos Realm"));
        statusMTA.setModelNumber(ReaderHtmlAssembler.getNextValue(textP, "Model Number"));
        statusMTA.setPingStatus(ReaderHtmlAssembler.getNextValue(textP, "Ping Status"));
        statusMTA.setProvisioningCounter(ReaderHtmlAssembler.getNextValue(textP, "Provisioning Counter"));
        statusMTA.setProvisioningState(Constants.getProvisioningState(ReaderHtmlAssembler.getNextValue(textP, "Provisioning State")));
        statusMTA.setSerialNumber(ReaderHtmlAssembler.getNextValue(textP, "Serial Number"));
        statusMTA.setSnmpEntity(ReaderHtmlAssembler.getNextValue(textP, "SNMP Entity"));
        statusMTA.setSwVersion(ReaderHtmlAssembler.getNextValue(textP, "SW Version"));
        statusMTA.setVoiceEnabled(ReaderHtmlAssembler.getNextValue(textP, "Voice Enabled"));
        status.setStatusMTA(statusMTA);

        StatusMTAExt statusMTAExt = new StatusMTAExt();
        statusMTAExt.setLineasTelefonicas(ReaderHtmlAssembler.getLineasTelefonicas(textP));
        statusMTAExt.setVendor(ReaderHtmlAssembler.getValuePoint(textP, "Extended MTA Status", 12));
        status.setStatusMTAExt(statusMTAExt);
        
        LOG.debug("Se obtiene StatusFromTelephony de getTelefonia");
        return status;
    }
}

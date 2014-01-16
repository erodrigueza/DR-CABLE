package mx.net.cablevision.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import javax.jws.WebService;

import mx.net.cablevision.data.DiagnosticoInput;
import mx.net.cablevision.data.DiagnosticoOutput;
import mx.net.cablevision.vo.Hub;
import mx.net.cablevision.vo.Item;

import org.apache.log4j.Logger;


@Stateless
@WebService(serviceName = "TskDiagnosticoDAC",
            portName = "TskDiagnosticoDACPort",
            endpointInterface = "mx.net.cablevision.port.TskDiagnosticoDACPort",
            targetNamespace =
            "http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/TskDiagnosticoDAC")
public class TskDiagnosticoDAC {

    private static Logger LOG = Logger.getLogger(TskDiagnosticoDAC.class);

    public DiagnosticoOutput getDiagnosticoDAC(DiagnosticoInput input) {
        LOG.info("Se invoca el metodo getDiagnosticoDAC(DiagnosticoInput)");
        DiagnosticoOutput output = new DiagnosticoOutput();
        int code = 300;
        String msg = "OK";
        try{
            if (!isSameSerial(input)) {
                code = 301;
            } else if(!isActive(input)) {
                code = 302;
            } else if(isDCT2000(input)) {
                code = 303;
            } else if(!isSameProduct(input)) {
                code = 304;
            } else if(!isSameHub(input)) {
                code = 305;
            } else if(!isSameRetorno(input)) {
                code = 306;
            } else if(!isBidireccional(input)) {
                code = 307;
            } else if(!isOkMapa(input)) {
                code = 308;
            } else if(isPaqueteAdeudo(input)) {
                code = 309;
            }
        } catch (Exception e){
            msg = e.getMessage();
            LOG.error(getStackTrace(e));
        }
        output.setResult(code);
        output.setMsg(msg);
        output.setDetError("");
        LOG.info("Termina el metodo getDiagnosticoDAC(DiagnosticoInput)");
        return output;
    }

    private boolean isSameSerial(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValidacion de Items de Servicio Vs Items Facturacion.");
        boolean res = false;
        List<Item> itemsFactura = input.getItemsFacturacion().getItem();
        List<Item> itemsServicio = input.getItemsServicio().getItem();
        Map<String, String> result = new HashMap<String, String>();

        LOG.info(itemsServicio.size() + " items de Servicio");
        LOG.info(itemsFactura.size() + " items de Facturacion");
        for (Item itemS : itemsServicio) {
            for (Item itemF : itemsFactura) {
                if (itemS.getNumeroSerie().trim().equals(itemF.getNumeroSerie().trim())) {
                    LOG.info("El numero de serie " + itemS.getNumeroSerie() +
                              " existe en items de  servicio");
                    result.put(itemS.getNumeroSerie().trim(), itemF.getNumeroSerie().trim());
                }
            }
        }
        LOG.debug("Tamanio del Mapa: "+result.size());
        if (itemsServicio.size() == result.size()) {
            res = true;
        }
        return res;
    }

    private boolean isActive(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida si los equipos estan ACTIVOS.");
        boolean res = true;
        List<Item> itemsServicio = input.getItemsServicio().getItem();
        for (Item itemS : itemsServicio) {
            LOG.info("El status del equipo " + itemS.getNumeroSerie()
                     + " es [" + itemS.getStatus() + "]");
            if(!"ACTIVO".equals(itemS.getStatus().trim().toUpperCase())){
                res = false;
            }
        }
        return res;
    }

    private boolean isDCT2000(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida si el tipo de los equipos es DCT-2000.");
        boolean res = false;
        List<Item> itemsServicio = input.getItemsServicio().getItem();
        String equipoDAC = "";
        if(input.getResponseDACVO() != null){
            equipoDAC = input.getResponseDACVO().getEquipType() != null ? 
                input.getResponseDACVO().getEquipType() : "";
        }
        LOG.info("Tipo de equipo (770) [" + equipoDAC + "]");
        for (Item itemS : itemsServicio) {
            LOG.info("Tipo de equipo (Siebel) [" + itemS.getProducto() + "]");
            if(itemS.getProducto().toUpperCase().contains("DCT-2000") 
               && equipoDAC.toUpperCase().contains("DCT-2000")){
                res = true;
            }
        }
        return res;
    }

    private boolean isSameProduct(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida si el equipo se registro OK en el DAC.");
        boolean res = false;
        List<Item> itemsServicio = input.getItemsServicio().getItem();
        String equipoDAC = "";
        if(input.getResponseDACVO() != null){
            String equipo = input.getResponseDACVO().getEquipType();
            String []array = equipo != null ? equipo.split(" ") : new String[]{""};
            equipoDAC = array[0];
        }
        LOG.info("Tipo de equipo (770) ["+equipoDAC+"]");
        for (Item itemS : itemsServicio) {
            LOG.info("Tipo de equipo (Siebel) [" + itemS.getProducto() + "]");
            if( !equipoDAC.isEmpty()
                && itemS.getProducto() != null
                && itemS.getProducto().toUpperCase().contains(equipoDAC.toUpperCase())){
                res = true;
            }
        }
        return res;
    }

    private boolean isSameHub(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida si es igual el hub (Siebel) contra Planta (770).");
        boolean res = false;
        if(input.getDireccionPrincipal() != null
            && input.getResponseDACVO() != null){
            String hub = input.getDireccionPrincipal().getHub() != null ? 
                input.getDireccionPrincipal().getHub() : "";
            String planta = input.getResponseDACVO().getDownstreamPlantHandle() != null ?
                input.getResponseDACVO().getDownstreamPlantHandle() : "";
            LOG.info("Hub (Siebel) ["+hub+"] Planta (770)["+planta+"]");
            res = planta.toUpperCase().contains(Hub.hubs.get(hub.trim()));
        } else {
            LOG.error("No fue posible la validacion debido a campos nulos.");    
        }   
        return res;
    }

    private boolean isSameRetorno(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida si es igual el tipo de retorno del equipo.");
        boolean res = false;
        if(input.getDireccionPrincipal() != null
            && input.getResponseDACVO() != null){
            String retorno = input.getDireccionPrincipal().getRetorno() != null ? 
                input.getDireccionPrincipal().getRetorno() : "";
            String tipoEquipo = input.getResponseDACVO().getEquipType() != null ?
                input.getResponseDACVO().getEquipType() : "";
            LOG.info("Retorno (Siebel) ["+retorno+"] Tipo de Equipo (770) ["+tipoEquipo+"]");
            res = tipoEquipo.toUpperCase().contains(retorno.trim());
        } else {
            LOG.error("No fue posible la validacion debido a campos nulos.");    
        }
        return res;
    }

    private boolean isBidireccional(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida bandera bidireccional del equipo (si es igual a 0).");
        boolean res = false;
        if(input.getResponseDACVO() != null){
            String flag = input.getResponseDACVO().getRespondingFlag() != null ?
                input.getResponseDACVO().getRespondingFlag() : "";
            LOG.info("Valor de Bandera Bidireccional (770) ["+flag+"]");
            res = !flag.trim().equals("0");
        } else {
            LOG.error("No fue posible la validacion debido a campos nulos.");    
        }
        return res;
    }

    private boolean isOkMapa(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida el Mapa del equipo (si es igual a 20).");
        boolean res = false;
        if(input.getResponseDACVO() != null){
            String mapa = input.getResponseDACVO().getVcmHandle() != null ?
                input.getResponseDACVO().getVcmHandle() : "";
            LOG.info("Valor de Mapa (770) ["+mapa+"]");
            res = !mapa.trim().equals("20");
        } else {
            LOG.error("No fue posible la validacion debido a campos nulos.");    
        }
        return res;
    }

    private boolean isPaqueteAdeudo(DiagnosticoInput input) throws Exception {
        LOG.info("\n\t\tValida el paquete del equipo (si contiene 'Paquete Adeudo').");
        boolean res = false;
        if(input.getResponseDACVO() != null){
            String paquete = input.getResponseDACVO().getPackageAuthorizations() != null ?
                input.getResponseDACVO().getPackageAuthorizations() : "";
            LOG.info("Nombre del paquete (770) ["+paquete+"]");
            res = paquete.toUpperCase().contains("ADEUDO");
        } else {
            LOG.error("No fue posible la validacion debido a campos nulos.");    
        }        
        return res;
    }
    
    public static String getStackTrace(Exception e)
    {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}

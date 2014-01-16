package mx.net.cablevision.brm.service.impl;

import mx.net.cablevision.common.SuiteBRMException;

import org.apache.log4j.Logger;

import com.portal.pcm.EBufException;
import com.portal.pcm.FList;
import com.portal.pcm.PortalContext;
import com.portal.pcm.PortalOp;

import mx.net.cablevision.util.Messages;

/**
 * Clase Genérica para la creación del contexto <code>PortalContext</code> y la
 * invocación de los Opcodes
 *
 * @author Latbc - EFRA
 * @date 17/10/2013
 */
public class GenericService {

    private static Logger LOG = Logger.getLogger(GenericService.class);

    protected PortalContext ctx;

    protected GenericService() {
        try {
            ctx = new PortalContext();
        } catch (EBufException e) {
            LOG.error("\n\t" +
                      Messages.getMsg("exception.portalcontext.create"));
            LOG.error(Messages.getStackTrace(e));
        }
    }

    FList executeOpcode(int opcode, FList inFlist) throws SuiteBRMException {

        FList outFlist = null;
        if (ctx != null) {
            try {
                ctx.connect();

                LOG.debug("\nExecute OPCODE: " + PortalOp.opToString(opcode));
                LOG.debug("Flist de ENTRADA:\n" + inFlist.asString());
                outFlist = ctx.opcode(opcode, inFlist);

                if (outFlist == null) {
                    LOG.error("outFlist is NULL...!!");
                    throw new SuiteBRMException(Messages.getMsg("exception.portalcontext.opcode.null"));
                }

                LOG.debug("Flist de SALIDA:\n" +
                        outFlist.asString());

            } catch (EBufException e) {
                LOG.error("\n\tError en Opcode: " +
                          PortalOp.opToString(opcode));
                LOG.error(Messages.getStackTrace(e));
                throw new SuiteBRMException(Messages.getMsg("exception.portalcontext.opcode") +
                                            PortalOp.opToString(opcode), e);
            } finally {
                try {
                    ctx.close(true);
                } catch (EBufException e) {
                    LOG.error(Messages.getStackTrace(e));
                    throw new SuiteBRMException(Messages.getMsg("exception.portalcontext.connection"),
                                                e);
                }
            }
        } else {
            throw new SuiteBRMException(Messages.getMsg("exception.portalcontext.null"));
        }

        return outFlist;
    }
}

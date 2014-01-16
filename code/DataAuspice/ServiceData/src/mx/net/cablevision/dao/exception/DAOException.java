package mx.net.cablevision.dao.exception;

public class DAOException extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String OPEN = "Error al abrir la conexión html.";
    public static final String DOC_NULL = "No se encontro información del equipo ";


    public String mensaje;
    public String detalle;
    public String sentenciaSQL;

    public DAOException(String msg, Exception e) {
        super(msg, e);
        this.mensaje = msg;
        this.detalle = e.getMessage();
    }

    public DAOException(String msg) {
        super(msg);
        this.mensaje = msg;
        this.detalle = msg;
    }
}

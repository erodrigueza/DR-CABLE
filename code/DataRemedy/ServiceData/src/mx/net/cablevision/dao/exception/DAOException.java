package mx.net.cablevision.dao.exception;

public class DAOException extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String CREATE = "Error al crear el Registro.";
    public static final String UPDATE = "Error al modificar el Registro.";
    public static final String REMOVE = "Error al eliminar el Registro.";
    public static final String FIND = "Error, al realizar la consulta.";
    public static final String FINDALL = "Error al buscar todos los registros.";
    public static final String FIND_EMPTY = "No se encontraron registros en la DB ";


    public String mensaje;
    public String detalle;
    public String sentenciaSQL;

    public DAOException(String msg, String sentenciaSQL, Exception e) {
        super(msg, e);
        this.mensaje = msg;
        this.detalle = e.getMessage();
        this.sentenciaSQL = sentenciaSQL;
    }

    public DAOException(String msg, String det) {
        super(msg);
        this.mensaje = msg;
        this.detalle = det;
        this.sentenciaSQL = null;
    }
}

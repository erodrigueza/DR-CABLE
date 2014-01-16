package mx.net.cablevision.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public class Utilities {

	/**
	 * Devuelve el valor <code>Entero</code> del Integer en caso de que este sea
	 * una instancia de <code>Integer</code> En caso contrario devuelve un
	 * <code>CERO</code>
	 * 
	 * @param value
	 * @return String
	 * @throws getInteger
	 * @author Latbc -EFRA
	 */
	public static Integer getInteger(Integer value) {

		Integer rs = 0;
		if (value instanceof Integer) {
			rs = value;
		}
		return rs;
	}

	/**
	 * @param cliente
	 * @return
	 * @author Latbc - EFRA
	 */
	public static Integer getInteger(String valor) {

		Integer rolValue = new Integer(0);

		if (valor instanceof String && !valor.trim().isEmpty()) {
			rolValue = Integer.parseInt(valor);
		}

		return rolValue;
	}

	/**
	 * Devuelve el <code>String</code> del Objeto en caso de que este contenga
	 * En caso contrario devuelve una cadena vacia
	 * 
	 * @param value
	 * @return String
	 * @throws getString
	 * @author Latbc -EFRA
	 */
	public static String getString(Object value) {

		String rs = "";
		if (value != null) {
			rs = value.toString();
		}
		return rs;
	}

	/**
	 * Devuelve el valor <code>boolean</code> del Objeto <code>true</code> en
	 * caso que el String se igual a "true" En caso contrario devuelve
	 * <code>false</code> Si es nulo devuelve <code>false</code>
	 * 
	 * @param value
	 * @return boolean
	 * @throws getBoolean
	 */
	public static boolean getBoolean(Object value) {

		boolean rs = false;
		if (value instanceof Boolean) {
			rs = (Boolean) value;
		} else if (value instanceof Object) {
			rs = Boolean.parseBoolean(value.toString());
		}
		return rs;
	}

	/**
	 * Devuelve el valor <code>BigDecimal</code> del Objeto
	 * <code>BigDecimal 0</code> en caso que el objeto sea nulo O si no es una
	 * instacia de esta clase
	 * 
	 * @param value
	 * @return BigDecimal
	 * @throws getBigDecimal
	 */
	public static BigDecimal getBigDecimal(Object value) {

		BigDecimal rs = BigDecimal.ZERO;
		if (value instanceof BigDecimal) {
			rs = (BigDecimal) value;
		}
		return rs;
	}

	/**
	 * Devuelve <b>true</b> o <b>false</b> al validar si el objeto es nulo o
	 * vac&iacute;o.
	 * <ul>
	 * <li><b>true</b>: En caso de que la cadena sea null o vac&iacute;a</li>
	 * <li><b>false</b>: En caso contrario</li>
	 * </ul>
	 * 
	 * @param objeto
	 *            Contiene el objeto a validar si es null o vacio.
	 * @return <ul>
	 *         <li><b>true</b>: En caso de que la cadena sea null o vac&iacute;a
	 *         </li>
	 *         <li><b>false</b>: En caso contrario</li>
	 *         </ul>
	 */
	public static boolean isEmptyString(Object objeto) {
		return objeto == null || objeto.toString().trim().isEmpty();
	}

	/**
	 * Devuelve el <code>Date</code> del BigInteger en caso de que este contenga
	 * En caso contrario devuelve una fecha cero
	 * 
	 * @param value
	 * @return Date
	 * @throws getDate
	 * @author Latbc -EFRA
	 */
	public static Date getDate(BigInteger value) {

		Date rs = new Date(0);
		if (value instanceof BigInteger) {
			rs = new Date(value.longValue() * 1000);
		}
		return rs;
	}

	public static Date getDate(Date value) {

		Date rs = new Date();
		if (value instanceof Date) {
			return value;
		}
		return rs;
	}

	public static Date getDateTomorrow() {
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DAY_OF_YEAR, 1);
		tomorrow.set(Calendar.HOUR_OF_DAY, 0);
		tomorrow.set(Calendar.MINUTE, 0);
		tomorrow.set(Calendar.SECOND, 0);
		tomorrow.set(Calendar.MILLISECOND, 0);
		return tomorrow.getTime();
	}

}

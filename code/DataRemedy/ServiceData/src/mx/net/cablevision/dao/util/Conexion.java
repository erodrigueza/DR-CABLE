package mx.net.cablevision.dao.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import mx.net.cablevision.util.Property;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

public class Conexion {

	private static Logger LOG = Logger.getLogger(Conexion.class);

	private static Conexion _instance = null;
	private DataSource dataSource = null;


	public static Conexion getInstance() {
		if (_instance == null) {
			_instance = new Conexion();
		}
		return _instance;
	}
	
	private Conexion() {
		BasicDataSource basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName(Property.getJdbc("driver"));
		basicDataSource.setUrl(Property.getJdbc("url"));
//		basicDataSource.setUsername(Property.getJdbc("user"));
//		basicDataSource.setPassword(Property.getJdbc("pass"));

		basicDataSource.setMaxActive(5);
		basicDataSource.setMinIdle(1);
		basicDataSource.setMaxIdle(3);
		basicDataSource.setInitialSize(1);

		this.dataSource = basicDataSource;
		LOG.info("Se inicializa el DataSource de la Conexion con la DB");
	}

	public Connection getConexion() throws SQLException {

		return dataSource.getConnection();
		
	}

	public void liberaConexion(Connection conexion) {
        try {
            if (null != conexion) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

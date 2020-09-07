package integrador.dao;

import java.sql.SQLException;

import integrador.interfaces.ClienteDAO;
import integrador.interfaces.FacturaDAO;
import integrador.interfaces.FacturaProductoDAO;
import integrador.interfaces.ProductoDAO;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int DERBY = 2;
	
	public abstract ClienteDAO obtenerClienteDAO();
	public abstract FacturaDAO obtenerFacturaDAO();
	public abstract FacturaProductoDAO obtenerFacturaProductoDAO();
	public abstract ProductoDAO obtenerProductoDAO();
	
	public abstract void crearTablas();
	
	public static DAOFactory obtenerDAOFactory(int qFactory, String usuario, String clave) {
		switch (qFactory) {
		case MYSQL:
			try {
				return new MySQLDAOFactory(usuario, clave);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case DERBY:
			try {
				return new DERBYDAOFactory();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			return null;
		}
	}
}

package facu.arqui;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD {

	public static void main(String[] args) {
	String driver = "org.apache.derby.jdbc.EmbeddedDriver";

	try {
		Class.forName(driver).getDeclaredConstructor().newInstance();
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
			| NoSuchMethodException | SecurityException | ClassNotFoundException e1) {
		e1.printStackTrace();
		System.exit(1);
	}
	
	String uri = "jdbc:derby:MyDerbyDB;create=true";
	
	try {
		Connection conn = DriverManager.getConnection(uri);
		createTables(conn);
		addPerson(conn,1,"Carlito",53);
		addPerson(conn,2,"Pepa",12);
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 

	}

	private static void addPerson(Connection conn, int id, String name, int age) throws SQLException {
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2,name);
		ps.setInt(3, age);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

	private static void createTables(Connection conn) throws SQLException {
		String table = "CREATE TABLE persona (" +
				"id INT," +
				"nombre VARCHAR (500),"+
				"edad INT,"+
				"PRIMARY KEY (id))";
		conn.prepareStatement(table).execute();
		conn.commit();
	}

}

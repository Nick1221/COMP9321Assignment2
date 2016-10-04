package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DATABASE_NAME = "9321DataBase";
	private final String user = "root";
	private final String password = "12345";
	
	private final String dbms = "mysql";
	
	private final String server_name = "localhost";
	private final String port = "3306";
	
	private Connection conn = null;
	
	private Statement stmt = null;
	
	public DBConnection() throws SQLException, ClassNotFoundException {
		this.conn = this.getConnection();
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.user);
	    connectionProps.put("password", this.password);
	    
	    Class.forName(DRIVER);
	    
    	conn = DriverManager.getConnection(
                "jdbc:" + this.dbms + "://" +
                		this.server_name +
                ":" + this.port + "/" + DBConnection.DATABASE_NAME + "?zeroDateTimeBehavior=convertToNull",
                connectionProps);
	    return conn;
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		this.stmt = conn.createStatement();
		
		System.out.println(query);
		
		return this.stmt.executeQuery(query);
	}
	
	public int executeUpdateQuery(String query) throws SQLException {
		this.stmt = conn.createStatement();
		
		System.out.println(query);
		
		return this.stmt.executeUpdate(query);
	}
	
	public void closeStatement() throws SQLException {
		if (stmt != null) stmt.close();
	}
	
	public boolean hasActiveStatement() {
		return this.stmt != null;
	}
}

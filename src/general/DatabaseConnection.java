package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {
	public static final String DATABASE_NAME = "creativity";
	private final String user = "";
	private final String password = "";
	
	private final String dbms = "mysql";
	
	private final String server_name = "8009";
	private final String port = "8009";
	
	private Connection conn = null;
	
	private Statement stmt = null;
	
	public DatabaseConnection() throws SQLException {
		this.conn = this.getConnection();
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.user);
	    connectionProps.put("password", this.password);
	    
	    conn = DriverManager.getConnection(
                "jdbc:" + this.dbms + "://" +
                		this.server_name +
                ":" + this.port + "/",
                connectionProps);
	    return conn;
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		this.stmt = conn.createStatement();
		
		this.stmt.executeQuery(query);
		
		return null;
	}
	
	public void closeStatement() throws SQLException {
		if (stmt != null) stmt.close();
	}
	
	public boolean hasActiveStatement() {
		return this.stmt != null;
	}
	
}

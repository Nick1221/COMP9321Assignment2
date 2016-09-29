import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class dbController {
	// JDBC driver name and db URL
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost/local";
	static final String localHost_URL = "jdbc:mysql://localhost/";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "1234";
	
	public dbController(){
		
	}
	
	// USER table////////////////////////////////////////////////////////////////////
	public void createUser(String username, String password, String email, String fname, String lname, String Bdate){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `User` "
					+ "(`uID`, `Username`, `password`, `email`, `confirmedEmail, `first_name`, `last_name`, `Bdate`, `isAdmin`) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, maxUsersID()+1);
			statement.setString(2, username);
			statement.setString(3, password);
			statement.setString(4, email);
			statement.setInt(5, 0);
			statement.setString(6, fname);
			statement.setString(7, lname);
			statement.setString(8, Bdate);
			statement.setInt(9, 0);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public int getuID(String username){
		Connection connection = null;
		PreparedStatement statement = null;
		int uID = 0;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (Username = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				uID = rs.getInt("uID");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return uID;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return uID; 
	}
	
	public String getUserName(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		String userName = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				userName = rs.getString("Username");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return userName;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return userName; 	
	}
	
	public String getPassword(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		String password = null;
		
		try {
			// Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				password = rs.getString("password");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return password;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return password; 	
	}

	public String getEmail(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		String email = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				email = rs.getString("email");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return email;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return email; 	
	}

	public boolean getConfirmedEmail(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		int confirmed = 0;
		
		try {
			//STEP 2: Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				confirmed = rs.getInt("confirmedEmail");
		
			}
			
			// Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			if(confirmed == 1){
				return true;
			}
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return false; 	
	}

	public String getFname(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		String fName = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				fName = rs.getString("first_name");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return fName;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return fName; 
	}

	public String getLname(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		String lName = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				lName = rs.getString("last_name");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return lName;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return lName; 
	}

	public Date getBdate(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		Date Bdate = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				Bdate = rs.getDate("Bdate");
				
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return Bdate;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return Bdate; 
	}
	
	public boolean getIsAdmin(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		int isAdmin = 0;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM User WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				isAdmin = rs.getInt("isAdmin");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			if(isAdmin == 1){
				return true;
			}
			
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return false; 
	}

	// USER credit card table //////////////////////////////////////////////////////////
	public void createCreditCard(int uID, int cardNum){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `UserCreditCard` "
					+ "(`uID`, `cardNumber`) "
					+ "VALUES(?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.setInt(2, cardNum);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public int getCreditCard(int uID){
		
	}
	
	// Email confirmation table //////////////////////////////////////////////////////
	public void createEmailComfirm(int uID, String code, int attempts){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `EmailConfirmation` "
					+ "(`uID`, `code`, `attempts`) "
					+ "VALUES(?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.setString(2, code);
			statement.setInt(3, attempts);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public String getCode(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		String code = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM EmailConfirmation WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				code = rs.getString("code");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return code;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return code; 
	}

	public int getattempts(int uID){
		Connection connection = null;
		PreparedStatement statement = null;
		int attempts = 0;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM EmailConfirmation WHERE (uID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				attempts = rs.getInt("attempts");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return attempts;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return attempts; 
	}
	
	// Publication table //////////////////////////////////////////////////////////////
	public void createPublication(String title, int year, int volume, float price, String pic){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `Publications` "
					+ "(`pID`, `title`, `year`, `volume`, `price, `picture`) "
					+ "VALUES(?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, maxpID()+1);
			statement.setString(2, title);
			statement.setInt(3, year);
			statement.setInt(4, volume);
			statement.setFloat(5, 0);
			statement.setString(6, pic);
		
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public int getpID(String title){
		Connection connection = null;
		PreparedStatement statement = null;
		int pID = 0;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM Publications WHERE (title = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, pID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				pID = rs.getInt("pID");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return pID;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return pID;
	}
	
	public String gettitle(int pID){
		Connection connection = null;
		PreparedStatement statement = null;
		String title = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM Publications WHERE (pID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, pID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				title = rs.getString("title");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return title;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return title; 
	}
	
	public int getYear(int pID){
		Connection connection = null;
		PreparedStatement statement = null;
		int year = 0;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM Publications WHERE (pID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, pID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				year = rs.getInt("year");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return year;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return year;
	}
	
	public int getVolume(int pID){
		Connection connection = null;
		PreparedStatement statement = null;
		int volume = 0;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM Publications WHERE (pID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, pID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				volume = rs.getInt("volume");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return volume;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return volume;
	}
	
	public float getPrice(int pID){
		Connection connection = null;
		PreparedStatement statement = null;
		float price = 0;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM Publications WHERE (pID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, pID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				price = rs.getFloat("price");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return price;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return price;
	}
	
	public String getPic(int pID){
		Connection connection = null;
		PreparedStatement statement = null;
		String pic = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM Publications WHERE (pID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, pID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				pic = rs.getString("picture");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return pic;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return pic;
	}
	
	
	// USER registered publication table ///////////////////////////////////////////////// 
	public void createRegisteredPublication(int uID, int pID, Date timeStamp, int visible){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `userRegisteredPublication` "
					+ "(`uID`, `pID`, `timeStamp`, `visible`) "
					+ "VALUES(?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.setInt(2, pID);
			statement.setDate(3, (java.sql.Date) timeStamp);
			statement.setInt(4, visible);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public int getRPuID(int pID){
		
	}
	
	public int getRPpID(int uID){
		
	}
	
	public Date getRPtimeStamp(int uID){
		
	}
	
	public int getRPvisible(){
		
	}
	
	// USER bought publication table //////////////////////////////////////////////////
	public void createBoughtPublication(int uID, int pID, Date timeStamp){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `userBoughtPublication` "
					+ "(`uID`, `pID`, `timeStamp`) "
					+ "VALUES(?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.setInt(2, pID);
			statement.setDate(3, (java.sql.Date) timeStamp);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	// Ban publication table /////////////////////////////////////////////////////////
	public void addBanPublication(int uID, int pID, String reason, Date timeStamp){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `BanPublication` "
					+ "(`uID`, `BanPID`, `Reason`, `timeStamp`) "
					+ "VALUES(?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.setInt(2, pID);
			statement.setString(3, reason);
			statement.setDate(4, (java.sql.Date) timeStamp);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	// User Ban table ////////////////////////////////////////////////////////////////
	public void addBanUser(int uID, int BanUID,String Reason, Date timeStamp){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `UserBan` "
					+ "(`uID`, `BanUID`, `Reason`, `timeStamp`) "
					+ "VALUES(?,?,?,?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.setInt(2, BanUID);
			statement.setString(3, Reason);
			statement.setDate(4, (java.sql.Date) timeStamp);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	// Authors table ////////////////////////////////////////////////////////////////
	public void createAuthor(String name){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `authors` "
					+ "(`aID`, `name`) "
					+ "VALUES(?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, maxaID()+1);
			statement.setString(2, name);

			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public String getAuthorName(int aID){
		Connection connection = null;
		PreparedStatement statement = null;
		String name = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM authors WHERE (aID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, aID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				name = rs.getString("name");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return name;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return name;
	}
	
	// Authors publication table /////////////////////////////////////////////////////
	public void addAuthorPublication(int aID, int pID){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `authorPublication` "
					+ "(`aID`, `pID`) "
					+ "VALUES(?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, aID);
			statement.setInt(2, pID);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	// TODO
	
	// Editors table ////////////////////////////////////////////////////////////////
	public void createEditors(String name){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `editors` "
					+ "(`eID`, `name`) "
					+ "VALUES(?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, maxeID()+1);
			statement.setString(2, name);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public String getEditorName(int eID){
		Connection connection = null;
		PreparedStatement statement = null;
		String name = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM editors WHERE (eID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, eID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				name = rs.getString("name");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return name;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return name;
	}
	
	// Editors publication table //////////////////////////////////////////////////////
	public void addEditorPublication(int eID, int pID){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `editorPublication` "
					+ "(`eID`, `pID`) "
					+ "VALUES(?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, eID);
			statement.setInt(2, pID);

			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	//TODO
	// Activity table /////////////////////////////////////////////////////////////////
	public void createActivity(String actName){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `activity` "
					+ "(`actID`, `actName`) "
					+ "VALUES(?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, maxactID()+1);
			statement.setString(2, actName);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public String getActName(int actID){
		Connection connection = null;
		PreparedStatement statement = null;
		String actName = null;
		
		try {
			//Register JDBC driver
			Class.forName(DRIVER);
			
			//open connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			
			//Execute a query
			
			String query = "SELECT * FROM activity WHERE (actID = ?)";
	
			statement = connection.prepareStatement(query);
			statement.setInt(1, actID);
			statement.executeQuery();
			
			ResultSet rs = statement.getResultSet();
	
			  //Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				actName = rs.getString("actName");
		
			}
			
			//Clean-up environment
			rs.close();
			statement.close();
			connection.close();	
			
			return actName;
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(connection!=null)
			      connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 				
		return actName;
	}
	
	// User Activity table /////////////////////////////////////////////////////////////
	public void addUserActivity(int uID, int pID, int actID, Date timeStamp){
		Connection connection = null;
		
		try{
			// register JDBC driver
			Class.forName(DRIVER);
			
			// open Connection
			connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			// Execute query
			String query;
			query = "INSERT INTO `User` "
					+ "(`uID`, `pID`, `actID`, `timeStamp`) "
					+ "VALUES(?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, uID);
			statement.setInt(2, pID);
			statement.setInt(3, actID);
			statement.setDate(4, (java.sql.Date) timeStamp);
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		}catch (SQLException se) {
			  //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally {		 
			  try {
			     if(connection != null)
			        connection.close();
			  } catch (SQLException se) {
			     se.printStackTrace();
			  } 
		}
	}
	
	public sth getUserActivity(){
		
	}
	
	// other //////////////////////////////////////////////////////
	public int maxUsersID() {
		Connection conn = null;
		PreparedStatement stmt = null;
		int uID = 0;
		//String bookName = null;
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//
			conn = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			//Execute a query		
			String sql = "SELECT MAX(uID) AS Size FROM User";
	
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				uID = rs.getInt("Size");
				//System.out.println(rs.getInt("Size"));
			}
			
			//Clean-up environment
			stmt.close();
			conn.close();	
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(conn!=null)
			      conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 
		
		return uID;
	}

	public int maxpID() {
		Connection conn = null;
		PreparedStatement stmt = null;
		int pID = 0;
		//String bookName = null;
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//
			conn = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			//Execute a query	
			String sql = "SELECT MAX(pID) AS Size FROM publications";
	
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			//stmt.getFetchSize()
			while (rs.next()) {
				pID = rs.getInt("Size");
			}
			
			
			// Clean-up environment
			stmt.close();
			conn.close();	
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(conn!=null)
			      conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		}
		
		return pID;
	}

	public int maxaID(){
		Connection conn = null;
		PreparedStatement stmt = null;
		int aID = 0;
		//String bookName = null;
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//
			conn = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			//Execute a query		
			String sql = "SELECT MAX(aID) AS Size FROM authors";
	
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				aID = rs.getInt("Size");
			}
			
			//Clean-up environment
			stmt.close();
			conn.close();	
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(conn!=null)
			      conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 
		
		return aID;		
	}
	
	public int maxeID(){
		Connection conn = null;
		PreparedStatement stmt = null;
		int eID = 0;
		//String bookName = null;
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//
			conn = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			//Execute a query		
			String sql = "SELECT MAX(eID) AS Size FROM editors";
	
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				eID = rs.getInt("Size");
			}
			
			//Clean-up environment
			stmt.close();
			conn.close();	
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(conn!=null)
			      conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 
		
		return eID;
	}
	
	public int maxactID(){
		Connection conn = null;
		PreparedStatement stmt = null;
		int actID = 0;
		//String bookName = null;
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//
			conn = (Connection) DriverManager.getConnection(URL,USER,PASS);
			
			//Execute a query		
			String sql = "SELECT MAX(actID) AS Size FROM activity";
	
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while (rs.next()) {
				actID = rs.getInt("Size");
			}
			
			//Clean-up environment
			stmt.close();
			conn.close();	
			
		} catch (SQLException se) {
			//Handle errors for JDBC
			    se.printStackTrace();
		} catch (Exception e) {
		    //Handle errors for Class.forName
		    e.printStackTrace();
		} finally {
			try {
			   if(conn!=null)
			      conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		} 
		
		return actID;
	}
}

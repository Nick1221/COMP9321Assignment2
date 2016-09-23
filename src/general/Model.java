package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

// and make it so its easier for models to extend it
public class Model {
	
	protected String table = "";

	protected String primary_key = "id";
	
	private HashMap<String,Object> column_to_data = null;
	
	protected HashMap<String,String> column_to_cast = null;
	
	public Model () {
		this.column_to_data = new HashMap<String,Object>();
		this.column_to_cast = new HashMap<String,String>();
	}
	
	// find the user based on his id
	// return null if user couldn't be found
	public Object findById(int id) {
		return this.findByKey("id", id);
	}
	
	public Object find(Object o) {
		return this.findByKey(this.primary_key, o); 
	}
	
	public Object findByKey(String key, Object value) {
		// TODO : Test and do something better when there is an exception
	    String query = "select * " +
	                   "from " + DatabaseConnection.DATABASE_NAME + "." + this.table +
	                   "where" + key + " = " + value.toString();
	    
	    DatabaseConnection dbc = null;
	    
	    try {
	    	 dbc = new DatabaseConnection();
	    	
	    	 ResultSet rs = dbc.executeQuery(query);
	    	 
	    	 if (rs.first())
	    		 this.updateData(dbc.executeQuery(query));
	    	 else
	    		 return null; // no data in result
	    } catch (SQLException e ) {
	        e.printStackTrace();
	    } finally {
	        if (dbc.hasActiveStatement()) { 
	        	try {
					dbc.closeStatement();
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO throw error 500
				}
	        } else {
	        	return null; // something went horribly wrong...
	        }
	    }
	    return this;
	}
	
	//	TODO: public Object create();
	
	// returns the object that has been deleted
	public Object delete() {
		// TODO : test and exception handling
		String query = "delete " +
                "from " + DatabaseConnection.DATABASE_NAME + "." + this.table +
                "where" + this.primary_key + " = " + this.column_to_data.get(this.primary_key);
		
		DatabaseConnection dbc = null;
		try {
		 	 dbc = new DatabaseConnection();
		 	
		 	 dbc.executeQuery(query);

		} catch (SQLException e ) {
		     e.printStackTrace();
		} finally {
		    if (dbc.hasActiveStatement()) { 
		     	try {
					dbc.closeStatement();
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO throw error 500
				}
			} else {
				return null; // something went horribly wrong...
			}
		}
		
		return this;
	}
	
	public Object get(String column_name) {
		return this.column_to_data.get(column_name);
	}
	
	public void set(String column_name, Object column_value) {
		this.column_to_data.put(column_name, column_value);
	}
	
	public Object save() {
		// TODO: save all the data to the database
		return null;
	};
	
	private void updateData(ResultSet rs) {
		try {
			while (rs.next()) {
				// Set the data based on column name
				ResultSetMetaData rsmd = rs.getMetaData();
				for(int i = 0; i < rsmd.getColumnCount(); i++)
					this.set(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnLabel(i)));
			}
		} catch (SQLException e) {
			// TODO throw error 500
			e.printStackTrace();
		}	
	}
	
	private void testDataTypes() {
		List<Object> data = new ArrayList<Object>();
		data.add("test"); // String
		data.add(1); // Integer
		data.add(true); // Boolean
		data.add(1.22); // Double
		data.add(new Date()); // Date
		
		for(Object o : data)
			System.out.println(o.getClass().getSimpleName());
	}
	
	public static void main (String[] args) {
		Model m = new Model();
		m.testDataTypes();
	}
}

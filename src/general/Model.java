package general;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// and make it so its easier for models to extend it
public class Model<E> {
	
	private Class<E> typeArgumentClass;
	
	protected String table = "";
	
	protected String primary_key = "id";
	
	private HashMap<String,Object> column_to_data = null;
	
	protected HashMap<String,String> column_to_cast = null;
	
	public Model (Class<E> typeArgumentClass) {
		this.typeArgumentClass = typeArgumentClass;
		this.column_to_data = new HashMap<String,Object>();
		this.column_to_cast = new HashMap<String,String>();
	}
	
	public String getTable() {
		return this.table;
	}
	
	// find the user based on his id
	// return null if user couldn't be found
	public E findById(int id) {
		return this.findByKey("id", id);
	}
	
	public E find(Object o) {
		return this.findByKey(this.primary_key, o); 
	}
	
	public E findByKey(String key, Object value) {
		// Search by key
		
		List<E> m = this.searchByKey(key, value);
		
	    return m == null || m.isEmpty()? null : m.get(0); // return null if nothing found2 or the first item in search results
	}
	
	public List<E> searchByKey(String key, Object value) {
	    String query = "select * " + 
	                   "from " + this.table +
	                   " where " + key + " = '" + value.toString() + "'";
	    
	    List<E> ret = new LinkedList<E>();
	    
	    DBConnection dbc = null;
	    
	    try {
	    	 dbc = new DBConnection();
	    	 
	    	 ResultSet rs = dbc.executeQuery(query);
	    	 
	    	 if (rs.first()) { // check if it is empty or not
	    		 rs.beforeFirst();
	    		 while (rs.next()) {
	    			 Object[] args = new Object[]{rs};
	    			 Constructor<?> temp = null;
	    			 for(Constructor<?> c : typeArgumentClass.getDeclaredConstructors()) {
	    				 if (c.getParameterCount() == 1) {
	    					 temp = c;
	    				 }
	    			 }
	    			 ret.add((E) temp.newInstance(args));
	    		 }
	    	 }
	    } catch (SQLException e ) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
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
		return ret;
	}
	
	public E create(HashMap<String,Object> data) {
		this.column_to_data = data;
		String query = "INSERT INTO `" + this.table + "` (";
		for(String key : column_to_data.keySet()) {
			query += "`" + key + "`,";
		}
		query = query.substring(0,query.length()-1);
		query += ") VALUES (";
		for(Object value : column_to_data.values()) {
			query += "'" + value.toString() + "',";
		}
		query = query.substring(0,query.length()-1);
		query += ")";
		DBConnection dbc = null;
		try {
		 	 dbc = new DBConnection();
		 	
		 	 dbc.executeUpdateQuery(query);

		} catch (SQLException e ) {
		     e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return (E)this;
	}
	
	// returns the object that has been deleted
	public E delete() {
		// TODO : test and exception handling
		String query = "delete " +
                "from " + DBConnection.DATABASE_NAME + "." + this.table +
                "where" + this.primary_key + " = " + this.column_to_data.get(this.primary_key);
		
		DBConnection dbc = null;
		try {
		 	 dbc = new DBConnection();
		 	
		 	 dbc.executeQuery(query);

		} catch (SQLException e ) {
		     e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		
		return (E)this;
	}
	
	public Object get(String column_name) {
		return this.column_to_data.get(column_name);
	}
	
	public void set(String column_name, Object column_value) {
		this.column_to_data.put(column_name, column_value);
	}
	
	public E save() {
		// TODO: save all the data to the database
		String query = "UPDATE `" + this.table + "`" +
						" SET";
		for(String col : column_to_data.keySet()) {
			if (column_to_cast.containsKey(col)) {
				String temp = column_to_data.get(col).toString() == "true"?"1" : column_to_data.get(col).toString() == "false"? "0" : column_to_data.get(col).toString();
				query += " " + col + " = \"" + temp + "\",";
			} else {
				query += " " + col + " = \"" + column_to_data.get(col) + "\",";
			}
		}
		query = query.substring(0, query.length()-1);
		
		query += " WHERE " + this.primary_key + " = " + this.get(this.primary_key);
		
		DBConnection dbc = null;
		try {
		 	 dbc = new DBConnection();
		 	
		 	 dbc.executeUpdateQuery(query);

		} catch (SQLException e ) {
		     e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return (E)this;
	};
	
	public E updateData(HashMap<String, Object> data) {
		for(String key : data.keySet())
			this.set(key, data.get(key));
		return (E)this;
	}
	
	public E updateData(ResultSet rs) {
		try {
			// Set the data based on column name
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for(int i = 1; i < rsmd.getColumnCount(); i++) {
				this.set(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnLabel(i)));
			}
		} catch (SQLException e) {
			// TODO throw error 500
			e.printStackTrace();
		}
		return (E)this;
	}
	
	public List<E> hasMany(String connection_table, String key_column, Class<E> c) {
		// TODO : find all the id of the connected Model using the connection_table
		return null;
	}
	
	public E hasOne(String connection_table, Class<E> c, String key_column) {
		List<E> m = this.hasMany(connection_table, key_column, c);
	    return m == null || m.isEmpty()? null : m.get(0); // return null if nothing found2 or the first item in search
	}
	
	public E addRelatedItem(String connection_table, String key_column, Class<E> c, HashMap<String, Object> data) {
		// TODO
		
		// 1. Create a new item
		
//		Object[] args = new Object[]{};
//		Constructor<?> temp = null;
//		for(Constructor<?> c : typeArgumentClass.getDeclaredConstructors()) {
//			 if (c.getParameterCount() == 1) {
//				 temp = c;
//			 }
//		 }
//		 ret.add((E) temp.newInstance(args));
		
//		Class<E> new_c = c.getConstructor()
				
		// 2. Link the two items
		
		// 3. Return ???
		
		return null;
	}
}

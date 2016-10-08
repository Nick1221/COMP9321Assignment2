package general;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
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

    public List<E> searchByKeys(HashMap<String,Object> key_value, boolean exactMatch) {
        String query = "select * " + 
                "from " + this.table +
                " where";
        
        for(String k : key_value.keySet()) {
            query += " " + k +
                    (exactMatch? " = ":" LIKE ") +
                    "'" + key_value.get(k).toString() + "' AND";
        }
        query = query.substring(0,query.length()-4); // remove last and

        List<E> ret = new LinkedList<E>();

        DBConnection dbc = null;

        try {
            dbc = new DBConnection();

            ResultSet rs = dbc.executeQuery(query);
            rs.last();
            System.out.println(rs.getRow());
            if (rs.first()) { // check if it is empty or not
                rs.beforeFirst();
                while (rs.next()) {
                    // Hacky but works....
                    Object[] args = new Object[]{rs};
                    Constructor<?> temp = null;
                    for(Constructor<?> c : typeArgumentClass.getDeclaredConstructors()) {
                        if (c.getParameterCount() == 1) {
                            for(Class<?> arg : c.getParameterTypes()) {
                                if (arg.equals(ResultSet.class))
                                    temp = c;
                            }
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
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            if (dbc.hasActiveStatement()) { 
                try {
                    dbc.closeStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                return null; // something went horribly wrong...
            }
        }
        return ret;
    }
    
    public List<E> searchByKey(String key, Object value, boolean exactMatch) {
        HashMap<String,Object> hash = new HashMap<String,Object>();
        hash.put(key, value);
        return this.searchByKeys(hash, exactMatch);
    }

    public List<E> searchByKey(String key, Object value) {
        return this.searchByKey(key,value,true);
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
                }
            } else {
                return null; // something went horribly wrong...
            }
        }
        return (E)this;
    }

    // returns the object that has been deleted
    public E delete(String table, String key, Object value) {
        String query = "delete " +
                "from " + table +
                " where " + key + " = " + value;

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
        String query = "UPDATE `" + this.table + "`" +
                " SET";
        for(String col : column_to_data.keySet()) {
            if (column_to_cast.containsKey(col) || column_to_data.get(col).toString().equals("true") || column_to_data.get(col).toString().equals("false")) {
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
            e.printStackTrace();
        }
        return (E)this;
    }

    public String getPrimaryKey() {
        return this.get(this.primary_key).toString();
    }

    // connection_table -- in between table
    // key_column -- column of key to use
    // connected_class -- class to return
    public List<DataHolder> hasMany(String connection_table, String connection_column, String connection_key_column, String connection_key_value, String connected_table, String connected_column) {

        String query = "SELECT * " + 
                "FROM " + connection_table + " JOIN " + connected_table +
                " ON " + connection_table+"."+connection_column+"="+connected_table+"."+connected_column+
                " WHERE " + connection_key_column + " = " + connection_key_value;

        DBConnection dbc = null;
        List<DataHolder> ret = new LinkedList<DataHolder>();
        try {
            dbc = new DBConnection();

            ResultSet rs = dbc.executeQuery(query);

            while (rs.next()) {
                ret.add(new DataHolder(rs));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            if (dbc.hasActiveStatement()) { 
                try {
                    dbc.closeStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                return null; // something went horribly wrong...
            }
        }
        return ret;
    }

    public DataHolder hasOne(String connection_table, String connection_column, String connection_key_column, String connection_key_value, String connected_table, String connected_column) {
        List<DataHolder> m = this.hasMany(connection_table,connection_column,connection_key_column,connection_key_value, connected_table,connected_column);
        return (m == null || m.isEmpty())? null : m.get(0); // return null if nothing found or the first item in search
    }
}

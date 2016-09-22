package general;

public interface Model {
	public static final String table = "";
	
	public Object findById(int id);
	
	//	TODO: public Object create();		
	//	TODO: public Object delete();
	
	// TODO: public Object get(String data_name);
	// TODO: public Object set(String data_name, Object data_value);
	
	public Object save();
	
//	Not sure if needed : public Object findByAttribute(String attribute,Object value);
}

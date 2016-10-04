package ban;

import java.sql.ResultSet;
import java.util.HashMap;

import general.Model;

public class Ban extends Model<Ban> {	
	public static final String PRIMARY_KEY = "bID";
	
	public Ban(String table) {
		super(Ban.class);
		this.table = table;
	}
	
	// 
	public Ban(ResultSet rs) {
		super(Ban.class);
		this.primary_key = Ban.PRIMARY_KEY;
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public Ban(HashMap<String,Object> data) {
		super(Ban.class);
		this.primary_key = Ban.PRIMARY_KEY;
		this.updateData(data);
	}
}
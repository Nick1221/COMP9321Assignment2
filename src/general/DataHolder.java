package general;

import java.sql.ResultSet;
import java.util.HashMap;

import general.DataHolder;

public class DataHolder extends Model<DataHolder> {
	public DataHolder() {
		super(DataHolder.class);
	}
	
	// 
	public DataHolder(ResultSet rs) {
		super(DataHolder.class);
		this.updateData(rs);
	}
	
	// Creates a new DataHolder -- THIS DOES NOT SAVE THE NEW DataHolder"S INFORMATION TO DATABASE
	public DataHolder(HashMap<String,Object> data) {
		super(DataHolder.class);
		this.updateData(data);
	}
	
}

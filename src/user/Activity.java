package user;

import java.sql.ResultSet;
import java.util.HashMap;

import general.Model;

public class Activity extends Model<Activity> {
	private static final String TABLE_NAME = "activity";
	public Activity() {
		super(Activity.class);
		this.table = Activity.TABLE_NAME;
	}
	
	// 
	public Activity(ResultSet rs) {
		super(Activity.class);
		this.table = Activity.TABLE_NAME;
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public Activity(HashMap<String,Object> data) {
		super(Activity.class);
		this.table = Activity.TABLE_NAME;
		this.updateData(data);
	}
}

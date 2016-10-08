package user;

import java.sql.ResultSet;
import java.util.HashMap;

import general.Model;

public class UserRegisteredPublication extends Model<UserRegisteredPublication> {
	public static final String TABLE_NAME = "userRegisteredPublication";
	public static final String TABLE_PRIMARY_KEY = "pID";
	
	public UserRegisteredPublication() {
		super(UserRegisteredPublication.class);
		this.table = UserRegisteredPublication.TABLE_NAME;
		this.primary_key = UserRegisteredPublication.TABLE_PRIMARY_KEY;
	}
	
	// 
	public UserRegisteredPublication(ResultSet rs) {
		super(UserRegisteredPublication.class);
		this.table = UserRegisteredPublication.TABLE_NAME;
		this.updateData(rs);
		this.primary_key = UserRegisteredPublication.TABLE_PRIMARY_KEY;
	}
	
	// Creates a new UserRegisteredPublication -- THIS DOES NOT SAVE THE NEW UserRegisteredPublication"S INFORMATION TO DATABASE
	public UserRegisteredPublication(HashMap<String,Object> data) {
		super(UserRegisteredPublication.class);
		this.table = UserRegisteredPublication.TABLE_NAME;
		this.updateData(data);
		this.primary_key = UserRegisteredPublication.TABLE_PRIMARY_KEY;
	}
}

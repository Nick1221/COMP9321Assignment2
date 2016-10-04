package user;

import java.sql.ResultSet;
import java.util.HashMap;

import general.Model;

public class UserBoughtPublication extends Model<UserBoughtPublication> {
	public static final String TABLE_NAME = "UserBoughtPublication";
	
	public UserBoughtPublication() {
		super(UserBoughtPublication.class);
		this.table = UserBoughtPublication.TABLE_NAME;
	}
	
	// 
	public UserBoughtPublication(ResultSet rs) {
		super(UserBoughtPublication.class);
		this.table = UserBoughtPublication.TABLE_NAME;
		this.updateData(rs);
	}
	
	// Creates a new UserBoughtPublication -- THIS DOES NOT SAVE THE NEW UserBoughtPublication"S INFORMATION TO DATABASE
	public UserBoughtPublication(HashMap<String,Object> data) {
		super(UserBoughtPublication.class);
		this.table = UserBoughtPublication.TABLE_NAME;
		this.updateData(data);
	}
}
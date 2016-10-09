package user;

import java.sql.ResultSet;
import java.util.HashMap;

import general.Model;
import publication.*;

public class UserActivity extends Model<UserActivity> {
	public static final String TABLE_NAME = "userActivity";
	
	public UserActivity() {
		super(UserActivity.class);
		this.table = UserActivity.TABLE_NAME;
	}
	
	// 
	public UserActivity(ResultSet rs) {
		super(UserActivity.class);
		this.table = UserActivity.TABLE_NAME;
		this.updateData(rs);
	}
	
	// Creates a new UserActivity -- THIS DOES NOT SAVE THE NEW UserActivity"S INFORMATION TO DATABASE
	public UserActivity(HashMap<String,Object> data) {
		super(UserActivity.class);
		this.table = User.TABLE_NAME;
		this.updateData(data);
	}

	public Publication getPublication() {
        return new Publication().findByKey("pID",this.get("pID"));
    }
}

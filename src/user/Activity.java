package user;

import java.sql.ResultSet;
import java.util.List;

import general.Model;

public class Activity extends Model<Activity> {

	public Activity() {
		super(Activity.class);
	}
	
	public Activity(ResultSet rs) {
		super(Activity.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.updateData(rs);
	}

	private static String table = "activity";
	
	// returns the users that performed this activity
	public List<User> getUsers() {
		return null;
	}
}

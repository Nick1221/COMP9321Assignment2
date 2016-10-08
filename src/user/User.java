package user;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import general.BanableModel;
import general.DataHolder;
import publication.Publication;

public class User extends BanableModel<User> {
	public static final String TABLE_NAME = "user";
	public static final String BAN_TABLE = "UserBan";
	public static final String BAN_TABLE_KEY = "banUID";
	public static final String TABLE_PRIMARY_KEY = "uID";
	
	public User() {
		super(User.class,User.BAN_TABLE,User.BAN_TABLE_KEY);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.table = User.TABLE_NAME;
		this.column_to_cast.put("confirmedEmail", "boolean");
	}
	
	// 
	public User(ResultSet rs) {
		super(User.class,User.BAN_TABLE,User.BAN_TABLE_KEY);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.table = User.TABLE_NAME;
		this.column_to_cast.put("confirmedEmail", "boolean");
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public User(HashMap<String,Object> data) {
		super(User.class,User.BAN_TABLE,User.BAN_TABLE_KEY);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.table = User.TABLE_NAME;
		this.updateData(data);
	}
	
	public void registerPublication(Publication p) {
		 HashMap<String,Object> temp = new HashMap<String,Object>();
	        
	        temp.put("uID", this.get("uID"));
	        temp.put("pID", p.get("pID"));
	        temp.put("isVisible", "1");
	        temp.put("timeStamp", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	        new UserRegisteredPublication().create(temp);
	}
	
	public List<DataHolder> getRegisteredPublications() {
		return this.hasMany("userRegisteredPublication", "pID","uID",this.get(this.primary_key).toString(),"Publications","pID");
	}
	
	@Override
	public User findById(int id) {
        return this.findByKey("uID", id);
    }
	
	public void buyPublication(Publication p) {
		HashMap<String,Object> temp = new HashMap<String,Object>();
		temp.put("uID", this.get("uID"));
		temp.put("pID", p.get("pID"));
		new UserRegisteredPublication().create(temp);
	}
	
	public List<DataHolder> getBoughtPublications() {
		return this.hasMany("userBoughtPublication", "pID","uID",this.get(this.primary_key).toString(),"Publications","pID");
	}
	
	public void addActivity(String activity_title, Publication p) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("uID", this.get("uID"));
		data.put("pID",p.get("pID"));
		data.put("activity", activity_title);
		data.put("timeStamp", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		new UserActivity().create(data);
	}
	
	public List<DataHolder> getActivity() {
		return this.hasMany("userActivity", "aID","uID",this.get(this.primary_key).toString(),"activity","actID");
	}
	
	// attempts to validate the email
	// returns true if email is valid else returns false
	public boolean attemptEmailConfirmation(String code) {
		if (this.get("code").equals(code)) {
			this.set("confirmedEmail", "1");
			this.save();
		}
		return (boolean)this.get("confirmedEmail");
	}
	
	public boolean isAdmin() {
		return this.get("isAdmin").equals("1");
	}
	
	public boolean attemptLogin(String password) {
		return this.get("password").equals(password);
	}
	
	
	// TESTING - DEBUG
	public static void main(String[] args) {
		System.out.println("-- Starting User tests --");
		
		// returns a list of all the users which qualify for this key - value pair
		List<User> users = new User().searchByKey("1",1);
		for(User u : users) {
			System.out.println(u.get("Username"));
		}
		System.out.println(users.size());
		
		// returns the first user who has the username : "publific"
		User u = new User().findByKey("Username", "publific");
		System.out.println(u.get("Username"));
		
		u.set("Username", "MyAwesome");// change the Username
		u.set("isAdmin", "1");
		u.save(); // save it to database -- Needed otherwise only this specific user instance will have the change
		System.out.println("Is admin : " + u.isAdmin());
		System.out.println(u.get("Username")); // "MyAwesome"
		
		// REVERTING BACK USERNAME
		u.set("Username", "publific");// change the Username
		u.save();
		
		if (u.isBanned()) {
			u.unban();
			System.out.println("User Unbanned");
		} else {
			u.ban();
			System.out.println("User banned");
		}
		
		List<DataHolder> a = u.getActivity();
		System.out.println("User activity size : " + a.size());
		
		System.out.println("-- Ending User tests --");
	}
}

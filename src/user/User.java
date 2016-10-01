package user;

import java.sql.ResultSet;
import java.util.List;

import general.BanableModel;
import publication.Publication;

public class User extends BanableModel<User> {
	public static final String TABLE_NAME = "User";
	public static final String TABLE_PRIMARY_KEY = "uID";
	
	public User() {
		super(User.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.table = User.TABLE_NAME;
		this.column_to_cast.put("confirmedEmail", "boolean");
	}
	
	public User(ResultSet rs) {
		super(User.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.table = User.TABLE_NAME;
		this.column_to_cast.put("confirmedEmail", "boolean");
		this.updateData(rs);
	}
	
	public List<CreditCard> getCreditCards() {
		return null;
	}
	
	public List<Publication> getRegisteredPublications() {
		return null;
	}
	
	public List<Publication> getBoughtPublications() {
		return null;
	}
	
	public List<Activity> getActivity() {
		return null;
	}
	
	// attempts to validate the email
	// returns true if email is valid else returns false
	public boolean attemptEmailConfirmation(String code) {
		// TODO
		// get the email confirmation data
		// query : "select * from email_confirmations where user_id = " + this.id 
		
		// if both code match :
			// this.confirmed_email = true;
			// this.save();
		
		return (boolean)this.get("confirmed_email");
	}
	
	public boolean attemptLogin(String password) {
		// TODO : make sure the password is bcrypted first
		return this.get("password") == password;
	}
	
	public static void main(String[] args) {
		System.out.println("-- Starting User tests --");
		
		// get all users
		List<User> users = new User().searchByKey("1",1);
		for(User u : users) {
			System.out.println(u.get("Username"));
		}
		System.out.println(users.size());
		
		// get user named publific
		User u = new User().findByKey("Username", "publific");
		System.out.println(u.get("Username"));
		
		System.out.println("-- Ending User tests --");
	}
}

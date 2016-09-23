package user;

import java.util.List;

import general.Model;
import ban.Banable;

public class User extends Model {
	private static final String table = "users";
	
	private int id = -1; // auto-increments
	private String username;
	private String email;
	private String first_name;
	private String last_name;
	private String yob;
	private boolean confirmed_email;
	private String password;
	
	private boolean is_admin = false;
	
	private List<CreditCard> ccs;
	
	public User() {
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getFullName() {
		return this.first_name + " " + this.last_name;
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public String getYearOfBirth() {
		return this.yob;
	}
	
	public List<CreditCard> getCreditCards() {
		return this.ccs;
	}
	
	public boolean hasConfirmedEmail() {
		return this.confirmed_email;
	}
	
	public boolean isAdmin() {
		return this.is_admin;
	}
	
	public int getID() {
		return this.id;
	}
	
	public User setFirstName(String first_name) {
		this.first_name = first_name;
		return this;
	}

	public User setLastName(String last_name) {
		this.last_name = last_name;
		return this;
	}
	
	public User setYearOfBirth(String yob) {
		this.yob = yob;
		return this;
	}
	
	public User setEmail(String email) {
		// different email addresses
		if (!this.email.equals(email)) {
			this.email = email;
			this.confirmed_email = false;
			// TODO : update confirmation code
		}
		return this;
	}
	
	public User setConfirmedEmail(boolean b) {
		this.confirmed_email = b;
		return this;
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
		
		return this.confirmed_email;
	}
	
	@Override
	public User save() {
		// TODO : save all the user's data to database
		return this; 
	}
	
//	@Override
//	public User findByAttribute(String attribute, Object value) {
//		// TODO
//		// "select * from " + this.table + " where " + attribute + " = " + value;
//		// get the first item that comes back
//		return null;
//	}
	
	public boolean attemptLogin(String password) {
		return this.password == password;
	}
}

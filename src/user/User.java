package user;

import java.util.List;

import general.BanableModel;
import publication.Publication;

public class User extends BanableModel {
	private static final String table = "users";
	
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
		// make sure the password is bcrypted first
		return this.get("password") == password;
	}
}

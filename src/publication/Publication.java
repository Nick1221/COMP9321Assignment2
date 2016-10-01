package publication;

import java.util.List;

import general.BanableModel;
import user.User;

public class Publication extends BanableModel {
	private static final String table = "Publications";
	
	public Publication() {
		
	}
	
	// returns the user that added this publication
	public User getRegistrer() {
		// TODO
		return null;
	}
	
	// returns the list of users that bought the publication
	public List<User> getBoughtBy() {
		// TODO
		return null;
	}
	
	public List<Author> getAuthors() {
		// TODO
		return null;
	}
	
	public List<Editor> getEditors() {
		return null;
	}
}

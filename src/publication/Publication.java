package publication;

import java.sql.ResultSet;
import java.util.List;

import general.BanableModel;
import user.Activity;
import user.User;

public class Publication extends BanableModel<Publication> {
	private static final String table = "Publications";
	
	public Publication() {
		super(Publication.class);
	}
	
	public Publication(ResultSet rs) {
		super(Publication.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.updateData(rs);
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

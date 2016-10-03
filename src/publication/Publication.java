package publication;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import general.BanableModel;
import user.User;

@SuppressWarnings("unchecked")
public class Publication extends BanableModel<Publication> {
	private static final String TABLE_NAME = "Publications";
	private static final String BAN_TABLE = "BanPublication";
	private static final String PRIMARY_KEY = "pID";
	
	public Publication() {
		super(Publication.class,Publication.BAN_TABLE);
		this.table = Publication.TABLE_NAME;
		this.primary_key = Publication.PRIMARY_KEY;
	}
	
	// 
	public Publication(ResultSet rs) {
		super(Publication.class,Publication.BAN_TABLE);
		this.table = Publication.TABLE_NAME;
		this.primary_key = Publication.PRIMARY_KEY;
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public Publication(HashMap<String,Object> data) {
		super(Publication.class,Publication.BAN_TABLE);
		this.table = Publication.TABLE_NAME;
		this.primary_key = Publication.PRIMARY_KEY;
		this.updateData(data);
	}
	
	// returns the user that added this publication
	public User getRegistrer() {
		return (User) this.hasOne("userRegisteredPublication","pID", User.class);
	}
	
	// returns the list of users that bought the publication
	public List<User> getBoughtBy() {
		return (List<User>) this.hasMany("userBoughtPublication", "pID", User.class);
	}
	
	public List<Author> getAuthors() {
		return (List<Author>) this.hasMany("authorPublication", "pID", Author.class);
	}
	
	public List<Editor> getEditors() {
		return (List<Editor>) this.hasMany("editorPublication","pID", Editor.class);
	}
}

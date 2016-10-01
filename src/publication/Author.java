package publication;

import java.sql.ResultSet;
import java.util.List;

import general.Model;
import user.Activity;
import user.User;

public class Author extends Model<Author> {
	private static final String table = "authors";
	
	public Author() {
		super(Author.class);
	}
	
	public Author(ResultSet rs) {
		super(Author.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.updateData(rs);
	}
	
	public List<Publication> getPublications() {
		// TODO
		return null;
	}
	
	public List<Editor> getEditors() {
		// TODO
		return null;
	}
	
}

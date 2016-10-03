package publication;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import general.Model;

@SuppressWarnings("unchecked")
public class Author extends Model<Author> {
	private static final String TABLE_NAME = "authors";
	
	public Author() {
		super(Author.class);
		this.table = Author.TABLE_NAME;
	}
	
	// 
	public Author(ResultSet rs) {
		super(Author.class);
		this.table = Author.TABLE_NAME;
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public Author(HashMap<String,Object> data) {
		super(Author.class);
		this.table = Author.TABLE_NAME;
		this.updateData(data);
	}
	
	public List<Publication> getPublications() {
		return (List<Publication>) this.hasMany("authorPublication", "pID", Publication.class);
	}
}

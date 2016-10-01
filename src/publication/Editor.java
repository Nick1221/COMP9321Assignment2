package publication;

import java.sql.ResultSet;
import java.util.List;

import general.Model;
import user.Activity;
import user.User;

public class Editor extends Model<Editor> {
	private static final String table = "editors"; 
	
	public Editor() {
		super(Editor.class);
	}
	
	public Editor(ResultSet rs) {
		super(Editor.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.updateData(rs);
	}
	
	public List<Publication> getPublications() {
		// TODO
		return null;
	}
}

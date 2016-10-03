package publication;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import general.Model;

@SuppressWarnings("unchecked")
public class Editor extends Model<Editor> {
	private static final String TABLE_NAME = "editors"; 
	
	public Editor() {
		super(Editor.class);
		this.table = Editor.TABLE_NAME;
	}
	
	// 
	public Editor(ResultSet rs) {
		super(Editor.class);
		this.table = Editor.TABLE_NAME;
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public Editor(HashMap<String,Object> data) {
		super(Editor.class);
		this.table = Editor.TABLE_NAME;
		this.updateData(data);
	}
	
	public List<Publication> getPublications() {
		return (List<Publication>) this.hasMany("editorPublication", "eID", Publication.class);
	}
}

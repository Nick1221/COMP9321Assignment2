package publication;

import java.sql.ResultSet;
import java.util.HashMap;
import general.BanableModel;

public class Publication extends BanableModel<Publication> {
	private static final String TABLE_NAME = "publications";
	private static final String BAN_TABLE = "BanPublication";
	private static final String BAN_TABLE_KEY = "uID";
	private static final String PRIMARY_KEY = "pID";
	
	public Publication() {
		super(Publication.class,Publication.BAN_TABLE,Publication.BAN_TABLE_KEY);
		this.table = Publication.TABLE_NAME;
		this.primary_key = Publication.PRIMARY_KEY;
	}
	
	// 
	public Publication(ResultSet rs) {
		super(Publication.class,Publication.BAN_TABLE,Publication.BAN_TABLE_KEY);
		this.table = Publication.TABLE_NAME;
		this.primary_key = Publication.PRIMARY_KEY;
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public Publication(HashMap<String,Object> data) {
		super(Publication.class,Publication.BAN_TABLE,Publication.BAN_TABLE_KEY);
		this.table = Publication.TABLE_NAME;
		this.primary_key = Publication.PRIMARY_KEY;
		this.updateData(data);
	}
	@Override
	public Publication findById(int id) {
        return this.findByKey("pID", id);
    }
}

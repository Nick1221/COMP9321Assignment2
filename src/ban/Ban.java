package ban;

import java.sql.ResultSet;
import java.util.Date;

import general.Model;
import user.Activity;
import user.User;

public class Ban extends Model<Ban> {
	private String reason;
	private Date timestamp;
	private int admin_id;
	private int banned_id;
	private String item_table;
	
	public Ban() {
		super(Ban.class);
	}
	
	public Ban(ResultSet rs) {
		super(Ban.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.updateData(rs);
	}
	
	public Ban(String reason, Date timestamp, int admin_id,
			int banned_id, String banned_item_table) {
		super(Ban.class);
		this.reason = reason;
		this.admin_id = admin_id;
		this.timestamp = new Date();
		this.banned_id = banned_id;
		this.item_table = banned_item_table;
		this.timestamp = timestamp;
	}
	
	public String getReason() {
		return this.reason;
	}
	
	public Date getDate() {
		return this.timestamp;
	}
	
	public int getAdminId() {
		return this.admin_id;
	}
	
	public int getBannedItemId() {
		return this.banned_id;
	}
	
	public String getBannedItemTable() {
		return this.item_table;
	}
	
	public Ban setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public Ban setAdminId(int id) {
		this.admin_id = id;
		return this;
	}
	
	public Ban setBannedItemId(int id) {
		this.banned_id = id;
		return this;
	}
	
	public Ban setBannedItemTable(String table) {
		this.item_table = table;
		return this;
	}
	public Ban findById(int id) {
		// TODO Auto-generated method stub
		return this;
	}

	public Ban save() {
		// TODO Auto-generated method stub
		// update timestamp
		return this;
	}
}

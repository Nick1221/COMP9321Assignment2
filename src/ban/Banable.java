package ban;

public class Banable {
	private Ban ban = null;
	
	protected void loadBan(int id, String table) {
		// TODO
		// check if a ban exist for item in table
		// db_query : 
		
		// if a ban exists :
			// ban = new Ban(reason,date,admin_id);
	}
	
	public boolean isBanned() {
		return this.ban != null;
	}
	
	public String getBannedReason() {
		return this.ban == null? "" : "";
	}
}

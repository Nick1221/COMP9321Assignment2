package ban;

public interface Banable {
	public Ban ban = null;
	
	public String ban_table = "bans";
	
	public void findBan(int id);
	
	public boolean isBanned();
	
	public String getBannedReason();
	
	public void ban();
	
	public void unban();
}

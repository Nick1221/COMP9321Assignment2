package ban;

public interface Banable {
	public Ban ban = null;
	
	public boolean isBanned();
	
	public void ban();
	
	public void unban();
}

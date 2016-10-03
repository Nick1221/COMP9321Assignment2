package general;

import ban.Ban;
import ban.Banable;

public class BanableModel<E> extends Model<E> implements Banable {
	private Ban ban = null;
	private String ban_table;
	
	public BanableModel(Class<E> c, String ban_table) {
		super(c);
		this.ban_table = ban_table;
	}
	
	@Override
	public boolean isBanned() {
		return this.ban != null;
	}
	
	@Override
	public String getBannedReason() {
		return this.ban.getReason();
	}

	@Override
	public void findBan(int id) {
		
	}

	@Override
	public void ban() {
		// TODO
	}

	@Override
	public void unban() {
		// TODO Auto-generated method stub
	}
}

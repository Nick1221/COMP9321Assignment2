package general;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import ban.Ban;
import ban.Banable;

public class BanableModel<E> extends Model<E> implements Banable {
	private Ban ban = null;
	private String ban_table;
	private String ban_table_key;
	
	public BanableModel(Class<E> c, String ban_table, String ban_table_key) {
		super(c);
		this.ban_table = ban_table;
		this.ban_table_key = ban_table_key;
	}
	
	@Override
	public boolean isBanned() {
		this.findBan();
		return this.ban != null;
	}

	private void findBan() {
		String id = this.get(this.primary_key).toString();
		Ban temp = new Ban(ban_table).findByKey(ban_table_key, id);
		if (temp != null) ban = temp;
	}

	@Override
	public void ban() {
		HashMap<String,Object> data = new HashMap<String,Object>();
		data.put(this.ban_table_key,this.get(this.primary_key));
		data.put(this.primary_key, this.get(this.primary_key));
		data.put("reason","Banned");
		data.put("timeStamp", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		this.ban = new Ban(ban_table).create(data);
	}

	@Override
	public void unban() {
		this.ban.delete(this.ban_table, this.ban_table_key,this.get(this.primary_key));
	}
}

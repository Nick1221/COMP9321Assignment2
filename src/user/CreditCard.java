package user;

import java.sql.ResultSet;

import general.Model;

public class CreditCard extends Model<CreditCard> {
	private static final String table = "userCreditCard";
	
	public CreditCard() {
		super(CreditCard.class);
	}
	
	public CreditCard(ResultSet rs) {
		super(CreditCard.class);
		this.primary_key = User.TABLE_PRIMARY_KEY;
		this.updateData(rs);
	}
	
	public User getUser() {
		return null;
	}
}

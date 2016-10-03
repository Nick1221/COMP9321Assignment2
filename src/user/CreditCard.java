package user;

import java.sql.ResultSet;
import java.util.HashMap;

import general.Model;

public class CreditCard extends Model<CreditCard> {
	private static final String TABLE_NAME = "userCreditCard";
	
	public CreditCard() {
		super(CreditCard.class);
		this.table = CreditCard.TABLE_NAME;
	}
	
	// 
	public CreditCard(ResultSet rs) {
		super(CreditCard.class);
		this.table = CreditCard.TABLE_NAME;
		this.updateData(rs);
	}
	
	// Creates a new User -- THIS DOES NOT SAVE THE NEW USER"S INFORMATION TO DATABASE
	public CreditCard(HashMap<String,Object> data) {
		super(CreditCard.class);
		this.table = CreditCard.TABLE_NAME;
		this.updateData(data);
	}
	
	public User getUser() {
		return new User().findByKey("uID", this.get("uID"));
	}
}

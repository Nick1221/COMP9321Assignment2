package user;

import general.Model;

public class CreditCard implements Model {
	private static final String table = "credit_cards";
	
	private int user_id;
	private String number;
	
	public CreditCard(int user_id, String number) {
		this.user_id = user_id;
		this.number = number;
		this.save();
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public int getUserId() {
		return this.user_id;
	}
	
	public CreditCard setNumber(String number) {
		this.number = number;
		return this;
	}
	
	public CreditCard save() {
		// TODO : save the credit card's model data to database
		return this;
	}
	
	public CreditCard findById(int id) {
		// TODO
		// "select * from " + this.table + " where id = " id;
		// if something is found :
			// update the data
		return this;
	}
}

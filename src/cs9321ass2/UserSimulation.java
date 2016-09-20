package cs9321ass2;

import java.util.*;

public class UserSimulation 
{
	private String username;
	private String password;
	private String email;
	private List<Publication> myRegisteredPublications;
	
	public UserSimulation(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		myRegisteredPublications = new LinkedList<Publication>();
	}
	
	public List<Publication> getMyRegisteredPublications() {
		return myRegisteredPublications;
	}

	public void setMyRegisteredPublications(List<Publication> myRegisteredPublications) {
		this.myRegisteredPublications = myRegisteredPublications;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

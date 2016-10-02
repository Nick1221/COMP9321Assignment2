package cs9321ass2;

import java.util.*;
import user.*;

public class UserBean 
{
	private List<User> loggedInUser;
	
	public UserBean()
	{
		loggedInUser = new LinkedList<User>();
	}

	public List<User> getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(List<User> loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	
	
}

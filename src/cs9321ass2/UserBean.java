package cs9321ass2;

import java.util.*;

public class UserBean 
{
	private List<UserSimulation> loggedInUser;
	
	public UserBean()
	{
		loggedInUser = new LinkedList<UserSimulation>();
	}

	public List<UserSimulation> getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(List<UserSimulation> loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	
	
}

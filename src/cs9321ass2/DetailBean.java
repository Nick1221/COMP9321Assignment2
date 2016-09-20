package cs9321ass2;

import java.util.*;

public class DetailBean 
{
	private List<Publication> fullDetailed;
	
	public DetailBean()
	{
		fullDetailed = new LinkedList<Publication>();
	}

	public List<Publication> getFullDetailed() {
		return fullDetailed;
	}

	public void setFullDetailed(List<Publication> fullDetailed) {
		this.fullDetailed = fullDetailed;
	}
	
}

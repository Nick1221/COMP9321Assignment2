package cs9321ass2;

import java.util.*;

public class ResultsBean 
{
	List<Publication> results;
	
	public ResultsBean()
	{
		results = new LinkedList<Publication>();
	}

	public List<Publication> getResults() {
		return results;
	}

	public void setResults(List<Publication> results) {
		this.results = results;
	}
	
	
}

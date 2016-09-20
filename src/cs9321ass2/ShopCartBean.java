package cs9321ass2;

import java.io.Serializable;
import java.util.*;

public class ShopCartBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Publication> publications;
	
	public ShopCartBean()
	{
		this.publications = new LinkedList<Publication>();
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	
	
}

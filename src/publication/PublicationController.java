package publication;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cs9321ass2.*;

//@WebServlet("/publication")
public class PublicationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public PublicationController()
	{
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		String nextPage = "";
		if(action.equals("addPublication"))
		{
			Publication p1 = new Publication();
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			List<Publication> addedPubs = ub.getLoggedInUser().get(0).getRegisteredPublications();
			String [] athrs = request.getParameter("publishAuthor").split(",");
			for(String as : athrs) as.trim();
			List<String> authorList = Arrays.asList(athrs);
			p1.set("title",request.getParameter("publishTitle"));
			p1.set("Author",authorList);
			p1.set("Year",request.getParameter("publishYear"));
			
			addedPubs.add(p1);
//			ub.getLoggedInUser().get(0).setRegisteredPublications(addedPubs);
		}
		else if(action.equals("pauseItem"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			List<Publication> addedPubs = ub.getLoggedInUser().get(0).getRegisteredPublications();
			if(!(request.getParameter("ownItems") == null))
			{
				int toPause = Integer.parseInt(request.getParameter("ownItems").trim());
				Publication pubToPause = ub.getLoggedInUser().get(0).getRegisteredPublications().get(toPause);
				boolean alreadyPaused = true;
				//go thru db to pause the item by the user
				//if paused, set alreadyPaused to true
				if(alreadyPaused)
					request.setAttribute("paused", true);
//				else
//					ub.getLoggedInUser().get(0).getRegisteredPublications().get(toPause).setActive(false);
			}
			else
				request.setAttribute("nothingSelected", true);
			nextPage = "existingItems.jsp";
		}
		else if(action.equals("activateItem"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			if(!(request.getParameter("ownItems") ==  null))
			{
				int toActivate = Integer.parseInt(request.getParameter("ownItems").trim());
				Publication pubToActivate = ub.getLoggedInUser().get(0).getRegisteredPublications().get(toActivate);
//				if(pubToActivate.isActive()) //if already active
//					request.setAttribute("active", true);
//				else
//				{
//					//publications.add(pubToActivate); go to db and include item to search results
//					ub.getLoggedInUser().get(0).getRegisteredPublications().get(toActivate).setActive(true);
//				}
			}
			else
				request.setAttribute("nothingSelected", true);
			nextPage = "existingItems.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher("/"+nextPage);
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}